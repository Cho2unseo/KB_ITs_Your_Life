package org.scoula.practice0521.practice02;

import java.sql.*;

public class SushiDaoImpl implements SushiDao {
    Connection conn = JDBCUtil.getConnection();

    private String CUSTOMER_INSERT = "insert into customer values(?, ?)";
    private String PLATE_INSERT = "insert into sushi_log (customer_id, plate_color) values(?, ?)";
    private String PLATE_SELECT = "select * from sushi_log";
    @Override
    public int insertCustomer(String id, String name) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(CUSTOMER_INSERT)) {
            stmt.setString(1, id);
            stmt.setString(2, name);
            return stmt.executeUpdate();
        }
    }

    @Override
    public int insertSushiLog(String customerId, String plateColor) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(PLATE_INSERT)) {
            stmt.setString(1, customerId);
            stmt.setString(2, plateColor);
            return stmt.executeUpdate();
        }
    }

    @Override
    public void printSushiLogByCustomer(String customerId) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(PLATE_SELECT);
        ) {
            System.out.println("[고객 ID: " + customerId + "] 의 접시 기록:");
            while (rs.next()) {
                System.out.printf("%2s. %-8s (%s)%n", rs.getString("id"), rs.getString("plate_color"), rs.getString("eaten_at"));
            }
        }
    }
}
