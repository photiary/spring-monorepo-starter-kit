package com.funa.batchapp.batch.example;

import com.funa.batchapp.example.ExampleProcessedData;
import com.funa.batchapp.example.ExampleRawData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ExampleJobConfig {

  private final JobRepository jobRepository;
  private final PlatformTransactionManager transactionManager;
  private final ExampleReader exampleReader;
  private final ExampleProcessor exampleProcessor;
  private final ExampleWriter exampleWriter;

  @Bean
  public Job exampleJob() {
    return new JobBuilder("exampleJob", jobRepository).start(exampleStep()).build();
  }

  @Bean
  public Step exampleStep() {
    return new StepBuilder("exampleStep", jobRepository)
        .<ExampleRawData, ExampleProcessedData>chunk(10, transactionManager)
        .reader(exampleReader.reader())
        .processor(exampleProcessor)
        .writer(exampleWriter)
        .build();
  }
}
