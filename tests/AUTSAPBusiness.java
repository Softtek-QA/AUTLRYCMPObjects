package br.lry.components.tests;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import br.lry.components.sap.AUTSAPBaseServices;

public class AUTSAPBusiness{

	public AUTSAPBusiness() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void autInit() {
		AUTSAPBaseServices sap = new AUTSAPBaseServices();			
		java.util.HashMap<String,Object> parameters = new java.util.HashMap<String,Object>();

		parameters.put("USER_SAP", "51028487");
		parameters.put("PWD_SAP", "Auto5@2020");	
		parameters.put("AUT_LOJA", "035");
		parameters.put("AUT_FILA", "ARMAZENA");
		parameters.put("AUT_FORMATO", "16X20ITS");
		parameters.put("AUT_DOC_FORNECIMENTO", "800000109");
		parameters.put("INIT_TRANSACTION", true);
		
		sap.autSAPConfigUsuarioRFLoja().autInitProcess(parameters);
		//sap.autConferenciasPedidos().autStartConf(parameters);	
		
	}


}
