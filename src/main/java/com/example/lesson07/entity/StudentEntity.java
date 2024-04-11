package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;

@Entity // 이 객체는 entity이다. DB-JPA
public class StudentEntity {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dreamJob;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}
