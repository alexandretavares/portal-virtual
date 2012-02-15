package br.ueg.portalVirtual.sets;

import java.util.ResourceBundle;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Connect extends DriverManagerDataSource {

	private ResourceBundle jdbc;

	public Connect() {
		jdbc = ResourceBundle.getBundle("br/ueg/portalVirtual/bundle/jdbc");

		this.setDriverClassName(jdbc.getString("driverClassName"));
		this.setUrl(jdbc.getString("url"));
		this.setUsername(jdbc.getString("username"));
		this.setPassword(jdbc.getString("password"));
	}

}
