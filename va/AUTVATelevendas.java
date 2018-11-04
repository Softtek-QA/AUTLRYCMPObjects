/**
 * 
 */
package br.lry.components.va;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import sun.management.resources.agent;

import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_MEIOS_PAGAMENTO;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_PLANO_PAGAMENTO;
import br.lry.dataflow.AUTDataFlow.*;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.win32.AccessibleControl;

/**
 * 
 * Cadastro de pessoa Física
 * 
 * @author Softtek-QA
 * 
 *
 */
public class AUTVATelevendas extends AUTVALogin {
	public String host = "127.0.0.1";
	private Desktop AUT_AGENT_SILK4J = new Desktop(host);
	public String AUT_NUMERO_PEDIDO;
	

	
	public void autSetHostExecutionService(String host) {
		AUT_AGENT_SILK4J = new Desktop(host);
	}
	
	public void realizarTrocaLojaTelevendas() {

		autLoginVATelevendasDefault();
			
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoLoja").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.Televendas.SelecionarLoja").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.Televendas.CampoSeleçãoLoja").setText("35");
		AUT_AGENT_SILK4J.<DomElement>find("VA.Televendas.Loja35").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.Televendas.BotaoEscolher").click();
		//AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
	}
	
	public void selectClient(String docClient) {
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setText(docClient);
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.Avancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
	}
	
	public void selectProduct(String codProduct) {
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.LM").typeKeys(codProduct);
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.+").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.BotaoGerar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
	}
	
	public void finishOrder() {
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.botaoAvancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.CaixaMsgPedidoNum").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();	
	}
	
	
	@Test
	public void pedidoTelevendasCARTCREDingAntifraude() {
		
	
		realizarTrocaLojaTelevendas();
		
		String docCliente = "58.506.064/0001-49"; //"758.536.958-19" ;
		
		AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();
		
	
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.LM").typeKeys("89296193");
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.+").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.BotaoGerar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.PesquisaAvancada").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.name").setText("Lynda");
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.BotaoPesquisar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ItemCPF_CNPJ").click();
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.Avancar").click();
		
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.PagamentoLoja").select(1);
		AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.ValorMeioPagamento").typeKeys("4,00");
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.MeioPagamento").select(AUT_VA_MEIOS_PAGAMENTO.CARTAO_CREDITO.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.Pagamento").select(AUT_VA_PLANO_PAGAMENTO.SEM_JUROS_1X.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.CadastroClientesDados.AdicionarNovoMeioPag").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.MeioPagamento").select(AUT_VA_MEIOS_PAGAMENTO.VOUCHER.toString());
		AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.Pagamento").select(AUT_VA_PLANO_PAGAMENTO.SEM_JUROS_1X.toString());
		
		AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.OpcaoAntiFraude").select(1);
//		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.botaoAvancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.CaixaMsgPedidoNum").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
}

	//@Test
	public void pedidoTelevendasCARTCREDenvAntifraude() {

		realizarTrocaLojaTelevendas();

		String docCliente = "758.536.958-19";

		AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();

		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.LM").typeKeys("89296193");
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.+").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.BotaoGerar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();

		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.Avancar").click();

		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.PagamentoLoja").select(1);
		AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.MeiodePagamento").select("C. CRÉDITO");
		AUT_AGENT_SILK4J.<DomListBox>find("VA.CadastroClientesDados.Pagamento1x").select("1X SEM JUROS");

		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.botaoAvancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.CaixaMsgPedidoNum").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();

	}

	//@Test
	public void pedidoTelevendasCARTCREDeVoucherFalhaTrans() {
		realizarTrocaLojaTelevendas();

		String docCliente = "758.536.958-19";

		AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();

		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.LM").typeKeys("89296193");
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.+").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.BotaoGerar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();

		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.Avancar").click();

		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.PagamentoLoja").select(1);
		
		//voucher 
		//..
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.botaoAvancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.CaixaMsgPedidoNum").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
	}
	
	//@Test
	public void pedidoTelevendasCARTCREDeVoucher() {
		realizarTrocaLojaTelevendas();

		String docCliente = "758.536.958-19";

		AUT_AGENT_SILK4J.<DomLink>find("VA02.TelaInicialLoja.CriarCarrinho").click();

		AUT_AGENT_SILK4J.<DomTextField>find("VA.CadastroClientesDados.LM").typeKeys("89296193");
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.+").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.BotaoGerar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPedidos.BotaoFiltroPedido").click();

		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA02.PesquisaClienteCadastrado.CampoPesquisa").setText(docCliente);
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.BotaoPesquisarCliente").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA02.PesquisaClienteCadastrado.ClientePesquisado").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaCliente.AvancarTelaCliente").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.Avancar").click();

		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.AvancarPaginaCadastro").click();
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.ValorMeioPagamento").getText();
		
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.ValorMeioPagamento").typeKeys("4,00");
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.MeioPagamento").select(AUT_VA_MEIOS_PAGAMENTO.CARTAO_CREDITO.toString());
		AUT_AGENT_SILK4J.<DomCheckBox>find("VA.CadastroClientesDados.PagamentoLoja").select(1);
		AUT_AGENT_SILK4J.<DomListBox>find("VA02.TelaMeioPagamento.AdicionarNovoMeioPag").click();
		
		//voucher 
		//..
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.botaoAvancar").click();
		AUT_AGENT_SILK4J.<DomButton>find("VA.CadastroClientesDados.Finalizar").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.CadastroClientesDados.CaixaMsgPedidoNum").click();
		AUT_AGENT_SILK4J.<AccessibleControl>find("VA02.Fechar").click();
	}
	
//	@Test
	
	public void pedidoTelevendasPagarLoja() {
		
		String client = "";
		String product = "";
		
		this.realizarTrocaLojaTelevendas();
		this.selectClient(client);
		this.selectProduct(product);
		
		
		
		this.finishOrder();
	}
	
}




