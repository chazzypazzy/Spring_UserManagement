package com.UserController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserDao.UserDao;
import com.UserDto.UserDetails;

@WebServlet("/userRegister")
public class AddNewUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		int pass = Integer.parseInt(req.getParameter("password"));

		UserDetails userDetails = new UserDetails();
		userDetails.setName(name);
		userDetails.setAge(age);
		userDetails.setEmail(email);
		userDetails.setPassword(pass);

		UserDao userDao = new UserDao();
		userDao.saveuser(userDetails);
		HttpSession session = req.getSession();
		if (userDao != null) {
			session.setAttribute("pass", "Heigala re Register Successfull!");
			resp.sendRedirect("register.jsp");
		}

	}
}
