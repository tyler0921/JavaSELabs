package mylab.student.exception;

public class InvalidGradeException extends Exception{
	 // �⺻ ������
    public InvalidGradeException() {
        super(); // �θ��� Exception Ŭ������ ������ ȣ��
    }

    // ���� �޽����� �޴� ������
    public InvalidGradeException(String message) {
        super(message); // �θ� Ŭ������ ���� �޽��� ����
    }
}
