package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.AtivEComBeanRemote;
import br.com.fiap.entity.ComentarioProduto;



@Stateless
public class AtivEComBean implements AtivEComBeanRemote {

	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;
	
    public AtivEComBean() {
       
    }

	@Override
	public List<ComentarioProduto> listarComentariosProduto() {
		TypedQuery<ComentarioProduto> query = em.createQuery("From ComentarioProduto",ComentarioProduto.class);
		List<ComentarioProduto> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void inserirComentarioProduto(ComentarioProduto comentarioProd) {
		em.persist(comentarioProd);
		
	}
    
	
	@Schedule(second="*/5",minute="*",hour="*",month="*",year="*")
	public void init(){
		System.out.println(listarComentariosProduto().size());
	}
    

}
