package service;

import java.util.HashMap;
import java.util.Map;

//ctrl+shift+O
import model.Customer;

//id���޾Ƽ� DB�� �����ؾ��ϱ� ������ �̰����� Map�� ����� 
//�� id�� �������� Map�� ��ȸ���ؼ� �ش�Ǵ� customer������ �������ִ� Service��ü�� �����.
public class CustomerService {
	
	private Map<String, Customer> customers;

	//������
	public CustomerService() {
		customers = new HashMap<String, Customer>();
		
		addCustomer( new Customer("id001", "Alice", "alice.hansung.ac.kr") );
		addCustomer( new Customer("id002", "Bob", "Bob.hansung.ac.kr") );
		addCustomer( new Customer("id003", "Charlie", "Charlie.hansung.ac.kr") );
		addCustomer( new Customer("id004", "David", "David.hansung.ac.kr") );
		addCustomer( new Customer("id005", "Trudy", "Trudy.hansung.ac.kr") );
		
	}
	
	//customer�� ���ڸ� �޾Ƽ� HashMap�� key�� value�� �����ϴ� �Լ�
	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	//id�� ���ڷ� �޾Ƽ� �ش�Ǵ� value���� �ѱ�� �Լ�
	public Customer findCustomer(String id) {
		if(id != null)
			return(customers.get(id.toLowerCase())); //�ҹ��ڷ� �ٲ�
		else
			return null;
	}
}
