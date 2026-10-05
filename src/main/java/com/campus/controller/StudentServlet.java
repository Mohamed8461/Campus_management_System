package com.campus.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.campus.model.Student;
import com.campus.services.StudentService;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            action = "list";
        }

        switch (action) {

            case "list":
                request.setAttribute("students", studentService.getStudents());

                RequestDispatcher listDispatcher =
                        request.getRequestDispatcher("/student.jsp");

                listDispatcher.forward(request, response);
                break;

            case "edit":
                String editId = request.getParameter("id");

                if (editId == null || editId.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/students");
                    return;
                }

                int id = Integer.parseInt(editId);

                Student student = studentService.getStudentById(id);

                request.setAttribute("student", student);

                RequestDispatcher editDispatcher =
                        request.getRequestDispatcher("/update-student.jsp");

                editDispatcher.forward(request, response);
                break;

            case "delete":
                String deleteId = request.getParameter("id");

                if (deleteId == null || deleteId.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/students");
                    return;
                }

                studentService.deleteStudent(Integer.parseInt(deleteId));

                response.sendRedirect(request.getContextPath() + "/students");
                break;

            default:
                response.sendRedirect(request.getContextPath() + "/students");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            action = "add";
        }

        switch (action) {

            case "add": {
                String name = request.getParameter("name");
                String department = request.getParameter("department");
                String ageParam = request.getParameter("age");

                if (name == null || department == null || ageParam == null) {
                    response.sendRedirect(request.getContextPath() + "/students");
                    return;
                }

                int age = Integer.parseInt(ageParam);

                studentService.addStudent(name, department, age);

                response.sendRedirect(request.getContextPath() + "/students");
                break;
            }

            case "update": {
                String idParam = request.getParameter("id");
                String name = request.getParameter("name");
                String department = request.getParameter("department");
                String ageParam = request.getParameter("age");

                if (idParam == null || name == null ||
                        department == null || ageParam == null) {
                    response.sendRedirect(request.getContextPath() + "/students");
                    return;
                }

                int id = Integer.parseInt(idParam);
                int age = Integer.parseInt(ageParam);

                studentService.updateStudent(id, name, department, age);

                response.sendRedirect(request.getContextPath() + "/students");
                break;
            }

            case "delete": {
                String idParam = request.getParameter("id");

                if (idParam == null || idParam.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/students");
                    return;
                }

                studentService.deleteStudent(Integer.parseInt(idParam));

                response.sendRedirect(request.getContextPath() + "/students");
                break;
            }

            default:
                response.sendRedirect(request.getContextPath() + "/students");
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String ageParam = request.getParameter("age");

        if (idParam == null || name == null ||
                department == null || ageParam == null) {

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Missing student data"
            );
            return;
        }

        int id = Integer.parseInt(idParam);
        int age = Integer.parseInt(ageParam);

        studentService.updateStudent(id, name, department, age);

        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isEmpty()) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Student ID is required"
            );
            return;
        }

        int id = Integer.parseInt(idParam);

        studentService.deleteStudent(id);

        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
