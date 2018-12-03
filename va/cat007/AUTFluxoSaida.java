package br.lry.components.va.cat007;

import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import com.borland.silktest.jtf.common.types.ItemIdentifier;
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
	public static enum AUT_VA_FLUXO_SAIDA{
		ENTREGA,
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

			if(parametros.get("AUT_FLUXO_SAIDA").toString() ==  AUT_VA_FLUXO_SAIDA.CAIXA.toString()) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoCaixa").select();
			}
			else if(parametros.get("AUT_FLUXO_SAIDA").toString() == AUT_VA_FLUXO_SAIDA.ENTREGA.toString()) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.Entrega").select();
				AUT_AGENT_SILK4J.<DomElement>find("VA02.FluxoSaida.ListaEndereco").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA02.FluxoSaida.PopUpFreteAdicional").click();
				DomListBox listComboEntrega= AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.Turno");
				selectValor(listComboEntrega);
			} 
			
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA.toString());
				
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA02.FluxoSaida.UsarDataMaisProxima").click();

				DomListBox listComboFilialEstoque = AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.FilialEstoque");
				selectValor(listComboFilialEstoque);
				
				DomListBox listComboHorario = AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.Horario");
				selectValor(listComboHorario);
			}
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_IMEDIATA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_IMEDIATA.toString());
			}
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_IMEDIATA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_IMEDIATA.toString());
			}
			else if(parametros.get("AUT_FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_AGENDADA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_AGENDADA.toString());
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA02.FluxoSaida.UsarDataMaisProxima").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.turno").select(parametros.get("AUT_HORARIO").toString());
			}
			AUT_AGENT_SILK4J.<DomButton>find("VA02.FluxoSaida.Avancar").click();
			return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	

}
