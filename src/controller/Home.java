package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//login, help같은 String값이 저장되게 된다.
		String action = request.getParameter("action");
		
		String page = null;
		
		//action값의 따라서 해당하는 jsp파일을 호출한다.
		if(action.equals("login"))
			page = "/view/loginform.jsp";
		else if(action.equals("help"))
			page = "/view/help.jsp";
		else
			page = "/view/error.jsp";
		
		//dispatcher라는 객체를 얻어와서 forward메소드를 사용해서 해당되는 페이지로 이동하게된다. 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
			
	}

}
