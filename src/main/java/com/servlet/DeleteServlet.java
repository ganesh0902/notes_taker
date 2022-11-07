package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.factoryProvider;
import com.note.Note;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id= Integer.parseInt(request.getParameter("note_id").trim()); 
		
		Session session = factoryProvider.getFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Note note =(Note) session.get(Note.class,id);
		
		session.delete(note);
		
		tx.commit();
		
		session.close();
		
		response.sendRedirect("all_notes.jsp");
	}

}
