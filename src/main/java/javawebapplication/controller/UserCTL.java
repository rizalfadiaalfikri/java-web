package javawebapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapplication.Model.UserModel;
import javawebapplication.bean.UserBEan;
import javawebapplication.utility.DataUtility;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserCTL
 */

@WebServlet(name = "UserCTL", urlPatterns = {"/UserCTL"})
public class UserCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher(JWAView.UserView);
//		requestDispatcher.forward(request, response);
		ServletUtility.forward(JWAView.UserView, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	UserBEan user = new UserBEan();
		    user.setFirstName(request.getParameter("firstName"));
		    user.setLastName(request.getParameter("lastName"));
		    user.setLogin(request.getParameter("login"));
		    user.setPassword(request.getParameter("password"));
		    user.setDob(DataUtility.getDate(request.getParameter("dob")));
		    user.setMobileNo(request.getParameter("mobile"));
		    
		    long i = UserModel.addUser(user);
		    if(i>0) {
		      ServletUtility.setSuccessMessage("User register sucessfully", request);
		      
		    }else {
		      ServletUtility.setErrorMessage("Not insterted", request);
		    }
		    request.getRequestDispatcher(JWAView.UserView).forward(request, response);
		  }
	

}
