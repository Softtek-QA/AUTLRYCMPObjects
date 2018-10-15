package br.lry.components.va.cat010;

import com.borland.silktest.jtf.xbrowser.DomButton;

import br.lry.components.AUTVABaseComponent;

public class AUTEdicao extends AUTVABaseComponent{

	/**
	 * Clica no botão avançar para a proxima tela
	 * @return true caso clique no botão
	 */
	public boolean botãoAvancar() {
		try {
			AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
