package util;

public class DatabaseException extends RuntimeException{
	private static final long serialVersionUID = -5623776766017125741L;
	
	public DatabaseException(Throwable e) {
		super(e);
		System.out.println("Database not found");
	}

}
