package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javawebapplication.Model.UserModel;
import javawebapplication.bean.UserBEan;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class LoginCTL
 */
@WebServlet(name = "LoginCTL", urlPatterns = {"/LoginCTL"})
public class LoginCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher(JWAView.LoginView);
//		requestDispatcher.forward(request, response);
		ServletUtility.setErrorMessage("Invalid Data", request);
		ServletUtility.forward(JWAView.LoginView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBEan user = new UserBEan();
	       String login=request.getParameter("login");
	       String pwd=request.getParameter("password");
	       HttpSession session=request.getSession(true);
	       
	       user = UserModel.UserLogin(login,pwd);
	       if(user != null) {
 	    	   //Set attribute for session
	    	   session.setAttribute("user", user.getFirstName());
	           //ServletUtility.setSuccessMessage(request.getParameter("login")+ " is login successfully", request);
	           ServletUtility.forward(JWAView.WelcomeView, request, response);
	       }else {
	           ServletUtility.setErrorMessage("Invalid User", request);
	           ServletUtility.forward(JWAView.LoginView, request, response);
	       }
	}

}
