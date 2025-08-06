package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
    // 1. �ʵ�: �й�(studentId), �̸�(name), ����(major), �г�(grade) �� ��� private
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // �⺻ ������
    public Student() {
    }

    // ��� �ʵ带 �ʱ�ȭ�ϴ� ������
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    // 2. ��� �ʵ忡 ���� getter�� setter �ۼ�
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

  
    public void setGrade(int grade) throws InvalidGradeException { // throws ���� �߰�
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            // System.out.println ��� ���ܸ� �߻���Ŵ
            throw new InvalidGradeException("�г��� 1~4 ���̿��� �մϴ�.");
        }
    }
}