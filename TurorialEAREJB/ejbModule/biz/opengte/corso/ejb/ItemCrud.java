package biz.opengte.corso.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import biz.opengte.corso.entities.Item;

@Stateless
@LocalBean
public class ItemCrud {
	
	@PersistenceContext(unitName = "MyDS")
	private EntityManager em;

	
	public Item createNew(String description) {
		Item i = new Item();
		i.setDescription(description);
		return em.merge(i);
	}
	
	public Item update(Long id, String description) {
		Item i = new Item(id,description);
		return em.merge(i);
	}
	
	public List<Item> list() {
		return em.createQuery("FROM Item",Item.class).getResultList();
	}
	
	 
}
