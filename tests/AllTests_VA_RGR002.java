package br.lry.components.tests;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega001_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega002_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega003_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega004_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega005_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega006_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega007_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega008_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega009_RGR002;
import br.lry.qa.rsp.pjttrc.entregas.AUTEntrega010_RGR002;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(com.borland.silktest.jtf.SilkTestSuite.class)
@SuiteClasses({
	AUTEntrega002_RGR002.class,
	AUTEntrega003_RGR002.class,
	AUTEntrega004_RGR002.class,
	AUTEntrega005_RGR002.class,
	AUTEntrega006_RGR002.class,
	AUTEntrega007_RGR002.class,
	AUTEntrega008_RGR002.class,
	AUTEntrega009_RGR002.class,
	AUTEntrega010_RGR002.class
	})
public class AllTests_VA_RGR002 {

}
