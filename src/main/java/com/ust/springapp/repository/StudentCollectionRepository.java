package com.ust.springapp.repository;

import com.ust.springapp.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class StudentCollectionRepository{

    ArrayList<Student> lst = new ArrayList<>();

    public Student addStudent(Student student)
    {

        lst.add(student);
        return student;
    }

    public List<Student> getAll()
    {
        return lst;
    }

    public Student updateStudent(Student student)
    {
        for(int i=0;i<lst.size();i++)
        {
            if(lst.get(i).getId()==student.getId())
            {
                lst.set(i,student);
                return student;
            }
        }
        return null;

    }

    public Student studentById(long id)
    {
        for(Student s: lst)
        {
            if(s.getId()== id)
            {
                return s;
            }
        }

        return null;
    }

    public void deleteStudent(long id){

        for(Student s:lst)
        {
            if(s.getId()== id)
            {
                lst.remove(s);
                break;

            }
        }
    }



}
