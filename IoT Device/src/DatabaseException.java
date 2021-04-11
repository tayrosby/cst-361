
public class DatabaseException extends RuntimeException {
	
	private static final long serialVersionUID = -5623776766017125741L;
	
	public DatabaseException(Throwable error) {
		super(error);
		System.out.println("error occurred");
	}

}
