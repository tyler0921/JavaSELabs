package mylab.student.control;

import mylab.student.exception.InvalidGradeException; // �߰��� import
import mylab.student.entity.Student;

/**
 * Student Ŭ������ ����� �׽�Ʈ�ϴ� Ŭ���� (Control)
 */
public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("20240001", "��μ�", "��ǻ�Ͱ���", 3);

        System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "�г�");
        System.out.println("5�г����� ����");

        // setGrade()�� ���ܸ� �߻���ų �� �����Ƿ� try-catch ������ ���ξ� ��
        try {
            student.setGrade(5);
        } catch (InvalidGradeException e) {
            // �߻��� ���� ��ü�κ��� �޽����� �޾ƿ� ���
            System.out.println(e.getMessage());
        }
    }
}