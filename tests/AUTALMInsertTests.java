package br.lry.components.tests;

import javax.swing.text.StyleContext.SmallAttributeSet;

import br.lry.components.AUTBaseComponent;
import br.lry.qa.alm.webservices.scm.AUTALMManage;
import br.lry.qa.alm.webservices.scm.AUTALMManage.AUT_ALM_PROJECTS;
import br.lry.qa.alm.webservices.scm.AUTALMManage.AUT_ALM_TESTS_TYPES;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega001_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega002_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega003_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega004_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega005_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega006_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega007_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega008_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega009_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega010_RGR001;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega011_RGR001;

public class AUTALMInsertTests extends AUTBaseComponent {

	public AUTALMInsertTests() {
		// TODO Auto-generated constructor stub
	}

	public AUTALMInsertTests(boolean syncronizeDataFlow) {
		super(syncronizeDataFlow);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		br.lry.qa.alm.webservices.scm.AUTALMManage scm = new br.lry.qa.alm.webservices.scm.AUTALMManage();
		AUTJUnitManager manageTests = new AUTJUnitManager();
		
		java.util.HashMap<String, Object> parametersConfig = new java.util.HashMap<String,Object>();
		parametersConfig.put("AUT_SERVER_ALM", "192.168.0.3:19120");
		parametersConfig.put("AUT_USER_ALM", "admin");
		parametersConfig.put("AUT_PWD_ALM", "admin");
		parametersConfig.put("AUT_URL_ALM_PROXY_SERVICE","http://192.168.0.3:19120/Services1.0/jaxws/tests");
		parametersConfig.put("AUT_URL_WEBSERVICE_ALM", String.format("http://%s/Services1.0/jaxws/tests?wsdl",parametersConfig.get("AUT_SERVER_ALM").toString()));
		parametersConfig.put("AUT_PROJECT_ALM", AUT_ALM_PROJECTS.VA_VENDAS_ASSISTIDAS);
		parametersConfig.put("AUT_PROJECT_CONTAINER", AUT_ALM_PROJECTS.VA_CONTAINER_VENDAS_ASSISTIDAS);		
		parametersConfig.put("AUT_NOME_CTP", "NOME CASO DE TESTE");
		parametersConfig.put("AUT_DESCRICAO_CTP", "DESCRICAO DO CASO DE TESTES");
		parametersConfig.put("AUT_TIPO_TESTE", AUT_ALM_TESTS_TYPES.SILK4J);		
		parametersConfig.put("AUT_PASSOS_CTP", new br.lry.qa.alm.webservices.scm.tests.ManualTestStep[] {});
		parametersConfig.put("AUT_PARAMETROS_CTP", new br.lry.qa.alm.webservices.scm.tests.NodeParameter[] {});

		java.util.HashMap<String,String> tests = manageTests.autGetTestListQA(AUTEntrega011_RGR001.class);
		Object[] itens = tests.keySet().toArray();
		java.util.Arrays.sort(itens);
		for(Object tst : itens) {
			parametersConfig.remove("AUT_NOME_CTP");
			parametersConfig.put("AUT_NOME_CTP",tst.toString());	
			parametersConfig.remove("AUT_DESCRICAO_CTP");
			parametersConfig.put("AUT_DESCRICAO_CTP","AUT INFO: CLASSE IMPLEMENTAÇÃO : ".concat(tests.get(tst.toString())));
			scm.autInsertTestAutomation(parametersConfig);
		}
	}

}
