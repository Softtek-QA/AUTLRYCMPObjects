/**
 * 
 */
package br.lry.components;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.BrowserType;
import com.borland.silktest.jtf.win32.AccessibleControl;
import com.microfocus.silktest.jtf.*;

import br.lry.dataflow.AUTDataFlow;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem.AUT_TIPO_MSG_LOG;
import junit.framework.TestCase;
import junit.framework.TestResult;

/**
 * 
 * Componente - Realiza login no sistema:
 * 
 * VA : Vendas assistidas
 * 
 * @author Softtek-QA
 *
 */
public abstract class AUTBaseComponent extends junit.framework.TestSuite implements junit.framework.Test{
	protected Desktop AUT_AGENT_SILK4J = new Desktop();  //Objeto de conexão com aplicação da automação
	protected BrowserBaseState AUT_BASE_STATE_CONFIGURATION_BROWSER = null; //Objeto base de configuraçao do browser
	private AUTDataFlow AUT_CURRENT_DATA_FLOW = null; //Objeto de gerenciamento do fluxo de dados
	private AUTLogMensagem AUT_CURRENT_LOG_MANAGER = null; //Objeto de gerenciamento do log
	protected AUT_TABLE_PARAMETERS_NAMES AUT_CURRENT_PARAMETERS_TABLE_NAME = null;

	public void autSetMicrosoftEdgeBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.Edge);		
	}	

	public void autSetInternetExplorerBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.InternetExplorer);
	}

	public void autSetFirefoxBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.Firefox);
	}

	public void autSetChromeBrowser() {
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
	}

	/**
	 * 
	 * Retorna a instancia de gerenciamento de logs sistema
	 * 
	 * @return AUTLogMensagem - Classe de gerenciamento de Log
	 * 
	 */
	public AUTLogMensagem autGetLogManager()
	{
		try {
		
			System.out.println("AUT INFO: INICIALIZANDO SERVIÇO PARA GERENCIAMENTO DE LOGS DO SISTEMA");

			AUT_CURRENT_LOG_MANAGER = ( AUT_CURRENT_LOG_MANAGER!=null ? AUT_CURRENT_LOG_MANAGER : new AUTLogMensagem());

			return AUT_CURRENT_LOG_MANAGER;
		}
		catch(java.lang.Exception e) {

			System.out.println("AUT ERROR : ERROR INICIALIZAR SERVIÇO DE LOG");

			return null;
		}

	}	


	/**
	 * 
	 * Configura ou retorna a instância ativa da classe de gerenciamento do fluxo de dados da automação
	 * 
	 * @return boolean - True caso o processo seja finalizado com sucesso false caso contrário
	 * 
	 */
	public AUTDataFlow autGetDataFlow() {
		try {

			autGetLogManager().logMensagem("AUT INFO: INICIALIZANDO CONFIGURAÇAO DO FLUXO DE DADOS");

			AUT_CURRENT_DATA_FLOW = (AUT_CURRENT_DATA_FLOW != null ? AUT_CURRENT_DATA_FLOW :  new AUTDataFlow());

			autGetLogManager().logMensagem("AUT INFO: CONFIGURAÇAO DO FLUXO DE DADOS : FINALIZADA");

			return AUT_CURRENT_DATA_FLOW;
		}
		catch(java.lang.Exception e) {

			autGetLogManager().logMensagem("AUT ERROR: INICIALIZAÇÃO DA CLASSE DE GERENCIAMENTO FLUXO DE DADOS");

			return null;
		}
	}

	/**
	 * 
	 * Recupera o valor do parametro especificado na fonte de dados corrente
	 * 
	 * @param parameterName - Nome do parametro
	 * 
	 * @return Object - Valor do parametro
	 */
	public Object autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName) {
		try {

			AUT_CURRENT_PARAMETERS_TABLE_NAME = tableName;

			return autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_CURRENT_PARAMETERS_TABLE_NAME.toString()).get(1).get(parameterName);
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: GET PARAMETER VALUE FROM CURRENT DATATABLE");

			return null;
		}
	}

	/**
	 * 
	 * Retorna o valor do parametro especificado na tabela de parametros atualmente selecionada
	 * 
	 * @param parameterName - Nome do parametro
	 * 
	 * @return Object - Valor do objeto
	 * 
	 */
	public Object autGetCurrentParameter(String parameterName) {
		try {
			if(AUT_CURRENT_PARAMETERS_TABLE_NAME!=null) {
				return autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_CURRENT_PARAMETERS_TABLE_NAME.toString()).get(1).get(parameterName);
			}
			else {
				
				autGetLogManager().logMensagem("AUT ERROR: GET PARAMETER VALUE: TABLE FROM DATA ORIGIN NOT DEFINE");
				
				return null;
			}
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: GET PARAMETER VALUE FROM CURRENT DATATABLE");

			return null;
		}
	}

	public junit.framework.TestCase autStartNewTestObject(Class<?> testObject,String testName){
		try {

			junit.framework.TestCase testItem = (TestCase) org.junit.runners.AllTests.testFromSuiteMethod(testObject);
			testItem.setName(testName);
			junit.textui.TestRunner.run(testItem);
			return testItem;

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			autGetLogManager().logMensagem("AUT ERROR: TEST OBJECT DEFINITION : ".concat(e.getMessage()));

			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * Inicializa aplicação da aplicaçao VA
	 * 
	 */
	public void autInitWebApplication() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState();		
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);
		try {
			AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}


	/**
	 * 
	 * Finaliza a aplicação utilizada na automação
	 * 
	 */
	public void autCloseApplication() {
		System.out.println("AUT INFO: FINALIZANDO APLICAÇÃO");			
	}
}
