package in.ineuron.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;

import in.ineuron.dto.Student;
import in.ineuron.util.Jdbc_util;

//persistence logic using JDBC Api
public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;

	@Override
	public String addStudent(Student student) throws ParseException {

		int rowAffected = 0;

		try {

			String sqlQuery = "insert into jobapplication(name,age,cityname,dob,image,resume) values(?,?,?,?,?,?)";

			connection = Jdbc_util.getConnection();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlQuery);

				prepareStatement.setNString(1, student.getName());
				prepareStatement.setInt(2, student.getAge());
				prepareStatement.setNString(3, student.getCityName());

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = sdf.parse(student.getDob());
				long l = date.getTime();
				java.sql.Date date2 = new java.sql.Date(l);

				prepareStatement.setDate(4, date2);

				File file = new File(student.getImage());
				FileInputStream fis = new FileInputStream(file);

				prepareStatement.setBinaryStream(5, fis);

				File file2 = new File(student.getResume());
				FileReader reader = new FileReader(file2);

				prepareStatement.setCharacterStream(6, reader);

				rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {

					return "success";

				}

			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchStudent(Integer id) {

		Student student = null;
		try {

			connection = Jdbc_util.getConnection();

			String sqlQuery = "select id,name,age,cityname,dob,image,resume from jobapplication where id = ?";

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlQuery);
				prepareStatement.setInt(1, id);
			}

			if (prepareStatement != null) {
				resultSet = prepareStatement.executeQuery();
			}

			if (resultSet != null) {

				while (resultSet.next()) {

					student = new Student();

					int id1 = resultSet.getInt(1);
					student.setId(id1);
					String name = resultSet.getNString(2);
					student.setName(name);

					int age = resultSet.getInt(3);
					student.setAge(age);

					String cityName = resultSet.getNString(4);
					student.setCityName(cityName);

					java.sql.Date date = resultSet.getDate(5);
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					String dob = sdf.format(date);
					student.setDob(dob);

					InputStream inputStream = resultSet.getBinaryStream(6);
					File f = new File("E:\\Images\\image.jpg");
					FileOutputStream fileOutputStream = new FileOutputStream(f);
					IOUtils.copy(inputStream, fileOutputStream);
					String image = f.getAbsolutePath();
					student.setImage(image);

					Reader reader = resultSet.getCharacterStream(7);
					File f1 = new File("E:\\Images\\Resume.txt");
					FileWriter writer = new FileWriter(f1);
					IOUtils.copy(reader, writer);
					String resume = f1.getAbsolutePath();
					student.setResume(resume);

					return student;
				}

			}

		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateStudent(Student student) throws ParseException {
		int rowAffected = 0;

		try {

			String sqlQuery = "update jobapplication set name=?, age=?, cityname=?, dob=?, image=?, resume=? where id=?";

			connection = Jdbc_util.getConnection();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlQuery);

				prepareStatement.setNString(1, student.getName());
				prepareStatement.setInt(2, student.getAge());
				prepareStatement.setNString(3, student.getCityName());

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date date = sdf.parse(student.getDob());
				long l = date.getTime();
				java.sql.Date date2 = new java.sql.Date(l);

				prepareStatement.setDate(4, date2);

				File file = new File(student.getImage());
				FileInputStream fis = new FileInputStream(file);

				prepareStatement.setBinaryStream(5, fis);

				File file2 = new File(student.getResume());
				FileReader reader = new FileReader(file2);

				prepareStatement.setCharacterStream(6, reader);

				prepareStatement.setInt(7, student.getId());

				rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {

					return "success";

				}

			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String deleteStudent(Integer id) {
		int rowAffected = 0;

		try {

			String sqlQuery = "delete from jobapplication where id = ? ";

			connection = Jdbc_util.getConnection();

			if (connection != null) {
				prepareStatement = connection.prepareStatement(sqlQuery);

				prepareStatement.setInt(1, id);

				rowAffected = prepareStatement.executeUpdate();

				if (rowAffected == 1) {

					return "success";

				} else {

					return "record not found";

				}
			}
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}

}
