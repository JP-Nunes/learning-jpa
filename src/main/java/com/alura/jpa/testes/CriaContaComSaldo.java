package com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = factory.createEntityManager();
		
		Conta contaDoJoao = entityManager.find(Conta.class, 1L);
		
		entityManager.getTransaction().begin();
		contaDoJoao.setSaldo(800.0);
		entityManager.getTransaction().commit();
	}

}
