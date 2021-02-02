package havis.device.rf.exception;

import java.lang.String;

/**
 * Signals an internal implementation error.
 * 
 */
public class ImplementationException extends RFControllerException {
	private static final long serialVersionUID = 7071330414970961332L;

	/**
	 * Creates an instance of this class.
	 */
	public ImplementationException() {
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
	public ImplementationException(String message, Throwable cause,
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
	public ImplementationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public ImplementationException(String message) {
		super(message);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param cause
	 *            the cause. (A null value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 */
	public ImplementationException(Throwable cause) {
		super(cause);
	}

	
}
