package org.scoula.practice0521.practice03;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiDaoTest {
    SushiDao dao = new SushiDaoImpl();

    @BeforeEach
    void setUp() throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");
        dao.insertCustomer("cust01", "김초밥");
        dao.insertSushiLog("cust01", "red");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
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

    @Test
    @DisplayName("고객의 접시 기록을 콘솔에 출력한다")
    @Order(3)
    void testPrintSushiLogByCustomer() throws SQLException {
        dao.printSushiLogByCustomer("cust01");
    }

    @Test
    @DisplayName("고객의 최애 접시 색상을 콘솔에 출력한다")
    @Order(4)
    void findFavoriteColor() throws SQLException {
        Optional<SushiLogStat> plate = dao.findFavoriteColor("cust01");
        if (plate.isPresent()) {
            System.out.println("cust01 고객님의 " + plate.get());
        }
        else System.out.println("⚠️ 접시 기록이 없어 분석할 수 없습니다.");
    }
}