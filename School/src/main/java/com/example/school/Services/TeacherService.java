package com.example.school.Services;
import com.example.school.Model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers= new ArrayList<>();
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void add(Teacher teacher) {
        teachers.add(teacher);
    }


    public boolean isUpdated(Integer id, Teacher teacher) {
        int index = idHere(id);
        if( index == -1)
            return false;
        teachers.set(index,teacher);
        return true;
    }

    public int idHere(Integer id) {
        for(int i=0; i<teachers.size();i++)
            if(teachers.get(i).getId()==id)
                return i;
        return -1;
    }

    public boolean isDeleted(Integer id) {
        int index= idHere(id);
        if(index == -1)
            return false;
        teachers.remove(index);
        return true;
    }
    public Teacher whoTeacher(int index) {
        return teachers.get(index);
    }
    public ArrayList<Teacher> getSalaryTechers(Integer sal) {
        ArrayList<Teacher> sals = new ArrayList<>();
        for(int i=0; i<teachers.size();i++)
            if(teachers.get(i).getSalary()>=sal)
                sals.add(teachers.get(i));
        return sals;
    }

}
