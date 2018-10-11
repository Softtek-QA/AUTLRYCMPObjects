package br.lry.components.va.cat018;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;

public class AUTTrocarLoja extends AUTVABaseComponent {
	/**
	 * Realizar troca de loja para usuários Televendas
	 * @param <AUT_VA_SELECAO_LOJA>
	 * 
	 * @param usuario - Usuário Televendas
	 * @param senha - Senha para acesso ao sistema VA
	 * @param lojaSelecionada - Loja selecionada
	 */
	

	public  boolean autTrocaDeLoja(String usuario, String senha, AUT_VA_SELECAO_LOJA lojaSelecionada) {
		
		try {
			autLoginVATelevendas(usuario, senha);
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoLoja").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.Televendas.SelecionarLoja").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.Televendas.CampoSelecaoLoja").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Televendas.CampoSelecaoLoja").typeKeys(lojaSelecionada.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Televendas.CampoSelecaoLoja").typeKeys("\n");
			AUT_AGENT_SILK4J.<DomButton>find("VA.Televendas.BotaoEscolher").click();
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
