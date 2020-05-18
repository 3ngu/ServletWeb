package Servlet;

import bean.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/CRUDStudent")
public class CRUDServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("methodName");
        try {
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Student student = new Student();

        Date birthday = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setStudentID(Integer.parseInt(req.getParameter("studentID")));
        student.setName(req.getParameter("name"));
        student.setSex(req.getParameter("sex"));
        student.setScore(Double.parseDouble(req.getParameter("score")));
        student.setBirthday(birthday);

        studentDao.addStudent(student);

        resp.sendRedirect("/CRUDStudent?methodName=listStudent");
    }

    public void delStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        studentDao.deleteStudent(id);
        resp.sendRedirect("/CRUDStudent?methodName=listStudent");
    }

    public void editStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("1");
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentDao.getStudentByID(id);

        req.setAttribute("student", student);

        req.getRequestDispatcher("/MyPage/editStudent.jsp").forward(req, resp);
    }

    public void updateStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Student student = new Student();

        Date birthday = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = sdf.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setId(Integer.parseInt(req.getParameter("id")));
        student.setStudentID(Integer.parseInt(req.getParameter("studentID")));
        student.setName(req.getParameter("name"));
        student.setSex(req.getParameter("sex"));
        student.setScore(Double.parseDouble(req.getParameter("score")));
        student.setBirthday(birthday);

        System.out.println(student);
        studentDao.updateStudent(student);
        resp.sendRedirect("/CRUDStudent?methodName=listStudent");
    }

    public void listStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Student> students = studentDao.list();

        req.setAttribute("students", students);
        req.setAttribute("studentCount", studentDao.getStudentTotal());
        req.getRequestDispatcher("/MyPage/listStudent.jsp").forward(req, resp);
    }
}
