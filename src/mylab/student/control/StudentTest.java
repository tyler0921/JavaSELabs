package mylab.student.control;

import mylab.student.exception.InvalidGradeException; // 추가된 import
import mylab.student.entity.Student;

/**
 * Student 클래스의 기능을 테스트하는 클래스 (Control)
 */
public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("20240001", "김민수", "컴퓨터공학", 3);

        System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
        System.out.println("5학년으로 변경");

        // setGrade()가 예외를 발생시킬 수 있으므로 try-catch 문으로 감싸야 함
        try {
            student.setGrade(5);
        } catch (InvalidGradeException e) {
            // 발생한 예외 객체로부터 메시지를 받아와 출력
            System.out.println(e.getMessage());
        }
    }
}