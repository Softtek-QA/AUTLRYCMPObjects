package br.lry.components.va.cat011;

import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;

import br.lry.components.AUTVABaseComponent;

public class AUTLogOffBoitata extends AUTVABaseComponent {
	
	/**
	 * Realiza LogOff no sistema Boitata
	 * @return - Verdadeiro para LogOff realizado
	 */
	public boolean autRealizarLogOff() {
		try {
			
			AUT_AGENT_SILK4J.<DomElement>find("Boitata.MenuLogOff.BotaoUsuario").click();
			AUT_AGENT_SILK4J.<DomElement>find("Boitata.MenuLogOff.Sair").click();
			AUT_AGENT_SILK4J.<AccessibleControl>find("Boitata.Fechar").click();
			return true;
		}
		catch(java.lang.Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}

}
