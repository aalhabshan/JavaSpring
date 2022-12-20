package com.example.users_management.Service;
import com.example.users_management.Model.*;
import com.example.users_management.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    public List<User> get(){
        return userRepository.findAll();
    }
   public void add(User user){
        userRepository.save(user);
   }
    public boolean update(Integer id, User user){
        User old = userRepository.getById(id);
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
        User old = userRepository.getById(id);
        if(old == null)
            return false;
        userRepository.delete(old);
        return true;
    }
}
