package com.thoughtworks.jpetstore.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Student implements Serializable {


  private int id;
  private String name;
  private int classes;

  List<Course> coursea=new ArrayList<>();//Set 对象
}
