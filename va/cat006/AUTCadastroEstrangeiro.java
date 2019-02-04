package br.lry.components.va.cat006;

import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;

import br.lry.components.AUTVABaseComponent;
import br.lry.components.va.AUTVACadastros;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTCadastroEstrangeiro extends AUTVABaseComponent {
	
	public static String AUT_NUMERO_DOC_PASSAPORTE_OUTPUT=null;


	public AUTCadastroEstrangeiro() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Realizar cadastro de pessoa jurídica no momento da criação do pedido
	 * @param parametros - Dados para o cadastro
	 * @return - Verdadeiro para a busca de clientes realizada
	 */
	public boolean autCadastrarEstrangeiro(java.util.HashMap parametros) {

		try {
			AUTVACadastros autCadastros = new AUTVACadastros();
			DomElement btAddNovoClient = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo");
			autInsertScreenByScenario();
			String numPassPorte = "";
			autInsertScreenByScenario();
			
			btAddNovoClient.click();
			numPassPorte = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_PASSAPORTE").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : ESTRANGEIRO - PASSA PORTE");
			AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.ClienteEstrangeiro").check();			
			numPassPorte = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_PASSAPORTE").toString();
			AUT_NUMERO_DOC_PASSAPORTE_OUTPUT = numPassPorte;			
			autCadastros.autCadastrarEstrangeiro();
					
			return true;

		} catch (java.lang.Exception e) {
			
			return false;

		}

	}
		


}
