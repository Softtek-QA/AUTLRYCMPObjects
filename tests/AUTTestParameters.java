package br.lry.components.tests;

import java.util.HashMap;

import br.lry.components.AUTBaseComponent;
import br.stk.framework.tests.AUTFWKTestObjectBase;
import br.stk.framework.tests.AUTFWKTestObjectBase.AUTBusinessObject;

class AUTTestObject extends AUTBusinessObject{
	public String valorItem = "Valor do item";
	public String valorDescricao = "descricao do item";
	
}

public class AUTTestParameters extends AUTFWKTestObjectBase {
	public String AUT_TEST_OBJECT = "VARIAVEL LOCAL TESTE DE REFLEXAO";

	public AUTTestParameters() {
		// TODO Auto-generated constructor stub		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AUTTestParameters test = new AUTTestParameters();
		AUTTestObject tst = new AUTTestObject();
		System.out.println(tst.autGetRuntimeData());
	}
	
	
	
	public AUTTestParameters(boolean syncronizeDataFlow) {
		
		// TODO Auto-generated constructor stub
	}

}
