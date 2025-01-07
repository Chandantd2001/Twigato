package com.foodApplication.daoImpl;

import java.util.HashMap;
import java.util.Map;

import com.foodApplication.dao.CartDAO;
import com.foodApplication.model.CartItem;

public class Cart implements CartDAO{			//CartDAO Class
	
	private Map<Integer,CartItem> items=null;

	public Cart() {
		super();
		 this.items = new HashMap<>();
	}

	@Override
	public void addItem(CartItem item) {
		
		int itemId=item.getItemId();
//		System.out.println("itemid: "+itemId);
		
//		System.out.println(items.containsKey(itemId));
		if(items.containsKey(itemId)) {
//			System.out.println("updating");
			
			CartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity()+item.getQuantity());
			
		}
		else {
//			System.out.println("New");
			
			items.put(itemId, item);
//			System.out.println(items);
		}
		
	}

	@Override
	public void updateItem(int itemId, int quantity) {

			if(quantity<=0) 
			{
				items.remove(itemId);
			}
			else {
				items.get(itemId).setQuantity(quantity);
			}

	}
	
	@Override
	public void removeItem(int itemId) {
		items.remove(itemId);
	}
	
	@Override
	public Map<Integer,CartItem> getItems(){
		return items;
	}
	
	@Override
	public void removeAll() {
		items.clear();
	}
	
	

}
