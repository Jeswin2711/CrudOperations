package com.springboot.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.crud.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {}
