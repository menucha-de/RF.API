package havis.device.rf.exception;

import java.lang.String;

/**
 * Signals a communication problem with the RF hardware.
 * 
 */
public class CommunicationException extends RFControllerException {
	private static final long serialVersionUID = 2433708301815213411L;

	/**
	 * Creates an instance of this class.
	 */
	public CommunicationException() {
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
	public CommunicationException(String message, Throwable cause,
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
	public CommunicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public CommunicationException(String message) {
		super(message);
	}

	/**
	 * Creates an instance of this class.
	 * 
	 * @param cause
	 *            the cause. (A null value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 */
	public CommunicationException(Throwable cause) {
		super(cause);

	}

}
