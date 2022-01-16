package edu.iset.annonce.service;

import java.util.List;

import javax.ejb.Remote;

import edu.iset.annonce.entites.Annonce;

@Remote
public interface gestionannonceRemote {
	public void addAnnoce(Annonce a);
	public void updateAnnonce(Annonce a);
	public Annonce findaAnnonceByCin(int id) ;
	public void delete(Annonce a);
	public void remove(int id);
	public Annonce findaAnnonceBycate(String categorie) ;
	public List<Annonce> findAllAonnce();
	public List<Annonce> findAll( );


}
