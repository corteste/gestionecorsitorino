package com.gestionecorsi.torino.exception;

public class InvalidCorsistaException extends Throwable {
	private boolean [] b;
	public InvalidCorsistaException(boolean[] b) {
		// TODO Auto-generated constructor stub
	this.b = b;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7779587581405751075L;
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String msg = "";
		if(!this.b[0])
			msg = msg+"Il nome contiene numeri e/o e' piu lungo di 30 caratteri";
		if(!this.b[1])
			msg = msg+" \nIl cognome contiene numeri e/o e' piu lungo di 30 caratteri";
		return msg ;
	}
	
	
}
