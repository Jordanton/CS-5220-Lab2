package mytodolist.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mytodolist.model.MyToDoList;

@WebServlet( urlPatterns = "/Display", loadOnStartup = 1 )
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Display() {
    }

	public void init( ServletConfig config ) throws ServletException {
	
		super.init( config );
		
		// Create some test data for display
		List<MyToDoList> entries = new ArrayList<MyToDoList>();
				
		entries.add( new MyToDoList( 1, "Take out trash", "08/28/2016" ) );
		entries.add( new MyToDoList( 2, "Buy milk", "08/26/2016" ) );
		entries.add( new MyToDoList( 3, "Watch \"Suicide Squad\"", "08/20/2016" ) );
				
		// Store data on the application scope
		getServletContext().setAttribute( "entries", entries );
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Forward the request to JSP
		request.getRequestDispatcher( "/WEB-INF/Display.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet( request, response );
	}

}
