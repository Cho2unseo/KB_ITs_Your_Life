import common.JDBCUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    @Test
    @DisplayName("dd")
    public void testConnection2() throws SQLException {
        try (Connection conn = JDBCUtil.getConnection()) {
            System.out.println("ddds");
        }
    }
}
