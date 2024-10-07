package data;
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
}