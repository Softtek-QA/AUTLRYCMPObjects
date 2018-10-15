package br.lry.components.va.cat007;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;

import br.lry.components.AUTVABaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTFluxoSaida extends AUTVABaseComponent{

	
	
	@Test
	public void autStartTest() {
		java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
		
		parametros.put("FLUXO_SAIDA", AUT_VA_FLUXO_SAIDA.values());
	}
	
	public enum AUT_VA_FLUXO_SAIDA{
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
		String turno = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_TURNO_PERIODO").toString();
		String horario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_VA_GERACAO_PEDIDOS, "AUT_TURNO_HORARIO").toString();
		
		
		try {
			if(parametros.get("FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.CAIXA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoCaixa").select();
			}
			else if(parametros.get("FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.ENTREGA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.Entrega").select();
				AUT_AGENT_SILK4J.<DomElement>find("VA02.FluxoSaida.ListaEndereco").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA02.FluxoSaida.PopUpFreteAdicional").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.Turno").select(turno.toString());
			} 
			else if(parametros.get("FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA.toString());
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA02.FluxoSaida.UsarDataMaisProxima").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.turno").select(horario.toString());
			}
			else if(parametros.get("FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_IMEDIATA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_IMEDIATA.toString());
			}
			else if(parametros.get("FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_IMEDIATA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_IMEDIATA.toString());
			}
			else if(parametros.get("FLUXO_SAIDA") == AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_AGENDADA) {
				AUT_AGENT_SILK4J.<DomRadioButton>find("VA02.FluxoSaida.OpcaoRetirada").select();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.FluxoSaida.TipoRetirada").select(AUT_VA_FLUXO_SAIDA.RETIRA_INTERNA_AGENDADA.toString());
				AUT_AGENT_SILK4J.<DomCheckBox>find("VA02.FluxoSaida.UsarDataMaisProxima").click();
				AUT_AGENT_SILK4J.<DomListBox>find("VA02.ConfirmacaoLogin.turno").select(horario.toString());
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
