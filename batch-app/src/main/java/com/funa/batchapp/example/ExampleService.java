package com.funa.batchapp.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExampleService {

  private final JobLauncher jobLauncher;
  private final Job exampleJob;

  @Async
  public void runJob() {
    try {
      JobParameters jobParameters =
          new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();

      log.info("Starting example batch job with parameters: {}", jobParameters);
      jobLauncher.run(exampleJob, jobParameters);
      log.info("Example batch job has been triggered successfully");
    } catch (JobExecutionAlreadyRunningException
        | JobRestartException
        | JobInstanceAlreadyCompleteException
        | JobParametersInvalidException e) {
      log.error("Error triggering example batch job", e);
      throw new RuntimeException("Error triggering example batch job: " + e.getMessage(), e);
    }
  }
}
