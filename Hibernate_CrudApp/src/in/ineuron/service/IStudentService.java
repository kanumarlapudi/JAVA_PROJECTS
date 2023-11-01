package in.ineuron.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import in.ineuron.dto.Student;

public interface IStudentService {

	// operations to be implemented

	public String save(String name, int age, String cityName, int year, int month, int date, String image,
			String resume) throws ParseException, FileNotFoundException, IOException;

	public Student selectById(Integer id) throws FileNotFoundException, IOException;

	public String updateById(int id, String name, int age, String cityName, int year, int month, int date, String image,
			String resume) throws ParseException, FileNotFoundException, IOException;

	public String deleteById(Integer id) throws FileNotFoundException, IOException;
}
