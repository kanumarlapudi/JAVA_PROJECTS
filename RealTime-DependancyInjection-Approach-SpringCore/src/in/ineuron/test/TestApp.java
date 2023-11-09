package in.ineuron.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.comp.FlipKart;

public class TestApp {

	public static void main(String[] args) throws IOException {

		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext(
				"in/ineuron/cfg/ApplicationContext.xml");
		System.out.println("*****CONTAINER STARTED****\n");

		FlipKart flipKart = factory.getBean("fpkt", FlipKart.class);
		System.out.println(flipKart);

		String result = flipKart.doShopping(new String[] { "fossil", "tissot" }, new Float[] { 20000.0f, 30000.0f });

		System.out.println(result);
		System.out.println("Container stopped");
		factory.close();
	}

}
