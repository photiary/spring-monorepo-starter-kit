# Junie Guidelines for Spring Batch Development

This file contains guidelines for Junie to follow when working on this Spring Batch project.

## Project Structure

- **Packaging:** Strongly prefer **package-by-feature** structure over package-by-layer.

    * **PREFER THIS (Package-by-Feature):** `{Domain}` is a feature.

      ```
          main
          ├── java
          │   └── com.funa.batchapp
          │       ├── BatchApplication.java
          │       ├── common
          │       │   ├── exception                              # batch-app only
          │       │   ├── config
          │       │   │   ├── BatchConfig.java
          │       │   │   ├── AsyncConfig.java
          │       │   │   ├── JpaConfig.java
          │       │   ├── util
          │       │   │   └── BatchUtils.java
          │       │   └── listener
          │       │       ├── GlobalJobCompletionListener.java
          │       │       └── GlobalStepExecutionListener.java
          │       └── {Domain}
          │           ├── {Domain}JobConfig.java
          │           ├── {Domain}JobController.java
          │           ├── {Domain}JobService.java
          │           ├── {Domain}Step.java
          │           ├── {Domain}Tasklet.java
          │           ├── {Domain}Reader.java
          │           ├── {Domain}Processor.java
          │           ├── {Domain}Writer.java
          │           ├── domain
          │           │   └── {Domain}Entity.java
          │           ├── dto                                     # Data Transfer Objects specific to Domain
          │           │   ├── {Domain}Request.java
          │           │   └── {Domain}Response.java    
          │           └── repository
          │               └── {Domain}Repository.java
          └── resources
              └── application.yml
      ```

## Controller

## Data Access

## Database

- **Table naming rules:** Use **Snake case** and prefix it with 'batch_'.