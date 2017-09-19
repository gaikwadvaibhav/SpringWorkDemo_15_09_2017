package com.Spring.MyDemo.controller;

import com.Spring.MyDemo.impl.StudImpl;
import com.Spring.MyDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by melayer on 13/9/17.
 */
@RestController
public class Studcontrol {

    @Autowired
    private StudImpl studentimpl;

    @Autowired
    public void setStudentimpl(StudImpl studentimpl) {
        this.studentimpl = studentimpl;
    }

    @GetMapping(value = "/getdata")
    Student data(){
        Student st=studentimpl.getdata();
        System.out.println(st);
        return st;
    }

    @GetMapping(value = "/showdbdata")
    List<Student> showdbdt(){
        List<Student> li=studentimpl.showdbdata();
        System.out.println(li);
        return li;
    }

    @PostMapping(value = "/insert")
    String getImageAndData(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam MultipartFile file){

        String imagename= file.getOriginalFilename();
        File f= new File("/home/melayer/Desktop/Hello/" +imagename);

        String st1= f.getAbsolutePath();
        System.out.println(st1);

        Student s1=new Student();
        s1.setId(id);
        s1.setName(name);
        s1.setImgPath(imagename);

        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        studentimpl.savdata(s1);

        return "Data Saved...";
    }

    @GetMapping(value = "/delete")
     String deleteRecord(@RequestParam Integer id) {
        studentimpl.deleteRecord(id);
        return "Record deleted ......";
    }

    @PostMapping(value = "/update")
            String updatedata(){
                studentimpl.updatedata();
                return "Record Updated";
    }

    @GetMapping(value = "/joinquery")
        List<Map<String,Object>> join(){
        List<Map<String,Object>> list=studentimpl.joinquery();
        return list;
            }

    @GetMapping(value = "/innerjoin")
    List<Map<String,Object>> inner(){
        List<Map<String,Object>> list=studentimpl.innerjoin();
        return list;
    }

}
