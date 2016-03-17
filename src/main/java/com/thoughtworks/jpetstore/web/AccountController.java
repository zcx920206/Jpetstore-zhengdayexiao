package com.thoughtworks.jpetstore.web;

import com.thoughtworks.jpetstore.domain.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thoughtworks.jpetstore.service.AccountService;
import java.util.List;
@Controller
public class AccountController {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/account/{userName}", method = RequestMethod.GET)
	public @ResponseBody Account query(@PathVariable String userName) {
		return accountService.getAccount(userName);
	}
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public @ResponseBody Student sess(@PathVariable int id) {

		Student ss=accountService.getStudentById(id);

		return  ss;
	}
	@RequestMapping(value = "/home")
	public String index() {
		//List<Student> s=accountService.getAllStudent();
		return "/home";
	}
	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public @ResponseBody List<Student> addStudent(Student student) {
		accountService.addStudent(student);
		return accountService.getAllStudent();
	}
	@RequestMapping(value = "/addcourse", method = RequestMethod.GET)
	public @ResponseBody List<Course> addCourse(Course course) {
		accountService.addCourse(course);
		return accountService.getAllCourse();
	}
	@RequestMapping(value = "/getstudent", method = RequestMethod.GET)
	public @ResponseBody List<Student>getStudent(String cname) {
		return accountService.getStudent(cname);
	}
	@RequestMapping(value = "/getpassstudent", method = RequestMethod.GET)
	public @ResponseBody List<Student> getPassstudent(String cname){
		return accountService.getPassstudent(cname);
	}
}
