package com.mudra.mboss.master.services.client;

import java.sql.Connection;

public interface ConnectionProvider {

	public Connection getConnection();

}
