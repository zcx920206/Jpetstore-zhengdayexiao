package com.thoughtworks.jpetstore.persistence;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountMapper {

  Account getAccountByUsername(String username);

  void insertAccount(Account account);

  void updateAccount(Account account);

  Student getstudentclass(int id);

  @Insert("insert into student(name,id,classes) values(#{name},#{id},#{classes})")
  public int addStudent(Student student);

  @Delete("delete from student where id = #{id}")
  public int deleteStudentById(int id);

  @Update("update student set name = #{name}, classes = #{classes} where id = #{id}")
  public int updateStudent(Student student);

  @Select("select * from student where id = #{id}")
  public Student getStudentById(int id);

  @Select("select * from student")
  public List<Student> getAllStudent();
}
