package com.example.tasks.manager;

import com.example.tasks.db.DBConnectionProvider;
import com.example.tasks.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
    Connection connection = DBConnectionProvider.getInstance().getConnection();
    UserManager userManager = new UserManager();

    public void addTask(Task task) {
        int userId = userManager.getUserIdByEmail(task.getUser().getEmail());

        String query = "INSERT INTO task(name, description, user_id, status, deadline) VALUES(?,?,?,?,?)";

        Date deadline = task.getDeadline();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setInt(3, userId);
            statement.setString(4, task.getStatus());
            statement.setDate(5, (java.sql.Date) deadline);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Task> getUserTasks(int userId) {
        String query = "SELECT * FROM task WHERE user_id = ?";
        List<Task> tasks = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Date deadline = resultSet.getDate("deadline");

                Task task = Task.builder()
                        .id(id)
                        .name(name)
                        .description(description)
                        .status(status)
                        .deadline(deadline)
                        .user(userManager.getUserById(userId)).build();

                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }

    public void updateTaskStatus(String status, int taskId) {
        String query = "UPDATE task SET status = ? WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, status);
            statement.setInt(2, taskId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> getAllTasks() {
        String query = "SELECT * FROM task";
        List<Task> tasks = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                Date deadline = resultSet.getDate("deadline");

                Task task = Task.builder()
                        .id(id)
                        .name(name)
                        .description(description)
                        .status(status)
                        .deadline(deadline)
                        .user(userManager.getUserById(resultSet.getInt("user_id"))).build();

                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }
}
