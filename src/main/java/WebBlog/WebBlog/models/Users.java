package WebBlog.WebBlog.models;

import jakarta.persistence.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class Users {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="create_at")
    private ZonedDateTime create_up;

    @Column(name = "update_at")
    private ZonedDateTime update_at;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "users")
    private List<Posts> postsList;


    public Users() {
    }

    public Users(String username, String email, String password, ZonedDateTime create_up, ZonedDateTime update_at) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.create_up = create_up;
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ZonedDateTime getCreate_up() {
        return create_up;
    }

    public void setCreate_up(ZonedDateTime create_up) {
        this.create_up = create_up;
    }

    public ZonedDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(ZonedDateTime update_at) {
        this.update_at = update_at;
    }

    public List<Posts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Posts> postsList) {
        this.postsList = postsList;
    }

    public void addToPostList(Posts posts){
        if(postsList == null){
            postsList = new ArrayList<>();
        }
        posts.setUsers(this);
        postsList.add(posts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(username, users.username) && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(create_up, users.create_up) && Objects.equals(update_at, users.update_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, create_up, update_at);
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", create_up=" + create_up +
                ", update_at=" + update_at +
                '}';
    }
}
