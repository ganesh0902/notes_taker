

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.note.Note;

public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{		
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Note note=new Note(title,content,new Date(0));
			
			System.out.println(note.getTitle()+" "+note.getContent());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}						
	}
}