package WebBlog.WebBlog.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "created_at")
    private ZonedDateTime created_at;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_follower")
    private List<Users> id_follower;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_following")
    private List<Users> id_following;


    private Subscriptions(){

    }

    private Subscriptions(ZonedDateTime zonedDateTime,Users follower,Users following){
        this.created_at=zonedDateTime;
        this.id_follower = new ArrayList<>();
        this.id_follower.add(follower);
        this.id_following = new ArrayList<>();
        this.id_following.add(following);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ZonedDateTime created_at) {
        this.created_at = created_at;
    }

    public List<Users> getId_follower() {
        return id_follower;
    }

    public void setId_follower(List<Users> id_follower) {
        this.id_follower = id_follower;
    }

    public List<Users> getId_following() {
        return id_following;
    }

    public void setId_following(List<Users> id_following) {
        this.id_following = id_following;
    }

    public void addFollower(Users follower){
        if(this.id_follower == null){
            this.id_follower = new ArrayList<>();
        }
        id_follower.add(follower);
    }

    public void addFollowing(Users following){
       if(  this.id_following == null){
           this.id_following = new ArrayList<>();
       }

       this.id_following.add(following);
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", id_follower=" + id_follower +
                ", id_following=" + id_following +
                '}';
    }
}
