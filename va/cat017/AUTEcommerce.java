package br.lry.components.va.cat017;

import java.util.HashMap;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.functions.AUTProjectsFunctions;

public class AUTEcommerce extends AUTBaseComponent{

	public static String AUT_NUMERO_PEDIDO;

	
	public void autEcommerceCarrinho(boolean maisItens, java.util.HashMap<String, Object> parametros) {
		
		String strCep;
		
		//Verifica se exibe msg indicando que não calculou o frete e recarrega tela para o calculo
		if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaPesquisaBoitata").exists("PopUpFreteECommerce",5000)) {
			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtOk").click(); 
			
			strCep = AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.CepEcommerce").getText();
			AUTProjectsFunctions.aguardaTempo(1000);
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.CepEcommerce").typeKeys(strCep);
		}
		
		//aguardar calcular frete para seguir
		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtFinalizaCompra").mouseMove();

		//Informa quantidade de item
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.QdeItem").setText(parametros.get("AUT_QUANTIDADE_ITEM").toString());
		
		if(maisItens)
			AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtEscolherMaisProdutos").click();
		else
			AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtFinalizaCompra").click();
	
		
	}

	public void autAddCarrinhoEcommerce() {
		
		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtAddComprar").setFocus();	
		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtAddComprar").click();
		
	}
	
	public void autEcommercePedido(java.util.HashMap<String, Object> parametros) {
		
//		String strCep;
		
		
//		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtAddComprar").setFocus();	
//		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtAddComprar").click();
	
//		//Verifica se exibe msg indicando que não calculou o frete e recarrega tela para o calculo
//		if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.TelaPesquisaBoitata").exists("PopUpFreteECommerce",5000)) {
//			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtOk").click(); 
//			
//			strCep = AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.CepEcommerce").getText();
//			AUTProjectsFunctions.aguardaTempo(1000);
//			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.CepEcommerce").typeKeys(strCep);
//		}
		
//		//aguardar calcular frete para seguir
//		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtFinalizaCompra").mouseMove();
//
//		//Informa quantidade de item
//		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.QdeItem").setText(parametros.get("AUT_QUANTIDADE_ITEM").toString());
//		
//		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaPesquisaBoitata.BtFinalizaCompra").click();
		
		//Tela Continuar Pagamento
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtContinuarPagamento").setFocus();
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtContinuarPagamento").click();		

		//Tela Modo de pagamento
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtNumeroCartao").mouseMove();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtNumeroCartao").typeKeys(parametros.get("AUT_NUMERO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtNomeCartao").mouseMove();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtNomeCartao").typeKeys(parametros.get("AUT_NOME_TITULAR").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtValidadeCartao").mouseMove();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtValidadeCartao").typeKeys(parametros.get("AUT_VALIDADE").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtCVVCartao").mouseMove();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.TxtCVVCartao").typeKeys(parametros.get("AUT_CODIGO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtFinalizaPagamento").mouseMove();
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtFinalizaPagamento").click();

		AUT_NUMERO_PEDIDO = AUT_AGENT_SILK4J.<DomElement>find("VA.TelaFinalPedidos.NumeroPedidoEcommerce").getText();
		
		AUT_NUMERO_PEDIDO = AUT_NUMERO_PEDIDO.substring(AUT_NUMERO_PEDIDO.indexOf("#"));
		
		System.out.println("O número do Pedido é: " + AUT_NUMERO_PEDIDO);
		
				
//		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setFocus();
//		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setText(parametros.get("AUT_CODIGO_ITEM").toString());
//		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys("\n");
//		AUT_AGENT_SILK4J.<DomLink>find("Boitata.Fluxo.ReceberEmCasa").click();
//
//		AUT_AGENT_SILK4J.<DomLink>find("Boitata.Fluxo.FinalizarCompra").click();
//
//		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.UtilizarOutroEnd").click();
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CEP").setText(parametros.get("AUT_CEP").toString());
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Bairro").setText(parametros.get("AUT_BAIRRO_ENDERECO").toString());
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Rua").setText(parametros.get("AUT_RUA_ENDERECO").toString());
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Numero").setText(parametros.get("AUT_NUMERO_ENDERECO").toString());
//
//		AUT_AGENT_SILK4J.<DomElement>find("Boitata.Fluxo.EntregaEconomica").click();
//		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.ContinuarPagamento").click();
//
//		AUT_AGENT_SILK4J.<DomElement>find("Boitata.Fluxo.CartaoCrédito").click();
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.NumeroCartao").setText(parametros.get("AUT_NUMERO_CARTAO").toString());
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CartaoNome").setText(parametros.get("AUT_NOME_TITULAR").toString());
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.ValidadeCartao").setText(parametros.get("AUT_VALIDADE").toString());
//		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CodigoCartao").setText(parametros.get("AUT_CODIGO_CARTAO").toString());
//		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.FinalizarPagamento").click();
//				
	}

	public void autEcommerceClicaRetira(HashMap<String, Object> parametros) {
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setText(parametros.get("AUT_CODIGO_ITEM").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.RetiraNaLoja").click();
		AUT_AGENT_SILK4J.<DomLink>find("Boitata.Fluxo.RetirarAqui").click();
		
		AUT_AGENT_SILK4J.<DomLink>find("Boitata.Fluxo.FinalizarCompra").click();

		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.UtilizarOutroEnd").click();
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CEP").setText(parametros.get("AUT_CEP").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Bairro").setText(parametros.get("AUT_BAIRRO_ENDERECO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Rua").setText(parametros.get("AUT_RUA_ENDERECO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Numero").setText(parametros.get("AUT_NUMERO_ENDERECO").toString());

		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.ContinuarPagamento").click();

		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.NumeroCartao").setText(parametros.get("AUT_NUMERO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CartaoNome").setText(parametros.get("AUT_NOME_TITULAR").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.ValidadeCartao").setText(parametros.get("AUT_VALIDADE").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CodigoCartao").setText(parametros.get("AUT_CODIGO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.FinalizarPagamento").click();
	
	}
	
	

}
