package in.ineuron.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import in.ineuron.dto.Student;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.persistence.IStudentDao;

//service layer logic
public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = null;

	@Override
	public String save(String name, int age, String cityName, int year, int month, int date, String image,
			String resume) throws ParseException, FileNotFoundException, IOException {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.save(name, age, cityName, year, month, date, image, resume);

	}

	@Override
	public Student selectById(Integer id) throws FileNotFoundException, IOException {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.selectById(id);
	}

	@Override
	public String updateById(int id, String name, int age, String cityName, int year, int month, int date,
			String image, String resume) throws ParseException, FileNotFoundException, IOException {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateById(id, name, age, cityName, year, month, date, image, resume);
	}

	@Override
	public String deleteById(Integer id) throws FileNotFoundException, IOException {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteById(id);
	}

}
