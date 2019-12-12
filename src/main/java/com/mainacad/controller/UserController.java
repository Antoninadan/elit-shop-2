package com.mainacad.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mainacad.model.User;
import com.mainacad.service.UserService;

import lombok.Getter;

@WebServlet(urlPatterns = "/user")
public class UserController extends HttpServlet {

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	// getByLoginAndPassword
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		RequestDispatcher dispatcher;

		// Login
		if (action != null && action.equals("login")) {
			String login = req.getParameter("login");
			String password = req.getParameter("password");

			User user = UserService.getByLoginAndPassword(login, password);
			if (user != null) {
				// path
				dispatcher = req.getRequestDispatcher("/jsp/user-cabinet.jsp");
				req.getSession().setAttribute("user-name", user.getFirstName() + " " + user.getLastName());
				req.getSession().setAttribute("user-id", user.getId());
				dispatcher.forward(req, resp);
			} else {
				dispatcher = req.getRequestDispatcher("/jsp/wrong-auth.jsp");
				dispatcher.forward(req, resp);
			}
		}

		// Open create page
		if (action != null && action.equals("open-create-page")) {
			dispatcher = req.getRequestDispatcher("/jsp/user-create.jsp");
			dispatcher.forward(req, resp);
		}

		// Create user
		if (action != null && action.equals("create-user")) {
			String login = req.getParameter("login");
			String password = req.getParameter("password");
			String firstName = req.getParameter("first-name");
			String lastName = req.getParameter("last-name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");

			User user = new User(login, password, firstName, lastName, email, phone);
			System.out.print(user.toString());
			User savedUser = UserService.save(user);
			if (savedUser != null) {
				dispatcher = req.getRequestDispatcher("/jsp/user-cabinet.jsp");
				req.getSession().setAttribute("user-name", savedUser.getFirstName() + " " + savedUser.getLastName());
				req.getSession().setAttribute("user-id", savedUser.getId());
				dispatcher.forward(req, resp);
			} else {
				dispatcher = req.getRequestDispatcher("/jsp/wrong-create-user.jsp");
				dispatcher.forward(req, resp);
			}
		}

		// Open edit page
		if (action != null && action.equals("open-edit-user-page")) {
			Integer editedUserId = (Integer) (req.getSession().getAttribute("user-id"));
			dispatcher = req.getRequestDispatcher("/jsp/user-edit.jsp");
			dispatcher.forward(req, resp);
		}

		// Update user
		if (action != null && action.equals("update-user")) {
			Integer editedUserId = (Integer) (req.getSession().getAttribute("user-id"));
			String login_edit = req.getParameter("login");
			String password_edit = req.getParameter("password");
			String firstName_edit = req.getParameter("first-name");
			String lastName_edit = req.getParameter("last-name");
			String email_edit = req.getParameter("email");
			String phone_edit = req.getParameter("phone");

			User updatedUser = UserService.getById(editedUserId);
			updatedUser.setLogin(login_edit);
			updatedUser.setPassword(password_edit);
			updatedUser.setFirstName(firstName_edit);
			updatedUser.setLastName(lastName_edit);
			updatedUser.setEmail(email_edit);
			updatedUser.setPhone(phone_edit);

			User savedUser = UserService.update(updatedUser);
			if (savedUser != null) {
				dispatcher = req.getRequestDispatcher("/jsp/user-cabinet.jsp");
				req.getSession().setAttribute("user-name", savedUser.getFirstName() + " " + savedUser.getLastName());
				req.getSession().setAttribute("user-id", savedUser.getId());
				dispatcher.forward(req, resp);
			} else {
				dispatcher = req.getRequestDispatcher("/jsp/wrong-edit-user.jsp");
				dispatcher.forward(req, resp);
			}
		}

		// Delete user
		if (action != null && action.equals("delete-user")) {
			Integer deletedUserId = (Integer) (req.getSession().getAttribute("user-id"));

			User deletedUser = UserService.getById(deletedUserId);

			UserService.delete(deletedUserId);

			if (UserService.getById(deletedUserId) == null) {
				dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.forward(req, resp);
			} else {
				dispatcher = req.getRequestDispatcher("/jsp/wrong-edit-user.jsp");
				dispatcher.forward(req, resp);
			}
		}

		// Back to cabinet user
		if (action != null && action.equals("back-to-cabinet-page")) {
			dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		} 
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
