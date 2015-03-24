package com.sam.demo.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sam.demo.dao.StudentDao;
import com.sam.demo.entity.Student;
import com.sam.demo.service.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(Student student) {
		studentDao.save(student);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Student get(int id) {
		return studentDao.getStudent(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Student> getAll() {
		return studentDao.getAllStudent();
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void initConfiguration() {
		this.studentDao.initConfiguration();
	}
}