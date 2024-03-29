package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	public void addStduent(Student student) {
		studentMapper.insertStduent(student);
	}
	
	// input: id , output:student or null
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
