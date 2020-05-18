package Servlet;

import bean.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editStudent")
public class editServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = new StudentDao().getStudentByID(id);

        req.setAttribute("student", student);
        System.out.println(student);
        req.getRequestDispatcher("/MyPage/editStudent.jsp").forward(req, resp);
    }
}
