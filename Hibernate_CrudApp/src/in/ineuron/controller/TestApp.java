package in.ineuron.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

//controller Logic
public class TestApp {

	static IStudentService studentService = null;

	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {

		while (true) {
			System.out.println(" 1 : Insert");
			System.out.println(" 2 : Select");
			System.out.println(" 3 : Update");
			System.out.println(" 4 : Delete");
			System.out.println(" 5 : Exit");

			Scanner scan = new Scanner(System.in);
			System.out.println("PLease Choose the option [1/2/3/4/5] : ");
			int number = scan.nextInt();

			switch (number) {

			case 1:
				insertOperation();
				break;
			case 2:
				selectOperation();
				break;
			case 3:
				updateOperation();
				break;
			case 4:
				deleteOperation();
				break;
			case 5:
				System.out.println(" ******   Thank for choosing this application  ******");
				System.exit(0);
			default:
				System.out.println("Invalid Option please try again with valid options : ");
			}

		}

	}

	public static void updateOperation()
			throws ParseException, NumberFormatException, FileNotFoundException, IOException {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the id to udpate : ");
		String id = scan.next();

		studentService = StudentServiceFactory.getStudentService();
		Student oldStudent = studentService.selectById(Integer.parseInt(id));

		int id1;
		String name;
		int age;
		String cityName;
		int year;
		int month;
		int date;
		String image;
		String resume;

		if (oldStudent != null) {
			Student newStudent = new Student();
			System.out.println("Student id is : " + oldStudent.getId());
			// newStudent.setId(oldStudent.getId());
			id1 = oldStudent.getId();

			System.out.println(
					"Student oldName is : " + oldStudent.getName() + " Do you want to change the name (yes/no) : ");
			String answerName = scan.next();
			if (answerName.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Name : ");
				String newName = scan.next();
				if (newName.equals("") || newName == "") {
					// newStudent.setName(oldStudent.getName());
					name = oldStudent.getName();
				} else {
					// newStudent.setName(newName);
					name = newName;
				}
			} else {
				// newStudent.setName(oldStudent.getName());
				name = oldStudent.getName();
			}

			System.out.println(
					"Student oldAge is : " + oldStudent.getAge() + " Do you want to change the age (yes/no) : ");
			String answerAge = scan.next();
			if (answerAge.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Age : ");
				String newAge = scan.next();
				if (newAge.equals("") || newAge == "") {
					// newStudent.setAge(oldStudent.getAge());
					age = oldStudent.getAge();
				} else {
					// newStudent.setAge(Integer.parseInt(newAge));
					age = Integer.parseInt(newAge);
				}
			} else {
				// newStudent.setAge(oldStudent.getAge());
				age = oldStudent.getAge();
			}

			System.out.println("Student oldCityName is : " + oldStudent.getCityName()
					+ " Do you want to change the CityName (yes/no) : ");
			String answerCityName = scan.next();
			if (answerCityName.equalsIgnoreCase("yes")) {
				System.out.println("Enter new City Name : ");
				String newCityName = scan.next();
				if (newCityName.equals("") || newCityName == "") {
					// newStudent.setCityName(oldStudent.getCityName());
					cityName = oldStudent.getCityName();
				} else {
					// newStudent.setCityName(newCityName);
					cityName = newCityName;
				}
			} else {
				// newStudent.setCityName(oldStudent.getCityName());
				cityName = oldStudent.getCityName();
			}

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("*********You have to enter DOB pakka ********");
			System.out.println();
			System.out.println();
			System.out.println();

			System.out.println("Student oldDob is : " + oldStudent.getDob() + "Please enter dob details newly  ");

			System.out.println("Please enter the Year in DOB to insert : ");
			year = scan.nextInt();

			System.out.println("Please enter the month in DOB to insert : ");
			month = scan.nextInt();

			System.out.println("Please enter the date in DOB to insert : ");
			date = scan.nextInt();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("*********You have to enter image location pakka ********");
			System.out.println();
			System.out.println();
			System.out.println();

			System.out.println(
					"Student oldimage is : " + oldStudent.getImage() + " Check the image in the given location  ");
			System.out.println("Enter new Image url : ");
			image = scan.next();

			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("*********You have to enter resume location pakka ********");
			System.out.println();
			System.out.println();
			System.out.println();

			System.out.println(
					"Student oldResume is : " + oldStudent.getResume() + " Check the resume in the given location  ");
			System.out.println("Please enter the resume location to insert : ");
			resume = scan.next();

			String msg = studentService.updateById(id1, name, age, cityName, year, month, date, image, resume);
			if (msg.equalsIgnoreCase("success")) {
				System.out.println("Record Updated Succesfully");
			} else {
				System.out.println("Record Updated failed");
			}
		}

		else {
			System.out.println("Student record not available for given id " + id + " for updation");
		}

	}

	public static void selectOperation() throws FileNotFoundException, IOException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the id to get the details : ");

		int id = scan.nextInt();

		studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.selectById(id);

		if (student != null) {
			System.out.println(student);

		} else {
			System.out.println("record not found for the given id : " + id);
		}

	}

	public static void insertOperation() throws ParseException, FileNotFoundException, IOException {

		Scanner scan = new Scanner(System.in);

		studentService = StudentServiceFactory.getStudentService();

		System.out.println("Please enter the name to insert : ");
		String name = scan.next();

		System.out.println("Please enter the age to insert : ");
		int age = scan.nextInt();

		System.out.println("Please enter the City Name to insert : ");
		String cityName = scan.next();

		System.out.println("Please enter the Year in DOB to insert : ");
		int year = scan.nextInt();

		System.out.println("Please enter the month in DOB to insert : ");
		int month = scan.nextInt();

		System.out.println("Please enter the date in DOB to insert : ");
		int date = scan.nextInt();

		System.out.println("Please enter the image location to insert : ");
		String image = scan.next();

		System.out.println("Please enter the resume location to insert : ");
		String resume = scan.next();

		String msg = studentService.save(name, age, cityName, year, month, date, image, resume);

		if (msg.equalsIgnoreCase("success")) {
			System.out.println("Record Inserted Succesfully");
		} else {
			System.out.println("Record Insertion failed");
		}
	}

	public static void deleteOperation() throws ParseException, FileNotFoundException, IOException {

		Scanner scan = new Scanner(System.in);

		studentService = StudentServiceFactory.getStudentService();

		System.out.println("Please enter the id number to delete : ");
		int id = scan.nextInt();

		String msg = studentService.deleteById(id);

		if (msg.equalsIgnoreCase("success")) {
			System.out.println("Record Deleted Succesfully");
		} else if (msg.equalsIgnoreCase("record not found")) {
			System.out.println("Record Not available : " + id);
		} else {
			System.out.println("record deletion failed");
		}
	}
}
