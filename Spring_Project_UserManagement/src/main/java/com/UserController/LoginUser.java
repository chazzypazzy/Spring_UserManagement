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

@WebServlet("/login_user")
public class LoginUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		int password = Integer.parseInt(req.getParameter("password"));

		UserDao userDao = new UserDao();
		UserDetails fetchUserbyEmailAndPassword = userDao.fetchUserbyEmailAndPassword(email, password);
		System.out.println(fetchUserbyEmailAndPassword);

		HttpSession session = req.getSession();
		if (fetchUserbyEmailAndPassword != null) {
			session.setAttribute("right", fetchUserbyEmailAndPassword);
			resp.sendRedirect("Home.jsp");
		} else {
			session.setAttribute("fail", "Invalid Email & Password");
			resp.sendRedirect("login.jsp");
		}
	}
}
