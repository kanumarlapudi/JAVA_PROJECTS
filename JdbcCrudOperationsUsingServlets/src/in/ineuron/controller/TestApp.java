package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;

@WebServlet("/test/*")
public class TestApp extends HttpServlet {
	public static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = null;
		String status = null;

		IStudentService studentService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI ::  " + request.getRequestURI());
		System.out.println("Path info :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {

			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String cityname = request.getParameter("cityname");
			String dob = request.getParameter("dob");
			String image = request.getParameter("image");
			String resume = request.getParameter("resume");

			System.out.println(name);

			Student s = new Student();
			s.setName(name);
			s.setAge(Integer.parseInt(age));
			s.setCityName(cityname);
			s.setDob(dob);
			s.setImage(image);
			s.setResume(resume);

			try {
				status = studentService.addStudent(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			try {
				writer = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}

//			if (status.equalsIgnoreCase("success")) {
//
//				writer.println("<h1 style = 'color: green; text-align:center;'> Registration Successfull </h1>");
//			} else {
//				writer.println("<h1 style = 'color: red; text-align:center;'> Registration Failed </h1>");
//			}

			RequestDispatcher rd = null;
			if (status.equalsIgnoreCase("success")) {

				rd = request.getRequestDispatcher("../addSuccess.html");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../addFailure.html");
				rd.forward(request, response);
			}

			writer.close();
		}

		if (request.getRequestURI().endsWith("searchform")) {

			String id = request.getParameter("id");

			Student searchStudent = studentService.searchStudent(Integer.parseInt(id));

			try {
				writer = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (searchStudent != null) {

				writer.println("<body>");
				writer.println("<br/><br/><br/>");
				writer.println("<center>");
				writer.println("<table border = '1'>");
				writer.println("<tr><th>Id</th><td>" + searchStudent.getId() + "</td></tr>");
				writer.println("<tr><th>Name</th><td>" + searchStudent.getName() + "</td></tr>");
				writer.println("<tr><th>Age</th><td>" + searchStudent.getAge() + "</td></tr>");
				writer.println("<tr><th>CityName</th><td>" + searchStudent.getCityName() + "</td></tr>");
				writer.println("<tr><th>DateOfBirth</th><td>" + searchStudent.getDob() + "</td></tr>");
				writer.println("<tr><th>Image</th><td>" + searchStudent.getImage() + "</td></tr>");
				writer.println("<tr><th>Resume</th><td>" + searchStudent.getResume() + "</td></tr>");
				writer.println("</table>");
				writer.println("</center>");
				writer.println("</body>");
			} else {
				writer.println(
						"<h1 style = 'color: red; text-align:center;'> Record Not Found For The Provided Id</h1>");
			}
			writer.close();
		}

		if (request.getRequestURI().endsWith("deleteform")) {

			String id = request.getParameter("id");

			String deleteStudent = studentService.deleteStudent(Integer.parseInt(id));

			try {
				writer = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}

//			if (deleteStudent.equalsIgnoreCase("success")) {
//
//				writer.println("<h1 style = 'color:green;text-align:center;'> Record Deleted Succesfully </h1>");
//
//			} else if (deleteStudent.equalsIgnoreCase("failure")) {
//				writer.println("<h1 style = 'color:red;text-align:center;'> Record Deletion Failed </h1>");
//			} else {
//				writer.println("<h1 style = 'color:blue;text-align:center;'> Record Not Found For Deletion </h1>");
//			}

			RequestDispatcher rd = null;
			if (deleteStudent.equalsIgnoreCase("success")) {

				rd = request.getRequestDispatcher("../deleteSuccess.html");
				rd.forward(request, response);

			} else if (deleteStudent.equalsIgnoreCase("failure")) {
				rd = request.getRequestDispatcher("../deleteFailure.html");
				rd.forward(request, response);

			} else {
				rd = request.getRequestDispatcher("../deleteNotFound.html");
				rd.forward(request, response);

			}

			writer.close();

		}

		if (request.getRequestURI().endsWith("editform")) {

			String id = request.getParameter("id");
			System.out.println("Hi");
			Student search = studentService.searchStudent(Integer.parseInt(id));

			try {
				writer = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (search != null) {
				// display student details as a form data so it is editable

				writer.println("<body>");
				writer.println("<center>");
				writer.println("<form method='post' action='./test/updateRecord'>");
				writer.println("<table>");
				writer.println("<tr><th>ID</th><td>" + search.getId() + "</td></tr>");
				writer.println("<input type='hidden' name='id' value='" + search.getId() + "'/>");
				writer.println("<tr><th>NAME</th><td><input type='text' name='sname' value='" + search.getName()
						+ "'/></td></tr>");
				writer.println("<tr><th>AGE</th><td><input type='text' name='sage' value='" + search.getAge()
						+ "'/></td></tr>");
				writer.println("<tr><th>ADDRESS</th><td><input type='text' name='saddr' value='" + search.getCityName()
						+ "'/></td></tr>");
				writer.println("<tr><th>DOB</th><td><input type='text' name='sdob' value='" + search.getDob()
						+ "'/></td></tr>");
				writer.println("<tr><th>Image</th><td><input type='text' name='simage' value='" + search.getImage()
						+ "'/></td></tr>");
				writer.println("<tr><th>Resume</th><td><input type='text' name='resume' value='" + search.getResume()
						+ "'/></td></tr>");
				writer.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				writer.println("</table>");
				writer.println("</form>");
				writer.println("</center>");
				writer.println("</body>");

			} else {
				// display not found image

				writer.println(
						"<h1 style = 'color: red; text-align:center;'> Record Not Found For The Provided Id</h1>");
			}
			writer.close();
		}

		if (request.getRequestURI().endsWith("updateRecord")) {
			String id = request.getParameter("id");
			String name = request.getParameter("sname");
			String age = request.getParameter("sage");
			String cityname = request.getParameter("saddr");
			String dob = request.getParameter("sdob");
			String image = request.getParameter("simage");
			String resume = request.getParameter("resume");

			Student s = new Student();
			s.setId(Integer.parseInt(id));
			s.setName(name);
			s.setAge(Integer.parseInt(age));
			s.setCityName(cityname);
			s.setDob(dob);
			s.setImage(image);
			s.setResume(resume);

			try {
				status = studentService.updateStudent(s);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			try {
				writer = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}

//			if (status.equalsIgnoreCase("success")) {
//
//				writer.println(
//						"<h1 style = 'color: green; text-align:center;'> Student Record Updated Successfully </h1>");
//			} else {
//				writer.println("<h1 style = 'color: red; text-align:center;'> Student Record Updation Failed </h1>");
//			}

			RequestDispatcher rd = null;
			if (status.equalsIgnoreCase("success")) {

				rd = request.getRequestDispatcher("../../updatedSuccess.html");
				rd.forward(request, response);

			} else {
				rd = request.getRequestDispatcher("../../updatedFailure.html");
				rd.forward(request, response);

			}
			writer.close();
		}

	}

}
