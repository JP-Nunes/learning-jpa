package com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.alura.jpa.modelo.MediaComData;

public class MovimentacaoDAO {
	
	private EntityManager manager;
	
	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public List<MediaComData> getMediaDiariaDasMovimentacoes() {		
		String jpql = 
				"select new com.alura.jpa.modelo.MediaComData(avg(m.valor), day(m.data), month(m.data)) "
				+ "from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<MediaComData> query = manager.createQuery(jpql, MediaComData.class);
		return query.getResultList();
	}
	
	public BigDecimal getSomaDasMovimentacoes() {		
		String jpql = "select sum(m.valor) from Movimentacao m";
		
		TypedQuery<BigDecimal> query = manager.createQuery(jpql, BigDecimal.class);
		return query.getSingleResult();
	}
}
