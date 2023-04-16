package com.higradius;

public class mytable {
	private Integer Serial_No;
	private String Customer_Name;
	private String Customer;
	private Integer Invoice;
	private Integer Invoice_Amount;
	private String due_Date;
	private String Predicted_Payment_Date;
	public Integer getSerial_No() {
		return Serial_No;
	}
	public void setSerial_No(Integer string) {
		Serial_No = string;
	}
	
	public String getCustomer_Name() {
		return Customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public Integer getInvoice() {
		return Invoice;
	}
	public void setInvoice(Integer invoice) {
		Invoice = invoice;
	}
	public Integer getInvoice_Amount() {
		return Invoice_Amount;
	}
	public void setInvoice_Amount(Integer invoice_Amount) {
		Invoice_Amount = invoice_Amount;
	}
	public String getDue_Date() {
		return due_Date;
	}
	public void setDue_Date(String due_Date) {
		this.due_Date = due_Date;
	}
	public String getPredicted_Payment_Date() {
		return Predicted_Payment_Date;
	}
	public void setPredicted_Payment_Date(String predicted_Payment_Date) {
		Predicted_Payment_Date = predicted_Payment_Date;
	}
	
	
	
}
