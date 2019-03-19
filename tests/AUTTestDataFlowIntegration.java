package br.lry.components.tests;

import org.junit.Test;

import br.lry.dataflow.AUTDataFlow;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTTestDataFlowIntegration {

	public AUTTestDataFlowIntegration() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void AUT_IT00015_STVA_ID00021_FRT021_CN00075_REALIZAR_ORCAMENTO_COM_GARANTIA_ESTENDIDA_DESCONTO_NAO_ELEGIVEL_PARA_RATEIO_LOJA0035() {
		AUTDataFlow datFlow = new AUTDataFlow();
		datFlow.autInitDataFlow();
		System.out.println(datFlow.autGetParametersFromTable(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS).get("AUT_TIPO_IMOVEL_RESIDENCIA"));
	}
	public static void main(String[] args) {
		
	}

}
