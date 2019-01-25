<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style.css">
<script>
function showfield(name){
	  if(name=='PersonalLoan')document.getElementById('div1').innerHTML='<input type="text" placeholder ="Enter CustomerName" name="cust_name" required><br/><input type ="text" placeholder="Enter LoanAmount" name="loanamt" required><br/><input type="text" placeholder="Enter LoanPeriod" name="loanperiod" required><br/><input type="text" placeholder="Enter Annual InterestRate" name="interest" required><br /><button type="submit" class="registerbtn">Calculate</button>  <button type="reset" class="registerbtn">Clear</button>';
	  else document.getElementById('div1').innerHTML='';
	}
	System.out.println(name);
	</script>
<!-- script>

	windows.onload = function(){
		
	
location.href = document.getElementById("selectbox").value;
}
</script-->
	
</head>
<body background="D:\Users\nmohanasundaram\Pictures\3.jpg">

<div class="dropdown" id="div1">
	<select name="loantype" id="loantype" onchange="showfield(this.options[this.selectedIndex].value)">
	<option selected="selected">Please select ...</option>
	<option value="PersonalLoan">PersonalLoan</option>
	<option value="GoldLoan">GoldLoan</option>
	<option value="Other">Other</option>
	</select>
	</div>
	
	



</body>
</html>