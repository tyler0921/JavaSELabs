package mylab.student.exception;

public class InvalidGradeException extends Exception{
	 // 기본 생성자
    public InvalidGradeException() {
        super(); // 부모인 Exception 클래스의 생성자 호출
    }

    // 예외 메시지를 받는 생성자
    public InvalidGradeException(String message) {
        super(message); // 부모 클래스에 예외 메시지 전달
    }
}
