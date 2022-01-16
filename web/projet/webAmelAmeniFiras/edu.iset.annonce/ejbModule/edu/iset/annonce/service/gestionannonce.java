package edu.iset.annonce.service;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.iset.annonce.entites.Annonce;

/**
 * Session Bean implementation class gestionannonce
 */
@Stateless
@LocalBean
public class gestionannonce implements gestionannonceRemote, gestionannonceLocal {

	
	
	
	 @PersistenceContext( unitName = "edu.iset.annonce" )
	    private EntityManager em;
	 
	 
	 
	 
	 @Override
		public void addAnnoce(Annonce a)
		{
			
			em.persist(a);
		}

		@Override
		public void updateAnnonce(Annonce a) {
			
			em.merge(a);
		}

		@Override
		public Annonce findaAnnonceByCin(int id) 
		{
			return em.find(Annonce.class, id);
		}

		
		@Override
		public Annonce findaAnnonceBycate(String categorie) 
		{
			return em.find(Annonce.class, categorie);
		}

		@Override
		public void delete(Annonce a)
		{
			em.remove(em.merge(a));
		}
		
		
		@Override
		public void remove(int id) {
			em.remove(findaAnnonceByCin(id) );
		}

	
		public List<Annonce> findAllAonnce()
		{
			
			
				Query et = em.createQuery("From Annonce a ");
					return et.getResultList();	
			
		}
		
		public List<Annonce> findcherche(String categorie)
		{
		Query query =em.createQuery( "FROM Annonce a where a.categorie =:c",Annonce.class);
		query.setParameter("c",categorie);
		return query.getResultList();
}
		
		public List<Annonce> findAll()
		{
		Query query =em.createQuery( "FROM Annonce a where a.categorie =:param1",Annonce.class);
		query.setParameter("param1","Femme");
		return query.getResultList();
}
	

    /**
     * Default constructor. 
     */
    public gestionannonce() {
        // TODO Auto-generated constructor stub
    }

}
