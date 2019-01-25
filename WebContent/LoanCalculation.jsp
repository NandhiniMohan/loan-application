<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>

<body>
	<form method="post" action="PersonalLoan">
		<div class="container">
			<h1>Loan Calculation</h1>
			<!--  <input list="cust_type" placeholder="Your CustomerType"	name="custtype" onClick="GetSelectedItem('cust_type')">
			<datalist id="cust_type">
				<option value="1">New Customer (1)</option>
				<option value="0">OldCustomer (0)</option>
			</datalist>-->	
				
			<input type ="text" placeholder="Enter LoanAmount" name="loanamt" required>
			<input type="text" placeholder="Enter LoanPeriod" name="loanperiod" required><br /> 
			<input type="text" placeholder="Enter Annual InterestRate" name="interest" required><br />
			<button type="submit" class="registerbtn">Calculate</button>
			<button type="reset" class="registerbtn">Clear</button>
		</div>
	</form>
</body>
</body>
</html>