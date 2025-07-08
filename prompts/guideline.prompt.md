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

## Project Structure

- **Monorepo structure**

```
root/
├── build.gradle            # Root Common build
├── settings.gradle
├── gradle/                 # Common gradle setting, Ex: Version management, Plugin setting.
├── common/                 # Common library and util module
│   └── build.gradle
├── boot-app/               # Spring Boot REST API Service module
│   └── build.gradle
├── batch-app/              # Spring Batch Service module
│   └── build.gradle
├── ai-app/                 # Spring AI Service module
│   └── build.gradle
└── prompts/                # Prompt for AI Agent
```

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