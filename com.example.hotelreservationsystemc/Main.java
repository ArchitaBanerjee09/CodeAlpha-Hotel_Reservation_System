package com.example.hotelreservationsystemc;



import dao.ReservationDao;
import dao.RoomDao;
import dao.UserDao;
import model.Room;
import model.Reservation;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserDao userDAO = new UserDao();
        RoomDao roomDAO = new RoomDao();
        ReservationDao reservationDAO = new ReservationDao();

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Search Available Rooms");
            System.out.println("4. Make a Reservation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    registerUser(userDAO);
                    break;
                case 2:
                    loginUser(userDAO);
                    break;
                case 3:
                    searchAvailableRooms(roomDAO);
                    break;
                case 4:
                    makeReservation(reservationDAO);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerUser(UserDao userDao) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        userDao.registerUser(username, password, email);
        System.out.println("User registered successfully!");
    }

    private static void loginUser(UserDao userDao) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        boolean loggedIn = userDao.loginUser(username, password);
        if (loggedIn) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void searchAvailableRooms(RoomDao roomDAO) {
        List<Room> rooms = roomDAO.getAllAvailableRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            System.out.println("Available rooms:");
            for (Room room : rooms) {
                System.out.println("Room ID: " + room.getRoomId());
                System.out.println("Room Number: " + room.getRoomNumber());
                System.out.println("Category: " + room.getCategory());
                System.out.println("Price: " + room.getPrice());
                System.out.println("Availability: " + (room.isAvailability() ? "Yes" : "No"));
                System.out.println();
            }
        }
    }

    private static void makeReservation(ReservationDao reservationDAO) {
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.next();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.next();
        System.out.print("Enter total price: ");
        double totalPrice = scanner.nextDouble();

        reservationDAO.makeReservation(userId, roomId, checkInDate, checkOutDate, totalPrice);
        System.out.println("Reservation made successfully!");
    }
}