package edu.iset.annonce.service;

import java.util.List;

import javax.ejb.Local;

import edu.iset.annonce.entites.admin2;


@Local
public interface gestionEtudiantLocal {
	public void addadmin(admin2 a);
	public void updateadmin(admin2 a);
	public admin2 findadminByCin(int cin) ;
	public void deleteAdmin(int cin);
	public List<admin2> findAllAdmin();
	public admin2 loginadmin(String mail, String password);
	public void deleteAdm(admin2 a);

}
