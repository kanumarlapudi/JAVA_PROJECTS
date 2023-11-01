package in.ineuron.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.dto.Student;
import in.ineuron.util.hibernate_util;

//persistence logic using JDBC Api
public class StudentDaoImpl implements IStudentDao {

	Session session = null;
	Transaction transaction = null;

	@Override
	public String save(String name, int age, String cityName, int year, int month, int date, String image,
			String resume) throws FileNotFoundException, IOException {

		session = hibernate_util.getSession();
		transaction = session.beginTransaction();
		byte i[] = null;
		char c[] = null;
		boolean flag = false;

		Student s = new Student();

		if (session != null) {

			System.out.println(age);
			System.out.println(name);
			System.out.println(cityName);
			System.out.println(year);
			System.out.println(month);
			System.out.println(date);
			System.out.println(image);
			System.out.println(resume);

			s.setName(name);
			s.setAge(age);
			s.setCityName(cityName);
			s.setDob(LocalDate.of(year, month, date));

			try (FileInputStream fis = new FileInputStream(image)) {

				i = new byte[fis.available()];
				fis.read(i);

			}

			s.setImage(i);

			File f = new File(resume);
			try (FileReader fr = new FileReader(f)) {

				c = new char[(int) f.length()];
				fr.read(c);

			}

			s.setResume(c);

			session.save(s);

			flag = true;
		}

		if (flag) {
			transaction.commit();
			System.out.println("record Inserted");
			return "success";
		} else {
			transaction.rollback();
			System.out.println("record not Inserted");
			return "failure";
		}

	}

	@Override
	public Student selectById(Integer id) throws FileNotFoundException, IOException {

		session = hibernate_util.getSession();

		if (session != null) {

			Student student = session.get(Student.class, id);

			if (student != null) {
				try (FileOutputStream fot = new FileOutputStream("./store/image.jpg");
						FileWriter fw = new FileWriter("./store/resume.txt")) {

					fot.write(student.getImage());

					fw.write(student.getResume());

					fot.flush();
					fw.flush();

					System.out.println("Photo and Resume got downloaded to :: ./store/*** ");

					student.setImage(null);
					student.setResume(null);
					return student;
				}

			}

		}

		return null;

	}

	@Override
	public String updateById(int id, String name, int age, String cityName, int year, int month, int date,
			String image, String resume) {

		session = hibernate_util.getSession();
		transaction = session.beginTransaction();
		byte i[] = null;
		char c[] = null;
		boolean flag = false;

		Student s = new Student();

		if (session != null) {

			System.out.println(id);
			System.out.println(age);
			System.out.println(name);
			System.out.println(cityName);
			System.out.println(year);
			System.out.println(month);
			System.out.println(date);
			System.out.println(image);
			System.out.println(resume);

			s.setId(id);
			s.setName(name);
			s.setAge(age);
			s.setCityName(cityName);
			s.setDob(LocalDate.of(year, month, date));

			try (FileInputStream fis = new FileInputStream(image)) {

				i = new byte[fis.available()];
				fis.read(i);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			s.setImage(i);

			File f = new File(resume);
			try (FileReader fr = new FileReader(f)) {

				c = new char[(int) f.length()];
				fr.read(c);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			s.setResume(c);

			session.merge(s);

			flag = true;
		}

		if (flag) {
			transaction.commit();
			System.out.println("record Inserted");
			return "success";
		} else {
			transaction.rollback();
			System.out.println("record not Inserted");
			return "failure";
		}

	
	}

	@Override
	public String deleteById(Integer id) throws FileNotFoundException, IOException {

		session = hibernate_util.getSession();

		transaction = session.beginTransaction();

		boolean flag = false;

		if (session != null) {
			Student student = session.get(Student.class, id);
			// System.out.println(student);
			if (student != null) {
				session.delete(id);
				flag = true;
			} else {
				return "record not found";
			}
		}

		if (flag) {
			transaction.commit();
			return "success";
		} else {
			transaction.rollback();
			return "failed";
		}

		/*
		 * int rowAffected = 0;
		 * 
		 * try {
		 * 
		 * String sqlQuery = "delete from jobapplication where id = ? ";
		 * 
		 * connection = Jdbc_util.getJdbcConnection();
		 * 
		 * if (connection != null) { prepareStatement =
		 * connection.prepareStatement(sqlQuery);
		 * 
		 * prepareStatement.setInt(1, id);
		 * 
		 * rowAffected = prepareStatement.executeUpdate();
		 * 
		 * if (rowAffected == 1) {
		 * 
		 * return "success";
		 * 
		 * } else {
		 * 
		 * return "record not found";
		 * 
		 * } } } catch (IOException | SQLException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); return "failure"; } return "failure";
		 */
	}

}
