package com.berdibek.gym.database;

import com.berdibek.gym.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

    public void insertMember(Member member) {

        String sql =
                "INSERT INTO member (name, age, membership_type) VALUES (?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set parameters (? → actual values)
            statement.setString(1, member.getName());
            statement.setInt(2, member.getAge());
            statement.setString(3, member.getMembershipType());

            // Execute INSERT
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println(" Member inserted successfully!");
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println(" Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
}