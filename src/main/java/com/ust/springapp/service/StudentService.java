package com.ust.springapp.service;

import com.ust.springapp.entity.Student;

import com.ust.springapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student)
    {
           return studentRepository.save(student);
    }
     public List<Student> findAll()
     {
         return studentRepository.findAll();
     }

     public Student findById(long id)
     {
         Optional<Student> option = studentRepository.findById(id);
         if(option.isPresent())
         {
             return option.get();
         }
         else
             return null;

     }

     public Student updateStudent(long id ,Student student)
     {


         if(studentRepository.existsById(id))
         {
             student.setId(id);
             return studentRepository.save(student);
         }

         else{
             return null;
         }
     }

     public boolean deleteById(long id){


     if(studentRepository.existsById(id))
     {
         studentRepository.deleteById(id);
         return true;
     }
     else {
         return false;
     }

     }

}
