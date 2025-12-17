# JDBC PostgreSQL Connection Example

A simple Java application demonstrating JDBC connectivity with PostgreSQL database to perform DELETE operations on a Student table.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- PostgreSQL database installed and running
- PostgreSQL JDBC Driver (postgresql-*.jar)

## Database Setup

1. Ensure PostgreSQL is running on `localhost:5432`
2. Create a database named `Student`
3. Create a table with the following structure:

```sql
CREATE TABLE student (
    sid INTEGER PRIMARY KEY,
    name VARCHAR(100),
    marks INTEGER
);
```

## Configuration

Before running the application, update the following variables in `JdbcConn.java`:

```java
String url = "jdbc:postgresql://localhost:5432/Student";
String uname = "postgres";
String password = "your password";  // Replace with your actual password
```

## JDBC Driver Setup

### Option 1: Manual Setup
1. Download the PostgreSQL JDBC driver from [https://jdbc.postgresql.org/download/](https://jdbc.postgresql.org/download/)
2. Add the JAR file to your project's classpath

### Option 2: Maven
Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>
```

### Option 3: Gradle
Add this to your `build.gradle`:

```gradle
implementation 'org.postgresql:postgresql:42.6.0'
```

## How to Run

### Compile:
```bash
javac JdbcConn.java
```

### Run:
```bash
java JdbcConn
```

## What This Program Does

The application performs the following operations:

1. **Loads the PostgreSQL JDBC Driver** - Registers the driver with the JVM
2. **Establishes Connection** - Connects to the PostgreSQL database using provided credentials
3. **Executes DELETE Statement** - Deletes the student record with `sid = 15`
4. **Closes Connection** - Properly closes the database connection

## Expected Output

```
Connection Established
connection Closed
```

## Code Features

The code includes commented sections that demonstrate:

- **Query Execution Status**: Checking if a query executed successfully
- **SELECT Query**: Retrieving and displaying student records
- **ResultSet Processing**: Iterating through query results

### Uncommenting Examples

To retrieve data instead of deleting:

```java
String query = "select * from student";
ResultSet rs = st.executeQuery(query);
while(rs.next()){
    System.out.print(rs.getString(1) + "-");
    System.out.print(rs.getInt(2) + "-");
    System.out.println(rs.getInt(3));
}
```

## Important Notes

⚠️ **Security Warning**: This code contains hardcoded credentials. For production applications:
- Use environment variables for credentials
- Implement proper connection pooling
- Use PreparedStatement to prevent SQL injection

⚠️ **Current Behavior**: The program deletes the student with `sid = 15` every time it runs.

## JDBC Steps Explained

1. **Import Package** - `import java.sql.*;`
2. **Load and Register Driver** - `Class.forName("org.postgresql.Driver")`
3. **Create Connection** - `DriverManager.getConnection(url, uname, password)`
4. **Create Statement** - `con.createStatement()`
5. **Execute Statement** - `st.execute(query)`
6. **Process Results** - Handle ResultSet (if SELECT query)
7. **Close Connection** - `con.close()`

## Troubleshooting

### ClassNotFoundException
- Ensure PostgreSQL JDBC driver is in your classpath

### SQLException: Connection refused
- Verify PostgreSQL is running
- Check the port number (default: 5432)
- Confirm database name exists

### Authentication failed
- Verify username and password
- Check PostgreSQL pg_hba.conf for authentication settings

## License

This is a sample educational project demonstrating basic JDBC operations.
