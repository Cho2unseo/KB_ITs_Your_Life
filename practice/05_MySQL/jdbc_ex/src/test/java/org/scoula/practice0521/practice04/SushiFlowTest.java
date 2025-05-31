package org.scoula.practice0521.practice04;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SushiFlowTest {
    SushiDao dao = new SushiDaoImpl();
    static Connection conn = JDBCUtil.getConnection();

    @BeforeAll
    static void clearBeforeStart() throws SQLException {
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");
        System.out.println("🧹 [BeforeAll] 전체 테이블 초기화 완료");
    }

    @AfterAll
    static void printEndMessage() {
        System.out.println("✅ [AfterAll] 모든 테스트 종료!");
    }

    @Test
    @DisplayName("1. 샘플 고객 및 기록 삽입")
    @Order(1)
    void insertSampleData() throws SQLException {
        dao.insertCustomer("cust01", "김초밥");
        dao.insertSushiLog("cust01", "red");
        dao.insertSushiLog("cust01", "blue");
        dao.insertSushiLog("cust01", "gold");
        System.out.println("📌 [1단계] 샘플 데이터 삽입 완료");
    }

    @Test
    @DisplayName("2. 특정 고객 최애 접시 색상 분석")
    @Order(2)
    void printFavoriteColor() throws SQLException {
        System.out.println("📌 [2단계] cust01 고객님의 " + dao.findFavoriteColor("cust01").get());
    }

    @Test
    @DisplayName("3. 전체 데이터 초기화")
    @Order(3)
    void resetData() throws SQLException {
        conn.createStatement().executeUpdate("DELETE FROM sushi_log");
        conn.createStatement().executeUpdate("DELETE FROM customer");
        System.out.println("📌 [3단계] 모든 고객 및 기록이 삭제되었습니다.");
    }

    @Test
    @DisplayName("4. 다중 고객 삽입")
    @Order(4)
    void insertMultipleCustomers() throws SQLException {
        dao.insertCustomer("cust02", "이연어");
        dao.insertCustomer("cust03", "박광어");

        dao.insertSushiLog("cust02", "blue");
        dao.insertSushiLog("cust02", "blue");
        dao.insertSushiLog("cust02", "gold");
        dao.insertSushiLog("cust03", "red");
        dao.insertSushiLog("cust03", "gold");
        dao.insertSushiLog("cust03", "gold");

        System.out.println("📌 [4단계] 다중 고객 데이터 삽입 완료.");
    }

    @Test
    @DisplayName("5. 전체 고객 통계 출력")
    @Order(5)
    void printAllStats() throws SQLException {
        List<String> list = dao.getAllCustomerIds();
        System.out.println("📌 [5단계] 전체 고객의 최애 접시 색상 통계:");
        for (String s: list) {
            System.out.println(" - " + s + " 고객님의 " + dao.findFavoriteColor(s).get());
        }
    }
}