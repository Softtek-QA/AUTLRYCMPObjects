package br.lry.components.tests;

import br.lry.components.AUTBaseComponent;

public class AUTParent extends AUTBaseComponent{
	public String AUT_NOME = "NOME PADRAO DO PROJETO TESTE";
	public java.util.HashMap<String,Object> AUT_PARAMETROS_IN = new java.util.HashMap<String,Object>();
	public java.util.HashMap<String,Object> AUT_PARAMETROS_OUT = new java.util.HashMap<String,Object>();
	public String AUT_VARIABLE = "AUT_CONFIG_OBJECT";
	public String AUT_OBJECT_VALOR = "VALOR TESTE CONFIGURACAO";
	
	public AUTParent() {
		// TODO Auto-generated constructor stub
		AUT_PARAMETROS_IN.put("NOME", AUT_NOME);
		AUT_PARAMETROS_IN.put("NOVO_NOME", AUT_NOME);
	}

}
