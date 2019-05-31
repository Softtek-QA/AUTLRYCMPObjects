package br.lry.components.va.cat006;

import java.util.HashMap;

import org.junit.Test;

import com.borland.silktest.jtf.common.types.ItemIdentifier;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;
import br.lry.components.va.AUTVACadastros;
import br.lry.components.va.AUTVACadastros.AUT_VA_CADASTROS;
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_ENDERECO;
import br.lry.components.va.AUTVACadastros.AUT_VA_TIPO_RESIDENCIA;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTCadastroPJ extends AUTVABaseComponent {

	private static final String AUT_NUMERO_TELEFONE = null;
	private static final ItemIdentifier AUT_TIPO_TELEFONE = null;
	private String referenciaResidencia;
	private String AUT_NOME_PJ_OUTPUT;

	public AUTCadastroPJ()  {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Realizar cadastro de pessoa jurídica no momento da criação do pedido
	 * @param parametros - Dados para o cadastro
	 * @return - Verdadeiro para a busca de clientes realizada
	 */
	/**
	 * Realizar cadastro de cliente no momento da criação do pedido
	 * @param parametros - Dados do cliente
	 * @param AUT_NUMERO_DOC_AUT_NOME_PJ_OUTPUT 
	 * @return - Verdadeiro para a busca de clientes realizada
	 */
	public boolean autCadastrarPJ(java.util.HashMap parametros) {

		try {
			String numCNPJ = "";
			DomTextField numeroDoc = null;
			numCNPJ = parametros.get("AUT_CNPJ").toString();
			
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : PJ - CNPJ");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesInicial.NumeroDocumento").typeKeys(numCNPJ);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesInicial.NumeroDocumento").typeKeys("\t");
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisaDesconto").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisaDesconto").click();
			AUT_AGENT_SILK4J.<DomLink>find("VA.CadastroClientesDados.AdicionarNovo").setFocus();
			AUT_AGENT_SILK4J.<DomLink>find("VA.CadastroClientesDados.AdicionarNovo").click();		
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroDocumento").typeKeys(numCNPJ);
			setAUT_NOME_PJ_OUTPUT(parametros.get("AUT_CNPJ").toString());
			
			String clienteNome = parametros.get("AUT_CNPJ").toString();
			String clientefantasia = parametros.get("AUT_FANTASIA").toString();

			DomTextField nome = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.razaosocial-pj");
			DomTextField fantasia = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeFantasia");

			nome.click();
			nome.domClick();
			nome.setText(clienteNome);
			nome.typeKeys("\t");	

			fantasia.click();
			fantasia.domClick();
			fantasia.setText(clientefantasia);
			//fantasia.setText("\t");
			
			String InscriçãoEstadual = parametros.get("AUT_INCRICAO_ESTADUAL").toString();
			DomTextField inscriçãoestadual = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoEstadual");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoEstadual").mouseMove();
			inscriçãoestadual.mouseMove();
			inscriçãoestadual.click();
			inscriçãoestadual.domClick();
			inscriçãoestadual.setText(InscriçãoEstadual);
			inscriçãoestadual.typeKeys("\t");			
			
			String Incricao_Municipal = parametros.get("AUT_INCRICAO_MUNICIPAL").toString();
			DomTextField inscricaoMunicipal = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoMunicipal");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoMunicipal").mouseMove();
			inscricaoMunicipal.click();			
			inscricaoMunicipal.setText(Incricao_Municipal);
			inscricaoMunicipal.typeKeys("\t");
			
			String nomeCompleto = parametros.get("AUT_NOME_PJ").toString();
			DomTextField nomecompleto = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeContato");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeContato").mouseMove();
			nomecompleto.click();
			nomecompleto.domClick();
			nomecompleto.setText(nomeCompleto);
			nomecompleto.typeKeys("\t");

			String Email = parametros.get("AUT_EMAIL").toString();
			DomTextField email = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.EmailContato");
			
			email.click();
			email.domClick();
			email.setText(Email);
			email.typeKeys("\t");
			
			String Departamento = parametros.get("AUT_PJ_DEPARTAMENTO_CONTATO").toString();
			DomTextField departamento = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Departamento");
			
			departamento.click();
			departamento.domClick();
			departamento.setText(Departamento);
			departamento.typeKeys("\t");
						
			DomElement btCheckEmailNFE = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.emailNFE");
			btCheckEmailNFE.mouseMove();
			btCheckEmailNFE.click();		
			btCheckEmailNFE.typeKeys("\t");
			
			AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoTelefone").mouseMove();
			DomListBox listaTipoElement = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoTelefone");
			listaTipoElement.click();
			listaTipoElement.select("Celular");
			listaTipoElement.click();
			listaTipoElement.typeKeys("\t");
			
			String telefone = parametros.get("AUT_NUMERO_TELEFONE").toString();
			DomElement numtelefone = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.NumeroTelefone");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NumeroTelefone").mouseMove();
			numtelefone.click();
			numtelefone.domClick();
			numtelefone.typeKeys(telefone);
			numtelefone.typeKeys("\t");	
			
			DomElement btCheckAceitoSMS = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesEstrangeiro.BotaoPropagSMS");
			btCheckAceitoSMS.setFocus();
			btCheckAceitoSMS.mouseMove();
			btCheckAceitoSMS.click();
						
			DomElement ofertas = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.AceitoPropagLeroy");			
			ofertas.setFocus();
			ofertas.mouseMove();
			ofertas.click();		
			ofertas.typeKeys("\t");
			
			
			AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.Endereco").mouseMove();
			DomListBox TipoImovel = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.Endereco");
			TipoImovel.click();
			TipoImovel.select("Obra");
			TipoImovel.click();
			TipoImovel.typeKeys("\t");
			
			String cep = parametros.get("AUT_CEP").toString();
			DomTextField txtCEPEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.CEP");
			txtCEPEnd.click();
			txtCEPEnd.typeKeys(cep);
			txtCEPEnd.typeKeys("\t");
			
			String rua = parametros.get("AUT_ENDERECO_PESQUISA").toString();
			DomTextField txtrua = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NomeRua");
			txtrua.click();
			txtrua.setText(rua);	

			String numeroEndereco = parametros.get("AUT_NUMERO_ENDERECO").toString();
			DomTextField txtNumeroCasaEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.NumeroLocal");
			txtNumeroCasaEnd.click();
			txtNumeroCasaEnd.setText(numeroEndereco);
			
			String bairroResidencia = parametros.get("AUT_BAIRRO_PESQUISA").toString();
			DomTextField txtBairroEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Bairro");
			txtBairroEnd.click();
			txtBairroEnd.setText(bairroResidencia);		
			
			String complementoResidencia = parametros.get("AUT_COMPLEMENTO_ENDERECO").toString();
			DomTextField txtComplementoResidEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Complemento");
			txtComplementoResidEnd.click();
			txtComplementoResidEnd.setText(complementoResidencia);
			
			String cidadeResidencia = parametros.get("AUT_CIDADE_PESQUISA").toString();
			DomTextField txtCidadeEnd = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Cidade");
			txtCidadeEnd.click();
			txtCidadeEnd.setText(cidadeResidencia);
			
			//AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Referencia").typeKeys(referenciaResidencia);
			String referenciaResidencia = parametros.get("AUT_REFERENCIA_ENDERECO").toString();
			DomTextField refernciaendereco = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.Referencia");
			refernciaendereco.click();
			refernciaendereco.typeKeys(referenciaResidencia);	
			
			String tipoImovel = parametros.get("AUT_TIPO_IMOVEL_RESIDENCIA").toString();
			DomListBox tipoimovel = AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoImovel");
			tipoimovel.setFocus();
			tipoimovel.click();
			tipoimovel.select(tipoImovel);	
			
//			AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoImovel").mouseMove();
//			AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoImovel").click();
//			AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoImovel").select("Casa");
//			AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesPJ.TipoImovel").click();
			
			DomElement btCheckMalaDireta = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim");
			btCheckMalaDireta.setFocus();
			btCheckMalaDireta.mouseMove();
			btCheckMalaDireta.click();
//			
//			DomTextField inscricaoEstadual = AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoEstadual");
//			String inscricao_Estadual = parametros.get("AUT_INCRICAO_ESTADUAL").toString();
//			inscricaoEstadual.setFocus();
//			inscricaoEstadual.click();		
//			inscricaoEstadual.typeKeys(inscricao_Estadual);
//			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesPJ.InscricaoEstadual").typeKeys("\t");	
		
			AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Avançar").click();	
			
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesPJ.RadioNovidades").setFocus();
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesPJ.RadioNovidades").mouseMove();
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.CadastroClientesPJ.RadioNovidades").click();
			
			AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Avançar").click();
			
			} catch (java.lang.Exception e) {
				e.printStackTrace();
				e.getMessage();
				return false;
			}	
			return true;		

		
	}
	
	
	public void autCadastrarPJcadastrado(java.util.HashMap parametros) {

			String numCNPJ = "";
			DomTextField numeroDoc = null;
			numCNPJ = parametros.get("AUT_CNPJ").toString();
			
			System.out.println("AUT INFO: CADASTRO DE CLIENTE : PJ - CNPJ");
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesInicial.NumeroDocumento").typeKeys(numCNPJ);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesInicial.NumeroDocumento").typeKeys("\t");
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisaDesconto").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisaDesconto").click();
			AUT_AGENT_SILK4J.<DomLink>find("VA.CadastroClientesDados.AdicionarNovo").setFocus();
			AUT_AGENT_SILK4J.<DomLink>find("VA.CadastroClientesDados.AdicionarNovo").click();		
			AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.NumeroDocumento").typeKeys(numCNPJ);
			setAUT_NOME_PJ_OUTPUT(parametros.get("AUT_CNPJ").toString());
			
			String clienteNome = parametros.get("AUT_CNPJ").toString();
		
	}

	public String getAUT_NOME_PJ_OUTPUT() {
		return AUT_NOME_PJ_OUTPUT;
	}

	public void setAUT_NOME_PJ_OUTPUT(String aUT_NOME_PJ_OUTPUT) {
		AUT_NOME_PJ_OUTPUT = aUT_NOME_PJ_OUTPUT;
	}

}