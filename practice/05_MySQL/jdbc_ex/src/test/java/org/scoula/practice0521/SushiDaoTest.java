package org.scoula.practice0521;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiDaoTest {
    SushiDao dao = new SushiDaoImpl();

    @AfterAll
    static void tearDown() {
        // 모든 테스트가 완료된 후에 JDBC 연결을 종료
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
    @DisplayName("고객을 등록합니다.")
    @Order(1)
    void insertCustomer() throws SQLException {
        int count = dao.insertCustomer("cust02", "이연어");
        Assertions.assertEquals(1, count);
    }

    @Test
    @DisplayName("접시를 등록합니다.")
    @Order(2)
    void insertSushiLog() throws SQLException {
        int count = dao.insertSushiLog("cust01", "red");
        Assertions.assertEquals(1, count);
    }
}