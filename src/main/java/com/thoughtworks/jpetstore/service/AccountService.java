package com.thoughtworks.jpetstore.service;


import com.thoughtworks.jpetstore.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
