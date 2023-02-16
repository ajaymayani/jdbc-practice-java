package student_management;

import student_management.dto.DBConnection;
import student_management.dto.StudentDto;
import student_management.entities.Mark;
import student_management.entities.Student;
import student_management.services.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentDto = new StudentDto(new DBConnection().getConnection());
        start(sc, studentDto);
    }

    private static void start(Scanner sc, StudentService studentDto) {
        System.out.println("*********Student Management System*********");
        int choose = 0;
        do {
            System.out.println("---------------------------------------");
            System.out.println("Press 1 for create student");
            System.out.println("Press 2 for update student");
            System.out.println("Press 3 for delete student");
            System.out.println("Press 4 for get student by studentID");
            System.out.println("Press 5 for get all students");
            System.out.println("Press 6 for EXIT");
            System.out.println("---------------------------------------");

            choose = sc.nextInt();
            int sId;
            Student student;
            switch (choose) {
                case 1:
                    student = studentDto.insertStudent(getStudentData(sc));
                    System.out.println("\nStudent inserted successfully...!");
                    System.out.println(student + "\n");
                    break;
                case 2:
                    System.out.println("\nEnter student id who's data you want to update : ");
                    sId = sc.nextInt();
                    student = studentDto.updateStudent(getStudentData(sc), sId);
                    System.out.println("\nStudent updated successfully...!");
                    System.out.println(student + "\n");
                    break;
                case 3:
                    System.out.println("\nEnter student id who's data you want to delete : ");
                    sId = sc.nextInt();
                    boolean b = studentDto.deleteStudent(sId);
                    if (b) {
                        System.out.println("\nStudent deleted successfully...!");
                    } else {
                        System.out.println("Something went to wrong");
                    }
                    break;
                case 4:
                    System.out.println("\nEnter student id who's data you want to show : ");
                    sId = sc.nextInt();
                    student = studentDto.getStudent(sId);
                    if (student != null) {
                        System.out.println("\nFirstName\tLastName\tMobile\t\tSub1\tSub2\tSub3\tSub4\tSub5\tTotal\tPercentage\tGrade");
                        System.out.println(student.getFirstName() + "\t\t" + student.getLastName() + "\t\t" + student.getMobileNumber() + "\t" + student.getMark().getSub1() + "\t\t" + student.getMark().getSub2() + "\t\t" + student.getMark().getSub3() + "\t\t" + student.getMark().getSub4() + "\t\t" + student.getMark().getSub5() + "\t\t" + student.getMark().getTotal() + "\t\t" + student.getResult().getPercentage() + "\t\t" + student.getResult().getGrade());
                    } else {
                        System.out.println("\nData not found");
                    }

                    break;
                case 5:
                    List<Student> allStudent = studentDto.getStudent();
                    System.out.println("\nFirstName\tLastName\tMobile");
                    System.out.println("\nFirstName\tLastName\tMobile\t\tSub1\tSub2\tSub3\tSub4\tSub5\tTotal\tPercentage\tGrade");
                    for (Student s : allStudent) {
//                        System.out.println(s.getFirstName() + "\t\t" + s.getLastName() + "\t\t" + s.getMobileNumber());
                        System.out.println(s.getFirstName() + "\t\t" + s.getLastName() + "\t\t" + s.getMobileNumber() + "\t" + s.getMark().getSub1() + "\t\t" + s.getMark().getSub2() + "\t\t" + s.getMark().getSub3() + "\t\t" + s.getMark().getSub4() + "\t\t" + s.getMark().getSub5() + "\t\t" + s.getMark().getTotal() + "\t\t" + s.getResult().getPercentage() + "\t\t" + s.getResult().getGrade());

                    }
                    break;
            }
        } while (choose != 6);
        System.out.println("\n THANK YOU....:)");
    }

    private static Student getStudentData(Scanner sc) {
        sc.nextLine();

        System.out.println("\nSTUDENT BASIC DETAILS ");
        System.out.println("Enter student First Name : ");
        String firstName = sc.nextLine();
        System.out.println("Enter student Last Name : ");
        String lastName = sc.nextLine();
        System.out.println("Enter student mobile number : ");
        String mobile = sc.nextLine();

        System.out.println("\nSTUDENT MARKS DETAILS ");

        System.out.println("Enter sub1 marks : ");
        int sub1 = sc.nextInt();
        System.out.println("Enter sub2 marks : ");
        int sub2 = sc.nextInt();
        System.out.println("Enter sub3 marks : ");
        int sub3 = sc.nextInt();
        System.out.println("Enter sub4 marks : ");
        int sub4 = sc.nextInt();
        System.out.println("Enter sub5 marks : ");
        int sub5 = sc.nextInt();

        Mark mark = new Mark();
        mark.setSub1(sub1);
        mark.setSub2(sub2);
        mark.setSub3(sub3);
        mark.setSub4(sub4);
        mark.setSub5(sub5);

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setMobileNumber(mobile);
        student.setMark(mark);


        return student;
    }
}
