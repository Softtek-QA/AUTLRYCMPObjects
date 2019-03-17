package br.lry.components.tests;

import org.junit.Test;

import br.stk.framework.tests.AUTFWKTestObjectBase.AUTTestFlowManager.AUTTestProcessDefinition;

public class AUTTestesNewScenarios {

	public class AUTCenarioTest extends AUTTestProcessDefinition{

		@Override
		public boolean autInitProcess() {
			// TODO Auto-generated method stub
			return super.autInitProcess();
		}

		@Override
		public boolean autStartProcess() {
			// TODO Auto-generated method stub
			System.out.println("AUT INFO: START PROCESS BY AUTOMATION PROCESS ***********");
			//return super.autStartProcess();
			return true;
		}

		@Override
		public boolean autEndProcess() {
			// TODO Auto-generated method stub
			return super.autEndProcess();
		}

		@Override
		public boolean autSyncronizeProcess() {
			// TODO Auto-generated method stub
			return super.autSyncronizeProcess();
		}

		@Override
		public boolean autStartParalelProcess() {
			// TODO Auto-generated method stub
			return super.autStartParalelProcess();
		}
		

		public void autStartScenario() {
			autGetCurrentListProcessDefinitions().put("AUT_START_SCENARIO000001", this);
			autGetCurrentListProcessDefinitions().put("AUT_START_SCENARIO000002", this);
			autGetCurrentListProcessDefinitions().put("AUT_START_SCENARIO000003", this);
			
			autStartAllProcessExecutionFlow();
			//autGetCurrentListProcessDefinitions().put("AUT_START_SCENARIO000001", this);
		}		
	}
	
	@Test
	public void autStartProcess() {
		AUTCenarioTest prcDef = new AUTCenarioTest();
		prcDef.autStartScenario();		
	}
	public AUTTestesNewScenarios() {
		// TODO Auto-generated constructor stub
		
	}

}
