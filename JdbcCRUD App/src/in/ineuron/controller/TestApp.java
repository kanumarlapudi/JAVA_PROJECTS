package in.ineuron.controller;

import java.text.ParseException;
import java.util.Scanner;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

//controller Logic
public class TestApp {

	static IStudentService studentService = null;

	public static void main(String[] args) throws ParseException {

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

	public static void updateOperation() throws ParseException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the id to udpate : ");
		String id = scan.next();

		studentService = StudentServiceFactory.getStudentService();
		Student oldStudent = studentService.searchStudent(Integer.parseInt(id));

		if (oldStudent != null) {
			Student newStudent = new Student();
			System.out.println("Student id is : " + oldStudent.getId());
			newStudent.setId(oldStudent.getId());

			System.out.println(
					"Student oldName is : " + oldStudent.getName() + " Do you want to change the name (yes/no) : ");
			String answerName = scan.next();
			if (answerName.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Name : ");
				String newName = scan.next();
				if (newName.equals("") || newName == "") {
					newStudent.setName(oldStudent.getName());
				} else {
					newStudent.setName(newName);
				}
			} else {
				newStudent.setName(oldStudent.getName());
			}

			System.out.println(
					"Student oldAge is : " + oldStudent.getAge() + " Do you want to change the age (yes/no) : ");
			String answerAge = scan.next();
			if (answerAge.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Age : ");
				String newAge = scan.next();
				if (newAge.equals("") || newAge == "") {
					newStudent.setAge(oldStudent.getAge());
				} else {
					newStudent.setAge(Integer.parseInt(newAge));
				}
			} else {
				newStudent.setAge(oldStudent.getAge());
			}

			System.out.println("Student oldCityName is : " + oldStudent.getCityName()
					+ " Do you want to change the CityName (yes/no) : ");
			String answerCityName = scan.next();
			if (answerCityName.equalsIgnoreCase("yes")) {
				System.out.println("Enter new City Name : ");
				String newCityName = scan.next();
				if (newCityName.equals("") || newCityName == "") {
					newStudent.setCityName(oldStudent.getCityName());
				} else {
					newStudent.setCityName(newCityName);
				}
			} else {
				newStudent.setCityName(oldStudent.getCityName());
			}

			System.out.println(
					"Student oldDob is : " + oldStudent.getDob() + " Do you want to change the DOB (yes/no) : ");
			String answerDob = scan.next();
			if (answerDob.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Date Of Birth (dd-MM-yyyy) : ");
				String newDob = scan.next();
				if (newDob.equals("") || newDob == "") {
					newStudent.setDob(oldStudent.getDob());
				} else {
					newStudent.setDob(newDob);
				}
			} else {
				newStudent.setDob(oldStudent.getDob());
			}

			System.out.println(
					"Student oldimage is : " + oldStudent.getImage() + " Do you want to change the image (yes/no) : ");
			String answerImage = scan.next();
			if (answerImage.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Image : ");
				String newImage = scan.next();
				if (newImage.equals("") || newImage == "") {
					newStudent.setImage(oldStudent.getImage());
				} else {
					newStudent.setImage(newImage);
				}
			} else {
				newStudent.setImage(oldStudent.getImage());
			}

			System.out.println("Student oldResume is : " + oldStudent.getResume()
					+ " Do you want to change the Resume (yes/no) : ");
			String answerResume = scan.next();
			if (answerResume.equalsIgnoreCase("yes")) {
				System.out.println("Enter new Resume : ");
				String newResume = scan.next();
				if (newResume.equals("") || newResume == "") {
					newStudent.setResume(oldStudent.getResume());
				} else {
					newStudent.setResume(newResume);
				}
			} else {
				newStudent.setResume(oldStudent.getResume());
			}

			String msg = studentService.updateStudent(newStudent);
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

	public static void selectOperation() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the id to get the details : ");

		int id = scan.nextInt();

		studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(id);

		if (student != null) {
			System.out.println(id);
			System.out.println("NAME\tAGE\tCITYNAME\tDOB\tIMAGE\tRESUME");
			System.out.println(student.getName() + "\t" + student.getAge() + "\t" + student.getCityName() + "\t"
					+ student.getDob() + "\t" + student.getImage() + "\t" + student.getResume());

		} else {
			System.out.println("record not found for the given id : " + id);
		}

	}

	public static void insertOperation() throws ParseException {

		Scanner scan = new Scanner(System.in);

		studentService = StudentServiceFactory.getStudentService();

		System.out.println("Please enter the name to insert : ");
		String name = scan.next();

		System.out.println("Please enter the age to insert : ");
		int age = scan.nextInt();

		System.out.println("Please enter the City Name to insert : ");
		String cityName = scan.next();

		System.out.println("Please enter the DateOfBirth to insert (dd-MM-yyyy) : ");
		String dob = scan.next();

		System.out.println("Please enter the image location to insert : ");
		String image = scan.next();

		System.out.println("Please enter the resume location to insert : ");
		String resume = scan.next();

		String msg = studentService.addStudent(name, age, cityName, dob, image, resume);

		if (msg.equalsIgnoreCase("success")) {
			System.out.println("Record Inserted Succesfully");
		} else {
			System.out.println("Record Insertion failed");
		}
	}

	public static void deleteOperation() throws ParseException {

		Scanner scan = new Scanner(System.in);

		studentService = StudentServiceFactory.getStudentService();

		System.out.println("Please enter the id number to delete : ");
		Integer id = scan.nextInt();

		String msg = studentService.deleteStudent(id);

		if (msg.equalsIgnoreCase("success")) {
			System.out.println("Record Deleted Succesfully");
		} else if (msg.equalsIgnoreCase("record not found")) {
			System.out.println("Record Not available : " + id);
		} else {
			System.out.println("record deletion failed");
		}
	}
}
