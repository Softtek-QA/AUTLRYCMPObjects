/**
 * 
 */
package br.lry.components;


import com.borland.silktest.jtf.xbrowser.DomTextField;

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
	 * CMP00001 - CMP00004 - Realizar login com perfil Televenda
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public boolean CMP00004(java.util.HashMap<String, Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00003 - Recuperar Carrinho de Compra
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00009(java.util.HashMap<String,Object> parametro) {
		
		try {
			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00001 - Inserir item no carrinho de compra pelo VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00010(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00001 - Criar carrinho
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00013(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	
	/**
	 * 
	 * CMP00001 - Converter em Pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00014(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00001 - Busca de Cliente Pessoa Física
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00016(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00005 - Selecionar caixa
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00028(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00002 - Cartão de Credito
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00039(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
		
	
	
	/**
	 * 
	 * CMP000012 - Cartão de Credito e Voucher
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00049(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP000013 - Cartão de Credito e Vale Troca
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00050(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00001 - Pedido em edição
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00051(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00001 - Realizar logOff
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00052(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00003 - Busca de pedido para Aprovação Antifraude ou Desconto
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00065(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	/**
	 * 
	 * CMP00001 - Seleção de loja Televendas
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00072(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00002 - Confirmação de Login
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00073(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}
	
	
	/**
	 * 
	 * CMP00003 - Ignorar Antifraude
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public boolean CMP00074(java.util.HashMap<String,Object> parametro) {
		
		try {

			return true;
		}
		
		catch(java.lang.Exception e) {

			return false;
		}

	}

}
