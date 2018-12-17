/**
 * 
 */
package br.lry.components.sap;

import br.lry.components.AUTBaseComponent;
import br.lry.components.sap.AUTSAPBaseComponent.IAUTSAPProcessExecution;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
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
			
			sapFaturamentos.autSetExecutionMonitor(processMonitor);
			
			return (TSAPFaturamentos)sapFaturamentos;
		}
		else {
			return (TSAPFaturamentos)sapFaturamentos;
		}
	}
	
	
	public <TSAPFaturamentos extends br.lry.process.AUTSAP01Faturamentos> TSAPFaturamentos autSAPFaturarPedido(String pedido) {
		
		AUTSAP01Faturamentos sap = autSAPFaturamentos();
		java.util.HashMap<String,Object> parametrosOut = autGetDataFlow().autGetParameters(AUT_TABLE_PARAMETERS_NAMES.AUT_SAP_FATURAMENTO_ZOSDGCP);
		try {
		if(parametrosOut.containsKey("AUT_PEDIDO")) {
			parametrosOut.remove("AUT_PEDIDO");
			parametrosOut.put("AUT_PEDIDO",pedido);
		}
		else {
			parametrosOut.put("AUT_PEDIDO",pedido);
		}
		
		sap.autFaturarPedido(parametrosOut, new IAUTSAPProcessExecution() {
			
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
		});
		
		return (TSAPFaturamentos) sap;
		}
		catch(java.lang.Exception e) {
			autSAPFaturamentos().autSAPLogout();
			return null;
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
			sapConsultas.autSetExecutionMonitor(processMonitor);
			
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
