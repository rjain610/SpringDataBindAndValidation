<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:errors path="register1.*"/>
<form id = "register1" method = "POST" action="register.do">
	<label>Name</label>
	<input type="text" name="name"/><br>
	<label>Age</label>
	<input type="text" name="age"/><br>
	<label>Date of Birth</label>
	<input type="text" name="dob"/><br>
	<label>City</label>
	<input type="text" name="address.city"/><br>
	<label>State</label>
	<input type="text" name="address.state"/><br>
	<label>Pincode</label>
	<input type="text" name="address.pincode"/><br>
	<select name= "languages">
	<option value = "Java">Java</option>
	
	<option value = "Spring">Spring</option>
	
	<option value = "Hibernate">Hibernate</option>
	</select>
	<input type="submit" value="Submit">
</form>
</body>
</html>