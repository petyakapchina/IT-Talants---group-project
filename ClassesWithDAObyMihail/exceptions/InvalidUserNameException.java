package exceptions;

public class InvalidUserNameException extends Exception {
	private static final long serialVersionUID = 8485608044512895115L;

	public InvalidUserNameException() {
		super();
	}

	public InvalidUserNameException(String message) {
		super(message);
	}

	public InvalidUserNameException(Throwable cause) {
		super(cause);
	}

	public InvalidUserNameException(String message, Throwable cause) {
		super(message, cause);
	}

}
