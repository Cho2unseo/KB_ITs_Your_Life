package org.scoula.food.dao;

import org.scoula.food.JDBCUtil;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantDaoImpl implements RestaurantDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public void insert(RestaurantVO restaurant) {
        String sql = "insert into tbl_restaurant(name, category, address, description) values (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCategory());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setString(4, restaurant.getDescription());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertReview(RestaurantReviewVO review) {
        String sql = "insert into tbl_restaurant_review(restaurant_id, writer, content, score) values (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, review.getRestaurantId());
            pstmt.setString(2, review.getWriter());
            pstmt.setString(3, review.getContent());
            pstmt.setString(4, review.getScore());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<RestaurantVO> getRestaurantWithReviews(Long id) {
        RestaurantVO restaurant = null;
        String sql = "select * from tbl_restaurant r LEFT OUTER JOIN tbl_restaurant_review re ON r.id = re.restaurant_id where r.id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    restaurant = map(rs);
                    List<RestaurantReviewVO> reviews = new ArrayList<>();
                    try {
                        do {
                            RestaurantReviewVO review = mapReview(rs);
                            reviews.add(review);
                        } while (rs.next());
                    } catch (SQLException e) {
                    }
                    restaurant.setReviews(reviews);
                    return Optional.of(restaurant);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RestaurantVO> getAllRestaurantWithScoreAvg() {
        String sql = "select r.id, name, category, address, description, AVG(score) AS average_score from tbl_restaurant r LEFT OUTER JOIN tbl_restaurant_review re ON r.id = re.restaurant_id GROUP BY r.id, name, category, address, description ORDER BY average_score DESC ";
        List<RestaurantVO> list = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                RestaurantVO restaurant = RestaurantVO.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .category(rs.getString("category"))
                        .address(rs.getString("address"))
                        .description(rs.getString("description"))
                        .averageScore(rs.getDouble("average_score"))
                        .build();
                if (rs.wasNull()) restaurant.setAverageScore(null);
                list.add(restaurant);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private RestaurantVO map(ResultSet rs) throws SQLException {
        return RestaurantVO.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .category(rs.getString("category"))
                .address(rs.getString("address"))
                .description(rs.getString("description"))
                .build();
    }

    private RestaurantReviewVO mapReview(ResultSet rs) throws SQLException {
        return RestaurantReviewVO.builder()
                .no(rs.getLong("no"))
                .restaurantId(rs.getLong("restaurant_id"))
                .writer(rs.getString("writer"))
                .content(rs.getString("content"))
                .score(rs.getString("score"))
                .build();
    }
}
