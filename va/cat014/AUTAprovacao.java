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
			AUT_AGENT_SILK4J.<DomLink>find("VA02.LiberacaoPendentes.MenuLiberacaoPendentes").click();
			AUT_AGENT_SILK4J.<DomLink>find("VA02.LiberacaoPendentes.OpcaoDesconto").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.LiberacaoPendentes.CampoPesquisaDesconto").setText("");
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.LiberacaoPendentes.CampoPesquisaDesconto").setText("/n");
			//pesquisar pra ver se esse botão AprovacaoAntiFraude também é valido 
			AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.AprovacaoAntifraude").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.Sim").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.Confirmar").click();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
