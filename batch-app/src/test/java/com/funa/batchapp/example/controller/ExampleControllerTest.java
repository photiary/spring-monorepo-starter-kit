package com.funa.batchapp.example.controller;

import com.funa.batchapp.batch.example.ExampleJobController;
import com.funa.batchapp.example.ExampleService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ExampleControllerTest {

  @TestConfiguration
  static class TestConfig {
    @Bean
    @Primary
    public ExampleService mockExampleJobService() {
      ExampleService mockService = Mockito.mock(ExampleService.class);
      doNothing().when(mockService).runJob();
      return mockService;
    }
  }

  @Autowired private MockMvc mockMvc;

  @Autowired private ExampleService exampleService;

  @Test
  void testRunBatch() throws Exception {
    // When
    mockMvc
        .perform(post("/api/batch/example/run").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string("Example batch job has been triggered successfully"));

    // Then
    verify(exampleService, times(1)).runJob();
  }
}
