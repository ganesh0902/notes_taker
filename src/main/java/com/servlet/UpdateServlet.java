package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.helper.factoryProvider;
import com.mysql.cj.Session;
import com.note.Note;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    		try
    		{
    			
    			String title=request.getParameter("title");
    			String content=request.getParameter("content");
    			int noteId =Integer.parseInt(request.getParameter("noteId"));
    			
    			PrintWriter out = response.getWriter();
    			
    			out.println("<h1>'"+noteId+"'</h1>");
    			out.println("<h1>'"+title+"' </h1>");
    			out.println("<h1>'"+content+"' </h1>");
    			
    			    			
    			org.hibernate.Session s=factoryProvider.getFactory().openSession();
    			
    			Transaction tx = s.beginTransaction();
    				
    			Note note=s.get(Note.class,noteId);
    			    		
    			note.setTitle(title);
    			note.setContent(content);
    			note.setAddDate(new Date());	
    			tx.commit();
    			s.close();
    			
    			response.sendRedirect("all_notes.jsp");
    			    			  		
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}   		
	}
}