package com.thoughtworks.jpetstore.service;


import com.thoughtworks.jpetstore.domain.Course;
import com.thoughtworks.jpetstore.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.persistence.AccountMapper;

import java.util.List;

@Service
public class AccountService {

  @Autowired
  private AccountMapper accountMapper;

  public Account getAccount(String username) {
    return accountMapper.getAccountByUsername(username);
  }
  public Student getstudentclass(int id){
    return accountMapper.getstudentclass(id);
  }

  public int addStudent(Student student){
    return accountMapper.addStudent(student);
  }
  public int addCourse(Course course){
    return accountMapper.addCourse(course);
  }

  public int deleteStudentById(int id){
    return accountMapper.deleteStudentById(id);
  }

  public int updateStudent(Student student){
    return accountMapper.updateStudent(student);
  }

  public Student getStudentById(int id){
    return accountMapper.getStudentById(id);
  }

  public List<Student> getAllStudent(){
    return accountMapper.getAllStudent();
  }

  public List<Course> getAllCourse(){
    return accountMapper.getAllCourse();
  }
  public List<Student> getStudent(String cname){return accountMapper.getStudent(cname);}
  public List<Student> getPassstudent(String cname){return accountMapper.getPassstudent(cname);}
}
