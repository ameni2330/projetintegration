package edu.iset.annonce.service;

import java.util.List;

import javax.ejb.Remote;

import edu.iset.annonce.entites.Troquer;

@Remote
public interface gestiontroquerRemote {
	public void addTroquer(Troquer t);
	public void updateTroquer(Troquer t);
	public Troquer findatroqByCin(int id) ;
	public void delete(Troquer t);
	public void remove(int id);
	public List<Troquer> findAlltr();

	public Troquer logintroqu(String mail, String password);

}
