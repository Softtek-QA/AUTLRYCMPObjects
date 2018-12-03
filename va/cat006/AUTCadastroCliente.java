package br.lry.components.va.cat006;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;
import br.lry.components.va.AUTVACadastros;
import br.lry.components.va.AUTVACadastros.AUT_VA_CADASTROS;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTCadastroCliente extends AUTVABaseComponent{
	
	public static String AUT_NUMERO_DOC_CPF_OUTPUT=null,AUT_NUMERO_DOC_CNPJ_OUTPUT=null,AUT_NUMERO_DOC_PASSAPORTE_OUTPUT=null;

	
	/**
	 * Realizar cadastro de cliente no momento da criação do pedido
	 * @param parametros - Dados do cliente
	 * @return - Verdadeiro para a busca de clientes realizada
	 */
	public boolean autCadastrarCliente(java.util.HashMap parametros) {

		try {

			String numCPF = "";
			DomElement btAddNovoClient = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo");
			btAddNovoClient.click();
			DomTextField numeroDoc = null;
			numCPF = parametros.get("AUT_CPF").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : PF - CPF");			
			numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");
			numeroDoc.click();
			numCPF = parametros.get("AUT_CPF").toString();
			AUT_NUMERO_DOC_CPF_OUTPUT = numCPF;
			numeroDoc.typeKeys(numCPF);
			AUTVACadastros autVACadastro = new AUTVACadastros();
			autVACadastro.autCadastrarPF(parametros);

//			autVACadastro.autCadastrarCliente(AUT_VA_CADASTROS.FISICA);

			return true;
		}
		catch(java.lang.Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	}

}
