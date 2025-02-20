package com.example.nit;

import com.example.nit.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {//type of primary key and class name

//custom find method
    public List<Student>findByname(String name);

//to give custom query from sql
    @Query(value="select * from student",nativeQuery = true)
    public List<Student>getStudent();

}
