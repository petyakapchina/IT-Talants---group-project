package exceptions;

public class InvalidEmailException extends Exception {

	private static final long serialVersionUID = -7466169186417884577L;

	public InvalidEmailException() {
		super();
	}

	public InvalidEmailException(String message) {
		super(message);
	}

	public InvalidEmailException(Throwable cause) {
		super(cause);
	}

	public InvalidEmailException(String message, Throwable cause) {
		super(message, cause);
	}

}
