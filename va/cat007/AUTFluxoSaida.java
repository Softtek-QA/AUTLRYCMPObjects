package br.lry.components.va.cat007;

import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import com.borland.silktest.jtf.common.types.ItemIdentifier;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;

import br.lry.components.AUTVABaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTFluxoSaida extends AUTVABaseComponent{

	

	/**
	 * Lista com as opções de fluxo de saída disponíveis a serem selecionados pelo sistema VA
	 * @author Softtek - QA
	 *
	 */
	
	
	public static enum AUT_VA_TIP_FRETE{
		ECONOMICA,
		EXPRESSA;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ECONOMICA: {
				return "ECONOMICA";
			}
			
			case EXPRESSA: {
				return "EXPRESSA";
			}
			}
			return super.toString();
		}
	}
	

	public static enum AUT_VA_TIPO_FRETE{
		NORMAL,
		EXPRESSA,
		VIAGEM;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case NORMAL: {
				return "NORMAL";
			}
			case EXPRESSA: {
				return "EXPRESSA";
			}
			case VIAGEM: {
				return "VIAGEM";
			}
			}
			return super.toString();
		}
	}
	
	
	public static enum AUT_VA_FLUXO_SAIDA{
		ENTREGA,
		ENCOMENDA,
		CAIXA,
		RETIRA_EXTERNA_AGENDADA,
		RETIRA_EXTERNA_IMEDIATA,
		RETIRA_INTERNA_AGENDADA,
		RETIRA_INTERNA_IMEDIATA;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ENTREGA: {
				return "Entrega";
			}
			case CAIXA: {
				return "Caixa";
			}
			case ENCOMENDA: {
				return "Encomenda";
			}
			case RETIRA_EXTERNA_AGENDADA: {
				return "Retira externa agendada";
			}
			case RETIRA_EXTERNA_IMEDIATA: {
				return "Retira externa imediata";
			}
			case RETIRA_INTERNA_AGENDADA: {
				return "Retira interna agendada";
			}
			case RETIRA_INTERNA_IMEDIATA: {
				return "Retira interna imediata";
			}
			}
			return super.toString();
		}
	}



	/**
	 * Seleção de Fluxo de Saída
	 * @param parametros - Seleção de tipo de fluxo de saída
	 * @return - Verdadeiro para fluxo de saída selecionado
	 */
	public boolean autSelecaoFluxoSaida(java.util.HashMap parametros) {
		try {
			
			//Verifica se  existe mensagem informando que  existem serviços para o item
			if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.AtualizacaoDados").exists("ProsseguirSemServico",5000)) {
				AUT_AGENT_SILK4J.<DomButton>find("VA.AtualizacaoDados.ProsseguirSemServico").click();
			}

			if(parametros.get("AUT_FLUXO_SAIDA").toString() ==  AUT_VA_FLUXO_SAIDA.CAIXA.toString()) {
				
				
				boolean statusListaEndereco = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida").exists("ListaEndereco",10000);
				if(statusListaEndereco) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
					autInsertScreenByScenario();
				}	
				
				boolean statusPopUpFrete = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida").exists("PopUpFreteAdicional",10000);
				if(statusPopUpFrete ) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
					autInsertScreenByScenario();
				}	
				
				boolean statusTurno = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.ConfirmacaoLogin").exists("Turno",10000);
				if(statusTurno ) {
					DomListBox listComboEntrega= AUT_AGENT_SILK4J.<DomListBox>find("VA.ConfirmacaoLogin.Turno");
					selectValor(listComboEntrega);	
					autInsertScreenByScenario();
				}	
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoCaixa").select();

			}
			else if(parametros.get("AUT_FLUXO_SAIDA").toString() == AUT_VA_FLUXO_SAIDA.ENTREGA.toString()) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.Entrega").select();
				
				if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida").exists("ListaEndereco",4000)) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
				}
				
				if(AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida").exists("PopUpFreteAdicional",4000)) {
					
					try {
						
						//Para cenários onde precisa selecionar frete adicional
						if (parametros.get("AUT_FRETE_ADICIONAL") != null  & parametros.get("AUT_FRETE_ADICIONAL").toString() == "SIM") {
							
							DomListBox listComboFrete = AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.SelecionarFrete");
							selectValor(listComboFrete);
		
							autInsertScreenByScenario();
							AUT_AGENT_SILK4J.<DomButton>find("VA.FluxoSaida.BotaoSalvar").click(); 												
						}
					} catch (Exception e) {
						// só pra tratar qdo dataflow não tiver campo AUT_FRETE_ADICIONAL
						AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
					}	
					
				}
				DomListBox listFilialEstoque = AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.FilialEstoque2");
				selectValor(listFilialEstoque,parametros.get("AUT_OPCAO_LOJA").toString());
				
				DomListBox listComboFrete= AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.ComboTipoFrete");
				selectValor(listComboFrete,parametros.get("AUT_TIPO_FRETE").toString());
				
				selectValor(AUT_AGENT_SILK4J.<DomListBox>find("VA.ConfirmacaoLogin.Turno"));
				  
			} 
			
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA) {
				
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA.toString());
				
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.FluxoSaida.UsarDataMaisProxima").click(); 
				
				DomListBox listFilialEstoque = AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.FilialEstoque");
				selectValor(listFilialEstoque,parametros.get("AUT_OPCAO_LOJA").toString());
		
				DomListBox listComboHorario = AUT_AGENT_SILK4J.<DomListBox>find("VA.ConfirmacaoLogin.Horario");
				selectValor(listComboHorario);
			}
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_IMEDIATA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_IMEDIATA.toString());
			}
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_IMEDIATA) {
				
				boolean janelaEndereco = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida").exists("ListaEndereco",5000);
				if(janelaEndereco) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
				}	
				
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_IMEDIATA.toString());
			}
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_AGENDADA) {

				boolean janelaEndereco = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida").exists("ListaEndereco",5000);
				if(janelaEndereco) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
				}	
				
				boolean statusPopUpFrete = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida").exists("PopUpFreteAdicional",10000);
				if(statusPopUpFrete ) {
					AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
					autInsertScreenByScenario();
				}	
				
				
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_AGENDADA.toString());
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.FluxoSaida.UsarDataMaisProxima").click();
				DomListBox listFilialEstoque = AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.FilialEstoque");
				selectValor(listFilialEstoque);							
				DomListBox listComboHorario = AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.ConfirmaLoginTurno");
				selectValor(listComboHorario);
			}
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.ENCOMENDA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA.toString());
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA.FluxoSaida.FlagEncomenda").click();
				DomListBox listComboHorario = AUT_AGENT_SILK4J.<DomListBox>find("VA.ConfirmacaoLogin.Horario");
				selectValor(listComboHorario);
			}
			AUT_AGENT_SILK4J.<DomButton>find("VA.FluxoSaida.Avancar").click();
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	

}
