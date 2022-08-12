package com.springboot.crud.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "StudentList")
/*
 * Pojo Class or Encapsulated Class
 */
public class Student {
    
    @Id
    private int id;
    private String name;
    private int rank;
}
