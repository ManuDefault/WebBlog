package WebBlog.WebBlog.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post_tags")
public class PostTags {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tag")
    private List<Tags> tags;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_post")
    private List<Posts> posts;

    public PostTags() {
    }

    public PostTags(int id, List<Tags> tags, List<Posts> post) {
        this.id = id;
        this.tags = tags;
        this.posts = post;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Posts> getUsers() {
        return posts;
    }

    public void setUsers(List<Posts> posts) {
        this.posts = posts;
    }

    public void addTag(Tags tags){
        if(this.tags == null){
            this.tags = new ArrayList<>();
        }

        this.tags.add(tags);
    }

    public void addPost(Posts posts){
        if( this.posts== null){
            this.posts = new ArrayList<>();
        }

        this.posts.add(posts);
    }


    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "PostTags{" +
                "id=" + id +
                ", tags=" + tags +
                ", posts=" + posts +
                '}';
    }
}
