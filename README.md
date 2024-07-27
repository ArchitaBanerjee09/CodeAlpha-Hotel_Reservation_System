# Hotel Reservation System

## Overview

This project is a simple Hotel Reservation System implemented in Java using JDBC to connect to a MySQL database. The system allows users to register, login, search for available rooms, and make reservations. The frontend is built using HTML, CSS, and JavaScript.

## Project Structure

The project is organized into the following packages:

- `com.example.hotelreservationsystemc`: Contains the main application entry point and the database connection class.
- `dao`: Data Access Objects (DAOs) for interacting with the database.
- `model`: Plain Old Java Objects (POJOs) representing the data model.

## Packages and Classes

### com.example.hotelreservationsystemc

- `Main.java`: The main application class that provides the user interface and controls the flow of the program.
- `DatabaseConnection.java`: A utility class for establishing a connection to the MySQL database.

### dao

- `UserDao.java`: Contains methods for registering and logging in users.
- `RoomDao.java`: Contains methods for retrieving available rooms from the database.
- `ReservationDao.java`: Contains methods for making reservations.

### model

- `User.java`: Represents a user in the system.
- `Room.java`: Represents a room in the hotel.
- `Reservation.java`: Represents a reservation made by a user.

## Database Schema

The MySQL database has the following tables:

### Users Table

```sql
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);
```

### Rooms Table

```sql
CREATE TABLE Rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number INT NOT NULL,
    category VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    availability BOOLEAN DEFAULT TRUE
);
```

### Reservations Table

```sql
CREATE TABLE Reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    room_id INT,
    check_in_date DATE,
    check_out_date DATE,
    total_price DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (room_id) REFERENCES Rooms(room_id)
);
```

## Setup Instructions

### Prerequisites

- Java Development Kit (JDK)
- MySQL Database
- IntelliJ IDEA or any other Java IDE

### Steps to Run Project

1. Clone the repository
   ```bash
   git clone <repository-url>
   ```
   
2. Create the Database
   Create a new database in MySQL and run the SQL scripts to create the necessary tables.

3. Update Database Credentials
   Update the database connection details in DatabaseConnection.java:
   ```bash
   private static final String URL = "jdbc:mysql://localhost:3306/hreservationsys";
   private static final String USER = "root";
   private static final String PASSWORD = "yourpassword";
   ```

4. Build and Run the Project
   Open the project in IntelliJ IDEA, build it, and run the Main class.

## Usage

1. Register a New User
   Choose the option to register, enter a username, password, and email.

2. Login
   Choose the option to login, enter the registered username and password.

3. Search for Available Rooms
   Choose the option to search for available rooms. The system will display a list of rooms that are available for booking.

4. Make a Reservation
   Choose the option to make a reservation, enter the user ID, room ID, check-in date, check-out date, and total price.

5. Exit
   Choose the option to exit the application.

## Example Usage
Here is a sample interaction with the system:
```bash
1. Register
2. Login
3. Search Available Rooms
4. Make a Reservation
5. Exit
Choose an option: 1
Enter username: john
Enter password: doe123
Enter email: john@example.com
User registered successfully!

1. Register
2. Login
3. Search Available Rooms
4. Make a Reservation
5. Exit
Choose an option: 2
Enter username: john
Enter password: doe123
Login successful!

1. Register
2. Login
3. Search Available Rooms
4. Make a Reservation
5. Exit
Choose an option: 3
Available rooms:
Room ID: 1
Room Number: 101
Category: Single
Price: 100.00
Availability: Yes

1. Register
2. Login
3. Search Available Rooms
4. Make a Reservation
5. Exit
Choose an option: 4
Enter user ID: 1
Enter room ID: 1
Enter check-in date (YYYY-MM-DD): 2024-08-01
Enter check-out date (YYYY-MM-DD): 2024-08-05
Enter total price: 400.00
Reservation made successfully!

1. Register
2. Login
3. Search Available Rooms
4. Make a Reservation
5. Exit
Choose an option: 5
Exiting...
```

## Conclusion

This Hotel Reservation System is a simple application to demonstrate the use of Java and JDBC for interacting with a MySQL database. It provides basic functionality for user registration, login, room search, and reservation. This project can be further extended to include more features such as payment processing, room categorization, and more robust error handling.
