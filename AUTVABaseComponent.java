/**
 * 
 */
package br.lry.components;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.va.cat007.AUTFluxoSaida;
import br.lry.components.va.cat007.AUTFluxoSaida.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.cat018.AUTAntifraude;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTVAProjectFunctions;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem.AUT_TIPO_MSG_LOG;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;

/**
 * 
 * 
 * 
 * @author Softtek-QA
 *
 */
public class AUTVABaseComponent extends AUTBaseComponent {
	public String AUT_USUARIO_LOGIN_DEFAULT = "";
	public String AUT_SENHA_LOGIN_DEFAULT = "";
	
	
	AUTAntifraude cat018 = new AUTAntifraude();
	AUTFluxoSaida cat007 = new AUTFluxoSaida();
	
	
	java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	
	
	public AUTVABaseComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean autLoginVA(Desktop agent, String user, String password) {
		try {
			
			autGetLogManager().logMensagem("AUT INFO: INICIANDO LOGIN : APLICACAO VA");
			
			agent.<DomTextField>find("VA.Login.Usuario").click();
			agent.<DomTextField>find("VA.Login.Usuario").setText(user);
			agent.<DomTextField>find("VA.Login.Senha").click();
			agent.<DomTextField>find("VA.Login.Senha").setText(password);
			agent.<DomButton>find("VA.Login.Avancar").click();
			
			autGetLogManager().logMensagem("AUT INFO: LOGIN REALIZADO COM SUCESSO");
			return true;
		} catch (java.lang.Exception e) {
			
			autGetLogManager().logMensagem(AUT_TIPO_MSG_LOG.MENSAGEM_INFORMATIVA,
					"AUT ERROR: LOGIN : APLICACAO VA");

			System.out.println(e.getMessage());
			e.printStackTrace();
			
			return false;
		}
	}
	/**
	 * 
	 * Realiza login na aplicação - VA
	 *
	 */
	
	public void autLogin() {
		
		AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
		AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
		
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
	}
	
	public void autLoginVA() {
		
		AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
		AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
		
		AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
	}
	
	public void autLoginVATelevendas() {
		
		AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER_TELEVENDAS").toString();
		AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
		
		AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
	}
	
	public void autLogin(String usuario, String senha) {
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, usuario.toString(), senha.toString());
	}
	
	public void autLogoutApplication() {
		AUT_AGENT_SILK4J.<DomElement>find("VA02.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
	}
	

	
	/**
	 * 
	 * 
	 * CMP00001 - Realizar login no VA
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00001(HashMap<String, Object> parametros) {
		


	}
	
	
	/**
	 * 
	 * CMP00003 - Recuperar Carrinho de Compra
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00007(HashMap<String, Object> parametros) {
		

	}
	
	
	/**
	 * 
	 * CMP00001 - Inserir item no carrinho de compra pelo VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00009(HashMap<String, Object> parametros) {


	}
	
	
	/**
	 * 
	 * CMP00004 - Criar carrinho
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00008(HashMap<String, Object> parametros) {
		

	}
	
	
	
	/**
	 * 
	 * CMP00001 - Converter em Pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00012(HashMap<String, Object> parametros) {
		

	}
	
	
	/**
	 * 
	 * CMP00001 - Busca
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00014(HashMap<String, Object> parametros) {


	}
	
	
	/**
	 * 
	 * CMP00001 - Fluxo de Saida
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00016(HashMap<String, Object> parametros) {
		


	}
	
	
	/**
	 * 
	 * CMP00002 - Cartão de Credito
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00039(HashMap<String, Object> parametros) {
		


	}
		
		
	
	/**
	 * 
	 * CMP00001 - Pagamento - VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00020(HashMap<String, Object> parametros) {
		


	}
	
	
	/**
	 * 
	 * CMP00001 - Realizar logOff
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00022(HashMap<String, Object> parametros) {
		


	}
	
	
	/**
	 * 
	 * CMP00003 - Busca de pedido para Aprovação Antifraude ou Desconto
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00027(HashMap<String, Object> parametros) {
		


	}
	
	/**
	 * 
	 * CMP00001 - Seleção de loja Televendas
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00036(HashMap<String, Object> parametros) {
		


	}
	
	
	/**
	 * 
	 * CMP00004 - Confirmação de Login
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00004(HashMap<String, Object> parametros) {
		


	}
	
	
	/**
	 * 
	 * CMP00003 - Flag Ignorar Antifraude
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00030(HashMap<String, Object> parametros) {
		

	}
	

}
