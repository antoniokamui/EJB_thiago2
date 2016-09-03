package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.entity.ComentarioProduto;
import br.com.fiap.webservice.IAtivComentarioProdutoEndpoint;

@ManagedBean
@RequestScoped
public class ComentarioProdutoMB {
	
	@EJB
	IAtivComentarioProdutoEndpoint endpoint;

	private ComentarioProduto comentarioProduto;
	private List<ComentarioProduto> listaComentariosProduto = new ArrayList<ComentarioProduto>();
	
	public ComentarioProdutoMB() {
		setComentarioProduto(new ComentarioProduto());
		setListaComentariosProduto(new ArrayList<ComentarioProduto>());
		
	}
	
	@PostConstruct
	public void listar(){
		setListaComentariosProduto(endpoint.listarComentariosProduto());
	}
	
	public void inserir(){
		endpoint.inserirComentarioProduto(getComentarioProduto());
		listar();
	}

	public List<ComentarioProduto> getListaComentariosProduto() {
		return listaComentariosProduto;
	}

	public void setListaComentariosProduto(List<ComentarioProduto> listaComentariosProduto) {
		this.listaComentariosProduto = listaComentariosProduto;
	}

	public ComentarioProduto getComentarioProduto() {
		return comentarioProduto;
	}

	public void setComentarioProduto(ComentarioProduto comentarioProduto) {
		this.comentarioProduto = comentarioProduto;
	}




}
