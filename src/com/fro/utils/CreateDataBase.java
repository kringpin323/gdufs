package com.fro.utils;

import java.io.File;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateDataBase {

	
	public static void main(String[] args) {

		 Configuration	config = new Configuration().configure(new File("hibernate.cfg.xml"));
		System.out.println("Creating tables...");
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.create(true, true);
		
		
	}
}
