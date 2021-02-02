package havis.device.rf.exception;

import java.lang.String;

/**
 * Signals that a parameter has is null or has an invalid value.
 *
 */
public class ParameterException extends RFControllerException {
	private static final long serialVersionUID = 9142182550161892501L;

	/**
	 * Creates an instance of this class.
	 */
	public ParameterException() {
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
	public ParameterException(String message, Throwable cause,
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

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
	/**
	 * Creates an instance of this class.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public ParameterException(String message) {
		super(message);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param cause
	 *            the cause. (A null value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 */
	public ParameterException(Throwable cause) {
		super(cause);
	
	}
}
