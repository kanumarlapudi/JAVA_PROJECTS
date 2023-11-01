package in.ineuron.persistence;

import java.text.ParseException;

import in.ineuron.dto.Student;

public interface IStudentDao {

	// operations to be implemented

	public String addStudent(Student student) throws ParseException;

	public Student searchStudent(Integer id);

	public String updateStudent(Student student) throws ParseException;

	public String deleteStudent(Integer id);

}
