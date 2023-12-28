import java.io.IOException;
import java.util.List;

@WebServlet("/teams")
public class TeamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeamDAO teamDAO = new TeamDAO();
        List<Team> teams = teamDAO.getAllTeams();

        request.setAttribute("teams", teams);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/teams.jsp");
        dispatcher.forward(request, response);
    }
}
