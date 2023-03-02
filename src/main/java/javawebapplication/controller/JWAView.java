package javawebapplication.controller;

public interface JWAView {
	public String APP_CONTEXT = "/JavaWebApplication";
	public String PAGE_FOLDER = "/jsp";
	
	public String HomeView = PAGE_FOLDER + "/home.jsp";
	public String Home = APP_CONTEXT + "/Home";
	
	public String LoginView = PAGE_FOLDER + "/LoginView.jsp";
	public String LoginCTL = APP_CONTEXT + "/LoginCTL";
	
	public String UserView = PAGE_FOLDER + "/UserView.jsp";
	public String UserCTL = APP_CONTEXT + "/UserCTL";
	
			
}
