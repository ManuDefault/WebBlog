package WebBlog.WebBlog.servisec;

import WebBlog.WebBlog.models.Posts;
import WebBlog.WebBlog.repositores.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsService {

    @Autowired
    PostsRepo postsRepo;

    public void savePost(Posts posts){
        postsRepo.save(posts);
    }


    public List<Posts> getAll() {
        return postsRepo.findAll();
    }

    public Posts getPostById(int id){
        Optional<Posts> optionalPosts = postsRepo.findById(id);

        return optionalPosts.orElseThrow();
    }

}
