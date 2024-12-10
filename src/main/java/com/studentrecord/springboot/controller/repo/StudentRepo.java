package com.studentrecord.springboot.controller.repo;

import com.studentrecord.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
