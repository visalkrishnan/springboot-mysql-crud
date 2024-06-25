package com.ust.springapp.controller;

import com.ust.springapp.entity.Student;
import com.ust.springapp.repository.StudentRepository;
import com.ust.springapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @Autowired
    private StudentRepository studentRepository;

//    @PostMapping("/student")
//    public Student addStudent(@RequestBody Student student)
//    {
//        return studentService.save(student);
//    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAll(){

        if(studentService.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
        {
            //  return ResponseEntity.status(HttpStatus.FOUND).body(studentService.findAll());
            return ResponseEntity.ok().body(studentService.findAll());

        }
    }


    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable long id , @RequestBody Student student)
    {

        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/student/{id}")
    public boolean deleteStudent(@PathVariable long id)
    {
        return studentService.deleteById(id);
    }

//    @GetMapping("/student/{id}")
//    public ResponseEntity<Student> findById(@PathVariable long id)
//    {
//        Optional<Student> option = studentRepository.findById(id);
////        return option.map(user -> ResponseEntity)
//
//        if(option.isEmpty()) {
//            return ResponseEntity.noContent().build();
////            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); both method can be used
//        }
//
//        else {
//            return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
//        }
//
//
//    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id)
    {
        Optional<Student> option = studentRepository.findById(id);
        return option.map(student -> ResponseEntity.ok().body(student))
                .orElseGet(() -> ResponseEntity.noContent().build());

    }
// no need for any condition to check if option object is present or not direct constion can be applied
}
