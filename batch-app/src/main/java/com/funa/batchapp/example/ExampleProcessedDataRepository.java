package com.funa.batchapp.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleProcessedDataRepository extends JpaRepository<ExampleProcessedData, Long> {
  // Custom query methods can be added here if needed
}
