package com.Spring.MyDemo.repo;

import com.Spring.MyDemo.model.Student;
import com.Spring.MyDemo.model.StudentNew;

import java.util.List;
import java.util.Map;

/**
 * Created by melayer on 13/9/17.
 */
public interface StudentRepo {

    Student getdata();

    List<Student> showdbdata();

    void savdata(Student st);

    void deleteRecord(Integer id);

    void updatedata();

    List<Map<String,Object>> joinquery();

    List<Map<String,Object>> innerjoin();

    void insertStudData(StudentNew sn);







}
