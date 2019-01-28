<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var counter=1;
function display() { 
	if (document.getElementById('yeschecked').checked) {      
		document.getElementById('projectdetails').style.display='block';
	    } 
	else {  
	   document.getElementById('projectdetails').style.display='none';
	    }
	}
function addProject()
	{
{
//var msgcontainer = document.createElement('div');
//msgcontainer.id = 'DOM';
//msgcontainer.className = '';
//var el = document.getElementById('projectdetails');
//var newel = el.clone();
//var div = document.getElementById('projectdetails');
//clone[k] = div.cloneNode(true);
//clone[k].id = "block"+k;
//document.getElementById('container1').append(clone[k]);
//check();
//var counter1 = counter;
//window.alert(document.getElementById('pno'));
//window.alert(document.getElementById('pno1'));
var newdiv = document.createElement('div');
newdiv.innerHTML = "Project"+(counter + 1)+"<br><label>Pno:</label><input type='text' name='pno1' id='pno1' size=2 maxlength=3 required><label>Hours:</label><input type='text' name='hours1' id='hours1' size=5 maxlength=5 required/>";
document.getElementById('container1').appendChild(newdiv);
counter++;
//System.out.println("counter:"+counter);
//document.body.appendChild(clone);
}
	}
/*function check()
{
	var num = Long.parseLong(document.getElementById('pno'));
	var num1[] = Long.parseLong(document.getElementById('pno1'));
 var f = num1.length;
	var sum1 = num;
	for(var i=0;i<f;i++)
		{
		sum1 = sum1 + num1[i];
		}
	window.alert("sum of projects:"+sum1);
	}*/
function displayDep() {
if(document.getElementById('yesselected').checked) {
document.getElementById('dependentdetails').style.display='block';
	}
else {
document.getElementById('dependentdetails').style.display='none';
	}
}
</script>
</head>
<body>
Welcome to Employee Page
<form method="post" name="employee" action="${pageContext.request.contextPath}/Servelt1">
<table border="0" name="employee_details" width="90%">
<tbody>
<tr>
<td>
<p> <label>
<strong>
First Name:
</strong> </td> 
<td> <input type="text" name="fname" id="fname" size=15 maxlength=20 autofocus required />
</td>
</label>
</p> </tr>

<tr>
<td>
<p> <label> <strong>
Middle Name:
</strong>
</td>
<td>
<input type="text" name="mname" id="mname" size=15 maxlength=20 />
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Last Name:
</strong>
</td>
<td>
<input type="text" name="lname" id="lname" size=15 maxlength=20 required />
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
SSN:
</strong>
</td>
<td>
<input type="text" name="ssn" id="ssn" size=15 maxlength=20 required />
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Birthdate:
</strong>
</td>
<td>
<input type="date" name="bdate" id="bdate" /> (dd-mon-yy)
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Address:
</strong>
</td>
<td>
<input type="text" name="address" id="address" size=30 maxlength=100 />
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Sex:
</strong>
</td>
<td>
<select name="sex">
<option selected="selected"> M </option>
<option> F </option>
</select>
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Salary:
</strong>
</td>
<td>
<input type="text" name="salary" id="salary" size=7 maxlength=10 />
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Supervisor SSN:
</strong>
</td>
<td>
<input type="text" name="superssn" id="superssn" size=15 maxlength=20 />
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Department No:
</strong>
</td>
<td>
<input type="text" name="depno" id="depno" size=2 maxlength=5 required/>
</td>
</p> </label>
</tr>

<tr>
<td>
<p> <label> <strong>
Email:
</strong>
</td>
<td>
<input type="email" name="email" id="email" placeholder="name@domain.com" /> (name@domain.com)
</td>
</p> </label>
</tr>

<section>
<tr>
<td>
<strong> !!!Optional!!! <br/>
Do You Want to Add Project Details? (Select Yes/NO) </strong>
</td>
<td> 
<label> Yes </label>
<input type="radio" name="projectoption" id="yeschecked" value="yes" onclick="javascript:display();" required/>
<label> No </label>
<input type="radio" name="projectoption" id="nochecked" value="no" onclick="javascript:display();" required/>
</td>
</tr>
</section>
</tbody>
</table>

<section>
<div id="projectdetails" style="display:none">

<label><strong> Pno: </strong></label>

<input type="text" name="pno" id="pno" size=2 maxlength=3 required/>


<label><strong> Hours: </strong></label>

<input type="text" name="hours" id="hours" size=5 maxlength=5 required/>

<a href="#" id="addproject" onclick="javascript:addProject();return false;"> click here to add more projects </a>
</div>
</section>

<div id="container1">

</div>

<section>
<strong>  <br/>
Would you like to Add Dependent Details for this Employee? (Select Yes/NO) </strong>

<label> Yes </label>
<input type="radio" name="dependentoption" id="yesselected" value="yes" onclick="javascript:displayDep();" required/>
<label> No </label>
<input type="radio" name="dependentoption" id="noselected" value="no" onclick="javascript:displayDep();" required/>
</section>


<section>
<div id="dependentdetails" style="display:none">

<label><strong> Dependent Name: </strong></label>

<input type="text" name="depname" id="depname" size=20 maxlength=30 required/>

<label><strong> Sex </strong></label>

<input type="text" name="depsex" id="depsex" size=1 maxlength=1 />

 
<label><strong> Bdate </strong></label>

<input type="date" name="depbdate" id="depbdate" placeholder="dd-mon-yy"/>

<label><strong> Relationship </strong></label>

<input type="text" name="deprelation" id="deprelation" size=10 maxlength=30 />
</div>
</section>

<br/> <br/>


<section>
<input type="submit" name="button1" value="submit employee data" />

<input type="reset" name="reset" value="clear values" /> 

<div id="error">
</div>
</section>
</form>
</body>
</html>