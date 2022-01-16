package edu.iset.annonce.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Troquer implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String mail;
private String password;
private String nom;
private String prenom;
private String image;
private String action;

@OneToMany
private List<Annonce> annonce;





public Troquer() {
	super();
	// TODO Auto-generated constructor stub
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




public String getAction() {
	return action;
}



public void setAction(String action) {
	this.action = action;
}





public String getNom() {
	return nom;
}



public void setNom(String nom) {
	this.nom = nom;
}



public String getPrenom() {
	return prenom;
}



public void setPrenom(String prenom) {
	this.prenom = prenom;
}



public String getImage() {
	return image;
}



public void setImage(String image) {
	this.image = image;
}



@Override
public String toString() {
	return "Troquer [id=" + id + ", mail=" + mail + ", password=" + password + "]";
}




}
