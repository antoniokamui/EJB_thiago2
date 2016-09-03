package br.com.fiap.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.naming.InitialContext;

import br.com.fiap.AtivEComBeanRemote;
import br.com.fiap.entity.ComentarioProduto;

@WebService(serviceName="AtivComentarioProdutoEndpoint")
public class AtivComentarioProdutoEndpoint implements IAtivComentarioProdutoEndpoint{

	
	 
	
	@Override
	public List<ComentarioProduto> listarComentariosProduto() {
		List<ComentarioProduto> lista = new ArrayList<ComentarioProduto>();
		try{
			
				InitialContext ctx = new InitialContext();
				AtivEComBeanRemote remote = (AtivEComBeanRemote) ctx
				.lookup("ejb:/Ativ_EComJSF/AtivEComBean!br.com.fiap.AtivEComBeanRemote");

				lista  = remote.listarComentariosProduto();

				}catch(Exception e){

				e.printStackTrace();

				}
		
		
		return lista;
	}

	@Override
	public void inserirComentarioProduto(ComentarioProduto comentarioPrd) {
		
		try{

			InitialContext ctx = new InitialContext();
			AtivEComBeanRemote remote = (AtivEComBeanRemote) ctx
			.lookup("ejb:/Ativ_EComJSF/AtivEComBean!br.com.fiap.AtivEComBeanRemote");
			
			remote.inserirComentarioProduto(comentarioPrd);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	

	
	
}
