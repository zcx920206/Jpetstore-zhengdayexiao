package com.thoughtworks.jpetstore.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {

  private String id;
  private String cname;
  private int grade;

}
