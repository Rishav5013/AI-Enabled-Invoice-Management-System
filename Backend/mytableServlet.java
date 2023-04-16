package com.higradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Servlet implementation class mytableServlet
 */
@WebServlet("/mytableServlet")
public class mytableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mytableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try(Connection connection = com.higradius.DBconnection.createConnection()){
			Statement stmt = connection.createStatement();
			
			
			/*String pageNumberStr = request.getParameter("page_number");
			final int pageCount = 5;
			
			int pageNumber = 0;
			if (pageNumberStr != null) {
				pageNumber = Integer.parseInt(pageNumberStr);
			}*/
			String sql = "SELECT sr_no, customer_Name, customer,invoice, invoice_Amount, due_date,predicted_payment_date FROM mytable ORDER BY sr_no ASC LIMIT 1, 50";
			
			/*PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, pageNumber * pageCount);
			stmt.setInt(2,  pageCount);*/
			
		ResultSet rs = stmt.executeQuery(sql);
		
       List<mytable> mytables = new ArrayList<>();
		
		while(rs.next())
		{
			mytable mytbl = new mytable();
			mytbl.setSerial_No(rs.getInt("sr_No"));
			mytbl.setCustomer_Name(rs.getString("customer_Name"));
			mytbl.setCustomer(rs.getString("customer"));
			mytbl.setInvoice(rs.getInt("invoice"));
			mytbl.setInvoice_Amount(rs.getInt("invoice_amount"));
			mytbl.setDue_Date(rs.getString("due_date"));
			mytbl.setPredicted_Payment_Date(rs.getString("predicted_payment_date"));
			
			mytables.add(mytbl);			
		}
		rs.close();
		
		Gson gson = new Gson();
		
		String mytableJson = gson.toJson(mytables);
		
		response.getWriter().append(mytableJson);
		
		}catch(SQLException e) {
			response.getWriter().append("SQL exception Occured");
			e.printStackTrace();
		}
		catch (Exception e) {
			response.getWriter().append("SQL exception Occured");
			e.printStackTrace();
		}
	
		
		
		response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
