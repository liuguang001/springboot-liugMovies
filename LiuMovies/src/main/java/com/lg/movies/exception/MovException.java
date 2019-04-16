package com.lg.movies.exception;

/**业务异常
 * @author
 *
 */
@SuppressWarnings("serial")
public class MovException extends RuntimeException{

	public MovException() {
		super();
	}

	public MovException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MovException(String message, Throwable cause) {
		super(message, cause);
	}

	public MovException(String message) {
		super(message);
	}

	public MovException(Throwable cause) {
		super(cause);
	}
	
}
