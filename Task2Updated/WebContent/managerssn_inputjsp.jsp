<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function promptmanager()
{
	var person = prompt("Please enter your manager SSN","managerSSN"); 
	
	document.c.manager_ssn1.value = person;
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prompt Manager SSN</title>
</head>
<body>
<i> Note: Only Manager's are allowed to add new employees </i> <br/> <br/>
Enter your Manager SSN: <br/>
<form name="c" method="post" action="Servelt1">
<input type="hidden" name="manager_ssn1" id="manager_ssn1" /> <br/>
<input type="button" name="Click here to enter the Manager SSN" value="click here to enter SSN" onclick="promptmanager()" />
<input type="submit" value="submit" />
</form>
</body>
</html>