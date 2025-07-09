# Junie Guidelines for Spring Boot Development

This file contains guidelines for Junie to follow when working on this Spring Boot project.

## Core Technologies & Versions

- **Java:** Use the latest Java 24.
- **Spring Boot:** Always use the latest stable release of Spring Boot 3.x (or the latest major
  stable version).
- **Spring Batch:** Always use the latest stable release of Spring Boot 3.x (or the latest major
  stable version).
- **Build Tool:** Use Gradle as the build tool. Ensure the `build.gradle` usees the latest stable
  Spring Boot package.
- **Unit test:** Use junit.
- **Log:** Use SLF4J as the logging API.
- **Swagger:** API Docs. Springdoc-openapi-starter-webmvc-ui 2.8.x (or the latest major stable
  version).
- **PostgresSQL:** Use the 16.x stable version.
- **Docker Compose** is a tool for defining and running multi-container applications.

# Excluded Technologies

# Excluded Prompt

- Ignore the `.prompt.md` resources defined in `./prompt.ignore`.

## Root Project Structure

- **Monorepo structure**

```
root/
├── build.gradle            # Root Common build
├── settings.gradle
├── gradle/                 # Common gradle setting, Ex: Version management, Plugin setting.
├── common/                 # Common library and util module
│   ├── com.funa.common.exception
│   │   ├── GlobalExceptionHandler.java
│   │   ├── ValidException.java
│   │   ├── DuplicationException.java
│   │   └── NotFoundException.java
│   └── build.gradle
├── boot-app/               # Spring Boot REST API Service module
│   └── build.gradle
├── batch-app/              # Spring Batch Service module
│   └── build.gradle
├── ai-app/                 # Spring AI Service module
│   └── build.gradle
└── prompts/                # Prompt for AI Agent
```

## Java Language Features

- **Data Carriers:** Use **Lombok** for immutable data transfer objects (DTOs). value objects (VOs).

## Controller

- **DO NOT use Entity:** Use the `./dto/*Request.java`, `./dto/*Response.java`.
- **Swagger:** Generate Docs in All API.
- Should be able to output to **Swagger.json**

## Data Access

- **Default:** If unsure, lean towards Spring Data JPA for typical applications development.
- Default Entity properties:
    - createdId
    - createdAt
    - updatedId
    - updatedAt

## Logs

- **Log content:** timestamp, log level, transaction ID(Trace ID), user ID

## Junie Guidelines Prompt files for App Project

Each **Sub-Module** should always follow the following pattern::

- **boot-app**: `./guideline-boot-app.prompt.md`
- **batch-app**: `./guideline-batch-app.prompt.md`