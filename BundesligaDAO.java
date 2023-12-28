package com.yourcompany.bundesliga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcompany.bundesliga.model.Fixture;
import com.yourcompany.bundesliga.util.DBUtil;

public class BundesligaDAO {
    private Connection connection;

    public BundesligaDAO() {
        connection = DBUtil.getConnection();
    }

    // Lấy danh sách đội bóng từ cơ sở dữ liệu
    public List<String> getAllTeams() {
        List<String> teams = new ArrayList<>();
        try {
            String query = "SELECT team_name FROM teams";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    teams.add(resultSet.getString("team_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    // Lấy danh sách các trận đấu từ cơ sở dữ liệu
    public List<Fixture> getAllFixtures() {
        List<Fixture> fixtures = new ArrayList<>();
        try {
            String query = "SELECT home_team, away_team, match_date FROM fixtures";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String homeTeam = resultSet.getString("home_team");
                    String awayTeam = resultSet.getString("away_team");
                    String matchDate = resultSet.getString("match_date");
                    fixtures.add(new Fixture(homeTeam, awayTeam, matchDate));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fixtures;
    }

    // Thêm mới một trận đấu vào cơ sở dữ liệu
    public boolean addFixture(Fixture fixture) {
        try {
            String query = "INSERT INTO fixtures (home_team, away_team, match_date) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, fixture.getHome());
                preparedStatement.setString(2, fixture.getAway());
                preparedStatement.setString(3, fixture.getDate());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật kết quả trận đấu vào cơ sở dữ liệu
    public boolean updateFixtureResult(String homeTeam, String awayTeam, String result) {
        try {
            String query = "UPDATE fixtures SET result = ? WHERE home_team = ? AND away_team = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, result);
                preparedStatement.setString(2, homeTeam);
                preparedStatement.setString(3, awayTeam);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
