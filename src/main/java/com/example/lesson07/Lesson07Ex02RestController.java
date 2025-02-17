package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	//!!! 이번만 BO 생략
	@Autowired
	private StudentRepository studentRepository;
	
	// 조회하는 방법
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		// 1) 전체 조회(기본 제공)
		// return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회
//		return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개만 조회
//		return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 유용준인 데이터 조회
//		return studentRepository.findByName("유용준");
		
		// 5) in문으로 일치하는 값 모두 조회
		// 유재석, 조세호
//		return studentRepository.findByNameIn(List.of("유재석", "조세호"));
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회
//		return studentRepository.findByNameAndDreamJob("유용준", "개발자");
		
		// 7) email 컬럼에 naver가 포함된 데이터 조회	like문 %naver%
//		return studentRepository.findByEmailContains("naver");
		
		// 8) 이름이 유로 시작하는 데이터 조회 like문 유%
//		return studentRepository.findByNameStartingWith("유");
		
		// 9) id가 2 ~ 5 조회 between
		return studentRepository.findByIdBetween(2, 5);
	}
}







