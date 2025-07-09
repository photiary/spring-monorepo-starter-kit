# Junie Guidelines for Spring Boot Development

This file contains guidelines for Junie to follow when working on this Spring Boot project.

# Excluded Technologies

## Project Structure

- **MSA Architecture**

- **Domain Driven Design**

- **Packaging:** Strongly prefer **package-by-feature** structure over package-by-layer.

    * **Why package-by-feature?** It improves modularity, makes navigating the code related to a
      single feature easier, and makes it easier to reuse code across features.

    * **Example:**

      **PREFER THIS (Package-by-Feature):** `{Domain}` is a feature.

      ```
      com.funa.bootapp
      ├─ {Domain}                          # Feature: Domain
      │   ├─ {Domain}Controller.java       # Controller for Domain
      │   ├─ {Domain}Service.java          # Service logic for Domain
      │   ├─ {Domain}Repository.java       # Data access for Domain
      │   ├─ {Domain}.java                 # Domain/Entity for Domain
      │   └─ dto                           # Data Transfer Objects specific to Domain
      │      ├─ {Domain}Request.java
      │      └─ {Domain}Response.java
      └─ common                            # Optional: Truly shared utilities/conifg, boot-app only.
          ├─ exception
          └─ config 
      ```

      **AVOID THIS (Package-by-Layer):**
      ```
      com.funa
      ├─ controller
      │  └─ {Domain}Controller.java
      ├─ service
      │  └─ {Domain}Service.java
      ├─ repository
      │  └─ {Domain}Repository.java
      └─ model (or domain/entity)
         └─ {Domain}.java
      ```

## Java Language Features

## Environment file

- The default profile is 'local' if not specified: `application.properties`

## Controller

## Data Access

## Database

- **Table naming rules:** Use **Snake case** and prefix it with 'web_'.

## Unit Test

## Logs

## ETC