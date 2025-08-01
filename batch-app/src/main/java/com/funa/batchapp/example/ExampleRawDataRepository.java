package com.funa.batchapp.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRawDataRepository extends JpaRepository<ExampleRawData, Long> {
  // Custom query methods can be added here if needed
}
