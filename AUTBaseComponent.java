/**
 * 
 */
package br.lry.components;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.TestClass;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.BrowserType;
import com.borland.silktest.jtf.common.types.ItemIdentifier;
import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.microfocus.silktest.jtf.*;

import br.lry.dataflow.AUTDataFlow;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem;
import br.lry.functions.AUTProjectsFunctions.AUTLogMensagem.AUT_TIPO_MSG_LOG;
import br.stk.framework.db.management.AUTDBProcessDataFlow;
import br.stk.framework.tests.AUTFWKTestObjectBase;
import junit.framework.TestCase;
import junit.framework.TestResult;

/**
 * 
 * Componente - Realiza login no  sistema:
 * 
 * VA : Vendas assistidas
 * 
 * @author Softtek-QA
 *
 */
public abstract class AUTBaseComponent extends AUTFWKTestObjectBase{
	private AUTDataFlow AUT_CURRENT_DATA_FLOW = null; //Objeto de gerenciamento do fluxo de dados
	private AUTLogMensagem AUT_CURRENT_LOG_MANAGER = null; //Objeto de gerenciamento do log
	protected AUT_TABLE_PARAMETERS_NAMES AUT_CURRENT_PARAMETERS_TABLE_NAME = null;

	public String AUT_USUARIO_LOGIN_DEFAULT = "";
	public String AUT_SENHA_LOGIN_DEFAULT = "";
	protected java.util.HashMap<String,Object> AUT_PARAMETROS_CONFIGURACAO = this.autGetDataFlow().autGetParameter();	

	public static enum AUT_TEST_STATUS_EXECUCAO{
		WAIT,
		PASSED,
		FAILED,
		ERROR,
		EXECUTION;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ERROR:{
				return "ERRO";
			}
			case EXECUTION:{
				return "EXECUTANDO";
			}
			case FAILED:{
				return "FALHOU";
			}
			case PASSED:{
				return "PASSOU";
			}
			case WAIT:{
				return "AGUARDANDO";
			}
			}
			return super.toString();
		}
	}

	public static enum AUT_SYNC_EXECUTION_STATE{
		UPDATE_TABLE_PROJECT_DETAIL_WAIT,
		UPDATE_TABLE_PROJECT_DETAIL_PASSED,
		UPDATE_TABLE_PROJECT_DETAIL_EXECUTANDO,
		UPDATE_TABLE_PROJECT_DETAIL_ERRO,
		UPDATE_TABLE_PROJECT_DETAIL_FAILED,
		WAIT,
		PASSED,
		EXECUTION,
		ERROR,
		FAILED;

		@Override
		public String toString() {
			// TODO Auto-generated method stub

			switch(this) {
			case UPDATE_TABLE_PROJECT_DETAIL_PASSED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='PASSOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_FAILED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='FALHOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_ERRO:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='ERRO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_EXECUTANDO:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='EXECUTANDO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID IN(%s);";
			}
			case UPDATE_TABLE_PROJECT_DETAIL_WAIT:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='AGUARDANDO EXECUÇÃO' WHERE STD_ITEM_CONFIGURATION=?  AND PJT_ID IN(%s);";
			}
			case PASSED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='PASSOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case FAILED:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='FALHOU' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case ERROR:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='ERRO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case EXECUTION:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='EXECUTANDO' WHERE STD_ITEM_CONFIGURATION=? AND PJT_ID=?;";
			}
			case WAIT:{
				return "UPDATE LRY.aut_projects_status_details SET STD_DATE_CREATION=CURRENT_TIMESTAMP,std_status='AGUARDANDO EXECUÇÃO' WHERE STD_ITEM_CONFIGURATION=?  AND PJT_ID=?;";
			}
			}
			return super.toString();
		}
	}

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

	public boolean autSetCurrentDataFlowObject(AUTDataFlow newDataflow) {
		try {

			AUT_CURRENT_DATA_FLOW = autGetDataFlow().autCopyDataFlow(autGetDataFlow(), newDataflow);
			System.out.println("AUT : DATAFLOW : SET CURRENT OBJECT : OK");

			return true;
		}
		catch(java.lang.Exception e) {
			System.out.println("AUT : ERROR: DATAFLOW : SET CURRENT OBJECT");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
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

	public void autSetHostExecution(String host) {
		AUT_AGENT_SILK4J = new Desktop(host);
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



	public void selectValor (DomListBox listCombo) {

		String valor = null;
		int contador=0;

		List<ItemIdentifier> list = listCombo.getItems();

		for(ItemIdentifier item:listCombo.getItems()) {

			if (item.getText()  != null) {
				valor = item.getText();
				break;
			}
		}

		listCombo.select(valor);

	}


	public void selectValor (DomListBox listCombo, String criterioSelecao) {

		String valor = null;

		List<ItemIdentifier> list = listCombo.getItems();

		for(ItemIdentifier item : listCombo.getItems()) {
			System.out.println(item.getText());
			if(item.getText() != null && item.getText().trim() != "") {
				java.util.regex.Pattern padrao = java.util.regex.Pattern.compile(criterioSelecao);
				java.util.regex.Matcher analise = padrao.matcher(item.getText());

				if(analise.find()) {
					valor = item.getText();
					System.out.println(valor);
					listCombo.select(valor);
					break;			
				}
			}
		}
	}


	public Double autGetDiv(String valueInput) {
		String vlInput = valueInput;
		String[] vlParts = valueInput.trim().split(",");		
		Double dbValor = Double.parseDouble(vlParts[0]);
		Double result = dbValor / 2;

		System.out.println(valueInput);
		System.out.println(dbValor);
		System.out.println(vlParts[1]);
		System.out.println(result);
		System.out.println(result * 2);

		return result * 10000;
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
			AUTRuntimeExecutionScenario scn = autGetCurrentScenarioRuntime();	
			java.util.HashMap<Integer,java.util.HashMap<String,Object>> prmOut = null;					
			if(scn.AUT_SCENARIO_FULL_NAME!=null) {
				java.util.HashMap<String,Object> parameters = new java.util.HashMap<String,Object>();
				java.util.regex.Pattern regExp = java.util.regex.Pattern.compile("\\d+");
				java.util.regex.Matcher verif = regExp.matcher(scn.AUT_PROJECT_ID);
				if(verif.find()) {
					Integer id = Integer.parseInt(verif.group());
					AUTDBProcessDataFlow prc = autGetDataFlowDBIntegration();
					parameters.put("PROJECT_ID", id);
					parameters.put("PROCESS_NAME", scn.AUT_SCENARIO_FULL_NAME_RUNTIME);
					parameters.put("PROCESS_DESCRIPTION", scn.AUT_SCENARIO_FULL_NAME_RUNTIME.concat(" : ").concat(tableName.toString()));
					parameters.put("COLUMN_NAME_DATAFLOW", parameterName);
					if(prc.autSelectValuesByParameters(parameters).size() == 0) {		
						String colRow = "PARAMETER_ROW";
						java.util.HashMap<Integer,java.util.HashMap<String,Object>> prns = autGetDataFlow().autGetParametersAllLines(tableName);
						//Adiciona os parametros da tabela específicada no banco de dados
						for(Integer row : autGetDataFlow().autGetParametersAllLines(tableName).keySet()) {
							for(String colName : prns.get(row).keySet()) {
								parameters.put("PARAMETER_NAME", colName);
								parameters.put("PARAMETER_VALUE", prns.get(row).get(colName).toString());
								parameters.put("PARAMETER_ROW", colRow);
								prc.autDBAddParameter(parameters);
								parameters.remove("PARAMETER_NAME");
								parameters.remove("PARAMETER_VALUE");
								parameters.remove("PARAMETER_ROW");						
							}
						}
						//Carrega parametro do banco de dados
						prmOut = prc.autSelectValuesByParameters(parameters);		
						return new String((byte[])prmOut.get(0).get("DRV_PARAMETER_VALUE"));
					}
					else {
						//Carrega parametro do banco de dados
						prmOut = prc.autSelectValuesByParameters(parameters);					
						return new String((byte[])prmOut.get(0).get("DRV_PARAMETER_VALUE"));
					}
				}
				else {
					//Carrega parametro configurado localmente no dataflow
					return autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(tableName).get(1).get(parameterName);
				}
			}
			else {
				//Carrega parametro configurado localmente no dataflow
				return autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(tableName).get(1).get(parameterName);
			}
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: GET PARAMETER VALUE FROM CURRENT DATATABLE");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "";
		}
	}


	public boolean autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES tableName,String parameterName,Object value) {
		try {

			AUT_CURRENT_PARAMETERS_TABLE_NAME = tableName;

			AUTRuntimeExecutionScenario scn = autGetCurrentScenarioRuntime();
			if(scn.AUT_SCENARIO_FULL_NAME!=null) {
				java.util.regex.Pattern regExp = java.util.regex.Pattern.compile("\\d+");
				java.util.regex.Matcher verif = regExp.matcher(scn.AUT_PROJECT_ID);
				if(verif.find()) {
					Integer id = Integer.parseInt(verif.group());
					java.util.HashMap<String,Object> parameters = new java.util.HashMap<String,Object>();					
					parameters.put("PROJECT_ID", id);
					parameters.put("PROCESS_NAME", scn.AUT_SCENARIO_FULL_NAME_RUNTIME);
					parameters.put("COLUMN_NAME", br.stk.framework.db.management.AUTDBProcessDataFlow.AUT_SQL_PROPERTIES.DRV_PARAMETER_NAME);
					parameters.put("COLUMN_TARGET", parameterName);
					parameters.put("COLUMN_VALUE", value);
					
					
					autGetDataFlowDBIntegration().autUpdateParameters(parameters);					
				}			
			}
			return true;
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: SET PARAMETER VALUE FROM CURRENT DATATABLE");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
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
			return autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME, parameterName);			
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: GET PARAMETER VALUE FROM CURRENT DATATABLE");
			return null;
		}
	}

	public boolean autSetCurrentParameter(String parameterName,Object value) {
		try {
			if(AUT_CURRENT_PARAMETERS_TABLE_NAME!=null) {
				autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_CURRENT_PARAMETERS_TABLE_NAME.toString()).get(1).remove(parameterName);
				autGetDataFlow().AUT_GLOBAL_PARAMETERS.get(AUT_CURRENT_PARAMETERS_TABLE_NAME.toString()).get(1).put(parameterName, value);

				return true;
			}
			else {				
				autGetLogManager().logMensagem("AUT ERROR: SET PARAMETER VALUE: TABLE FROM DATA ORIGIN NOT DEFINE");

				return false;
			}
		}
		catch(java.lang.Exception e) {
			autGetLogManager().logMensagem("AUT ERROR: SET PARAMETER VALUE FROM CURRENT DATATABLE");
			return false;
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
		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("va.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);
		AUT_AGENT_SILK4J.<BrowserApplication>find("VA").maximize();
		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationBoitata() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("boitata.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);		
		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationHMC() {		
		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("hmc.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);

		try {
			//AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationSafe() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState("safe.settings");
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);

		try {
			//AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitWebApplicationVA() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState();		
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setBrowserType(BrowserType.GoogleChrome);
		AUT_BASE_STATE_CONFIGURATION_BROWSER.setCommandLineArguments("--incognito");

		AUT_BASE_STATE_CONFIGURATION_BROWSER.setUrl(autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_LOGIN, "AUT_URL_VA").toString());
		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);
		try {
			AUT_AGENT_SILK4J.<BrowserApplication>find("VA").maximize();
			//AUT_AGENT_SILK4J.<AccessibleControl>find("VA.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		System.out.println("AUT INFO: INICIALIZANDO APLICAÇÃO WEB");

	}

	public void autInitHmcApplication() {

		AUT_BASE_STATE_CONFIGURATION_BROWSER = new BrowserBaseState();

		AUT_BASE_STATE_CONFIGURATION_BROWSER.setUrl(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_URL").toString());

		AUT_AGENT_SILK4J.executeBaseState(AUT_BASE_STATE_CONFIGURATION_BROWSER);

		try{
			AUT_AGENT_SILK4J.<AccessibleControl>find("HMC.Maximizar").click();
		}
		catch(java.lang.Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}




	/**
	 * 
	 * Finaliza a aplicação utilizada na automação
	 * 
	 */
	public void autCloseApplication() {

		System.out.println("AUT INFO: FINALIZANDO APLICAÇÃO");	
		AUT_AGENT_SILK4J.<BrowserApplication>find("VA").close();

	}

	public AUTBaseComponent() {
		super();
		autGetDataFlow().autInitDataFlow();
	}

	public AUTBaseComponent(boolean syncronizeDataFlow) {
		super();
	}

}
