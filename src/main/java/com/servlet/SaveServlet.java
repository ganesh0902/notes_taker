package com.servlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.factoryProvider;
import com.note.Note;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
		
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Note note=new Note(title,content,new Date());
		
			//hibernate save method
			
			Session session = factoryProvider.getFactory().openSession();
			
			Transaction tx = session.beginTransaction();		
			session.save(note);
			
			tx.commit();
			session.close();
			
			PrintWriter out = response.getWriter();
			
			response.setContentType("text/html");
			out.println("<h1 style='text-align:center;'> Notes added successfully</h1><br>");
			out.println("<h1 style='text-align:center;'> <a href='all_notes.jsp'>View All Notes</a></h1>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}