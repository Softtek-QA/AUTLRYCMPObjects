package br.lry.components.tests;

import br.lry.components.AUTBaseComponent.*;
public class AUTTestStoreItens {

	public static class AUTTestStore extends br.lry.components.AUTBaseComponent.AUTStoreItem
	{
		
	}

	public AUTTestStoreItens() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AUTTestStore items = new AUTTestStore();				
		while(items.autGetNextItemStore(items.autGetFilterOptions().SELECT_ALL_ITEMS_WITH_ORDER_LIST) != null) {
			System.out.println(items);
		}
	}

}
