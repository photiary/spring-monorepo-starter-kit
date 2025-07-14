package com.funa.batchapp.batch.example;

import com.funa.batchapp.example.ExampleProcessedData;
import com.funa.batchapp.example.ExampleRawData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExampleProcessor implements ItemProcessor<ExampleRawData, ExampleProcessedData> {

  @Override
  public ExampleProcessedData process(ExampleRawData rawData) {
    log.info("Processing raw data: {}", rawData.getRawAmount());
    // Multiply by 100 as per business logic
    int processedAmount = rawData.getRawAmount() * 100;

    // Check if processed data already exists
    if (rawData.getProcessedData() != null) {
      ExampleProcessedData existingProcessedData = rawData.getProcessedData();
      existingProcessedData.setProcessedAmount(processedAmount);
      return existingProcessedData;
    } else {
      // Create new processed data
      return new ExampleProcessedData(rawData, processedAmount);
    }
  }
}
