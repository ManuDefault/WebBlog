package WebBlog.WebBlog.servisec;


import WebBlog.WebBlog.models.Users;
import WebBlog.WebBlog.repositores.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {


    @Autowired
    private UsersRepo repo;

    public void  saveUsers(Users users){
        repo.save(users);
    }

    public Users getUsersById(int id){
        Optional<Users> users  = repo.findById(id);
        return users.orElseThrow();
    }

    public List<Users> getAll(){
        return repo.findAll();
    }

    public void deleteById(int id){
        repo.deleteById(id);
    }
}
