package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idd =request.getParameter("uid");
		String pric=request.getParameter("uprice");
		
		if (idd=="") {
			idd = "0";
		}
		if (pric=="") {
			pric = "0";
		}
		
		int id=Integer.parseInt(idd);
		String name=request.getParameter("uname");
		int price=Integer.parseInt(pric);
		String sellerdetails=request.getParameter("usd");
		
		if (id!=0 && name!="" && price!=0 && sellerdetails!="") {
			try {
				
				Configuration cfg= new Configuration().configure("hibernate.cfg.xml");
				
				SessionFactory factory=cfg.buildSessionFactory();
				Session session=factory.openSession();
				Transaction trx=session.beginTransaction();
				
				product p=new product();
				p.setUid(id);
				p.setUname(name);
				p.setUprice(price);
				p.setUsd(sellerdetails);
				
				session.save(p);
				trx.commit();
				session.close();
				
				System.out.println("completed");
				
				
			
			}
			catch (Exception e){
				e.printStackTrace();
			
				
			}
		}
		PrintWriter out=response.getWriter();
		
		if (id!=0 && name!="" && price!=0 && sellerdetails!="") {
			
		RequestDispatcher rd =request.getRequestDispatcher("form.jsp");
		rd.include(request, response);
		out.println("<center> <span style = 'color:green'> Product "+name+" with Id "+id+" is added </span> </center>");
		
		}
		
		if (id==0 || name=="" || price==0 || sellerdetails=="") {
			
			RequestDispatcher rd =request.getRequestDispatcher("form.jsp");
			rd.include(request, response);
			out.println("<center> <span style = 'color:red'> Missing Inputs </span> </center>");	
			
		}
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
