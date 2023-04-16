package com.bryan._007onlineexamsystem.dao;

import com.bryan._07onlineexamsystem.entity.User;
import com.bryan._07onlineexamsystem.util.JdbcUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    private final JdbcUtil util = new JdbcUtil();

    // 添加用户
    public int add(User user) {
        int result = 0;
        try {
            String sql = "insert into Users values(null, ?, ?, ?, ?)";

            PreparedStatement statement = util.createStatement(sql);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSex());
            statement.setString(4, user.getEmail());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            util.close();
        }
        return result;
    }

    // 重载
    public int add(User user, HttpServletRequest request) {
        int result = 0;
        try {
            String sql = "insert into Users values(null, ?, ?, ?, ?)";

            PreparedStatement statement = util.createStatement(sql, request);

            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getSex());
            statement.setString(4, user.getEmail());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            util.close(request);
        }
        return result;
    }

    // 查询所有用户信息
    public ArrayList<User> find() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "select * from Users";

            PreparedStatement statement = util.createStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String userId = resultSet.getString(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                String sex = resultSet.getString(4);
                String email = resultSet.getString(5);
                User user = new User(userId, userName, password, sex, email);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            util.close();
        }

        return users;
    }

    // 删除用户
    public int delete(String UserId) {
        int result = 0;

        try {
            String sql = "delete from Users where userId = ?";
            PreparedStatement statement = util.createStatement(sql);
            statement.setString(1, UserId);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            util.close();
        }

        return result;
    }

    public int login(String userName, String password) {
        ResultSet resultSet;
        int result = 0;
        try {
            String sql = "select count(*) from Users where userName = ? and password = ?";
            PreparedStatement statement = util.createStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, password);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result = resultSet.getInt("count(*)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            util.close();
        }

        return result;
    }
}
