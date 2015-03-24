package com.sam.demo.dao;

import java.util.List;

import com.sam.demo.entity.Student;

public interface StudentDao {
	void save(Student student);

	Student getStudent(int id);

	List<Student> getAllStudent();

	void initConfiguration();
}