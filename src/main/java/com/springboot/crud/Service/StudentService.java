package com.springboot.crud.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.springboot.crud.Model.Student;
import com.springboot.crud.Repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentsRepository;
    /*
     * Service function to Create a Student
     */
    public Student createStudent(Student student)
    {
       return studentsRepository.save(student);
    }
    /*
     * Service function to get a Student
     */
    public Student getStudent(int id)
    {
        return studentsRepository.findById(id).orElse(null);
    }
    /*
     * Service function to get all Student
     */
    public List<Student> getAllStudent()
    {
        return studentsRepository.findAll();
    }
    /*
     * Service function to Create a List of Students
     */
    public List<Student> createStudentList(List<Student> students)
    {
        return studentsRepository.saveAll(students);
    }
    /*
     * Service function to Delete a Student by  Id
     */
    public String deleteStudent(int id)
    {
        studentsRepository.deleteById(id);
        return "Student Deleted Successefully";
    }
    /*
     * Service function to Update a Student by Request Body
     */
    public Student updateStudent(@RequestBody Student student)
    {
        Student oldData = null;
        Optional<Student> optional = studentsRepository.findById(student.getId());
        if (optional.isPresent()) {
            oldData = optional.get();
            oldData.setId(student.getId());
            oldData.setName(student.getName());
            oldData.setRank(student.getRank());
            return studentsRepository.save(oldData);

        }
        else
        {
            return new Student();
        }
    }
}
