<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bundesliga Teams</title>
<link rel="stylesheet" type="text/css" href="Teams.css">
</head>
<body>
    <header>
        <div class="container">
            <h1>Bundesliga Teams</h1>
        </div>
    </header>

    <nav>
        <div class="container">
            <a href="index">Home</a>
        </div>
    </nav>

    <section>
        <div class="container">
            <h2>Teams</h2>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Coach</th>
                        <th>Points</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="team" items="${teams}">
                        <tr>
                            <td>${team.id}</td>
                            <td>${team.name}</td>
                            <td>${team.coach}</td>
                            <td>${team.points}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

    <footer>
        <div class="container">
            &copy; 2023 Bundesliga Teams. All rights reserved.
        </div>
    </footer>
</body>
</html>
