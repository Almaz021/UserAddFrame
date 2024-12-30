package ru.itis.fisd.repository;

import ru.itis.fisd.database.DBConnection;
import ru.itis.fisd.model.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    private final DBConnection db = DBConnection.getInstance();

    /* language=sql */
    private static final String SQL_INSERT = """
            INSERT INTO users(name, password)
            VALUES (?, ?)
            """;

    public void save(UserEntity user) {
        try (
                Connection connection = db.getConnection()
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
