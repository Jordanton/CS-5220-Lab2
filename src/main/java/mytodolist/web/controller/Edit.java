package mytodolist.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mytodolist.model.MyToDoList;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// Create a new list to store chores that are done
	List<MyToDoList> finishChores = new ArrayList<MyToDoList>();
		
    public Edit() {
        super();
    }

    // Create a method to get the entry using the id
    @SuppressWarnings("unchecked")
	private MyToDoList getEntry( Integer id ) {
    
    	// Retrieve the list of entries from application scope
    	List<MyToDoList> entries = (List<MyToDoList>) getServletContext().getAttribute( "entries" );
    	
    	for ( MyToDoList entry : entries ) {
    		
    		if ( entry.getId().equals( id ) ) {
    			
    			return entry;
    		}
    	}
    	
    	return null;
    }
    
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	
		// Get the entry to be edited
		Integer id = Integer.valueOf( request.getParameter( "id" ) );
		
		MyToDoList updatedEntry = getEntry( id );
				
		// Set boolean value to false
		updatedEntry.setCheck( false );
			
		finishChores.add( updatedEntry );
		
		// Store data on the application scope
		getServletContext().setAttribute( "finishChores", finishChores );		
		
		// Forward the request to the JSP
		request.getRequestDispatcher( "/WEB-INF/Edit.jsp" ).forward( request, response );
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		// Forward the request to Add Controller to add new todo entry
		request.getRequestDispatcher( "/Add" ).forward( request, response );
	}

}
