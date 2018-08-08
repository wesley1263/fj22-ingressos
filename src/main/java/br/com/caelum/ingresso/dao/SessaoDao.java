package br.com.caelum.ingresso.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Repository
public class SessaoDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Sessao sessao){
		manager.persist(sessao);
	}
	
	public List<Sessao> findAllBySala(Sala sala){
		
		Query q = manager.createQuery("select s from Sessao s where s.sala=:sala",Sessao.class);
		q.setParameter("sala", sala);
		
		return q.getResultList();
	}

	public List<Sessao> findAllByFilme(Filme filme) {
		Query q = manager.createQuery("select s from Sessao s where s.filme = :filme");
		q.setParameter("filme", filme);
		return q.getResultList();
	}

	public Sessao findOne(Integer id) {
		
		return manager.find(Sessao.class, id);
	}
	
	
}
