<%@page import="javawebapplication.bean.UserBEan"%>
<%@page import="java.util.Iterator"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>
<% 
	int index = 1;
	List list= ServletUtility.getList(request);
	Iterator iterator = list.iterator();
	while(iterator.hasNext()) {
		UserBEan user = (UserBEan) iterator.next();
	

%>
<body>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">FName</th>
      <th scope="col">LName</th>
      <th scope="col">Login</th>
      <th scope="col">Password</th>
      <th scope="col">MobileNo</th>
      <th scope="col">Date of Birth</th>
    </tr>
  </thead>
  <tbody>
  
    <tr>
      <th scope="row"><%= user.getId() %></th>
      <td><%= user.getFirstName() %></td>
      <td><%= user.getLastName() %></td>
      <td><%= user.getLogin() %></td>
      <td><%= user.getPassword() %></td>
      <td><%= user.getMobileNo() %></td>
      <td><%= user.getDob() %></td>
    </tr>
	<% } %>
  </tbody>
</table>
<%@ include file="footer.jsp"%>
</body>
</html>