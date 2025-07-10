package com.funa.batchapp.batch.example;

import com.funa.batchapp.example.ExampleProcessedData;
import com.funa.batchapp.example.ExampleProcessedDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExampleWriter implements ItemWriter<ExampleProcessedData> {

  private final ExampleProcessedDataRepository processedDataRepository;

  @Override
  public void write(Chunk<? extends ExampleProcessedData> chunk) {
    for (ExampleProcessedData processedData : chunk.getItems()) {
      log.info("Writing processed data: {}", processedData.getProcessedAmount());
      processedDataRepository.save(processedData);
    }
  }
}
