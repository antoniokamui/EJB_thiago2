package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.entity.ComentarioProduto;
import br.com.fiap.webservice.AtivComentarioProdutoEndpoint;
import br.com.fiap.webservice.IAtivComentarioProdutoEndpoint;

@ManagedBean
@RequestScoped
public class ComentarioProdutoMB {
	

	private ComentarioProduto comentarioProduto;
	private List<ComentarioProduto> listaComentariosProduto = new ArrayList<ComentarioProduto>();
	
	public ComentarioProdutoMB() {
		setComentarioProduto(new ComentarioProduto());
		setListaComentariosProduto(new ArrayList<ComentarioProduto>());
		
	}
	
	@PostConstruct
	public void listar(){
		listaComentariosProduto = new AtivComentarioProdutoEndpoint().listarComentariosProduto();
	}
	
	public void inserir(){
		new AtivComentarioProdutoEndpoint().inserirComentarioProduto(comentarioProduto);
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
