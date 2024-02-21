package com.UserController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.UserDto.UserDetails;

@WebServlet("/logout")
public class LogoutUser extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session != null)
		{
			UserDetails user =(UserDetails) session.getAttribute("right");
			session.invalidate();
		}
		resp.sendRedirect("login.jsp");
	}
}
