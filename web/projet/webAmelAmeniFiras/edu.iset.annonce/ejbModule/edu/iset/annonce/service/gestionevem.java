package edu.iset.annonce.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.iset.annonce.entites.Annonce;
import edu.iset.annonce.entites.evenement;

/**
 * Session Bean implementation class gestionevem
 */
@Stateless
@LocalBean
public class gestionevem implements gestionevemRemote, gestionevemLocal {

	
	 @PersistenceContext( unitName = "edu.iset.annonce" )
	    private EntityManager em;
	 
	 
	 
	 
	 @Override
		public void addEvenement(evenement e)
		{
			
			em.persist(e);
		}

		@Override
		public void updateEvenement(evenement e) {
			
			em.merge(e);
		}

		@Override
		public evenement findaEvenementByCin(int id) 
		{
			return em.find(evenement.class, id);
		}

		@Override
		public void delete(evenement e)
		{
			em.remove(em.merge(e));
		}
		
		
		@Override
		public void remove(int id) {
			em.remove(findaEvenementByCin(id) );
		}

	
		public List<evenement> findAllEvenem()
		{
			
			
				Query et = em.createQuery("From evenement e");
			
				return et.getResultList();
					
					
					
			
		}
		
		
		public List<evenement> findAll( String action)
		{
		Query query =em.createQuery( "FROM evenement a WHERE a.Action = :m");
		query.setParameter("m",action);
		return query.getResultList();
}
	
    /**
     * Default constructor. 
     */
    public gestionevem() {
        // TODO Auto-generated constructor stub
    }

}
