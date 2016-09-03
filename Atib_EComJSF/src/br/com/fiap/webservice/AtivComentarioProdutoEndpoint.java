package br.com.fiap.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.fiap.AtivEComBeanRemote;
import br.com.fiap.entity.ComentarioProduto;

@WebService(serviceName="AtivComentarioProdutoEndpoint")
@Stateless
@Local(value=IAtivComentarioProdutoEndpoint.class)
public class AtivComentarioProdutoEndpoint implements IAtivComentarioProdutoEndpoint{

	@EJB
	AtivEComBeanRemote remote;
	
	@Override
	public List<ComentarioProduto> listarComentariosProduto() {
		List<ComentarioProduto> comentarios = new ArrayList<ComentarioProduto>();
		try{
			comentarios = remote.listarComentariosProduto();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return comentarios;
	}

	@Override
	public void inserirComentarioProduto(ComentarioProduto comentarioPrd) {
		try{
			remote.inserirComentarioProduto(comentarioPrd);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
