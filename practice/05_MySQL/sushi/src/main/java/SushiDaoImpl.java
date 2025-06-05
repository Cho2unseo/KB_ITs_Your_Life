import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SushiDaoImpl implements SushiDao {
    Connection conn = JDBCUtil.getConnection();

    private String CUSTOMER_INSERT = "insert into customer values (?, ?)";
    private String LOG_INSERT = "insert into sushi_log (customer_id, plate_color) values (?, ?)";

    @Override
    public int insertCustomer(String id, String name) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(CUSTOMER_INSERT)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int insertSushiLog(String customerId, String plateColor) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(LOG_INSERT)) {
            pstmt.setString(1, customerId);
            pstmt.setString(2, plateColor);
            return pstmt.executeUpdate();
        }
    }
}
