package br.lry.components.tests;

import org.junit.Test;

import br.lry.components.AUTVABaseComponent;
import br.lry.dataflow.AUTDataFlow;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTTestDataFlowIntegration {

	public AUTTestDataFlowIntegration() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void AUT_IT00000_STCFG_ID00003_FRT003_CN00000() {
		AUTDataFlow datFlow = new AUTDataFlow();
		AUTVABaseComponent bs = new AUTVABaseComponent();
		
		datFlow.autInitDataFlow();
		bs.autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_NOVA_SENHA", "11111111111");		
		System.out.println(datFlow.autGetParametersFromTable(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN).get("AUT_NOVA_SENHA"));	
	
	}
	public static void main(String[] args) {
		
	}

}
