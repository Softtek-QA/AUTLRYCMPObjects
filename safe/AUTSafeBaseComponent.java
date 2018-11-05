/**
 * 
 */
package br.lry.components.safe;

import br.lry.components.AUTBaseComponent;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
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
		FISICA2,
		JURIDICA,
		JURIDICA2,
		ESTRANGEIRO,
		RNE,
		PASSAPORTE;		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case JURIDICA2:{
				return "Jurídica";
			}
			case ESTRANGEIRO:{
				return "Estrangeiro";
			}
			case FISICA:{
				return "Físico";
			}
			case FISICA2:{
				return "Física";
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

	public static enum AUT_SAFE_PROFISSOES{
		ARQUITETO,
		DECORADOR,
		ENGENHEIRO;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ARQUITETO:{
				return "2 - ARQUITETO";
			}
			case DECORADOR:{
				return "3 - DECORADOR";
			}
			case ENGENHEIRO:{
				return "1 - ENGENHEIRO";
			}
			default:{
				return this.name();
			}
			}
		}
	}
	
	public static enum AUT_SAFE_TIPO_CONVENIO{
		ACORDO_EXTRAJUDICIAL,
		CHEQUE_PRESENTE,
		CLIENTE_EM_CONTA,
		CLUBE_DO_ESPECIALISTA,
		COLABORADOR,
		CONSTRUTORA,
		GIFT_CARD,
		REEMISSAO_VOUCHER_EXPIRADO,
		SAFE_E_S,
		SALDAO_SOLIDARIO,
		VALE_GEMCO_EXPIRADO;
		
		@Override
		public String toString() {
			switch(this) {
			case ACORDO_EXTRAJUDICIAL:{
				return "ACORDO EXTRAJUDICIAL";
			}
			case CHEQUE_PRESENTE:{
				return "CHEQUE PRESENTE";
			}
			case CLIENTE_EM_CONTA:{
				return "CLIENTE EM CONTA";
			}
			case CLUBE_DO_ESPECIALISTA:{
				return "CLUBE DO ESPECIALISTA";
			}
			case COLABORADOR:{
				return "COLABORADOR";
			}
			case CONSTRUTORA:{
				return "CONSTRUTORA";
			}
			case GIFT_CARD:{
				return "GIFT CARD";
			}
			case REEMISSAO_VOUCHER_EXPIRADO:{
				return "REEMISSAO VOUCHER EXPIRADO";
			}
			case SAFE_E_S:{
				return "SAFE E/S";
			}
			case SALDAO_SOLIDARIO:{
				return "SALDAO SOLIDARIO";
			}
			case VALE_GEMCO_EXPIRADO:{
				return "VALE GEMCO EXPIRADO";
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
		AUT_AGENT_SILK4J.<BrowserApplication>find("SAFE").maximize();
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Usuario").setText(usuario);
		AUT_AGENT_SILK4J.<DomTextField>find("SAFE.Login.Senha").setText(senha);
		AUT_AGENT_SILK4J.<DomButton>find("SAFE.Login.BotaoEntrar").click();
		//end recording
	}
}
