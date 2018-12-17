package br.lry.components.va.cat014;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;

public class AUTAprovacao extends AUTVABaseComponent{

	/**
	 * Acessa o monitor liberação Antifraude - Reprovação
	 * @return true Reprovação
	 */
	public boolean monitorAprovacaoComercial() {

		try {
			AUT_AGENT_SILK4J.<DomLink>find("VA.LiberacaoPendentes.MenuLiberacaoPendentes").click();
			AUT_AGENT_SILK4J.<DomLink>find("VA.LiberacaoPendentes.OpcaoDesconto").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.CampoPesquisaDesconto").setText("");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.CampoPesquisaDesconto").setText("/n");
			//pesquisar pra ver se esse botão AprovacaoAntiFraude também é valido 
			AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.AprovacaoAntifraude").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.Sim").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.Confirmar").click();

			
			
			
			
			
			
			
			
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
