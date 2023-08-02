package com.vinuka.SpringDemo1.Controlles;

import com.vinuka.SpringDemo1.Models.student;
import com.vinuka.SpringDemo1.Services.studentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path ="api/student")
public class studentController {
    private studentService _StudentService;
    @Autowired
    public studentController(studentService student ) {

        this._StudentService = student;
    }

//    @GetMapping("/f")
//    public String hello2(){
//        return "Hai Vinuka Navod";
//    }


    @GetMapping("/json")
    public List<student> GetStudent() {

      return _StudentService.GetStudent();
    }
    @PostMapping
    public void addNewStudent(@RequestBody student student) throws IllegalAccessException {
        _StudentService.addNewStudent(student);
    }
    @DeleteMapping(path="{studentid}")
    public void deleteStudent(@PathVariable("studentid") Long id) throws IllegalAccessException {
        _StudentService.deleteStudent(id);
    }

     @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
    @RequestParam(required = false) String name,
    @RequestParam(required = false) String email) throws IllegalAccessException {
        _StudentService.updateStudent(studentId,name,email);
     }


}

