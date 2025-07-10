package com.funa.batchapp.batch.example;

import com.funa.batchapp.example.ExampleRawData;
import com.funa.batchapp.example.ExampleRawDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class ExampleReader {

  private final ExampleRawDataRepository rawDataRepository;

  public ItemReader<ExampleRawData> reader() {
    return new RepositoryItemReaderBuilder<ExampleRawData>()
        .name("exampleReader")
        .repository(rawDataRepository)
        .methodName("findAll")
        .pageSize(10)
        .sorts(Collections.singletonMap("id", Sort.Direction.ASC))
        .build();
  }
}
