package exceptions;

public class InvalidPasswordException extends Exception {
	private static final long serialVersionUID = -8373556203753931553L;

	public InvalidPasswordException() {
		super();
	}

	public InvalidPasswordException(String message) {
		super(message);
	}

	public InvalidPasswordException(Throwable cause) {
		super(cause);
	}

	public InvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

}
