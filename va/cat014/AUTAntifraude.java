package br.lry.components.va.cat014;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomLink;

import br.lry.components.AUTVABaseComponent;

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
	 * Acessa o monitor liberação Antifraude - Aprovação
	 * @return  true liberção
	 */
	public boolean monitorAntiFraudeAprovacao() {

		try { 
		AUT_AGENT_SILK4J.<DomLink>find("VA02.LiberacaoPendentes.MenuAprovacaoAntifraude").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.AprovacaoAntifraude").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.Sim").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.Confirmar").click();
		
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Acessa o monitor liberação Antifraude - Reprovação
	 * @return true Reprovação
	 */
	public boolean monitorAntiFraudeReprovacao() {

		try { 
			AUT_AGENT_SILK4J.<DomLink>find("VA02.LiberacaoPendentes.MenuAprovacaoAntifraude").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.Reprovar").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.Sim").click();
			AUT_AGENT_SILK4J.<DomButton>find("VA02.LiberacaoPendentes.Confirmar").click();	
		
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

	

