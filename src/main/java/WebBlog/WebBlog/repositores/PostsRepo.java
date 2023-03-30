package WebBlog.WebBlog.repositores;

import WebBlog.WebBlog.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepo extends JpaRepository<Posts,Integer> {
}
