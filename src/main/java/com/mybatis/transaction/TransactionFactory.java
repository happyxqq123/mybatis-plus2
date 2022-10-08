package com.mybatis.transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public interface TransactionFactory {

  default void setProperties(Properties props) {
    // NOP
  }

  Transaction newTransaction(Connection conn);


  Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}
