package calclogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonalLoan
 */
@WebServlet("/PersonalLoan")
public class PersonalLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalLoan() {
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
		//doGet(request, response);
		 PrintWriter out = response.getWriter();
			double loan_amount = Double.parseDouble(request.getParameter("loanamt"));
			int loan_period = Integer.parseInt(request.getParameter("loanperiod"));
			double interest_rate = Double.parseDouble(request.getParameter("interest"));
			PrintWriter prnt = response.getWriter();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root", "root");
				Statement st = con.createStatement();
				//ResultSet rs;
				int i = st.executeUpdate("insert into loandetails(loanamt, loanperiod, interest) values ('" + loan_amount + "','" + loan_period + "','" + interest_rate + "')");

				if (i > 0) {
					
					double interest1,interest_rate_month,unpaid_amount; 
					 double installment, principal;
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
				    
				     
				   	//loop for monthly calculation
					 for ( a = 1; a <= loan_period_month; a++){
						payment_no++;
						//interest paid for the current month
						interest1 = loan_amount * loan_period_month / 100 / loan_period_month;
						//monthly payment
						principal = installment - interest1;
						//balance amount to be paid
						unpaid_amount = loan_amount - principal;
						//increments the interest paid
						total_interest += interest1;
						out.println("<tr>");
					     out.println("<th>");
					     out.println(payment_no);
					     out.println("</th>");
					     out.println("<th>");
					     out.println(twoDigits.format(interest1));
					     out.println("</th>");
					     out.println("<th>");
					     out.println(twoDigits.format(principal));
					     out.println("</th>");
					     out.println("<th>");
					     out.println(twoDigits.format(unpaid_amount));
					     out.println("</th>");
					     /*out.println("<th>");
					     out.println(twoDigits.format(total_interest));
					     out.println("</th>");*/
						loan_amount = unpaid_amount;//current loan balance
						//out.println(loan_amount);
						
					 }	
					}
				 
				 else {
					
					out.println("Try Again!!!!!");
				    response.sendRedirect("LoanCalculation.jsp");
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				}


}
