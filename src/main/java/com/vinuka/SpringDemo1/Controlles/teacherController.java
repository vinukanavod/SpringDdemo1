package com.vinuka.SpringDemo1.Controlles;

import com.vinuka.SpringDemo1.Models.teacher;
import com.vinuka.SpringDemo1.Services.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/teacher")
public class teacherController {

    private teacherService _teacherService;
@Autowired
    public teacherController(teacherService _teacherService) {
        this._teacherService = _teacherService;
    }



    @GetMapping("/json")
    public List<teacher>GetAllTeacher(){
      return _teacherService.GetAllTeacher();
    }




}
