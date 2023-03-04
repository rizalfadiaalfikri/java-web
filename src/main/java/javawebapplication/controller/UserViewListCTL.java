package javawebapplication.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javawebapplication.Model.UserModel;
import javawebapplication.utility.ServletUtility;

/**
 * Servlet implementation class UserViewListCTL
 */

@WebServlet(name="UserViewListCtl" ,urlPatterns= {"/UserViewListCtl"})
public class UserViewListCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserViewListCTL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel model=new UserModel();
	    List list=null;
	    list=model.list();
	    
	    if(list==null && list.size()==0){
	      ServletUtility.setErrorMessage("Record Not Found", request);
	    }
	    
	    ServletUtility.setList(list, request);
		ServletUtility.forward(JWAView.UserViewList, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
