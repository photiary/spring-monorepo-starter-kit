package com.funa.batchapp.example.config;

import com.funa.batchapp.example.ExampleProcessedData;
import com.funa.batchapp.example.ExampleRawData;
import com.funa.batchapp.example.ExampleProcessedDataRepository;
import com.funa.batchapp.example.ExampleRawDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@SpringBatchTest
@ActiveProfiles("test")
class ExampleBatchJobConfigTest {

  @Autowired private JobLauncherTestUtils jobLauncherTestUtils;

  @Autowired private ExampleRawDataRepository rawDataRepository;

  @Autowired private ExampleProcessedDataRepository processedDataRepository;

  @Autowired private Job exampleJob;

  @BeforeEach
  void setUp() {
    // Clean up repositories
    processedDataRepository.deleteAll();
    rawDataRepository.deleteAll();

    // Set up test data
    List<ExampleRawData> rawDataList =
        Arrays.asList(new ExampleRawData(10), new ExampleRawData(20), new ExampleRawData(30));
    rawDataRepository.saveAll(rawDataList);

    // Configure job launcher test utils
    jobLauncherTestUtils.setJob(exampleJob);
  }

  @Test
  void testExampleBatchJob() throws Exception {
    // Given
    JobParameters jobParameters =
        new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();

    // When
    JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);

    // Then
    assertEquals("COMPLETED", jobExecution.getExitStatus().getExitCode());

    // Verify processed data
    List<ExampleRawData> rawDataList = rawDataRepository.findAll();
    List<ExampleProcessedData> processedDataList = processedDataRepository.findAll();

    assertEquals(3, rawDataList.size());
    assertEquals(3, processedDataList.size());

    for (ExampleRawData rawData : rawDataList) {
      assertNotNull(rawData.getProcessedData());
      assertEquals(rawData.getRawAmount() * 100, rawData.getProcessedData().getProcessedAmount());
    }
  }
}
