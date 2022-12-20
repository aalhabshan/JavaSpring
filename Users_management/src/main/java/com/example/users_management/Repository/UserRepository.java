package com.example.users_management.Repository;

import com.example.users_management.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User getUserById(Integer id);
    public User getUserByUsernameAndPassword(String un,String pass);
    public User getUserByEmail(String email);
    public List<User> getAllByRole(String role);
    public List<User> getAllByAgeGreaterThanEqual(Integer sge);
}
