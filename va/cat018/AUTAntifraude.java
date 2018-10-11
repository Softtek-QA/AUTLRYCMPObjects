package br.lry.components.va.cat018;

import com.borland.silktest.jtf.xbrowser.DomCheckBox;

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

	
}
