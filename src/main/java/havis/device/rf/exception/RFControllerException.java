package havis.device.rf.exception;

import java.lang.String;

/**
 * Abstract class describing RF controller specific errors.
 *
 */
public abstract class RFControllerException extends Exception {
	private static final long serialVersionUID = -8419273822344052897L;


	/**
	 * Creates an instance of this class.
	 */

	public RFControllerException() {
		super();
	}


	/**
	 * Creates an instance of this class.
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause. (A null value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 * @param enableSuppression
	 *            whether or not suppression is enabled or disabled
	 * @param writableStackTrace
	 *            whether or not the stack trace should be writable
	 */
	public RFControllerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param message
	 *            the detail message.
	 * @param cause
	 *            the cause. (A null value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 */
	public RFControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public RFControllerException(String message) {
		super(message);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param cause
	 *            the cause. (A null value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 */
	public RFControllerException(Throwable cause) {
		super(cause);
	}

	
}
