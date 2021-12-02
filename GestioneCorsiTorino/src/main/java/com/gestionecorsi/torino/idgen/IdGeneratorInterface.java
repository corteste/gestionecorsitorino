package com.gestionecorsi.torino.idgen;

import java.sql.SQLException;

public interface IdGeneratorInterface {
	public long getNextId() throws SQLException;

}
