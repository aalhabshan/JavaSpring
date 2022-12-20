package com.example.users_management.Service;
import com.example.users_management.Exception.ApiException;
import com.example.users_management.Model.*;
import com.example.users_management.Repository.*;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> get(){
        return userRepository.findAll();
    }
   public void add(User user){
        userRepository.save(user);
   }
    public boolean update(Integer id, User user){
        User old = userRepository.getUserById(id);
        if(old == null)
            return false;
        user.setAge(old.getAge());
        user.setRole(old.getRole());
        user.setEmail(old.getEmail());
        user.setName(old.getName());
        user.setPassword(old.getPassword());
        return true;
    }
    public boolean delete(Integer id){
        User old = userRepository.getUserById(id);
        if(old == null)
            return false;
        userRepository.delete(old);
        return true;
    }
    public void check(String un, String pass){
        User user= userRepository.getUserByUsernameAndPassword(un,pass);
        if(user == null)
            throw new ApiException("Wrong username or password");
    }
    public User getByE(String email){
        User user= userRepository.getUserByEmail(email);
        if (user==null)
            throw new ApiException("Wrong E-mail");
        return user;
    }
    public List<User> getAllByRole(String role){
        List<User> users= userRepository.getAllByRole(role);
        if(users.isEmpty())
            throw new APIException("Wrong role");
        return users;
    }
    public List<User> getbyAge(Integer age){
        List<User> users= userRepository.getAllByAgeGreaterThanEqual(age);
        if(users.isEmpty())
            throw new APIException("there is no user of this age or older");
        return users;
    }
}
