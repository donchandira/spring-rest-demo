package com.chandira.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandira.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	List<Student> students = new ArrayList<>();

	@PostConstruct
	public void loadData() {
		students.add(new Student("Chandira", "Withanage"));
		students.add(new Student("Hasini", "Kuruppu"));
		students.add(new Student("Mango", "Withanage"));
		students.add(new Student("Lily", "Withanage"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	@GetMapping("/student/{studentId}")
	public Student getStudents(@PathVariable int studentId) {
		try {
			return students.get(studentId);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

}
