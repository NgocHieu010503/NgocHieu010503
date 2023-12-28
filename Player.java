import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String position;
    private int jerseyNumber;

    // Constructors
    public Player() {
    }

    public Player(int id, String name, String position, int jerseyNumber) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    // toString method for debugging or logging
    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", position=" + position + ", jerseyNumber=" + jerseyNumber + "]";
    }
}
