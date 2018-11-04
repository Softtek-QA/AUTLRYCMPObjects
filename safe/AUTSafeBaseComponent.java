/**
 * 
 */
package br.lry.components.safe;

import br.lry.components.AUTBaseComponent;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;

/**
 * Gerencia componentes e funções reutilizaveis para o safe
 * 
 * @author Softtek-QA
 *
 */
public class AUTSafeBaseComponent extends AUTBaseComponent {
	public static enum AUT_SAFE_TYPE_PERSONS{
		FISICA,
		JURIDICA,
		ESTRANGEIRO,
		RNE,
		PASSAPORTE;		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ESTRANGEIRO:{
				return "Estrangeiro";
			}
			case FISICA:{
				return "Físico";
			}
			case  JURIDICA:{
				return "Jurídico";
			}
			case PASSAPORTE:{
				return "Passaporte";
			}
			case RNE:{				
				return "RNE";
			}
			default:{
				return this.name();
			}
			}
		}
	}

	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeBaseComponent() {
		// TODO Auto-generated constructor stub
	}

	public void autLogin(String usuario, String senha) {
		autInitWebApplication();
		//start recording 
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Usuario").setText(usuario);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Senha").setText(senha);
		AUT_AGENT_SILK4J.<DomButton>find("SAFE.Login.BotaoEntrar").click();
		//end recording
	}
}
