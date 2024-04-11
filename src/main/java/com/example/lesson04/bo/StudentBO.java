package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA로 insert
	public StudentEntity addStudent(
			String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now())  // @UpdateTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	
	// MyBatis로 insert
	public void addStduent(Student student) {
		studentMapper.insertStduent(student);
	}
	
	// update
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터를 조회해온다.								비어있을때 null 이 나올것이다.
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// 데이터의 값을 변경한다 => 엔티티에
		if (student != null) {
			student = student.toBuilder() // toBuilder는 기존 필드값은 유지하고 일부만 변경
				.dreamJob(dreamJob)
				.build(); // 꼭 다시 저장
			
			student = studentRepository.save(student);
		}
		
		// save(엔티티객체) => id가 채워져있기때문에 update 가 알아서 됨.
		return student; // null or StudentEntity
	}
	
	
	// input: id , output:student or null
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	public void deleteStudentById(int id) {
		// 1번째 방법
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 2번째 방법
		Optional<StudentEntity> studentOptiondal = studentRepository.findById(id);
		studentOptiondal.ifPresent(s -> studentRepository.delete(s));
	}
}
