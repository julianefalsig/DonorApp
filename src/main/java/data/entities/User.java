package data.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "DBUSER") //WATCH out  USER is a reserved name!
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "username", unique = true)
    private String username;

    @Column (name= "password")
    private String password;

    @OneToOne(mappedBy ="user", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private Donor donor;

    // Constructors
    public User(){} //empty one for flexibility
    public User(String username, String password){ //one for creating "Superusers", does not have a relation to donor
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, Donor donor){ //one for users that are donors
        this.username = username;
        this.password = password;
        this.donor = donor;
    }

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

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Donor getDonor(){return donor;}
    public void setDonor(Donor donor){
        this.donor = donor;
    }

}