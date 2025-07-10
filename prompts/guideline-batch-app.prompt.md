# Junie Guidelines for Spring Batch Development

This file contains guidelines for Junie to follow when working on this Spring Batch project.

## Project Structure

- **Packaging:** Strongly prefer **package-by-feature** structure over package-by-layer.

    * **PREFER THIS (Package-by-Feature):**

      ```
          main
          ├── java
          │   └── com.funa.batchapp
          │       ├── BatchApplication.java
          │       ├── common                                     # batch-app only
          │       │   ├── exception
          │       │   ├── config
          │       │   │   ├── BatchConfig.java
          │       │   │   ├── AsyncConfig.java
          │       │   │   ├── JpaConfig.java
          │       │   ├── util
          │       │   │   └── BatchUtils.java
          │       │   └── listener
          │       │       ├── GlobalJobCompletionListener.java
          │       │       └── GlobalStepExecutionListener.java
          │       ├── batch
          │       │   └── {Feature}
          │       │       ├── {Feature}JobConfig.java
          │       │       ├── {Feature}JobController.java
          │       │       ├── {Feature}JobService.java
          │       │       ├── {Feature}Step.java
          │       │       ├── {Feature}Tasklet.java
          │       │       ├── {Feature}Reader.java
          │       │       ├── {Feature}Processor.java
          │       │       └── {Feature}Writer.java
          │       └── {Domain}                          # Service: Domain
          │           ├── {Domain}Controller.java       # Controller for Domain
          │           ├── {Domain}Service.java          # Service logic for Domain
          │           ├── {Domain}Repository.java       # Data access for Domain
          │           ├── {Domain}.java                 # Domain/Entity for Domain
          │           └── dto                           # Data Transfer Objects specific to Domain
          │               ├─ {Domain}Request.java
          │               └─ {Domain}Response.java
          └── resources
              └── application.yml
      ```

## Controller

## Data Access

## Database

- **Table naming rules:** Use **Snake case** and prefix it with 'batch_biz_'.