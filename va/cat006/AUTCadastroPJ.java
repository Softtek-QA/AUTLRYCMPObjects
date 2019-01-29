package br.lry.components.va.cat006;

import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;
import br.lry.components.va.AUTVACadastros;
import br.lry.components.va.AUTVACadastros.AUT_VA_CADASTROS;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTCadastroPJ extends AUTVABaseComponent {

	public AUTCadastroPJ()  {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Realizar cadastro de pessoa jurídica no momento da criação do pedido
	 * @param parametros - Dados para o cadastro
	 * @return - Verdadeiro para a busca de clientes realizada
	 */
	public boolean autCadastrarPJ(java.util.HashMap parametros) {

		try {
			
			AUTVACadastros autCadastros = new AUTVACadastros();
			DomElement btAddNovoClient = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo");
			DomTextField txtNumDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.NumeroDocumento");
			String AUT_NUMERO_DOC_CNPJ_OUTPUT=null;

			String numCNPJ = "";

			numCNPJ = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_CNPJ").toString();
			AUT_NUMERO_DOC_CNPJ_OUTPUT = numCNPJ;			
			txtNumDoc.typeKeys(numCNPJ,500);
			
			btAddNovoClient.click();
			
			autInsertScreenByScenario();
			DomTextField numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");
			
			numeroDoc.click();
			numeroDoc.setText(numCNPJ);
			numeroDoc.typeKeys("\n");		
			autInsertScreenByScenario();
			autCadastros.autCadastrarPJ();
			autInsertScreenByScenario();
					
			return true;

		} catch (java.lang.Exception e) {
			
			return false;

		}

	}
		
}
