package com.hqb.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hqb.demo.entity.Student;
import com.hqb.demo.service.StudentService;

public class DemoController {

	private StudentService studentService;

	public static void main(String[] args) {
		// open/read the application context file
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"context.xml");

		// instantiate our spring dao object from the application context
		DemoController controller = (DemoController) ctx.getBean("controller");

		//controller.getStudentService().initConfiguration();

		controller.getStudentService().save(buildStudent());

		System.out.println("-- Finished --");
	}

	private static Student buildStudent() {
		Student student = new Student();
		student.setId(System.currentTimeMillis());
		student.setAge(20);
		student.setName("chengong_" + student.getId());
		student.setGender(student.getId() % 2 == 0 ? "male" : "female");
		return student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}