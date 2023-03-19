package WebBlog.WebBlog.models;


import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class Tags {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String name;

    public Tags() {
    }

    public Tags(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
