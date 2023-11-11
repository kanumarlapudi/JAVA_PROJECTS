package in.ineuron.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.controller.MainController;
import in.ineuron.vo.CustomerVO;

public class TestApp {

	public static void main(String[] args) {

		Scanner scanner = new java.util.Scanner(System.in);

		System.out.println("Please enter the customer Name : ");
		String cName = scanner.next();

		System.out.println("Please enter the customer Address : ");
		String cAddress = scanner.next();

		System.out.println("Please enter the Amount : ");
		String amount = scanner.next();

		System.out.println("Please enter the rate of interest : ");
		String rate = scanner.next();

		System.out.println("Please enter the time : ");
		String time = scanner.next();

		CustomerVO vo = new CustomerVO();
		vo.setCustomerName(cName);
		vo.setCustomerAddress(cAddress);
		vo.setPamt(amount);
		vo.setRate(rate);
		vo.setTime(time);

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/ApplicationContext.xml");
		MainController controller = factory.getBean("customerController", MainController.class);
		try {
			String result = controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Internal problem.. Try again....." + e.getMessage());
		}
		scanner.close();

	}

}
