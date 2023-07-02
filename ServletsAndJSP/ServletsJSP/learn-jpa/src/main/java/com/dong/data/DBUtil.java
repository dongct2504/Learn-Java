package com.dong.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

	//	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("emailListPU");
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("emailListPU");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
