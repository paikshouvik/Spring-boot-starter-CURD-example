package paik.jpa.example.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String errorCode;
		private String errorMassage;
		public String getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorMassage() {
			return errorMassage;
		}
		public void setErrorMassage(String errorMassage) {
			this.errorMassage = errorMassage;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public ControllerException(String errorCode, String errorMassage) {
			super();
			this.errorCode = errorCode;
			this.errorMassage = errorMassage;
		}
		@Override
		public String toString() {
			return "ControllerException [errorCode=" + errorCode + ", errorMassage=" + errorMassage + "]";
		}
		
		
}
