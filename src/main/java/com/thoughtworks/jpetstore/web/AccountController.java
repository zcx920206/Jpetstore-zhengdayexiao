package com.thoughtworks.jpetstore.web;

import com.thoughtworks.jpetstore.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.service.AccountService;

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
		Student s=accountService.getstudentclass(id);
		//System.out.println("*****"+s.getId());

		Student ss=accountService.getStudentById(id);
		Student stu=new Student();
		stu.setClasses(2);
		stu.setName("dad");
		int sss=accountService.addStudent(stu);
		//SqlSession openSession = factory.openSession();
		//UserMapper mapper = openSession.getMapper(UserMapper.class);
		//mapper.add(new Users(-1,"娃娃",99));
		//openSession.commit();
		//openSession.close();

		return  ss;
	}
}
