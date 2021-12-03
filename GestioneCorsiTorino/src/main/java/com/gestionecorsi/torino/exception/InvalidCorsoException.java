package com.gestionecorsi.torino.exception;

public class InvalidCorsoException extends Throwable {

	private  boolean [] b;
	private static final long serialVersionUID = -6997393756161655650L;
	
	public InvalidCorsoException(boolean [] b) {
		this.b = b;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String tmp ="" ;
		if(!this.b[0])
			tmp = "Nome corso non valido max 30 caratteri no numeri";
		if(!this.b[1])
			tmp = "Durata corso non valida max 2 GG";
		if(!this.b[2])
			tmp = "Commento troppo lungo max 200 caratteri";
		if(!this.b[3])
			tmp = "Nome aula troppo lungo max 30 caratteri";
		if(!this.b[4])
			tmp = "Docente non trovato o non abilitato all'insegnamento del corso scelto";
		return tmp;
	}
	
	
}
