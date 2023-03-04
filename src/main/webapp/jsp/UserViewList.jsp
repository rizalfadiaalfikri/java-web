<%@page import="javawebapplication.bean.UserBEan"%>
<%@page import="java.util.Iterator"%>
<%@page import="javawebapplication.utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp"%>

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
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  	<% 
		int index = 1;
		List list= ServletUtility.getList(request);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			UserBEan user = (UserBEan) iterator.next();
	
	%>
    <tr>
      <th scope="row"><%= user.getId() %></th>
      <td><%= user.getFirstName() %></td>
      <td><%= user.getLastName() %></td>
      <td><%= user.getLogin() %></td>
      <td><%= user.getPassword() %></td>
      <td><%= user.getMobileNo() %></td>
      <td><%= user.getDob() %></td>
      <td><a href="UserCTL?id=<%= user.getId() %>">Edit</a></td>
    </tr>
	<% } %>
  </tbody>
</table>
<%@ include file="footer.jsp"%>
</body>
</html>