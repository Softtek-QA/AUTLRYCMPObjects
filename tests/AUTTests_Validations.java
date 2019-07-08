package br.lry.components.tests;

import br.lry.qa.alm.AUTALMBaseServices;
import br.lry.qa.alm.webservices.scm.AUTALMManage.AUT_ALM_PROJECTS;
import br.lry.qa.alm.webservices.scm.AUTALMManage.AUT_ALM_TESTS_TYPES;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega001_RGR001_OLD;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega001_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega001_RGR003;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega002_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega002_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega002_RGR003;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega003_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega003_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega003_RGR003;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega004_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega004_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega004_RGR003;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega005_RGR003;
import br.lry.qa.rsp.pjttrc.entregas.*;

public class AUTTests_Validations {

	public AUTTests_Validations() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		br.lry.qa.alm.AUTALMBaseServices alm = new AUTALMBaseServices();
		java.util.HashMap<String, Object> parametersConfig = new java.util.HashMap<String,Object>();
		parametersConfig.put("AUT_SERVER_ALM", "192.168.0.101:19120");
		parametersConfig.put("AUT_USER_ALM", "admin");
		parametersConfig.put("AUT_PWD_ALM", "admin");
		parametersConfig.put("AUT_URL_WEBSERVICE_ALM", String.format("http://%s/Services1.0/jaxws/tests?wsdl",parametersConfig.get("AUT_SERVER_ALM").toString()));
		parametersConfig.put("AUT_PROJECT_ALM", AUT_ALM_PROJECTS.VA_VENDAS_ASSISTIDAS);
		parametersConfig.put("AUT_PROJECT_CONTAINER", AUT_ALM_PROJECTS.VA_CONTAINER_VENDAS_ASSISTIDAS);		
		parametersConfig.put("AUT_NOME_CTP", "CT0001 - TESTE DE AMBIENTE");
		parametersConfig.put("AUT_DESCRICAO_CTP", "DESCRICAO DO CASO DE TESTES");
		parametersConfig.put("AUT_TIPO_TESTE", AUT_ALM_TESTS_TYPES.SILK4J);		
		parametersConfig.put("AUT_PASSOS_CTP", new br.lry.qa.alm.webservices.scm.tests.ManualTestStep[] {});
		parametersConfig.put("AUT_PARAMETROS_CTP", new br.lry.qa.alm.webservices.scm.tests.NodeParameter[] {});
		
		java.util.HashMap<String,String> tests = alm.autGetJUnitManager().autGetTestList(AUTEntrega010_RGR003.class);
		
		System.out.println("\n\n***************** LISTA DE CENARIOS CARREGADOS *************");
		
		for(String cn : tests.keySet()) {
			if(parametersConfig.containsKey("AUT_NOME_CTP")) {
				parametersConfig.remove("AUT_NOME_CTP");	
				parametersConfig.put("AUT_NOME_CTP",cn);
			}
			else {
				parametersConfig.put("AUT_NOME_CTP",cn);				
			}
			
			if(parametersConfig.containsKey("AUT_DESCRICAO_CTP")) {
				parametersConfig.remove("AUT_DESCRICAO_CTP");
				parametersConfig.put("AUT_DESCRICAO_CTP",String.format("AUT: CENÁRIO DE TESTE: %s",cn));				
			}
			else {
				parametersConfig.put("AUT_DESCRICAO_CTP",String.format("AUT: CENÁRIO DE TESTE: %s",cn));								
			}
			
			alm.autALMWebServiceManager().autInsertTestAutomation(parametersConfig);
		}
		
	}
}
