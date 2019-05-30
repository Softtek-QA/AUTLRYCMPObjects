package br.lry.components.va.cat006;

import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

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
	public void autCadastrarEstrangeiro(java.util.HashMap parametros) {

//		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BuscarPedido").mouseMove();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BuscarPedido").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BuscarPedido").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.Passaporte").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.Passaporte").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.NumeroPassaporte").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.NumeroPassaporte").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.PesquisaClienteCadastrado.NumeroPassaporte").setText(parametros.get("AUT_CODIGO_ITEM").toString());
			AUT_AGENT_SILK4J.<DomElement>find("VA.LiberacaoPendentes.BotaoPesquisaDesconto").click();
			AUT_AGENT_SILK4J.<DomLink>find("VA.CadastroClientesDados.AdicionarNovo").click();
		    AUT_AGENT_SILK4J.<BrowserWindow>find("VA.CadastroClientesDados").exists("nome-foreign", 5000);
		    AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.nome-foreign").click();
		    AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.nome-foreign").setFocus();
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.nome-foreign").typeKeys(parametros.get("AUT_NOME_ESTRANGEIRO").toString());
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Email").click();
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Email").setFocus();
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Email").typeKeys(parametros.get("AUT_EMAIL").toString());
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.PassaPorte").click();
            //AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.PassaPorte").setFocus();
            //AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.PassaPorte").typeKeys(parametros.get("AUT_NUMERO_DOCUMENTO").toString());
            
            DomElement btCheckAceitonovidades = AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesEstrangeiro.checkSim");
            btCheckAceitonovidades.setFocus();
            btCheckAceitonovidades.mouseMove();
            btCheckAceitonovidades.click();
			
            //Verifica se existe os campos dos dados complementares
            if (AUT_AGENT_SILK4J.<BrowserWindow>find("VA.AtualizacaoDados").exists("RNE", 2000)){
                AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.RNE").setFocus();
                AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.RNE").click();
                AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.RNE").typeKeys("AUT_NUMERO_DOCUMENTO");
                
                AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").setFocus();
                AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").click();
                AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").typeKeys(parametros.get("AUT_SEXO").toString());
                
                
                AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.DataNascimento").setFocus();
                AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.DataNascimento").click();
                AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.DataNascimento").typeKeys(parametros.get("AUT_NASCIMENTO").toString());           
            }
          
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoTelefone").setFocus();
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoTelefone").click();
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoTelefone").typeKeys(parametros.get("AUT_TIPO_TELEFONE").toString());
            
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.telefone-0-foreign").click();
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.telefone-0-foreign").setFocus();              
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.telefone-0-foreign").typeKeys(parametros.get("AUT_NUMERO_TELEFONE").toString());
            
            AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.AceitoPropagLeroy").setFocus();              
            AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesPJ.AceitoPropagLeroy").click();
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.tipo-imovel-0-foreig").setFocus();
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.tipo-imovel-0-foreig").click();   
            
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.tipo-imovel-0-foreig").typeKeys(parametros.get("AUT_TIPO_ENDERECO").toString());
            
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.CEP").setFocus();              
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.CEP").typeKeys(parametros.get("AUT_CEP").toString());
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Rua").setFocus();             	
            			
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Rua").typeKeys(parametros.get("AUT_RUA_ENDERECO").toString());
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.NumeroCasa").mouseMove();
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.NumeroCasa").setFocus();            
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.NumeroCasa").typeKeys(parametros.get("AUT_NUMERO_ENDERECO").toString());
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Bairro").mouseMove();
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Bairro").setFocus();              
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Bairro").typeKeys(parametros.get("AUT_BAIRRO_PESQUISA").toString());
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Cidade").mouseMove();
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Cidade").setFocus();              
            AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesEstrangeiro.Cidade").typeKeys(parametros.get("AUT_CIDADE_PESQUISA").toString());
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoImovelResidencial").setFocus(); 
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoImovelResidencial").click();
            AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesEstrangeiro.TipoImovelResidencial").typeKeys(parametros.get("AUT_TIPO_IMOVEL_RESIDENCIA").toString());
            AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim").setFocus();
            AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.AceitaMalaDiretSim").click();          
            AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.Avançar").click();
		
//		return true;
////
//	} catch (java.lang.Exception e) {
//		
//			
//		}
//		return false;
//
	}

		


}
