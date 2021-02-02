package havis.device.rf.exception;

import java.lang.String;

/**
 * Signals a rejected connection request or an attempt to perform operations on a closed connection.
 * 
 */
public class ConnectionException extends RFControllerException {
	private static final long serialVersionUID = 5436838953309745868L;

	/**
	 * Creates an instance of this class.
	 * 
	 */
	public ConnectionException() {
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
	public ConnectionException(String message, Throwable cause,
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
	public ConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
	/**
	 * Creates an instance of this class.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public ConnectionException(String message) {
		super(message);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param cause
	 *            the cause. (A null value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 */
	public ConnectionException(Throwable cause) {
		super(cause);
	}


	
}
