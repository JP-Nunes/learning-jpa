package com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alura.jpa.dao.MovimentacaoDAO;
import com.alura.jpa.modelo.MediaComData;

public class TestaMediaDiariaProjecao {

	public static void main(String[] args) {
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager manager = managerFactory.createEntityManager();
		
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDAO(manager).getMediaDiariaDasMovimentacoes();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println(
					"A média das movimentações do dia " 
					+ resultado.getDia() + "/" + resultado.getMes() + " é: " + resultado.getMedia());
		}		
	}
}
