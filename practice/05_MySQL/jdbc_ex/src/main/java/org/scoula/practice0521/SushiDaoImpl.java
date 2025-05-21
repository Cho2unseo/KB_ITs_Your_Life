package org.scoula.practice0521;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SushiDaoImpl implements SushiDao {
    Connection conn = JDBCUtil.getConnection();

    private String CUSTOMER_INSERT = "insert into customer values(?, ?)";
    private String PLATE_INSERT = "insert into sushi_log (customer_id, plate_color) values(?, ?)";

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
}
