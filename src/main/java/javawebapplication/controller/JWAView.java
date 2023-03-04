package javawebapplication.controller;

public interface JWAView {
	public String APP_CONTEXT = "/JavaWebApplication";
	public String PAGE_FOLDER = "/jsp";
	
	public String HomeView = PAGE_FOLDER + "/Home.jsp";
	public String Home = APP_CONTEXT + "/Home";
	
	public String LoginView = PAGE_FOLDER + "/LoginView.jsp";
	public String LoginCTL = APP_CONTEXT + "/LoginCTL";
	
	public String UserView = PAGE_FOLDER + "/UserView.jsp";
	public String UserCTL = APP_CONTEXT + "/UserCTL";
	
	public String WelcomeView = PAGE_FOLDER + "/Welcome.jsp";
	public String WelcomeCTL = APP_CONTEXT + "/WelcomeCTL";
	
	public String UserViewList = PAGE_FOLDER + "/UserViewList.jsp";
	public String UserViewListCTL = APP_CONTEXT + "/UserViewListCTL";
	
			
}
