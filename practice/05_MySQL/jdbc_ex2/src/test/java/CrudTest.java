import common.JDBCUtil;
import org.junit.jupiter.api.*;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user 등록")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "insert into users(id, password, name, role) values (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user 목록 추출")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "select * from users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             ) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test
    @DisplayName("user 검색")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";
        String sql = "select * from users where id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user 수정")
    @Order(4)
    public void updateUser() throws SQLException {
        String userid = "scoula";
        String sql = "update users set name = ? where id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "스콜라 수정");
            pstmt.setString(2, userid);
            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("사용자 삭제")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql = "delete from users where id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            int count = pstmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
}
