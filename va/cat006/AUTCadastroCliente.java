package br.lry.components.va.cat006;

import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTCadastroCliente extends AUTVABaseComponent{
	
	public static String AUT_NUMERO_DOC_CPF_OUTPUT=null,AUT_NUMERO_DOC_CNPJ_OUTPUT=null,AUT_NUMERO_DOC_PASSAPORTE_OUTPUT=null;

	/**
	 * Realizar cadastro de cliente no momento da criação do pedido
	 * @param parametros - Dados do cliente
	 * @param btCheckAceitaMalaDiretSim 
	 * @param AUT_CEP 
	 * @param UFEnderecoPesquisa 
	 * @return - Verdadeiro para a busca de clientes realizada
	 */

	
	public void autMenuCadastroCliente() {
		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.FechaJanelaComentario").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.Menu").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.SubMenuClientes").click();
	}
	
	
	public boolean autCadastrarClienteComCep(java.util.HashMap parametros) {
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

			String clienteNome = parametros.get("AUT_NOME").toString();
			String clienteEmail = parametros.get("AUT_EMAIL").toString();

			DomTextField nome = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Nome");
			DomTextField email = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Email");

			nome.click();
			nome.domClick();
			nome.setText(clienteNome);

			email.click();
			email.domClick();
			email.setText(clienteEmail);
			String tipoTelefone = parametros.get("AUT_TIPO_TELEFONE").toString();
			String numeroTelefone = parametros.get("AUT_NUMERO_TELEFONE").toString();

			DomListBox listaTipoElement = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoTelefone");
			listaTipoElement.click();
			listaTipoElement.select(tipoTelefone);

			DomTextField txtNumeroContato = AUT_AGENT_SILK4J
					.<DomTextField>find("VA.CadastroClientesDados.NumeroTelefone");
			txtNumeroContato.click();
			txtNumeroContato.domClick();
			txtNumeroContato.setText(numeroTelefone);

			txtNumeroContato.click();
			txtNumeroContato.setFocus();
			txtNumeroContato.domClick();

			String txtDataNascimento = parametros.get("AUT_NASCIMENTO").toString();

			DomListBox listaGeneros = AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.gender-pf");
			DomTextField txtDataNascimentoField = AUT_AGENT_SILK4J
					.<DomTextField>find("VA.AtualizacaoDados.nascimento-pf");

			String txtTipo_Endereco = parametros.get("AUT_TIPO_ENDERECO").toString();
			DomListBox TipoEndereco = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoEndereco");
			TipoEndereco.select(txtTipo_Endereco);
			listaGeneros.select(1);
			txtDataNascimentoField.setText(txtDataNascimento);

			DomRadioButton btCheckAceitaNovidProp = AUT_AGENT_SILK4J
					.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");
			btCheckAceitaNovidProp.select();
			btCheckAceitaNovidProp.click();
			btCheckAceitaNovidProp.select();

			AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesEstrangeiro.BotaoPropagSMS").click();
			btCheckAceitaNovidProp.select();
			btCheckAceitaNovidProp.click();
			btCheckAceitaNovidProp.select();

			String txtCEP = parametros.get("AUT_CEP").toString();
			AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.CEP").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.CEP").typeKeys(txtCEP);

			String txtCASA = parametros.get("AUT_NUMERO_ENDERECO").toString();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroCasa").typeKeys(txtCASA);

			DomElement btCheckAceitaMalaDiretSim = AUT_AGENT_SILK4J
					.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim");
			AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim").click();
			btCheckAceitaMalaDiretSim.mouseMove();
			btCheckAceitaMalaDiretSim.click(); // nao está clicando aqui

			AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Avançar").mouseMove();
			AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Avançar").click();

			//Verificar se existe para clicar
			if (AUT_AGENT_SILK4J.<BrowserWindow>find("VA.CadastroClientesDados").exists("AceitarPropagandasSim",
					5000)) {

				AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitarPropagandasSim").mouseMove();
				AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitarPropagandasSim").click();
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.AtualizacaoDados.client-fidelity-sim").select();
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.AtualizacaoDados.mala-direta-sim-pf").select();
				autInsertScreenByScenario();

				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Avançar").mouseMove();
				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Avançar").click();

			}

		} catch (java.lang.Exception e) {

		}
		
		

		return true;

	}
	
	/**
	 * Realizar cadastro de cliente no momento da criação do pedido
	 * @param parametros - Dados do cliente
	 * @return - Verdadeiro para a busca de clientes realizada
	 */
	public boolean autCadastrarCliente(java.util.HashMap parametros) {

		try {

			String numCPF = "";
			//DomElement btAddNovoClient = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesInicial.BotaoAdicionarNovo");
			//btAddNovoClient.click();
			DomTextField numeroDoc = null;
			numCPF = parametros.get("AUT_CPF").toString();
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : PF - CPF");			
			numeroDoc = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDocs.NumeroDocumento");
			numeroDoc.click();
			numCPF = parametros.get("AUT_CPF").toString();
			AUT_NUMERO_DOC_CPF_OUTPUT = numCPF;
			//numeroDoc.typeKeys(numCPF);
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS,"AUT_CPF", numCPF);
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_CADASTROS, "AUT_NOME","AUT NOME PF: ".concat(numCPF));

			String clienteNome = parametros.get("AUT_NOME").toString();
			String clienteEmail = parametros.get("AUT_EMAIL").toString();

			DomTextField nome = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Nome");
			DomTextField email = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Email");

			nome.click();
			nome.domClick();
			nome.setText(clienteNome);

			email.click();
			email.domClick();
			email.setText(clienteEmail);


			
			String tipoTelefone = parametros.get("AUT_TIPO_TELEFONE").toString();
			String numeroTelefone = parametros.get("AUT_NUMERO_TELEFONE").toString();

			DomListBox listaTipoElement = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoTelefone");
			listaTipoElement.click();
			listaTipoElement.select(tipoTelefone);

			DomTextField txtNumeroContato = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroTelefone");
			txtNumeroContato.click();
			txtNumeroContato.domClick();
			txtNumeroContato.setText(numeroTelefone);

			txtNumeroContato.click();
			txtNumeroContato.setFocus();
			txtNumeroContato.domClick();
			
			String txtDataNascimento = parametros.get("AUT_NASCIMENTO").toString();

			DomListBox listaGeneros = AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.gender-pf");
			DomTextField txtDataNascimentoField = AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.nascimento-pf");
			
			listaGeneros.select(1);
			txtDataNascimentoField.setText(txtDataNascimento);
			
			DomRadioButton btCheckAceitaNovidProp = AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");
			btCheckAceitaNovidProp.select();
			btCheckAceitaNovidProp.click();
			btCheckAceitaNovidProp.select();

			AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesEstrangeiro.BotaoPropagSMS").click();

			btCheckAceitaNovidProp.select();
			btCheckAceitaNovidProp.click();
			btCheckAceitaNovidProp.select();
			
			
			DomButton btPesquisarCEP = AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.NaoSeiCEPPesquisa");
			btPesquisarCEP.click();

			String UFEnderecoPesquisa = parametros.get("AUT_UF_PESQUISA").toString();
			String cidade = parametros.get("AUT_CIDADE_PESQUISA").toString();
			String endereco = parametros.get("AUT_ENDERECO_PESQUISA").toString();
			String bairro = parametros.get("AUT_BAIRRO_PESQUISA").toString();

			DomListBox listUF = AUT_AGENT_SILK4J.<DomListBox>find("VA.PesquisaCEP.UF");

			listUF.click();
			listUF.domClick();
			listUF.select(UFEnderecoPesquisa);

			DomTextField txtCidadePesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Cidade");
			DomTextField txtEnderecoPesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Endereco");
			DomTextField txtBairroPesquisa = AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaCEP.Bairro");

			txtCidadePesquisa.click();
			txtCidadePesquisa.setText(cidade);

			txtEnderecoPesquisa.click();
			txtEnderecoPesquisa.setText(endereco);

			txtBairroPesquisa.click();
			txtBairroPesquisa.setText(bairro);

			DomButton btBuscarEndereco = AUT_AGENT_SILK4J.<DomButton>find("VA.PesquisaCEP.Buscar");

			btBuscarEndereco.click();

			if (AUT_AGENT_SILK4J.<BrowserWindow>find("VA.PesquisaCEP").exists("MsgStatusCEP", 10000)) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaCEP.Fechar").click();
			} else {
				DomElement itemSelectResultPesquisa = AUT_AGENT_SILK4J
						.<DomElement>find("VA.PesquisaCEP.ItemResultadoPesqSelecionado");

				itemSelectResultPesquisa.click();

			}
			
			String tipoEndereco = parametros.get("AUT_TIPO_ENDERECO").toString();
			DomListBox listTipoEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoEndereco");
			listTipoEnd.click();
			listTipoEnd.select(tipoEndereco);
			
			String cep = parametros.get("AUT_CEP").toString();
			DomTextField txtCEPEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.CEP");
			txtCEPEnd.click();
			txtCEPEnd.setText(cep);
			
			String nomeRuaEndereco = parametros.get("AUT_RUA_ENDERECO").toString();
			DomTextField txtCasaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NomeRua");
			txtCasaEnd.click();
			txtCasaEnd.setText(nomeRuaEndereco);
			
			String numeroEndereco = parametros.get("AUT_NUMERO_ENDERECO").toString();
			DomTextField txtNumeroCasaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroCasa");
			txtNumeroCasaEnd.click();
			txtNumeroCasaEnd.setText(numeroEndereco);
			
			String bairroResidencia = parametros.get("AUT_BAIRRO_ENDERECO").toString();
			DomTextField txtBairroEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Bairro");
			txtBairroEnd.click();
			txtBairroEnd.setText(bairroResidencia);
			
			String complementoResidencia = parametros.get("AUT_COMPLEMENTO_ENDERECO").toString();
			DomTextField txtComplementoResidEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Complemento");
			txtComplementoResidEnd.click();
			txtComplementoResidEnd.setText(complementoResidencia);
			
			String cidadeResidencia = parametros.get("AUT_CIDADE_ENDERECO").toString();
			DomTextField txtCidadeEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Cidade");
			txtCidadeEnd.click();
			txtCidadeEnd.setText(cidadeResidencia);

			String estadoResidencia = parametros.get("AUT_ESTADO_ENDERECO").toString();
			DomListBox txtEstadoEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.Estado");
			txtEstadoEnd.click();
			txtEstadoEnd.select(estadoResidencia);
			
			String referenciaResidencia = parametros.get("AUT_REFERENCIA_ENDERECO").toString();
			DomTextField txtReferenciaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.Referencia");
			txtReferenciaEnd.click();
			txtReferenciaEnd.setText(referenciaResidencia);

			String tipoImovelResidencia = parametros.get("AUT_TIPO_IMOVEL_RESIDENCIA").toString();
			DomListBox txtTipoImovelResidEnd = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.TipoImovelResidencial");
			txtTipoImovelResidEnd.click();
			txtTipoImovelResidEnd.select(tipoImovelResidencia);

			try {
				
				DomButton btCadastroPFAvanc = AUT_AGENT_SILK4J
						.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro");
				
				btCadastroPFAvanc.click();

				btCheckAceitaNovidProp = AUT_AGENT_SILK4J
						.<DomRadioButton>find("VA.CadastroClientesDados.AceitarOfertaTelefoneSim");

				btCheckAceitaNovidProp.select();
				btCheckAceitaNovidProp.click();
				btCheckAceitaNovidProp.select();

				DomElement btCheckMalaDirectAceit = AUT_AGENT_SILK4J
						.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim");

				btCheckMalaDirectAceit.click();

				AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitarPropagandasSim").click();
			} catch (java.lang.Exception e) {

			}
	
			return true;

		} catch (java.lang.Exception e) {
			
			return false;

		}
	}

}
