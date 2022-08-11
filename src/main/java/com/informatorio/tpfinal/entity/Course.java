package com.informatorio.tpfinal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Course {

    @Id
    Long id;

    @ManyToMany
    Set<Student> likes;
}
