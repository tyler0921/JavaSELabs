package mylab.student.control;

import mylab.student.exception.InvalidGradeException;
import mylab.student.entity.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("20240001", "김민수", "컴퓨터공학", 3);

        System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
        System.out.println("5학년으로 변경");
        try {
            student.setGrade(5);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }
}