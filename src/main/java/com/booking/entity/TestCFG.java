package com.booking.entity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCFG {
	public static void main(String[] args) {
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("doc");
		System.out.println(fac);
	}
}
