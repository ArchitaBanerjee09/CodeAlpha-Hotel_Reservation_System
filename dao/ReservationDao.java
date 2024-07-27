package dao;

import java.sql.Date;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.example.hotelreservationsystemc.DatabaseConnection;
import model.Reservation;
public class ReservationDao{
    public void makeReservation(int userId, int roomId, String checkInDate, String checkOutDate, double totalPrice) {
        String query = "INSERT INTO Reservations (user_id, room_id, check_in_date, check_out_date, total_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, roomId);
            preparedStatement.setDate(3, java.sql.Date.valueOf(checkInDate));
            preparedStatement.setDate(4, java.sql.Date.valueOf(checkOutDate));
            preparedStatement.setDouble(5, totalPrice);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void makeReservation(Reservation newReservation) {
    }
}

