package usuario;

public class UsuarioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1127643311422695482L;
	
	public UsuarioException() {
		
		super();
	}
	
	public UsuarioException(String error) {
		
		super(error);
	}

}
