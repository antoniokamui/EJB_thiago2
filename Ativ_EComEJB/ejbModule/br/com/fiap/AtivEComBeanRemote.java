package br.com.fiap;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.entity.ComentarioProduto;
@Remote
public interface AtivEComBeanRemote {
	
	List<ComentarioProduto> listarComentariosProduto();
	
	void inserirComentarioProduto(ComentarioProduto comentarioProduto);

}
