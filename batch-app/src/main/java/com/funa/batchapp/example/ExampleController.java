package com.funa.batchapp.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/batch/example")
@RequiredArgsConstructor
@Tag(name = "Example Batch", description = "Example Batch API")
public class ExampleController {

  private final ExampleService exampleService;

  @PostMapping("/run")
  @Operation(
      summary = "Run Example Batch Job",
      description = "Triggers the example batch job to process raw data")
  public ResponseEntity<String> runBatch() {
    try {
      exampleService.runJob();
      return ResponseEntity.ok("Example batch job has been triggered successfully");
    } catch (Exception e) {
      log.error("Error triggering example batch job", e);
      return ResponseEntity.internalServerError()
          .body("Error triggering example batch job: " + e.getMessage());
    }
  }
}
