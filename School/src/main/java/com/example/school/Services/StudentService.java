package com.example.school.Services;
import com.example.school.Model.*;
import com.example.school.Controllers.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students= new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public boolean isUpdated(Integer id, Student student) {
        int index = idHere(id);
        if( index == -1)
            return false;
        students.set(index,student);
        return true;
    }

    public int idHere(Integer id) {
        for(int i=0; i<students.size();i++)
            if(students.get(i).getId()==id)
                return i;
        return -1;
    }

    public boolean isDeleted(Integer id) {
        int index= idHere(id);
        if(index == -1)
            return false;
        students.remove(index);
        return true;
    }

    public Student whoStudent(int index) {
        return students.get(index);
    }

    public int nameHere(String name) {
        for(int i=0; i<students.size();i++)
            if(students.get(i).getName().equals(name))
                return i;
        return -1;
    }

    public ArrayList<Student> getMajorStudents(String major) {
        ArrayList<Student> majors = new ArrayList<>();
        for(int i=0; i<students.size();i++)
            if(students.get(i).getMajor().equals(major))
                majors.add(students.get(i));
        return majors;
    }

    public ArrayList<Student> getAgeStudents(Integer age) {
        ArrayList<Student> ages = new ArrayList<>();
        for(int i=0; i<students.size();i++)
            if(students.get(i).getAge()>=age)
                ages.add(students.get(i));
        return ages;
    }
}
