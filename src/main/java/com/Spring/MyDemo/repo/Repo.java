package com.Spring.MyDemo.repo;

import com.Spring.MyDemo.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by melayer on 13/9/17.
 */
public interface Repo {

    Student getdata();

    List<Student> showdbdata();

    void savdata(Student st);

    void deleteRecord(Integer id);

    void updatedata();

    List<Map<String,Object>>  joinquery();

    List<Map<String,Object>>  innerjoin();




}
