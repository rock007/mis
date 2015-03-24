package com.hqb.demo.dao;

import java.util.List;

import com.hqb.demo.entity.Student;

public interface StudentDao {
	void save(Student student);

	Student getStudent(int id);

	List<Student> getAllStudent();

	void initConfiguration();
}