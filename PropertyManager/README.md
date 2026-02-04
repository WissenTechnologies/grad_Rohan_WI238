# PropertyManager

Welcome to **PropertyManager**! 🏠

This is a simple application to help manage properties, sites, and users. It connects to a database to save your data.

## Prerequisites
Before you run this app, make sure you have:
1.  **Java** installed (Java 8 or higher).
2.  **PostgreSQL** installed and running.

## Database Setup
1.  Open your PostgreSQL tool (like pgAdmin or psql).
2.  Create a database named `Fontaine`.
3.  Make sure you have a user `postgres` with password `hydroarchon`.
    - *Note:* If your password is different, please update `src/database/operations/DatabaseConnector.java`.
4.  Run the SQL script found in `db/create.sql` to set up the tables. (Wait, I need to check if `create.sql` exists and move it).

## How to Compile
Open your terminal (PowerShell or Command Prompt) and run:

```bash
javac -d bin -sourcepath src src/Main.java
```

## How to Run
You can run the application in different modes:

- **Admin Mode:**
  ```bash
  java -cp "bin;lib/postgresql.jar" Main -a
  ```
- **Owner Mode:**
  ```bash
  java -cp "bin;lib/postgresql.jar" Main -o
  ```
- **General Mode:**
  ```bash
  java -cp "bin;lib/postgresql.jar" Main -g
  ```

*(Note: You might need to download the PostgreSQL JDBC driver and put it in a `lib` folder, or just make sure it's in your classpath)*

## Structure
- `src/model`: Defines the objects like Users and Sites.
- `src/database`: Handles saving and loading data.
- `src/business`: Contains the logic for the application.
