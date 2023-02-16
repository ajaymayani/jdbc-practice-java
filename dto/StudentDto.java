package student_management.dto;

import student_management.entities.Mark;
import student_management.entities.Result;
import student_management.entities.Student;
import student_management.services.MarkService;
import student_management.services.ResultService;
import student_management.services.StudentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDto implements StudentService {

    private Connection conn;
    private String query;
    private PreparedStatement ps;
    private MarkService markService;
    private ResultService resultService;

    public StudentDto(Connection conn) {
        this.conn = conn;
        markService = new MarkDto(conn);
        resultService = new ResultDto(conn);
    }

    @Override
    public Student insertStudent(Student student) {
        try {
            this.query = "INSERT INTO student (FirstName,LastName,mobile) VALUES (?,?,?)";
            this.ps = this.conn.prepareCall(this.query);
            this.ps.setString(1, student.getFirstName());
            this.ps.setString(2, student.getLastName());
            this.ps.setString(3, student.getMobileNumber());
            int i = this.ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            generatedKeys.next();

            int sId = generatedKeys.getInt(1);
            System.out.println(sId);

            Mark mark = student.getMark();
            mark.setsId(sId);

            float total = mark.getSub1()+mark.getSub2()+mark.getSub3()+mark.getSub4()+mark.getSub5();

            mark.setTotal(total);

            this.markService.insertMark(mark);

            Result result = new Result();
            result.setsId(sId);
            result.setPercentage(total/5);
            result.setGrade(calculateGrad(result.getPercentage()));

            Result result1 = this.resultService.insertResult(result);
            student.setResult(result1);

            if (i == 1) {
                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Student updateStudent(Student student, int sId) {
        try {
            this.query = "UPDATE student set FirstName=?,LastName=?,mobile=? WHERE sId = ?";
            this.ps = this.conn.prepareStatement(this.query);
            this.ps.setString(1, student.getFirstName());
            this.ps.setString(2, student.getLastName());
            this.ps.setString(3, student.getMobileNumber());
            this.ps.setInt(4, sId);
            int i = this.ps.executeUpdate();
            if (i == 1) {

                Mark mark = student.getMark();

                int total = mark.getSub1()+mark.getSub2()+mark.getSub3()+mark.getSub4()+mark.getSub5();
                mark.setTotal(total);
                this.markService.updateMark(mark,sId);

                Result r = new Result();
                r.setPercentage(total/5);
                r.setGrade(calculateGrad(total/5));

                this.resultService.updateResult(r,sId);

                return student;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteStudent(int sId) {
        try {
            this.query = "DELETE FROM student  WHERE sId = ?";
            this.ps = this.conn.prepareStatement(this.query);
            this.ps.setInt(1, sId);
            int i = this.ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Student getStudent(int sId) {
        try {
            this.query = "SELECT * FROM student s, marks m , result r WHERE s.sId = ? and  m.sId = ? and r.sId = ?";
            this.ps = this.conn.prepareStatement(this.query);
            this.ps.setInt(1, sId);
            this.ps.setInt(2, sId);
            this.ps.setInt(3, sId);

            Student student = new Student();
            ResultSet resultSet = this.ps.executeQuery();

            while (resultSet.next()) {
                student.setFirstName(resultSet.getString("FirstName"));
                student.setLastName(resultSet.getString("LastName"));
                student.setMobileNumber(resultSet.getString("mobile"));

                Mark mark = new Mark();
                mark.setSub1(resultSet.getInt("sub1"));
                mark.setSub2(resultSet.getInt("sub2"));
                mark.setSub3(resultSet.getInt("sub3"));
                mark.setSub4(resultSet.getInt("sub4"));
                mark.setSub5(resultSet.getInt("sub5"));
                mark.setTotal(resultSet.getInt("total"));

                Result result = new Result();
                result.setPercentage(resultSet.getFloat("percentage"));
                result.setGrade(resultSet.getString("grade"));

                student.setMark(mark);
                student.setResult(result);
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getStudent() {
        try {
                this.query = "SELECT * FROM student s,marks m , result r where s.sId = m.sId and s.sId = r.sId";
            this.ps = this.conn.prepareStatement(this.query);

            List<Student> studentList = new ArrayList<>();
            ResultSet resultSet = this.ps.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();

                student.setFirstName(resultSet.getString("FirstName"));
                student.setLastName(resultSet.getString("LastName"));
                student.setMobileNumber(resultSet.getString("mobile"));


                Mark mark = new Mark();
                mark.setSub1(resultSet.getInt("sub1"));
                mark.setSub2(resultSet.getInt("sub2"));
                mark.setSub3(resultSet.getInt("sub3"));
                mark.setSub4(resultSet.getInt("sub4"));
                mark.setSub5(resultSet.getInt("sub5"));
                mark.setTotal(resultSet.getInt("total"));

                Result result = new Result();
                result.setPercentage(resultSet.getFloat("percentage"));
                result.setGrade(resultSet.getString("grade"));

                student.setMark(mark);
                student.setResult(result);

                studentList.add(student);
            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String calculateGrad(float percentage)
    {
        String grade="";
        if (percentage > 90 && percentage <= 100) {
            grade = "A";
        } else if (percentage > 80 && percentage <= 90) {
            grade = "B";
        } else if (percentage > 70 && percentage <= 80) {
            grade = "C";
        } else if (percentage > 50 && percentage <= 70) {
            grade = "D";
        } else {
            grade = "F";
        }
        return grade;
    }
}
