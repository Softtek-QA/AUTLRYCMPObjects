package br.lry.components.va.cat007;

import java.util.ArrayList;
import java.util.HashMap;

import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomCheckBox;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;

import br.lry.components.AUTVABaseComponent;
import br.lry.components.va.cat003.Item;


public class AUTFluxoSaidaItens extends AUTVABaseComponent {
	
	
	
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

	public AUTFluxoSaidaItens() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean autVAFluxoSaidaItens(java.util.HashMap<String, Object> parametros) {
		try {

			HashMap<Integer, ArrayList<Item>> item = Item.carregaItens();

			int quantidadeItens = (int) parametros.get("AUT_QUANTIDADE_ITENS");

			for (Integer kv : item.keySet()) {
				System.out.println("Key: " + kv);

				int contador = 0;

				for (Item material : item.get(kv)) {

					if (contador >= quantidadeItens) {
						break;
					}

					System.out.println("Item no looping" + material.getFluxoSaida().toString() + contador);

					if (material.getFluxoSaida().toString() == AUT_VA_FLUXO_SAIDA.CAIXA.toString()) {

						boolean statusListaEndereco = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("ListaEndereco", 10000);
						if (statusListaEndereco) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
							autInsertScreenByScenario();
						}

						boolean statusPopUpFrete = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("PopUpFreteAdicional", 10000);
						if (statusPopUpFrete) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
							autInsertScreenByScenario();
						}

						//start recording 
										
						AUT_AGENT_SILK4J.<DomRadioButton>find("VA.AtualizacaoDados.//INPUT[@id='itemcaixa-" + contador + "']").click();

						
						//end recording

						boolean statusListaEndereco1 = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("ListaEndereco", 10000);
						if (statusListaEndereco1) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
							autInsertScreenByScenario();
						}

						boolean statusPopUpFrete1 = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("PopUpFreteAdicional", 10000);
						if (statusPopUpFrete1) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
							autInsertScreenByScenario();
						}

						

					}

					if (material.getFluxoSaida().toString() == AUT_VA_FLUXO_SAIDA.ENTREGA.toString()) {

						boolean statusListaEndereco = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("ListaEndereco", 10000);
						if (statusListaEndereco) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
							autInsertScreenByScenario();
						}

						boolean statusPopUpFrete = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("PopUpFreteAdicional", 10000);
						if (statusPopUpFrete) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
							autInsertScreenByScenario();
						}


						AUT_AGENT_SILK4J.<DomRadioButton>find("VA.AtualizacaoDados.//INPUT[@id='itementrega-" + contador + "']").click();

						boolean statusListaEndereco1 = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("ListaEndereco", 10000);
						if (statusListaEndereco1) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
							autInsertScreenByScenario();
						}

						boolean statusPopUpFrete1 = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("PopUpFreteAdicional", 10000);
						if (statusPopUpFrete1) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
							autInsertScreenByScenario();
						}
						
						if (material.getTipoFrete() != null) {
							AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionType-" + contador + "']").select(material.getTipoFrete().toString());
						}
						
						if (material.getFilialEstoque() != null) {
							AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionDeposit-" + contador + "']").select(material.getFilialEstoque());

						}
						
						if (material.getFilialSaída() != null) {
							AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionExpedition-" + contador + "']").select(material.getFilialSaída());

						}
						
						if (material.getDepLoja() != null) {
							AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionWarehouse-" + contador + "']").select(material.getDepLoja());

						}
						
						if (material.isDataProxima() == true) {
							//AUT_AGENT_SILK4J.<DomCheckBox>find("VA.AtualizacaoDados.//INPUT[@id='nearDate-"+ contador +"-delivery']").click();

						}
						
						AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionShift-" + contador + "']").select(1);



		 			}

					if (material.getFluxoSaida().toString() == AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA.toString()) {

						boolean statusListaEndereco = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("ListaEndereco", 10000);
						if (statusListaEndereco) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
							autInsertScreenByScenario();
						}

						boolean statusPopUpFrete = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("PopUpFreteAdicional", 10000);
						if (statusPopUpFrete) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
							autInsertScreenByScenario();
						}

						AUT_AGENT_SILK4J.<DomRadioButton>find("VA.AtualizacaoDados.//INPUT[@id='itemretirada-" + contador + "']").click();

						boolean statusListaEndereco1 = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("ListaEndereco", 10000);
						if (statusListaEndereco1) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
							autInsertScreenByScenario();
						}

						boolean statusPopUpFrete1 = AUT_AGENT_SILK4J.<BrowserWindow>find("VA.FluxoSaida")
								.exists("PopUpFreteAdicional", 10000);
						if (statusPopUpFrete1) {
							AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
							autInsertScreenByScenario();
						}
						
						
						AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='withdrawalOptionType-" + contador + "']").select(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA.toString());

						
						
						if (material.getFilialEstoque() != null) {
							AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionDeposit-" + contador + "']").select(material.getFilialEstoque());

						}
						
						if (material.getFilialSaída() != null) {
							AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionExpedition-" + contador + "']").select(material.getFilialSaída());

						}
						
						if (material.getDepLoja() != null) {
							AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='deliveryOptionWarehouse-" + contador + "']").select(material.getDepLoja());

						}
						
						if (material.isDataProxima() == true) {
							//AUT_AGENT_SILK4J.<DomCheckBox>find("VA.AtualizacaoDados.//INPUT[@id='nearDate-"+ contador +"-retire']").click();
							
						}
						
						AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//SELECT[@id='withdrawalOptionTime-" + contador + "']").select(1);
						


					}

					contador++;

				}
			}

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}


	}

}
