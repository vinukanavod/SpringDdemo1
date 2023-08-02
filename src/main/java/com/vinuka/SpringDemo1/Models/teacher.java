package com.vinuka.SpringDemo1.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
@Entity
@Table

public class teacher {
    @Id
    @SequenceGenerator(
            name="teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long Tid;
    private String Fname;
    private String Lname;
    @Column(name = "Date Of Birth")
    private LocalDate dob;
    @Transient
    private Integer age;
    private String Email;

    public teacher(Long tid, String fname,String lname,String email) {
        this.Tid = tid;
        this.Fname = fname;
        this.Lname = lname;
       // this.age = age;
        this.Email = email;
    }
    public teacher(String fname, String lname,String email) {
       // this.Tid = tid;
        this.Fname = fname;
        this.Lname = lname;
       // this.age = age;
        this.Email = email;
    }

    public teacher() {

    }

    public Long getTid() {
        return Tid;
    }

    public void setTid(Long tid) {
        Tid = tid;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
