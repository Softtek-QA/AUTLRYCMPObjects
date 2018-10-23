package br.lry.components.va.cat006;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;

public class AUTBuscarCliente extends AUTVABaseComponent{

	
	
	/**
	 * Realizar a busca de cliente previamente cadastrado no sistema VA
	 * @param parametros - Número de documento identificador do cliente
	 * @return - Verdadeiro para a busca de clientes realizada
	 */
	public boolean autBuscarCliente(java.util.HashMap parametros) {
		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.IconeModoDePesquisa").click();
			
			if(parametros.get("AUT_NUMERO_DOCUMENTO").toString().length() >= 2) {
				AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.Passaporte").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.NumeroPassaporte").setFocus();
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.NumeroPassaporte").setText(parametros.get("AUT_NUMERO_DOCUMENTO").toString());		
				
			}
			else {
				AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ItemCPF_CNPJ").click();
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
				AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setText(parametros.get("AUT_NUMERO_DOCUMENTO").toString());
			}
			
		
			AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ClientePesquisado").click();
			return true;
		}
		catch(java.lang.Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
}
