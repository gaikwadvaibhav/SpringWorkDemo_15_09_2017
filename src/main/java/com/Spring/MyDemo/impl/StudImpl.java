package com.Spring.MyDemo.impl;

import com.Spring.MyDemo.model.DeptModel;
import com.Spring.MyDemo.model.Student;
import com.Spring.MyDemo.model.StudentNew;
import com.Spring.MyDemo.repo.DeptRepo;
import com.Spring.MyDemo.repo.StudentRepo;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by melayer on 13/9/17.
 */
@Service
public class StudImpl implements StudentRepo  {

    @Override
    public Student getdata() {
        Student s= new Student();

        s.setId(1);
        s.setName("Vaibhav");

        return s;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> showdbdata() {
        String sql= "select * from mytab";

        List<Student> li=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return li;

    }

    @Override
    public void savdata(Student st) {

        String sql="insert into mytab values(?,?,?)";

        jdbcTemplate.update(sql, new Object[]{
                st.getId(),st.getName(),st.getImgPath()});
    }

    @Override
    public void deleteRecord(Integer id) {
        String sql1="delete from mytab where id=?";
        jdbcTemplate.update(sql1,new Object[]{id});
    }

    @Override
    public void updatedata() {
        String sql2="update mytab set name='VaibhavGaikwad' where id=3";
        jdbcTemplate.update(sql2);
    }

    @Override
    public List<Map<String, Object>> joinquery() {
        String sqlquery="select mytab.id, mytab.name, mytab.imgPath, demotab.city, demotab.pin  from mytab join demotab on mytab.id=demotab.id";
        List<Map<String, Object>> li=jdbcTemplate.queryForList(sqlquery);
        return li;
    }

    @Override
    public List<Map<String, Object>> innerjoin() {
        String sqlinner="select mytab.id, mytab.name, demotab.city  from mytab inner join demotab on mytab.id=demotab.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sqlinner);
        return list;
    }

    public void insertStudData(StudentNew s) {
        String sqlStud="insert into student values(?,?,?)";
        jdbcTemplate.update(sqlStud, new  Object[]{s.getId(),s.getName(),s.getCity()});
    }

}

