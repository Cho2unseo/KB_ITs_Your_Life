package org.scoula.practice0521.practice04;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface SushiDao {
    int insertCustomer(String id, String name) throws SQLException;

    int insertSushiLog(String customerId, String plateColor) throws SQLException;

    void printSushiLogByCustomer(String customerId) throws SQLException;

    Optional<SushiLogStat> findFavoriteColor(String customerId) throws SQLException;

    List<String> getAllCustomerIds() throws SQLException;
}
