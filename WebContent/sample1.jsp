<%@ page import="java.sql.*"%>
<%@ page import="java.text.DecimalFormat" %>
<%
String custname = request.getParameter("custname");
System.out.println(custname);
String loanamt1 = request.getParameter("loanmt");
System.out.println("Loan amount is RM"+loanamt1);
double loanamt = Double.parseDouble(loanamt1);


int loanperiod = Integer.parseInt(request.getParameter("loanperiod"));
double interest = Double.parseDouble(request.getParameter("interest"));
double loan_amount, interest_rate, interest_rate_month,unpaid_amount; 
	 double installment, principal;
	 double total_interest = 0;
	 int loan_period, loan_period_month;
	 int payment_no = 0;
	 int a;
	
	
	// System.out.print("Enter loan amount (RM):" +loanamt); //Input of loan amount
	 //loan_amount = scan.nextDouble();
	 System.out.println("Loan amount is RM"+loanamt);
   
	 //System.out.print("Enter loan period(year):"); //Input of loan period
	 //loan_period = scan.nextInt();
	 loan_period_month = loanperiod * 12;
	 System.out.println("Loan period is " +loan_period_month+ " months");
	 
	 //System.out.print("Enter annual interest rate(%):"); //Input of interest rate
	 //interest_rate = scan.nextDouble();
	 interest_rate_month = interest / (loan_period_month*100);  
	 System.out.println("Interest rate is "+interest);
   
	 installment = loanamt * interest_rate_month / (1 - Math.pow(1 + interest_rate_month, - loan_period_month));
	 // calculates the monthly installment payment
	  
	 System.out.println(""); //spacing
		
	 System.out.println(""); //spacing
		
	 DecimalFormat twoDigits = new DecimalFormat(".00");//format for the decimal		
	 System.out.println("Payment\t\t\t\tUnpaid\t\tTotal Interest"); //Output of table listing line 1
	 System.out.println("No.\tInterest\tPrincipal\tBalance\t\tTo Date\t");//Output of table listing line 2
			  
		
	 for ( a = 1; a <= loan_period_month; a++){//loop for monthly calculation
		payment_no++;//number indication for payment made
		interest = loanamt * loan_period_month / 100 / loan_period_month;//interest paid for the current month
		principal = installment - interest;//monthly payment
		unpaid_amount = loanamt - principal;//balance amount to be paid
		total_interest += interest;//increments the interest paid
		System.out.println("" + payment_no + "\t" + twoDigits.format(interest) + "\t\t" 
		   + twoDigits.format(principal)+ "\t\t" + twoDigits.format(unpaid_amount)+ "\t\t" 
		   + twoDigits.format(total_interest));//output for table listing
		loan_amount = unpaid_amount;//current loan balance
	 }	
	 %>