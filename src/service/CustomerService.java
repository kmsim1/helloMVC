package service;

import java.util.HashMap;
import java.util.Map;

//ctrl+shift+O
import model.Customer;

//id를받아서 DB에 접근해야하기 때문에 이곳에서 Map을 만들고 
//그 id를 바탕으로 Map을 조회를해서 해당되는 customer정보를 리턴해주는 Service객체를 만든다.
public class CustomerService {
	
	private Map<String, Customer> customers;

	//생성자
	public CustomerService() {
		customers = new HashMap<String, Customer>();
		
		addCustomer( new Customer("id001", "Alice", "alice.hansung.ac.kr") );
		addCustomer( new Customer("id002", "Bob", "Bob.hansung.ac.kr") );
		addCustomer( new Customer("id003", "Charlie", "Charlie.hansung.ac.kr") );
		addCustomer( new Customer("id004", "David", "David.hansung.ac.kr") );
		addCustomer( new Customer("id005", "Trudy", "Trudy.hansung.ac.kr") );
		
	}
	
	//customer로 인자를 받아서 HashMap에 key와 value로 삽입하는 함수
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	//id를 인자로 받아서 해당되는 value값을 넘기는 함수
	public Customer findCustomer(String id) {
		if(id != null)
			return(customers.get(id.toLowerCase())); //소문자로 바꿈
		else
			return null;
	}
}
