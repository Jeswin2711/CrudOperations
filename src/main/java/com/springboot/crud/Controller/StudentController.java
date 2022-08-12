package com.springboot.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.crud.Model.Student;
import com.springboot.crud.Service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;
    /*
     * Function to add a Student
     */
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student)
    {
        return service.createStudent(student);
    }
    /*
     * Function to add a List of Student
     */
    @PostMapping("/addstudents")
    public List<Student> addStudents(@RequestBody List<Student> students)
    {
        return service.createStudentList(students);
    }
    /*
     * Function to get a Student by Id
     */
    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable int id)
    {
        return service.getStudent(id);
    }
    /*
     * Function to get all Students
     */
    @GetMapping("/getall")
    public List<Student> getAll()
    {
        return service.getAllStudent();
    }
    /*
     * Function to delete a Student by Id
     */
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id)
    {
        return service.deleteStudent(id);
    }
    /*
     * Function to update a Student
     */
    @PutMapping("/update")
    public String updatStudent(@RequestBody Student student)
    {
        Student result = service.updateStudent(student);
        if(result.getName() == null) return "ID not present";
        else return "Updated Successfully";
    }

}
