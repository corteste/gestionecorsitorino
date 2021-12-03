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
			tmp =tmp+"Nome corso non valido max 30 caratteri. No numeri <br>";
		if(!this.b[1])
			tmp =tmp+ "Durata corso non valida max 2 GG <br>";
		if(!this.b[2])
			tmp =tmp+ "Commento troppo lungo max 200 caratteri <br>";
		if(!this.b[3])
			tmp =tmp+ "Nome aula troppo lungo max 30 caratteri <br>";
		if(!this.b[4])
			tmp = tmp+"Docente non trovato o non abilitato all'insegnamento del corso scelto <br>";
		return tmp;
	}
	
	
}
