package in.ineuron.service;

import java.text.ParseException;

import in.ineuron.dto.Student;

public interface IStudentService {

	// operations to be implemented

	public String addStudent(Student student) throws ParseException;

	public Student searchStudent(Integer id);

	public String updateStudent(Student student) throws ParseException;

	public String deleteStudent(Integer id);
}
