import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiDaoTest {
    SushiDao dao = new SushiDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @BeforeEach
    void setUp() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");
        dao.insertCustomer("cust01", "김초밥");
    }

    @Test
    @DisplayName("고객 등록")
    @Order(1)
    void insertCustomer() throws SQLException {
        int count = dao.insertCustomer("cust02", "이연어");
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("접시 등록")
    @Order(2)
    void insertSushiLog() throws SQLException {
        int count = dao.insertSushiLog("cust01", "red");
        Assertions.assertEquals(1, count);
    }
}