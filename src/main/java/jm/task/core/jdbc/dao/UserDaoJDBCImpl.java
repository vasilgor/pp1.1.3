package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() { // создать таблицу пользователей

        String createUsersTableSQL = """
                create table if not exists "users"(
                id BIGSERIAL NOT NULL PRIMARY KEY,
                name varchar,
                lastName varchar,
                age smallint);""";
        Statement statement = null;
        try (Connection connection = Util.getConnectionDB();) {
            statement = connection.createStatement();
            statement.execute(createUsersTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() { //удалить таблицу пользователей
        String dropUsersTableSQL = """
                DROP TABLE if exists "users";""";
        Statement statement = null;

        try (Connection connection = Util.getConnectionDB()) {
            statement = connection.createStatement();
            statement.execute(dropUsersTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) { //сохранить пользователя
        String saveUserSQL = """
                INSERT INTO "users"(name, lastName, age) VALUES(?,?,?);""";
        PreparedStatement preparedStatement = null;

        try (Connection connection = Util.getConnectionDB();) {
            preparedStatement = connection.prepareStatement(saveUserSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) { //удалить пользователя по иди
        String removeUserByIdSQL = """
                DELETE FROM users WHERE id = ?;""";
        PreparedStatement preparedStatement = null;

        try (Connection connection = Util.getConnectionDB()) {
            preparedStatement = connection.prepareStatement(removeUserByIdSQL);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() { //получить всех пользователей
        List<User> userList = new ArrayList<>();
        String getAllUsersSQL = "SELECT * FROM users";
        Statement statement = null;

        try (Connection connection = Util.getConnectionDB()) {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllUsersSQL);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                byte age = resultSet.getByte(4);
               User user = new User(name, lastname, age);
               user.setId(id);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void cleanUsersTable() { //очистить таблицу пользователей
        String cleanUsersTableSQL = "TRUNCATE users";
        Statement statement = null;

        try (Connection connection = Util.getConnectionDB()) {
            statement = connection.createStatement();
            statement.execute(cleanUsersTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
