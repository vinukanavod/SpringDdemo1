package com.vinuka.SpringDemo1.Repos;

import com.vinuka.SpringDemo1.Models.teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teacherRepo extends JpaRepository<teacher,Long> {



}
