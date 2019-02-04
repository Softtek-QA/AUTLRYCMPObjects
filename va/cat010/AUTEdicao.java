package br.lry.components.va.cat010;

import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;

import java.util.HashMap;


import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;

public class AUTEdicao extends AUTVABaseComponent{

	String AUT_NUMERO_PEDIDO;
	String STATUS = "NA";
	
	public static enum AUT_STATUS_PESQUISA{
		ELIMINADO,
		DEVOLVIDO,
		CANCELADO;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ELIMINADO: {
				return "Eliminado";
			}
			
			case DEVOLVIDO: {
				return "Devolvido";
			}
			
			case CANCELADO: {
				return "Cancelado";
			}
			}
			return super.toString();
		}
	}
	
	
	public static enum AUT_MANTER_CONDICOES{
		SIM,
		NAO;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case SIM: {
				return "Sim";
			}
			
			case NAO: {
				return "Nao";
			}
			
			}
			return super.toString();
		}
	}

	
	public boolean autEdicaoPedido(HashMap<String, Object> parametros) {

		AUT_AGENT_SILK4J.<DomLink>find("VA.TelaInicialLoja.RecuperarPedido").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.IconeModoDePesquisa").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcaoPedido").select();
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.NumeroPedido").setText(parametros.get("AUT_NUMERO_PEDIDO").toString());
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaInicialLoja.ItemMassa").click();
		
		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.EditarPedido").click();

		return true;

	}
	
	public boolean autCopiaPedido(HashMap<String, Object> parametros) {


		AUT_AGENT_SILK4J.<DomLink>find("Boitata.Fluxo.BuscarPedidoBoitata").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.PesquisaClienteCadastrado.IconeModoDePesquisa").click();
		AUT_AGENT_SILK4J.<DomRadioButton>find("VA.TelaPedidos.OpcaoPedido").select();

	
		if (parametros.get("AUT_STATUS_PEDIDO").toString() != STATUS){
				AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.StatusPesq").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.Status").select(parametros.get("AUT_STATUS_PEDIDO").toString());
		}
		
		if (parametros.get("AUT_NUMERO_PEDIDO").toString() != STATUS){
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.NumeroPedido").setFocus();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPedidos.NumeroPedido").typeKeys(parametros.get("AUT_NUMERO_PEDIDO").toString());	
		}
		
				
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.PesquisaPedid").setFocus();
		AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.PesquisaPedid").click();
		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.CopiaPedido").click();
		
		if (parametros.get("AUT_CONDICOES_PEDIDO").toString() == AUT_MANTER_CONDICOES.SIM.toString()) {

			
			boolean status = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.AtualizacaoDados").exists("ManterCondicoes",10000);
			if(status) {
				
				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.ManterCondicoes").click();
			}

		}
		
		else if (parametros.get("AUT_CONDICOES_PEDIDO").toString() == AUT_MANTER_CONDICOES.NAO.toString()) {
			
			boolean status = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.AtualizacaoDados").exists("UtilizarPrecoVigente",10000);
			if(status) {
				
				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.UtilizarPrecoVigente").click();
			}
			
		}

		


		return true;

	}
		
}
