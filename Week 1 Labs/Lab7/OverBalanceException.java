package Lab7;

public class OverBalanceException extends RuntimeException {

	//No-arg Constructor
	public OverBalanceException() {
	}
	
	//Parameterized Constructor
	public OverBalanceException(String errorMessage) {
		super(errorMessage);
	}
	
}
