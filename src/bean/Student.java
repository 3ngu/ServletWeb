package bean;

import java.util.Date;

public class Student {
    private int id;
    private int studentID;
    private String name;
    private Date birthday;
    private double score;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentID=" + studentID +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                '}';
    }
}
