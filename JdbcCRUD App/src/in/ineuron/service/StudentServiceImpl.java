package in.ineuron.service;

import java.text.ParseException;

import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistence.IStudentDao;

//service layer logic
public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = null;

	@Override
	public String addStudent(String name, Integer age, String cityName, String dob, String image, String resume)
			throws ParseException {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(name, age, cityName, dob, image, resume);

	}

	@Override
	public Student searchStudent(Integer id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.searchStudent(id);
	}

	@Override
	public String updateStudent(Student student) throws ParseException {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer id) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.deleteStudent(id);
	}

}
