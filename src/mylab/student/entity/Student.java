package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
    // 1. 필드: 학번(studentId), 이름(name), 전공(major), 학년(grade) → 모두 private
    private String studentId;
    private String name;
    private String major;
    private int grade;

    // 기본 생성자
    public Student() {
    }

    // 모든 필드를 초기화하는 생성자
    public Student(String studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.grade = grade;
    }

    // 2. 모든 필드에 대해 getter와 setter 작성
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

  
    public void setGrade(int grade) throws InvalidGradeException { // throws 선언 추가
        if (grade >= 1 && grade <= 4) {
            this.grade = grade;
        } else {
            // System.out.println 대신 예외를 발생시킴
            throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
        }
    }
}