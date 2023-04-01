package WebBlog.WebBlog.servisec;

import WebBlog.WebBlog.models.Comments;
import WebBlog.WebBlog.repositores.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepo comRepo;


    public void saveComment(Comments comments){
        comRepo.save(comments);
    }


    public List<Comments> getAllCommentsById(int id){
        return comRepo.findAllById(Collections.singleton(id));
    }

    public void delete(int id){
        comRepo.deleteById(id);
    }
}
