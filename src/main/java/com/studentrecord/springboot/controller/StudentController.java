package com.studentrecord.springboot.controller;


import com.studentrecord.springboot.controller.repo.StudentRepo;
import com.studentrecord.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;


    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }

    @PostMapping
    public Student createStudentRecord(@RequestBody Student student)
    {
        return studentRepo.save(student);
    }

    @GetMapping("{student_id}")
    public Student getRecordByStudent_Id(@PathVariable Long student_id) {
        return studentRepo.findById(student_id).
                orElseThrow(() -> new RuntimeException("Invalid Student_Id " + student_id));

    }
    @PutMapping("{student_id}")
    public Student updateStudentRecords(@PathVariable long student_id, @RequestBody Student studentRecord){
        Student studentUpdate = studentRepo.findById(student_id)
                .orElseThrow(() -> new RuntimeException("Invalid Student Record"));
        studentUpdate.setFirstname(studentRecord.getFirstname());
        studentUpdate.setLastname(studentRecord.getLastname());
        studentUpdate.setAge(studentRecord.getAge());

        studentUpdate.setCountry(studentRecord.getCountry());
        studentUpdate.setCity(studentRecord.getCity());
        return studentRepo.save(studentUpdate);
    }

    @DeleteMapping("{student_id}")
    public Student deleteStudentId(@PathVariable long student_id) {
        Student studentDelete = studentRepo.findById(student_id)
                .orElseThrow(() -> new RuntimeException("Invalid Student Id"));
        studentRepo.delete(studentDelete);
        return studentDelete;
    }

}
