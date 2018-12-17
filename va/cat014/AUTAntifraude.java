package br.lry.components.va.cat014;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomLink;

import br.lry.components.AUTVABaseComponent;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class AUTAntifraude extends AUTVABaseComponent {
	
	


	/**
	 * Flegar a tag de ignorar análise Antifraude
	 * @return - Verdadeiro caso a opção de ignorar análise antifraude seja marcada
	 */
	public boolean autVAFlagIgnorarAntifraude() {
		try {
			AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.OpcaoAntiFraude").click();
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	

	/**
	 * Acessar o monitor liberação Antifraude - Aprovação
	 * @return  Verdadeiro para a aprovação antifraude
	 */
	public boolean autMonitorAntiFraudeAprovacao() {
		try { 
		AUT_AGENT_SILK4J.<DomLink>find("VA.LiberacaoPendentes.MenuAprovacaoAntifraude").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.AprovacaoAntifraude").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.Sim").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.Confirmar").click();
		
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * Acessar o monitor liberação Antifraude - Reprovação
	 * @return Verdadeiro para Reprovação antifraude
	 */
	public boolean autMonitorAntiFraudeReprovacao() {

		try {
			AUT_AGENT_SILK4J.<DomLink>find("VA.LiberacaoPendentes.MenuLiberacaoPendentes").click();
			AUT_AGENT_SILK4J.<DomLink>find("VA.LiberacaoPendentes.OpcaoAntiFraude").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.CampoPesquisaAnti").setText("");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.LiberacaoPendentes.CampoPesquisaAnti").setText("/n");
			AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.AprovacaoAntifraude").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.Sim").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA.LiberacaoPendentes.Confirmar").click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}

	}
}

	

