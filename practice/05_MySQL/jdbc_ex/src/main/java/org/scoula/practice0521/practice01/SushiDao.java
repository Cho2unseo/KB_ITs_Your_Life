package org.scoula.practice0521.practice01;

import java.sql.SQLException;

public interface SushiDao {
    int insertCustomer(String id, String name) throws SQLException;

    int insertSushiLog(String customerId, String plateColor) throws SQLException;
}
