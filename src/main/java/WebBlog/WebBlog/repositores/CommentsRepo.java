package WebBlog.WebBlog.repositores;

import WebBlog.WebBlog.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepo extends JpaRepository<Comments,Integer> {
}
