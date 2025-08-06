package workshop.account.exception;

//사용자 정의 Exception
public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String errMessage) {
		//부모클래스(Exception)의 생성자를 호출하기
		super(errMessage);
	}

}
