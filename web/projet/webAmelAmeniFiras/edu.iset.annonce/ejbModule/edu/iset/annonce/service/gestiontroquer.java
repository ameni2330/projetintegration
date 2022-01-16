package edu.iset.annonce.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import edu.iset.annonce.entites.Troquer;

/**
 * Session Bean implementation class gestiontroquer
 */
@Stateless
@LocalBean
public class gestiontroquer implements gestiontroquerRemote, gestiontroquerLocal {

	
	
	
	 @PersistenceContext( unitName = "edu.iset.annonce" )
	    private EntityManager em;
	 
	 @Override
		public void addTroquer(Troquer t)
		{
			
			em.persist(t);
		}
	 
	 
		@Override
		public void updateTroquer(Troquer t) {
			
			em.merge(t);
		}
		
		@Override
		public Troquer findatroqByCin(int id) 
		{
			return em.find(Troquer.class, id);
		}

		@Override
		public void delete(Troquer t)
		{
			em.remove(em.merge(t));
		}
		
		
		@Override
		public void remove(int id) {
			em.remove(findatroqByCin(id) );
		}

	
		public List<Troquer> findAlltr()
		{
			
				Query et = em.createQuery("From Troquer a ");
				
					return et.getResultList();	
			
		}
	 
		public Troquer logintroqu(String mail, String password)
		{
			try {
			Query req=em.createQuery("select a from Troquer a where a.mail=:m AND a.password=:p");
					req.setParameter("m",mail);
					req.setParameter("p",password);
					return  (Troquer) req.getSingleResult();
			}
			catch (Exception e)
			{
				return null;
			}
		}
    /**
     * Default constructor. 
     */
    public gestiontroquer() {
        // TODO Auto-generated constructor stub
    }

}
