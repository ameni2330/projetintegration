package edu.iset.annonce.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class admin2 implements Serializable{
@Id
private int cin;
private String mail;
private String password;
public admin2() {
	super();
	// TODO Auto-generated constructor stub
}

public admin2(int cin, String mail, String password) {
	super();
	this.cin = cin;
	this.mail = mail;
	this.password = password;
}

public int getCin() {
	return cin;
}
public void setCin(int cin) {
	this.cin = cin;
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
@Override
public String toString() {
	return "admin2 [cin=" + cin + ", mail=" + mail + ", password=" + password + "]";
}


}
