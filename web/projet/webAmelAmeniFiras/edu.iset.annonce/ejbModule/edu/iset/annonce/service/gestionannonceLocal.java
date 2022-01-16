package edu.iset.annonce.service;

import java.util.List;

import javax.ejb.Local;

import edu.iset.annonce.entites.Annonce;

@Local
public interface gestionannonceLocal {
	public void addAnnoce(Annonce a);
	public void updateAnnonce(Annonce a);
	public Annonce findaAnnonceByCin(int id) ;
	public void delete(Annonce a);
	public void remove(int id);
	public Annonce findaAnnonceBycate(String categorie) ;
	public List<Annonce> findAllAonnce();


}
