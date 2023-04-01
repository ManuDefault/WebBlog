package WebBlog.WebBlog.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.IdentityHashMap;

@Entity
@Table(name="comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private ZonedDateTime zonedDateTime;


    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Posts posts;


    @OneToOne
    @JoinColumn(name = "users_id")
    private Users users;

    public Comments() {
    }

    public Comments(String content, ZonedDateTime zonedDateTime, Posts posts, Users users) {
        this.content = content;
        this.zonedDateTime = zonedDateTime;
        this.posts = posts;
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", zonedDateTime=" + zonedDateTime +
                ", posts=" + posts +
                ", users=" + users +
                '}';
    }
}
