package edu.iset.annonce.service;

import java.util.List;

import javax.ejb.Local;

import edu.iset.annonce.entites.evenement;

@Local
public interface gestionevemLocal {
	public void addEvenement(evenement e);
	public void updateEvenement(evenement e) ;
	public evenement findaEvenementByCin(int id) ;
	public void delete(evenement e);
	public void remove(int id);

	public List<evenement> findAllEvenem();
	public List<evenement> findAll( String action);


}
