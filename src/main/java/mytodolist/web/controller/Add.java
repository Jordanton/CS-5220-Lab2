package mytodolist.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mytodolist.model.MyToDoList;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Integer idSeed = 80;
	
    public Add() {
        super();
    }

	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	
		doPost( request, response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	
		// Get the user input
		String chore = request.getParameter( "item" );
		
		// Get today's date and format it
		Date today = new Date();
		
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat( "MM-dd-yyyy" );
		
		String day = DATE_FORMAT.format( today );
		
		// Create a new todo entry
		MyToDoList entry = new MyToDoList( idSeed++, chore, day );
		
		// Retrieve the list from application scope
		List<MyToDoList> entries = (List<MyToDoList>) getServletContext().getAttribute( "entries" );
		entries.add( entry );
		
		// Send the user back to the display page
		response.sendRedirect( "Display" );
	}

}
