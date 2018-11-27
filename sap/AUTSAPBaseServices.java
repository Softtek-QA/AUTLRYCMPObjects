/**
 * 
 */
package br.lry.components.sap;

import br.lry.components.AUTBaseComponent;
import br.lry.components.sap.AUTSAPBaseComponent.IAUTSAPProcessExecution;
import br.lry.process.AUTSAP01Faturamentos;
import br.lry.process.AUTSAPConsultaEstoque;

/**
 * Gerencia os componentes automatizados do SAP dentro do escopo do projeto raíz
 * 
 * @author Softtek-QA
 *
 */
public class AUTSAPBaseServices extends AUTBaseComponent {
	br.lry.process.AUTSAP01Faturamentos sapFaturamentos = null;
	br.lry.process.AUTSAPConsultaEstoque sapConsultas = null;
	
	public <TSAPFaturamentos extends br.lry.process.AUTSAP01Faturamentos> TSAPFaturamentos autSAPFaturamentos() {
		if(sapFaturamentos==null) {
			sapFaturamentos = new br.lry.process.AUTSAP01Faturamentos();
			return (TSAPFaturamentos)sapFaturamentos;
		}
		else {
			return (TSAPFaturamentos)sapFaturamentos;
		}
	}
	
	/**
	 * 
	 * Componente para consulta de estoques
	 * 
	 * @return TSAPEstoques - Componente para consulta de estoque
	 * 
	 */
	public <TSAPEstoques extends br.lry.process.AUTSAPConsultaEstoque> TSAPEstoques autSAPEstoques() {
		if(sapConsultas==null) {
			IAUTSAPProcessExecution processMonitor = new IAUTSAPProcessExecution() {
				
				@Override
				public void autProcessExecution() {
					// TODO Auto-generated method stub
					autInsertScreenByScenario();
				}
				
				@Override
				public void autParallelProcess() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void autInitProcess() {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void autEndProcess() {
					// TODO Auto-generated method stub
					
				}
			};
			sapConsultas = new AUTSAPConsultaEstoque();
			return (TSAPEstoques)sapConsultas;
		}
		else {
			return (TSAPEstoques)sapConsultas;
		}
	}
	
	
	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSAPBaseServices() {
		// TODO Auto-generated constructor stub
	}

}
