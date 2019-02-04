package br.lry.components.va.cat003;


import java.util.ArrayList;
import java.util.HashMap;

import br.lry.components.va.cat007.AUTFluxoSaida;
import br.lry.components.va.cat007.AUTFluxoSaida.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.cat010.AUTDesconto;


public class Item {

	public Item() {
		// TODO Auto-generated constructor stub
	}


	private Integer codItem;
	private Integer quantidadeItem;
	private AUTFluxoSaida.AUT_VA_FLUXO_SAIDA fluxoSaida;
	private AUTFluxoSaida.AUT_VA_TIPO_FRETE tipoFrete;
	private String filialEstoque;
	private String filialSaída;
	private String depLoja;
	private boolean dataProxima;
	private AUTDesconto.AUT_TIPO_DESCONTO tipoDesconto;
	private Integer valorDesconto;
	private AUTDesconto.AUT_VA_MOTIVO motivoDesconto;
	
	
	
	public AUTDesconto.AUT_TIPO_DESCONTO getTipoDesconto() {
		return tipoDesconto;
	}


	public void setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}


	public Integer getValorDesconto() {
		return valorDesconto;
	}


	public void setValorDesconto(Integer valorDesconto) {
		this.valorDesconto = valorDesconto;
	}


	public AUTDesconto.AUT_VA_MOTIVO getMotivoDesconto() {
		return motivoDesconto;
	}


	public void setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO motivoDesconto) {
		this.motivoDesconto = motivoDesconto;
	}

	
	public boolean isDataProxima() {
		return dataProxima;
	}


	public void setDataProxima(boolean dataProxima) {
		this.dataProxima = dataProxima;
	}


	public AUTFluxoSaida.AUT_VA_TIPO_FRETE getTipoFrete() {
		return tipoFrete;
	}


	public void setTipoFrete(AUTFluxoSaida.AUT_VA_TIPO_FRETE tipoFrete) {
		this.tipoFrete = tipoFrete;
	}
	
	public String getFilialEstoque() {
		return filialEstoque;
	}


	public void setFilialEstoque(String filialEstoque) {
		this.filialEstoque = filialEstoque;
	}


	public String getFilialSaída() {
		return filialSaída;
	}


	public void setFilialSaída(String filialSaída) {
		this.filialSaída = filialSaída;
	}


	public String getDepLoja() {
		return depLoja;
	}


	public void setDepLoja(String depLoja) {
		this.depLoja = depLoja;
	}
	
	public Integer getCodItem() {
		return codItem;
	}
	
	
	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}
	
	
	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}
	
	
	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	
	public AUTFluxoSaida.AUT_VA_FLUXO_SAIDA getFluxoSaida() {
		return fluxoSaida;
	}


	public void setFluxoSaida(AUTFluxoSaida.AUT_VA_FLUXO_SAIDA fluxoSaida) {
		this.fluxoSaida = fluxoSaida;
	}
	
	
	public static HashMap<Integer, ArrayList<Item>> carregaItens() {

		
			
		Item cimento = new Item();
		cimento.setCodItem(89368790);
		cimento.setQuantidadeItem(2);
		cimento.setFluxoSaida(AUT_VA_FLUXO_SAIDA.ENTREGA);
		cimento.setTipoFrete(AUTFluxoSaida.AUT_VA_TIPO_FRETE.NORMAL);
		cimento.setDataProxima(true);
		cimento.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.REAIS);
		cimento.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		cimento.setValorDesconto(1);
		
		
		Item prego = new Item();
		prego.setCodItem(86607542);
		prego.setQuantidadeItem(2);
		prego.setFluxoSaida(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA);	
		prego.setTipoFrete(AUTFluxoSaida.AUT_VA_TIPO_FRETE.VIAGEM);
		prego.setDataProxima(true);
		prego.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.PORCENTAGEM);
		prego.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		prego.setValorDesconto(1);
		
		
		Item argamassa = new Item();
		argamassa.setCodItem(89388663);
		argamassa.setQuantidadeItem(2);
		argamassa.setFluxoSaida(AUT_VA_FLUXO_SAIDA.ENTREGA);
		argamassa.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.REAIS);
		argamassa.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		argamassa.setValorDesconto(1);
		
		Item compressor = new Item();
		compressor.setCodItem(89407066);
		compressor.setQuantidadeItem(3);
		compressor.setFluxoSaida(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA);
		compressor.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.PORCENTAGEM);
		compressor.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		compressor.setValorDesconto(1);
		
		
		Item rejunte = new Item();
		rejunte.setCodItem(89174582);
		rejunte.setQuantidadeItem(2);
		rejunte.setFluxoSaida(AUT_VA_FLUXO_SAIDA.ENTREGA);	
		rejunte.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.REAIS);
		rejunte.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		rejunte.setValorDesconto(1);
		

		Item lampada = new Item();
		lampada.setCodItem(89718202);
		lampada.setQuantidadeItem(2);
		lampada.setFluxoSaida(AUT_VA_FLUXO_SAIDA.CAIXA);
		lampada.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.PORCENTAGEM);
		lampada.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		lampada.setValorDesconto(1);
		

		Item tinta = new Item();
		tinta.setCodItem(88206692);
		tinta.setQuantidadeItem(2);
		tinta.setFluxoSaida(AUT_VA_FLUXO_SAIDA.RETIRA_EXTERNA_AGENDADA);
		tinta.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.REAIS);
		tinta.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		tinta.setValorDesconto(1);
		
		
		Item pincel = new Item();
		pincel.setCodItem(89433743);
		pincel.setQuantidadeItem(2);
		pincel.setFluxoSaida(AUT_VA_FLUXO_SAIDA.CAIXA);	
		pincel.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.REAIS);
		pincel.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		pincel.setValorDesconto(1);
		
				
		Item broca = new Item();
		broca.setCodItem(89358885);
		broca.setQuantidadeItem(2);
		broca.setFluxoSaida(AUT_VA_FLUXO_SAIDA.CAIXA);	
		broca.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.REAIS);
		broca.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		broca.setValorDesconto(1);
		
		
		Item parafuso = new Item();
		parafuso.setCodItem(89353075);
		parafuso.setQuantidadeItem(2);
		parafuso.setFluxoSaida(AUT_VA_FLUXO_SAIDA.ENTREGA);	
		parafuso.setTipoDesconto(AUTDesconto.AUT_TIPO_DESCONTO.PORCENTAGEM);
		parafuso.setMotivoDesconto(AUTDesconto.AUT_VA_MOTIVO.SALDO);
		parafuso.setValorDesconto(1);
		
		
		ArrayList<Item> teste = new ArrayList<Item>();
		
		teste.add(cimento);
		teste.add(prego);
		teste.add(argamassa);
		teste.add(compressor);
		teste.add(rejunte);
		teste.add(lampada);
		teste.add(tinta);
		teste.add(pincel);
		teste.add(broca);
		teste.add(parafuso);
		teste.add(cimento);
		teste.add(prego);
		teste.add(argamassa);
		teste.add(compressor);
		teste.add(rejunte);
		teste.add(lampada);
		teste.add(tinta);
		teste.add(pincel);
		teste.add(broca);
		teste.add(parafuso);
		teste.add(cimento);
		teste.add(prego);
		teste.add(argamassa);
		teste.add(compressor);
		teste.add(rejunte);
		teste.add(lampada);
		teste.add(tinta);
		teste.add(pincel);
		teste.add(broca);
		teste.add(parafuso);
		teste.add(cimento);
		teste.add(prego);
		teste.add(argamassa);
		teste.add(compressor);
		teste.add(rejunte);
		teste.add(lampada);
		teste.add(tinta);
		teste.add(pincel);
		teste.add(broca);
		teste.add(parafuso);

		
		java.util.HashMap<Integer,ArrayList<Item>> item = new java.util.HashMap<Integer,ArrayList<Item>>();
		
		item.put(1, teste);
		
		return item;
		
	}
	
	
}
