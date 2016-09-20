package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 * 
 * JSP + EL
 * JSP + EL + JSTL JSP에 태그를 확장하여 사용할때 사용
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//customerId를 가져오는 변수 getParameter사용
		String customerId = request.getParameter("customerId");
		
		// Perfrom business logic. Return a bean as a result.
		// customerid에 맞는 bean을 불러와서 view해주어야함.
		
		CustomerService service = new CustomerService(); //Ctrl+Shift
		//가져온 id의 서비스 결과를 customer에 저장.
		Customer customer = service.findCustomer(customerId);
		//customer로 저장된 bean을 success.jsp에서 접근해서 수행하고있음.
		request.setAttribute("customer", customer);
		
		//Array생성하여 넘겨줌
		//We can iterate over lists using forEach in JSTL
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("id006", "Kim", "kim@hansung.ac.kr"));
		customers.add(new Customer("id007", "Lee", "Lee@hansung.ac.kr"));
		customers.add(new Customer("id008", "Park", "Park@hansung.ac.kr"));
		//request객체에 불러온 customer값을 집어넣음
		request.setAttribute("customerList", customers);

		
		String page;
		
		if(customer == null)
			page = "/view/error.jsp";
		else
			page = "/view/success.jsp";
		
		//dispatcher라는 객체를 얻어와서 forward메소드를 사용해서 해당되는 페이지로 이동하게된다. 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
