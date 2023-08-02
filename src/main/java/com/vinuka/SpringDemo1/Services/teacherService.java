package com.vinuka.SpringDemo1.Services;

import com.vinuka.SpringDemo1.Models.teacher;
import com.vinuka.SpringDemo1.Repos.teacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class teacherService {
    private final teacherRepo _teacherRepo;
@Autowired
    public teacherService(teacherRepo teacherRepo) {
        _teacherRepo = teacherRepo;
    }

    public List<teacher> GetAllTeacher() {
        return _teacherRepo.findAll() ;
    }
}
