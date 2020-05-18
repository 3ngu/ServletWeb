package dao;

import Tools.JDBCTool;
import bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public void addStudent(Student student) {
        String sql = "insert into student values(null, ?, ?, ?, ?, ?)";
        try(Connection c = JDBCTool.getDBConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, student.getStudentID());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSex());
            ps.setDate(4, new Date(student.getBirthday().getTime()));
            ps.setDouble(5, student.getScore());

            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "delete from student where id = ?";
        try(Connection c = JDBCTool.getDBConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);

            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String sql = "update  student set studentID = ?, name = ?, sex = ?, birthday = ?, score = ?  where id = ?";
        try(Connection c = JDBCTool.getDBConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, student.getStudentID());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSex());
            ps.setDate(4, new Date(student.getBirthday().getTime()));
            ps.setDouble(5, student.getScore());
            ps.setInt(6, student.getId());

            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> list() {
        List<Student> students = new ArrayList<>();
        String sql = "select * from student order by studentID";

        try(Connection c = JDBCTool.getDBConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while ((rs.next())) {
                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setStudentID(rs.getInt("studentID"));
                s.setName(rs.getString("name"));
                s.setSex(rs.getString("sex"));
                s.setScore(rs.getDouble("score"));
                s.setBirthday(rs.getDate("birthday"));

                students.add(s);
            }

            rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student getStudentByID(int id) {
        Student student = new Student();
        String sql = "select * from student where id = " + id;
        try (Connection c = JDBCTool.getDBConnection(); Statement st = c.createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                student.setStudentID(rs.getInt("studentID"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getDate("birthday"));
                student.setScore(rs.getDouble("score"));
                student.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public int getStudentTotal() {
        int total = 0;

        String sql = "select COUNT(*) from student";
        try (Connection c = JDBCTool.getDBConnection(); Statement st = c.createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
