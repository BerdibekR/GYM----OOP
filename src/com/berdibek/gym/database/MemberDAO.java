package com.berdibek.gym.database;

import com.berdibek.gym.model.Member;
import com.berdibek.gym.model.StudentMember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    public void insertMember(Member member) {

        String sql =
                "INSERT INTO member (name, age, membership_type, monthly_fee) VALUES (?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, member.getName());
            statement.setInt(2, member.getAge());
            statement.setString(3, member.getMembershipType());
            statement.setDouble(4, member.getMonthlyFee());

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

    public void getAllMembers() {

        String sql = "SELECT * FROM member";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            System.out.println("\n--- ALL MEMBERS ---");

            while (rs.next()) {
                Member m = extractMember(rs);
                if (m != null) {
                    System.out.println(m);
                }
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(" Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public Member getMemberById(int memberId) {

        String sql = "SELECT * FROM member WHERE member_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, memberId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Member m = extractMember(rs);
                rs.close();
                statement.close();
                return m;
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }

    public boolean updateMember(Member member) {

        String sql =
                "UPDATE member SET name = ?, age = ?, membership_type = ?, monthly_fee = ? " +
                        "WHERE member_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, member.getName());
            statement.setInt(2, member.getAge());
            statement.setString(3, member.getMembershipType());
            statement.setDouble(4, member.getMonthlyFee());
            statement.setInt(5, member.getMemberId());

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println(" Member updated: " + member.getName());
                return true;
            }

        } catch (SQLException e) {
            System.out.println(" Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean deleteMember(int memberId) {

        String sql = "DELETE FROM member WHERE member_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, memberId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println(" Member deleted (ID: " + memberId + ")");
                return true;
            } else {
                System.out.println(" No member found with ID: " + memberId);
            }

        } catch (SQLException e) {
            System.out.println(" Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public List<Member> searchByName(String name) {

        List<Member> memberList = new ArrayList<>();

        String sql = "SELECT * FROM member WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return memberList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Member m = extractMember(rs);
                if (m != null) {
                    memberList.add(m);
                }
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(" Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return memberList;
    }

    public List<Member> searchByFeeRange(double min, double max) {

        List<Member> memberList = new ArrayList<>();

        String sql =
                "SELECT * FROM member " +
                        "WHERE monthly_fee BETWEEN ? AND ? " +
                        "ORDER BY monthly_fee DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return memberList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setDouble(1, min);
            statement.setDouble(2, max);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Member m = extractMember(rs);
                if (m != null) {
                    memberList.add(m);
                }
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(" Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return memberList;
    }

    public List<Member> searchByMinFee(double min) {

        List<Member> memberList = new ArrayList<>();

        String sql =
                "SELECT * FROM member " +
                        "WHERE monthly_fee >= ? " +
                        "ORDER BY monthly_fee DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return memberList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, min);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Member m = extractMember(rs);
                if (m != null) {
                    memberList.add(m);
                }
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return memberList;
    }

    private Member extractMember(ResultSet rs) {

        try {
            StudentMember m = new StudentMember(
                    rs.getInt("member_id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("membership_type"),
                    "AITU"
            );

            m.setMonthlyFee(rs.getDouble("monthly_fee"));
            return m;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}