package com.hqb.demo.service;

import java.util.List;

import com.hqb.demo.entity.Student;

public interface StudentService {
	void save(Student student);

	Student get(int id);

	List<Student> getAll();

	void initConfiguration();
}
