package br.lry.components.va.cat017;

import java.util.HashMap;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;

public class AUTEcommerce extends AUTBaseComponent{

	

	public void autEcommercePedido(java.util.HashMap<String, Object> parametros) {
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setText(parametros.get("AUT_CODIGO_ITEM").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomLink>find("Boitata.Fluxo.ReceberEmCasa").click();

		AUT_AGENT_SILK4J.<DomLink>find("Boitata.Fluxo.FinalizarCompra").click();

		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.UtilizarOutroEnd").click();
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CEP").setText(parametros.get("AUT_CEP").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Bairro").setText(parametros.get("AUT_BAIRRO_ENDERECO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Rua").setText(parametros.get("AUT_RUA_ENDERECO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.Numero").setText(parametros.get("AUT_NUMERO_ENDERECO").toString());

		AUT_AGENT_SILK4J.<DomElement>find("Boitata.Fluxo.EntregaEconomica").click();
		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.ContinuarPagamento").click();

		AUT_AGENT_SILK4J.<DomElement>find("Boitata.Fluxo.CartaoCrédito").click();
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.NumeroCartao").setText(parametros.get("AUT_NUMERO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CartaoNome").setText(parametros.get("AUT_NOME_TITULAR").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.ValidadeCartao").setText(parametros.get("AUT_VALIDADE").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("Boitata.Fluxo.CodigoCartao").setText(parametros.get("AUT_CODIGO_CARTAO").toString());
		AUT_AGENT_SILK4J.<DomButton>find("Boitata.Fluxo.FinalizarPagamento").click();
		

		
		
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
