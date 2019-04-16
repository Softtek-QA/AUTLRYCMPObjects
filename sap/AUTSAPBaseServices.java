/**
 * 
 */
package br.lry.components.sap;

import br.lry.components.AUTBaseComponent;
import br.lry.components.sap.AUTSAPBaseComponent.IAUTSAPProcessExecution;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.lry.process.AUTSAP01Faturamentos;
import br.lry.process.AUTSAPConferenciaPedido;
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
	br.lry.process.AUTSAPAtualizacaoUsuarioRF sapAtualizaUsuarioRF = null;
	br.lry.process.AUTSAPConferenciaPedido sapConfPed = null;


	/**
	 * 
	 * Retorna o objeto para gerenciamento de atualização
	 * 
	 * @return TSAPAtualizaUsuario - Componente sap para atualização de componente
	 * 
	 */
	public <TSAPAtualizaUsuario extends br.lry.process.AUTSAPAtualizacaoUsuarioRF> TSAPAtualizaUsuario autSAPConfigUsuarioRFLoja() {		
		if(sapAtualizaUsuarioRF == null) {			
			sapAtualizaUsuarioRF = new br.lry.process.AUTSAPAtualizacaoUsuarioRF();						

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

			sapAtualizaUsuarioRF.autSetExecutionMonitor(processMonitor);

			return (TSAPAtualizaUsuario)sapAtualizaUsuarioRF;			
		}
		else {			
			return (TSAPAtualizaUsuario)sapAtualizaUsuarioRF;				
		}
	}

	public <TSAPConfPedidos extends br.lry.process.AUTSAPConferenciaPedido> TSAPConfPedidos autConferenciasPedidos() {
		if(sapConfPed==null) {

			sapConfPed = new AUTSAPConferenciaPedido();


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

			sapConfPed.autSetExecutionMonitor(processMonitor);

			return (TSAPConfPedidos)sapConfPed;
		}
		else {
			return (TSAPConfPedidos)sapConfPed;
		}
	}


	public void autConfigUsuarioLojaFaturamento() {		
		AUTSAPBaseServices sap = new AUTSAPBaseServices();			
		java.util.HashMap<String,Object> parameters = new java.util.HashMap<String,Object>();

		parameters.put("USER_SAP", "51028487");
		parameters.put("PWD_SAP", "Auto5@2020");	
		parameters.put("AUT_LOJA", "035");
		parameters.put("AUT_FILA", "ARMAZENA");
		parameters.put("AUT_FORMATO", "16X20ITS");
		parameters.put("AUT_DOC_FORNECIMENTO", "800000109");
		parameters.put("INIT_TRANSACTION", true);
		
		sap.autSAPConfigUsuarioRFLoja().autInitProcess(parameters);
		sap.autConferenciasPedidos().autStartConf(parameters);			
	}

	

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
		Integer pedNum = Integer.parseInt(pedido.trim());
		AUTSAP01Faturamentos sap = autSAPFaturamentos();
		java.util.HashMap<String,Object> parametrosOut = autGetDataFlow().autGetParameters(AUT_TABLE_PARAMETERS_NAMES.AUT_SAP_FATURAMENTO_ZOSDGCP);
		try {
			if(parametrosOut.containsKey("AUT_PEDIDO")) {
				parametrosOut.remove("AUT_PEDIDO");
				parametrosOut.put("AUT_PEDIDO",pedNum);
			}
			else {
				parametrosOut.put("AUT_PEDIDO",pedNum);
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


	public <TSAPFaturamentos extends br.lry.process.AUTSAP01Faturamentos,TParameters extends java.util.HashMap<String,Object>> TSAPFaturamentos autSAPFaturarPedidoParametrosDinamicos(TParameters parameters) {
		Integer pedNum = Integer.parseInt(parameters.get("AUT_NUMERO_PEDIDO").toString());
		AUTSAP01Faturamentos sap = autSAPFaturamentos();
		
		try {
			if(parameters.containsKey("AUT_PEDIDO")) {
				parameters.remove("AUT_PEDIDO");
				parameters.put("AUT_PEDIDO",pedNum);
			}
			else {
				parameters.put("AUT_PEDIDO",pedNum);
			}

			sap.autFaturarPedido(parameters, new IAUTSAPProcessExecution() {

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

	
	public <TSAPFaturamentos extends br.lry.process.AUTSAP01Faturamentos> TSAPFaturamentos autSAPFaturarPedido(java.util.HashMap<String,Object> parameters) {
		Integer pedNum = Integer.parseInt(parameters.get("AUT_PEDIDO").toString());
		AUTSAP01Faturamentos sap = autSAPFaturamentos();

		try {
			if(parameters.containsKey("AUT_PEDIDO")) {
				parameters.remove("AUT_PEDIDO");
				parameters.put("AUT_PEDIDO",pedNum);
			}
			else {
				parameters.put("AUT_PEDIDO",pedNum);
			}

			sap.autFaturarPedido(parameters, new IAUTSAPProcessExecution() {

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
