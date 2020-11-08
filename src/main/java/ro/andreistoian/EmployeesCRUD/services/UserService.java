package ro.andreistoian.EmployeesCRUD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.andreistoian.EmployeesCRUD.models.User;
import ro.andreistoian.EmployeesCRUD.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> listAll() {
        return repo.findAll();
    }

    public User getUser(Long id) {
        return repo.getOne(id);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public void saveUser(User user) {
        repo.save(user);
    }

}
