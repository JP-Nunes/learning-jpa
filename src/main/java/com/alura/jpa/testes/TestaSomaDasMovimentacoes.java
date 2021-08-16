package com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alura.jpa.dao.MovimentacaoDAO;

public class TestaSomaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = managerFactory.createEntityManager();
		
		BigDecimal soma = new MovimentacaoDAO(manager).getSomaDasMovimentacoes();
		
		System.out.println("A soma das movimentações é: " + soma);	
	}
}
