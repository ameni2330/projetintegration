package edu.iset.annonce.service;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.iset.annonce.entites.admin2;

/**
 * Session Bean implementation class gestionEtudiant
 */
@Stateless
@LocalBean
public class gestionEtudiant implements gestionEtudiantRemote, gestionEtudiantLocal {

	
	 @PersistenceContext( unitName = "edu.iset.annonce" )
	    private EntityManager em;
	    
	 
	 
	 @Override
		public void addadmin(admin2 a)
		{
			
			em.persist(a);
		}

		@Override
		public void updateadmin(admin2 a) {
			
			em.merge(a);
		}

		@Override
		public admin2 findadminByCin(int cin) 
		{
			return em.find(admin2.class, cin);
		}

		@Override
		public void deleteAdmin(int cin)
		{
			em.remove(em.merge(cin));
		}
		
		@Override
		public void deleteAdm(admin2 a)
		{
			em.remove(em.merge(a));
		}
		
		 int nb=0;
		public List<admin2> findAllAdmin()
		{
				Query et = em.createQuery("From Admin2 a");
					return et.getResultList();									
		}
		@Override
		public admin2 loginadmin(String mail, String password)
		{
			try {
			Query req=em.createQuery("select a from admin2 a where a.mail=:m AND a.password=:p");
					req.setParameter("m",mail);
					req.setParameter("p",password);
					return  (admin2) req.getSingleResult();
			}
			catch (Exception e)
			{
				return null;
			}
		}
    /**
     * Default constructor. 
     */
    public gestionEtudiant() {
        // TODO Auto-generated constructor stub
    }

}
