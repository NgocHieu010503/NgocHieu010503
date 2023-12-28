import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {
    private Connection connection;

    // Constructor và các phương thức khác cần thiết để thiết lập kết nối

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        String query = "SELECT * FROM teams";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Team team = new Team();
                team.setId(resultSet.getInt("id"));
                team.setName(resultSet.getString("name"));
                team.setAddress(resultSet.getString("address"));
                team.setPoints(resultSet.getInt("points"));
                teams.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }
}
