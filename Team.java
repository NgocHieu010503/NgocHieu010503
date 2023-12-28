import java.io.Serializable;

public class Team implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String coach;
    private int points;

    // Constructors
    public Team() {
    }

    public Team(int id, String name, String coach, int points) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.points = points;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", coach=" + coach + ", points=" + points + "]";
    }
}
