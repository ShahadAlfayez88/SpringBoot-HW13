package com.example.springday03.Controller;

import com.example.springday03.Pogo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/taskmanger")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<Task>();

    // Create - worked
    @PostMapping("/create")
    public String addTodo(@RequestBody Task task){
        tasks.add(task);
        return "Task have been added";
    }

    // display - worked
    @GetMapping("/display") //do homework
    public ArrayList<Task> displayTasks(){
        return tasks;
    }

    // Search -
    @GetMapping("/search/{title}")
    Optional<Task> searchByTitle(@PathVariable String title) {
        for (Task task : tasks) {
            if (title.equals(task.getTitle())) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    // update
    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task task){
        tasks.set(index, task);
        return "Task have been Updated";
    }


    // Change Status
    @GetMapping("/change/{index2}")
    Optional<Task> changeStatus(@PathVariable int index2 , Task task){
            for (Task task2 : tasks) {
                if (task2.getStatus()!="done") {
                    task2.setStatus("done");
                    return Optional.of(task2);
                }
            }
            return Optional.empty();
        }

    // delete
    @DeleteMapping("/delete/{index3}")
    public String deleteTodo(@PathVariable int index3){
        tasks.remove(index3);
        return "task Deleted";

    }





}
