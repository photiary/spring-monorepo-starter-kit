package com.funa.batchapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest
class BatchApplicationTests {

  @Autowired private DataSource dataSource;

  @Test
  void verifyBatchTablesCreated() throws SQLException {
    try (Connection connection = dataSource.getConnection()) {
      DatabaseMetaData metaData = connection.getMetaData();

      // Check for BATCH_JOB_INSTANCE table
      ResultSet tables = metaData.getTables(null, null, "BATCH_JOB_INSTANCE", null);
      boolean batchJobInstanceExists = tables.next();
      System.out.println("[DEBUG_LOG] BATCH_JOB_INSTANCE table exists: " + batchJobInstanceExists);

      // Check for BATCH_JOB_EXECUTION table
      tables = metaData.getTables(null, null, "BATCH_JOB_EXECUTION", null);
      boolean batchJobExecutionExists = tables.next();
      System.out.println(
          "[DEBUG_LOG] BATCH_JOB_EXECUTION table exists: " + batchJobExecutionExists);

      // Check for BATCH_STEP_EXECUTION table
      tables = metaData.getTables(null, null, "BATCH_STEP_EXECUTION", null);
      boolean batchStepExecutionExists = tables.next();
      System.out.println(
          "[DEBUG_LOG] BATCH_STEP_EXECUTION table exists: " + batchStepExecutionExists);

      // Assert that all tables exist
      assert batchJobInstanceExists && batchJobExecutionExists && batchStepExecutionExists
          : "Spring Batch metadata tables were not created";
    }
  }
}
