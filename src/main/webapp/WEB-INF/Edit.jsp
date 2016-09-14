<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>Updated Todo List</title>
</head>
<body>
    <h1>Todo List</h1>
    <form action="Edit" method="POST">
    <table>
    	<tr>
    		<th>Item</th><th>Date Added</th><th>Completed</th>
   		</tr>
        <c:forEach items="${entries}" var="entry">
        <tr>
            <c:if test="${entry.check == 'True'}">
                <td>${entry.chore}</td>
                <td align="center">${entry.date}</td>
                <td><a href="Edit?id=${entry.id}"><img src="<c:url value='/resources/delete.png'/>" alt="" /></a></td>
            </c:if>
        </tr>
        </c:forEach>
        <tr>
            <td>
                <input type="text" name="item" />
            </td>
            <td colspan="2" rowspan="1" style="text-align: center;">
                <input type="submit" name="add" value="Add" />
            </td>
        </tr>
    </table>
    </form>
    <br/>
    <h1>Completed Items</h1>
    <table>
    	 <tr>
        	<th>Item</th><th>Date Added</th><th>Date Completed</th>
        </tr>
        <c:forEach items="${finishChores}" var="finishChore">
        <tr>
            <td>${finishChore.chore}</td>
            <td align="center">${finishChore.date}</td>
            <td align="center">${finishChore.compDate}</td>             
        </tr>
        </c:forEach>      
    </table>
</body>
</html>
