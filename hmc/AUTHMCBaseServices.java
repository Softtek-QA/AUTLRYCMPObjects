/**
 * 
 */
package br.lry.components.hmc;

import br.lry.components.AUTBaseComponent;

/**
 * 
 * Gerenciamento integrações
 * 
 * @author Softtek-QA
 *
 */
public class AUTHMCBaseServices extends AUTBaseComponent {	
	br.lry.components.hmc.AUTHMCCadastros hmcCads = null;		
	public <THMCCadastros extends br.lry.components.hmc.AUTHMCCadastros> THMCCadastros autHMCCadastros() {
		if(hmcCads==null) {						
			hmcCads = new AUTHMCCadastros();
			
			return (THMCCadastros)hmcCads;
		}
		else {
			return (THMCCadastros)hmcCads;
		}
	}
	
	/**
	 * 
	 */
	public AUTHMCBaseServices() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param syncronizeDataFlow
	 */
	public AUTHMCBaseServices(boolean syncronizeDataFlow) {
		super(syncronizeDataFlow);
		// TODO Auto-generated constructor stub
	}

}
