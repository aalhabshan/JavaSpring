package com.example.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v2")
public class Controller {

    ArrayList<ToDoList> tasks= new ArrayList<>();
    @GetMapping("/tasks")
    public ArrayList<ToDoList> getTasks(){
        return tasks;
    }
    @PostMapping("/add")
    public ApiResponse add(@RequestBody ToDoList task){
        tasks.add(task);
        return new ApiResponse("Added task");
    }
    @PutMapping("/update/{index}")
    public ApiResponse update(@PathVariable int index,@RequestBody ToDoList task){
        tasks.set(index,task);
        return new ApiResponse("Updated");
    }
    @DeleteMapping("/delete/{index}")
    public ApiResponse del(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponse("Deleted");
    }
    @PutMapping("/updatestatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index, @RequestBody String status){
        tasks.get(index).setStatus(status);
        return new ApiResponse("changed");
    }

    @GetMapping("/search")
    public ApiResponse search(@RequestBody String task){

        for(int i = 0; i<tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(task))
                return new ApiResponse(task);
        }
        return new ApiResponse("Not found");
    }
}
