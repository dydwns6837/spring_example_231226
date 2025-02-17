package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex02/1
	@RequestMapping("/lesson03/ex02/1")
	public String ex02_1() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("유용준");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 적당쓰");
		
		// insert 후 성공한 row 수를 리턴 받는다.
		int rowCount = reviewBO.addReview(review);
		
		// String + int => String
		return "성공한 행의 개수:" + rowCount;
	}
	
	// http://localhost/lesson03/ex02/2
	@RequestMapping("/lesson03/ex02/2")
	public String ex02_2() {
		int rowCount = reviewBO.insertReviewAsField(4, "콤비네이션R", "바다", 5.0, "피자를 먹으니깐 바다소리가 들려요!");
		return "성공한 행의 개수:" + rowCount;
	}
	
}
