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
 * JSP + EL + JSTL JSP�� �±׸� Ȯ���Ͽ� ����Ҷ� ���
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
		
		//customerId�� �������� ���� getParameter���
		String customerId = request.getParameter("customerId");
		
		// Perfrom business logic. Return a bean as a result.
		// customerid�� �´� bean�� �ҷ��ͼ� view���־����.
		
		CustomerService service = new CustomerService(); //Ctrl+Shift
		//������ id�� ���� ����� customer�� ����.
		Customer customer = service.findCustomer(customerId);
		//customer�� ����� bean�� success.jsp���� �����ؼ� �����ϰ�����.
		request.setAttribute("customer", customer);
		
		//Array�����Ͽ� �Ѱ���
		//We can iterate over lists using forEach in JSTL
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("id006", "Kim", "kim@hansung.ac.kr"));
		customers.add(new Customer("id007", "Lee", "Lee@hansung.ac.kr"));
		customers.add(new Customer("id008", "Park", "Park@hansung.ac.kr"));
		//request��ü�� �ҷ��� customer���� �������
		request.setAttribute("customerList", customers);

		
		String page;
		
		if(customer == null)
			page = "/view/error.jsp";
		else
			page = "/view/success.jsp";
		
		//dispatcher��� ��ü�� ���ͼ� forward�޼ҵ带 ����ؼ� �ش�Ǵ� �������� �̵��ϰԵȴ�. 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
