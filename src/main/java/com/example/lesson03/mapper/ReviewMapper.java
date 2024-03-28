package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	public Review selectReview(int id);
	
	// Mybatis가 성공한 행의 개수 return
	public int insertReview(Review review);
	
	// @Param => 하나의 Map이 됨
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu,
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	public int deleteReviewById(int id);
}
