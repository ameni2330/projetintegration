package edu.iset.annonce.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Annonce implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String desciption ;
	private String categorie;
	private String image;
	private String Action;
	
	
	
	@ManyToOne
	private Troquer troquer;
	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Annonce(int id, String nom, String desciption, String categorie, String image) {
		super();
		this.id=id;
		this.nom = nom;
		this.desciption = desciption;
		this.categorie = categorie;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	




	public String getAction() {
		return Action;
	}



	public void setAction(String action) {
		Action = action;
	}



	@Override
	public String toString() {
		return "Annonce [id=" + id + ", nom=" + nom + ", desciption=" + desciption + ", categorie=" + categorie
				+ ", image=" + image + "]";
	}
	
	

}
