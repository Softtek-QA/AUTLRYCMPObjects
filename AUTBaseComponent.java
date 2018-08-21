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
public abstract class AUTBaseComponent{
	protected Desktop AUT_AGENT_SILK4J = new Desktop();  //Objeto de conexão com aplicação da automação
	protected BrowserBaseState AUT_BASE_STATE_CONFIGURATION_BROWSER = null; //Objeto base de configuraçao do browser
	private AUTDataFlow AUT_CURRENT_DATA_FLOW = null; //Objeto de gerenciamento do fluxo de dados
	private AUTLogMensagem AUT_CURRENT_LOG_MANAGER = null; //Objeto de gerenciamento do log

	
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
	@Before
	public void autInitWebApplication() {
		
		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState();		
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);
		AUT_AGENT_SILK4J.<AccessibleControl>find("WebBrowser.Maximizar").click();
		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");
		
	}
	
	
	/**
	 * 
	 * Finaliza a aplicação utilizada na automação
	 * 
	 */
	@After
	public void autCloseApplication() {
		System.out.println("AUT INFO: FINALIZANDO APLICAÇÃO");			
	}
	
	/**
	 * 
	 * Construtor padrão da classe
	 * 
	 */
	public AUTBaseComponent() {
		super();
	}
}
