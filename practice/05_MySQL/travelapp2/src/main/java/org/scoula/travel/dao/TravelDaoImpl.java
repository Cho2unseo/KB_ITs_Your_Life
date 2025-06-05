package org.scoula.travel.dao;

import org.scoula.common.JDBCUtil;
import org.scoula.travel.domain.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TravelDaoImpl implements TravelDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public void insert(TravelVO travel) {
        String sql = "insert into tbl_travel(no, district, title, description, address, phone) values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, travel.getNo());
            pstmt.setString(2, travel.getDistrict());
            pstmt.setString(3, travel.getTitle());
            pstmt.setString(4, travel.getDescription());
            pstmt.setString(5, travel.getAddress());
            pstmt.setString(6, travel.getPhone());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
