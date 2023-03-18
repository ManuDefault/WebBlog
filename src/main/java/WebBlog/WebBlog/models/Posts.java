package WebBlog.WebBlog.models;

import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name="posts")
public class Posts {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private ZonedDateTime create_at;

    @Column(name="updated_at")
    private ZonedDateTime update_at;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private Users users;

    public Posts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(ZonedDateTime create_at) {
        this.create_at = create_at;
    }

    public ZonedDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(ZonedDateTime update_at) {
        this.update_at = update_at;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", users=" + users +
                '}';
    }
}
