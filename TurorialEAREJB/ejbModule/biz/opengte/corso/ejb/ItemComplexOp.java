package biz.opengte.corso.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import biz.opengte.corso.entities.Item;

@Stateless
@LocalBean
public class ItemComplexOp {

	@EJB
	private ItemCrud itemCrud;
	
	public List<Item> complexOp(String suffix, Integer count) {
		List<Item> res = new ArrayList<Item>(count);
		
		for(int i=0;i<count;i++) {
			res.add(itemCrud.createNew(suffix + i));
		}
		
		return res;
	}
	
}
