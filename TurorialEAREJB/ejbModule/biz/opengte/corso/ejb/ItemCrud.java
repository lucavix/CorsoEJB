package biz.opengte.corso.ejb;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import biz.opengte.corso.entities.Item;

@Stateless
@LocalBean
public class ItemCrud {
	
	@PersistenceContext(unitName = "MyDS")
	private EntityManager em;

//	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Item createNew(String description) {
//		if (description.endsWith("7")) throw new EJBException();
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
