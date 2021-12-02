package com.gestionecorsi.torino.model;

public class CorsoCorsista {
	private int codCorso;
	private int codCorsista;
	
	public int getCodCorso() {
		return codCorso;
	}
	public void setCodCorso(int codCorso) {
		this.codCorso = codCorso;
	}
	public int getCodCorsista() {
		return codCorsista;
	}
	public void setCodCorsista(int codCorsista) {
		this.codCorsista = codCorsista;
	}
	
	@Override
	public String toString() {
		return "CorsoCorsista [codCorso=" + codCorso + ", codCorsista=" + codCorsista + "]";
	}
	
	

}
