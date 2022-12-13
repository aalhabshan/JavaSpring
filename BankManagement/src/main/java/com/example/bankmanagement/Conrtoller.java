package com.example.bankmanagement;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v3")
public class Conrtoller {
    ArrayList<User> users= new ArrayList<>();

    @GetMapping("/users")
    public ArrayList<User> allUsers(){
        return users;
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody User user){
        users.add(user);
        return new ApiResponse("Added User");
    }
    @PutMapping("/update/{index}")
    public ApiResponse update(@PathVariable int index,@RequestBody User user){
        users.set(index,user);
        return new ApiResponse("Updated");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse del(@PathVariable int index){
        users.remove(index);
        return new ApiResponse("Deleted");
    }

    @PutMapping("/Deposit/{id}")
    public ApiResponse Deposit(@PathVariable int id,@RequestBody double dep){
        for(int i=0; i< users.size();i++){
            if(users.get(i).getId()==id){
                users.get(i).setBalance(users.get(i).getBalance()+dep);
                return new ApiResponse("done Deposit "+dep);
            }
        }
        return new ApiResponse("The user not found");
    }

    @PutMapping("/Withdraw/{id}")
    public ApiResponse Withdraw(@PathVariable int id,@RequestBody double wi){
        for(int i=0; i< users.size();i++){
            if(users.get(i).getId()==id){
                if(users.get(i).getBalance() > wi) {
                    users.get(i).setBalance(users.get(i).getBalance() - wi);
                    return new ApiResponse("done Withdraw "+wi);
                }
                return new ApiResponse("The balance insufficient");
            }
        }
        return new ApiResponse("The user not found");
    }

}
