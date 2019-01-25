package calclogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loan1
 */
@WebServlet("/Loan1")
public class Loan1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loan1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		double loan_amount = 200000;
		int loan_period = 2;
		double interest_rate = 12;

		double interest,interest_rate_month,unpaid_amount = 0; 
		 double installment, principal = 0;
		 double total_interest = 0;
		 int loan_period_month;
		 int payment_no = 0;
		 int a;
		
			
			 out.println("<table>");
		     out.println("<tr>");
		     out.println("<td>");
		     out.println("Loan Amount :");
		      
			 out.println(loan_amount);
			 out.println("</td>");
			 out.println("</tr>");
		  
			
			 loan_period_month = loan_period * 12;
			 //out.println("Loan period is " +loan_period_month+ " months");
			 out.println("<tr>");
		     out.println("<td>");
		     out.println("Loan Period :");
		      
			 out.println(loan_period_month);
			 out.println("months");
			 out.println("</td>");
			 out.println("</tr>");
			 
			 interest_rate_month = interest_rate / (loan_period_month*100);  
			 //out.println("Interest rate is "+interest_rate);
			 out.println("<tr>");
		     out.println("<td>");
		     out.println("Interest :");
		      
			 out.println(interest_rate);
			 out.println("%");
			 out.println("</td>");
			 out.println("</tr>");
			 // calculates the monthly installment payment
			 installment = loan_amount * interest_rate_month / (1 - Math.pow(1 + interest_rate_month, - loan_period_month));
			 out.println("<tr>");
		     out.println("<td>");
		     out.println("Installment :");
			 out.println(installment); 
			 out.println("</td>");
			 out.println("</tr>");
				
			 out.println(" "); 
				
			 DecimalFormat twoDigits = new DecimalFormat(".00");	
			 out.println("<table>");
		     out.println("<tr>");
		     out.println("<th>Payment No</th>");
		     out.println("<th>Interest</th>");
		     out.println("<th>Principle</th>");
		     out.println("<th>Unpaid Amount</th>");
		    // out.println("<th>Total Interest</th>");
		     out.println("</tr>");
				
			 for ( a = 1; a <= loan_period_month; a++){//loop for monthly calculation
				payment_no++;//number indication for payment made
				interest = loan_amount * loan_period_month / 100 / loan_period_month;//interest paid for the current month
				principal = installment - interest;//monthly payment
				unpaid_amount = loan_amount - principal;//balance amount to be paid
				total_interest += interest;//increments the interest paid
				
				loan_amount = unpaid_amount;//current loan balance
			 }
			 System.out.println("" + payment_no + "\t" + twoDigits.format(principal)+ "\t\t" + twoDigits.format(unpaid_amount)+ "\t\t" 
					   + twoDigits.format(total_interest));//output for table listing
		
	}

}
