package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/ex01/create")
	public StudentEntity create() {
		String name = "유용준";
		String phoneNumber = "010-9281-8587";
		String email = "dydwns6837@naver.com";
		String dreamJob = "개발자";
		
		// save 된 객체를 리턴하므로 id값이 채워져 있다.
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// U: Update
	@GetMapping("/ex01/update")
	public StudentEntity update() {
		// id가 5번인 dreamJob 변경
		return studentBO.updateStudentDreamJobById(5, "운동선수");
	}
	
	// D: Delete
	@GetMapping("/ex01/delete")
	public String delete() {
		// id:4 삭제
		studentBO.deleteStudentById(4);
		return "삭제 성공";
	}
}
