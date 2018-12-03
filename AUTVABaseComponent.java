/**
 * 
 */
package br.lry.components;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.va.AUTVALogin;
import br.lry.components.va.cat001.AUTConfirmacaoLogin;
import br.lry.components.va.cat001.AUTLoginBoitata;
import br.lry.components.va.cat002.AUTRecuperacao;
import br.lry.components.va.cat003.AUTItem;
import br.lry.components.va.cat005.AUTConversao;
import br.lry.components.va.cat006.AUTBuscarCliente;
import br.lry.components.va.cat006.AUTCadastroCliente;
import br.lry.components.va.cat007.AUTFluxoSaida;
import br.lry.components.va.cat009.AUTMeiosPagamento;
import br.lry.components.va.cat010.AUTDesconto;
import br.lry.components.va.cat011.AUTLogOffBoitata;
import br.lry.components.va.cat011.AUTLogOffVA;
import br.lry.components.va.cat014.AUTMenuLiberacaoPendente;
import br.lry.components.va.cat016.AUTFinalizarPedidoVA;
import br.lry.components.va.cat018.AUTSelecaoLojaBoitata;
import br.lry.components.va.cat018.AUTSelecaoLojaVA;
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
	
	public static AUTVALogin autVALogin;
	public static AUTBuscarCliente autBuscaCliente;
	public static AUTLoginBoitata autLoginBoitata;
	public static AUTConfirmacaoLogin autVAConfirmacaoLogin;
	public static AUTRecuperacao autRecuperacao;
	public static AUTItem autItem;
	public static AUTConversao autConversao;
	public static AUTFluxoSaida autFluxoSaida;
	public static AUTMeiosPagamento autMeiosPagamento;
	public static AUTSelecaoLojaVA autSelecaoLojaVA;
	public static AUTSelecaoLojaBoitata autSelecaoLojaBoitata;
	public static AUTLogOffVA autLogOffVA;
	public static AUTLogOffBoitata autLogOffBoitata;
	public static AUTFinalizarPedidoVA autLogFinalizarPedidoVA;
	public static AUTCadastroCliente autCadastroCliente;
	public static AUTMenuLiberacaoPendente autMenuLiberacao;
	public static AUTDesconto autDesconto;
	protected java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	
	
	
	public AUTVABaseComponent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean autLoginVA(Desktop agent, String user, String password) {
		try {
			
			autGetLogManager().logMensagem("AUT INFO: INICIANDO LOGIN : APLICACAO VA");
			autInsertScreenByScenario();
			agent.<DomTextField>find("VA.Login.Usuario").click();
			agent.<DomTextField>find("VA.Login.Usuario").setText(user);
			agent.<DomTextField>find("VA.Login.Senha").click();
			agent.<DomTextField>find("VA.Login.Senha").setText(password);
			agent.<DomButton>find("VA.Login.Avancar").click();
			autInsertScreenByScenario();
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
		
		AUT_USUARIO_LOGIN_DEFAULT = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN,"AUT_USER").toString();
		AUT_SENHA_LOGIN_DEFAULT = autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN,"AUT_PASSWORD").toString();
		AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
		autInsertScreenByScenario();
	}
	
	public void autLogin(String usuario, String senha) {
		autInsertScreenByScenario();
		AUTVAProjectFunctions.autLogin(this.AUT_AGENT_SILK4J, usuario.toString(), senha.toString());
		autInsertScreenByScenario();
	}
	
	public void autLogoutApplication() {
		AUT_AGENT_SILK4J.<DomElement>find("VA02.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
		
	}

	public void autLoginVA(String usuario,String senha) {

		autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_USER", usuario);
		autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_PASSWORD", senha);
		
		
		AUT_USUARIO_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_USER").toString();
		AUT_SENHA_LOGIN_DEFAULT = AUT_PARAMETROS_CONFIGURACAO.get("AUT_PASSWORD").toString();
		autInsertScreenByScenario();
		AUTVAProjectFunctions.autLoginVA(this.AUT_AGENT_SILK4J, AUT_USUARIO_LOGIN_DEFAULT, AUT_SENHA_LOGIN_DEFAULT);
		autInsertScreenByScenario();
	}
	

	public void autVALogOff() {
		AUT_AGENT_SILK4J.<DomElement>find("VA02.FinalizarAplicacao.Sair").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
	}

	
	
	/**
	 * 
	 * CAT001
	 * CMP00001 - Realizar login no VA
	 * @param parametro - Parametros de entreat do sistema
	 * @return
	 */
	public void CMP00001(java.util.HashMap<String, Object> parametros) {
		autInitConfigurationTelevendas();	
		autVALogin.autStartLoginVA(parametros);
	}
	

	public void autInitConfigurationTelevendas() {
		
		autVALogin = new AUTVALogin();
		autBuscaCliente = new AUTBuscarCliente();
		autLoginBoitata = new AUTLoginBoitata();
		autVAConfirmacaoLogin = new AUTConfirmacaoLogin();
		autRecuperacao = new AUTRecuperacao();
		autItem = new AUTItem();
		autConversao = new AUTConversao();
		autFluxoSaida = new AUTFluxoSaida();
		autMeiosPagamento = new AUTMeiosPagamento();
		autSelecaoLojaVA = new AUTSelecaoLojaVA();
		autSelecaoLojaBoitata = new AUTSelecaoLojaBoitata();
		autLogOffVA = new AUTLogOffVA(); 
		autLogFinalizarPedidoVA  = new AUTFinalizarPedidoVA();
		autLogOffBoitata = new AUTLogOffBoitata();
		autCadastroCliente = new AUTCadastroCliente();
		autMenuLiberacao = new AUTMenuLiberacaoPendente();
		autDesconto = new AUTDesconto();

	}
	
	/**
	 * 
	 * CAT001
	 * CMP00002 - Realizar login no Boitata
	 * @param parametro - Parametros de entreat do sistema
	 * @return
	 */
	public void CMP00002(java.util.HashMap<String, Object> parametros) {
		
		autInitConfigurationTelevendas();	
		autLoginBoitata.autStartLoginBoitata(parametros);
	}
	
	
	/**
	 * 
	 * CMP00003 - Recuperar Carrinho de Compra
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00007(HashMap<String, Object> parametros) {
		autRecuperacao.autRecuperarCarrinho();

	}
	
	
	
	/**
	 * 
	 * CMP00001 - Recuperar Pedido de Compra
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00005(HashMap<String, Object> parametros) {
		autRecuperacao.autRecuperarPedido(parametros);
	}
	
	
	/**
	 * 
	 * CMP00001 - Inserir item no carrinho de compra pelo Boitata
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00009(HashMap<String, Object> parametros) {
		autItem.autBoitataIncluirItemCarrinho(parametros);
	}
	
	
	/**
	 * 
	 * CMP00003 - Inserir item no carrinho de compra pelo VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00011(HashMap<String, Object> parametros) {
		autItem.autVAIncluirItemNoCarrinho(parametros);
	}
	
	/**
	 * 
	 * CMP00004 - Criar carrinho
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00008(HashMap<String, Object> parametros) {
		autRecuperacao.autCriarCarrinho();
	}
	
	
	
	/**
	 * 
	 * CMP00001 - Converter em Pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00012(HashMap<String, Object> parametros) {
		autConversao.autVAConvercaoParaPedido();
	}
	
	
	/**
	 * 
	 * CMP00001 - Busca de Cliente
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00014(HashMap<String, Object> parametros) {

		autBuscaCliente.autBuscarCliente(parametros);
	}
	
	
	/**
	 * 
	 * CMP00002 - Cadastro de cliente a partir da busca de clientes
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00015(HashMap<String, Object> parametros) {

		autCadastroCliente.autCadastrarCliente(parametros);
	}
	
	
	/**
	 * 
	 * CMP00001 - Fluxo de Saida
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00016(HashMap<String, Object> parametros) {
		autFluxoSaida.autSelecaoFluxoSaida(parametros);
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
	public <TOutput extends AUTMeiosPagamento> TOutput CMP00020(HashMap<String, Object> parametros) {
		return (TOutput) autMeiosPagamento;
	}
		
	
	/**
	 * 
	 * CMP00001 - Realizar logOff VA
	 * @return
	 */	
	public void CMP00022() {
		autLogOffVA.autRealizarLogOff();
	}
	
	
	/**
	 * 
	 * CMP00001 - Realizar logOff Boitata
	 * @return
	 */	
	public void CMP00023() {
		autLogOffBoitata.autRealizarLogOff();
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
	 * CMP00001 - Finalizar compra no sistema Boitatá
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public <TOutput extends AUTFinalizarPedidoVA> TOutput CMP00034(HashMap<String, Object> parametros) {
		autLogFinalizarPedidoVA.autFinalizarPedidoVA(parametros);
		return (TOutput) autLogFinalizarPedidoVA;
	}
	
	
	
	/**
	 * 
	 * CMP00001 - Seleção de loja Televendas VA
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00036(HashMap<String, Object> parametros) {
		autSelecaoLojaVA.autSelecaoDeLoja(parametros);
	}
	
	
	/**
	 * 
	 * CMP00001 - Seleção de loja Televendas Boitata
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00037(HashMap<String, Object> parametros) {
		autSelecaoLojaBoitata.autSelecaoDeLoja(parametros);
	}
	
	
	/**
	 * 
	 * CMP00004 - Confirmação de Login
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */	
	public void CMP00004(HashMap<String, Object> parametros) {
		autVAConfirmacaoLogin.autConfirmacaoLogin(parametros);
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
	
	/**
	 * 
	 * CMP00001 - reprovação antifraude
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00043(HashMap<String, Object> parametros) {
		autMenuLiberacao.autMonitorAntiFraudeReprovacao(parametros);
	}
	
	/**
	 * 
	 * CMP00002 - aprovação comercial
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00040(HashMap<String, Object> parametros) {
		autMenuLiberacao.monitorAprovacaoComercialAprovar(parametros);
	}
	
	
	/**
	 * 
	 * CMP00001 - Desconto no pedido
	 * 
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00013(HashMap<String, Object> parametros) {
		autDesconto.autDesconto(parametros);
	}
	
	
}
