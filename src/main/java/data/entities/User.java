package data.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "DBUSER") //WATCH out  USER is a reserved name!
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;

    // TODO: Remember Getters and setters as well
    // Getter for id
    public int getId() {
        return id;
    }
    // Setter for id
    public void setId(int id) {
        this.id = id;
    }
    // Getter for username
    public String getUsername() {
        return username;
    }
    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }
}