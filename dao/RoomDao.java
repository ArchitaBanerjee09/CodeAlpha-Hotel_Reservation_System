package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Room;
import com.example.hotelreservationsystemc.DatabaseConnection;

public class RoomDao{
    public List<Room> getAllAvailableRooms() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM rooms WHERE availability = TRUE";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomId(resultSet.getInt("room_id"));
                room.setRoomNumber(resultSet.getInt("room_number"));
                room.setCategory(resultSet.getString("category"));
                room.setPrice(resultSet.getBigDecimal("price"));
                room.setAvailability(resultSet.getBoolean("availability"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
