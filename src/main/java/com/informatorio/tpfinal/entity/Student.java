package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    @Id
    Long id;

    /* The joinColumn attribute will connect to the owner side of the relationship,
     and the inverseJoinColumn to the other side */
    @ManyToMany
    @JoinTable(
//            name="course_like",
            joinColumns = @JoinColumn(name="student_id"),
            inverseJoinColumns = @JoinColumn(name="course_id")
    )
    Set<Course> likedCourses;

//    constructor
    public Student() {
    }

//    constructor
    public Student(Long id, Set<Course> likedCourses) {
        this.id = id;
        this.likedCourses = likedCourses;
    }

//    getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Course> getLikedCourses() {
        return likedCourses;
    }

    public void setLikedCourses(Set<Course> likedCourses) {
        this.likedCourses = likedCourses;
    }

}
