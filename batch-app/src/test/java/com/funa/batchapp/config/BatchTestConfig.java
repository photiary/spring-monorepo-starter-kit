package com.funa.batchapp.config;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for Spring Batch tests. Provides a JobLauncherTestUtils bean for testing batch
 * jobs only if one is not already provided by @SpringBatchTest.
 */
@Configuration
public class BatchTestConfig {

  @Autowired private JobLauncher jobLauncher;

  @Autowired private JobRepository jobRepository;

  @Bean
  @ConditionalOnMissingBean
  public JobLauncherTestUtils jobLauncherTestUtils() {
    JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
    jobLauncherTestUtils.setJobLauncher(jobLauncher);
    jobLauncherTestUtils.setJobRepository(jobRepository);
    return jobLauncherTestUtils;
  }
}
