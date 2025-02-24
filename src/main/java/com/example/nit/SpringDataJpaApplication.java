package com.example.nit;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.nit.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaApplication.class, args);
		StudentRepo repo=ctx.getBean(StudentRepo.class);


		//object of student
		Student s1=ctx.getBean(Student.class);
		Student s2=ctx.getBean(Student.class);
		Student s3=ctx.getBean(Student.class);

		s1.setRollno(1);
		s1.setName("sam");
		s1.setMarks(45);

		s2.setRollno(2);
		s2.setName("ram");
		s2.setMarks(85);

		s3.setRollno(3);
		s3.setName("sayyami");
		s3.setMarks(98);


		repo.save(s1);// automatically create a tablee if not there
		repo.save(s2);
		repo.save(s3);


		repo.findAll();//to fetch all the records

		Optional<Student> s=repo.findById(3);// it will take the primary key as an id
		//if it is null then null point exception will happen so thats why we put it in an optional class which is java 8 feature

	      //update the user id of 11
		Optional<Student> u=repo.findById(1);
		   Student change=u.get();//get the id and store it
		   change.setName("shaunak");

		  Student result=repo.save(change);
		  System.out.println(result);//to print the new update


		//to delete the data

		repo.deleteById(1);
		System.out.println("deleted");


		//to delete multiple with collection
		Iterable<Student> allusers=repo.findAll();
		allusers.forEach(x->System.out.println(x));//print that users
		repo.deleteAll(allusers);//to delete by collection


		//to select all
		Iterable<Student> itr=repo.findAll();
		itr.forEach(x-> System.out.println(x));



		//custom method call
		repo.findByname("sam");

		//by sql qquery
		repo.getStudent();
	}

}
