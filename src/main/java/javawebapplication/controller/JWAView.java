package javawebapplication.controller;

public interface JWAView {
	public String APP_CONTEXT = "/JavaWebApplication";
	public String PAGE_FOLDER = "/jsp";
	
	public String Home = APP_CONTEXT + PAGE_FOLDER + "/home.jsp";
	public String LoginView = APP_CONTEXT + PAGE_FOLDER + "/LoginView.jsp";
	public String UserView = APP_CONTEXT + PAGE_FOLDER + "/UserView.jsp";
			
}
