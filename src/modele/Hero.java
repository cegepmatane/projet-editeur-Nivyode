package modele;

import java.util.List;

import javafx.scene.paint.Color;
import modele.Animal.ANIMAL;
import utilitaire.Exportable;

public class Hero implements Exportable{
	public enum CASQUE {CASQUE1, CASQUE2, CASQUE3, CASQUE4, CASQUE5, }
	public enum ARMURE {ARMURE1, ARMURE2, ARMURE3, ARMURE4, ARMURE5, }
	public enum CAPE {CAPE1, CAPE2, CAPE3, CAPE4, CAPE5, }
	public enum BOTTES {BOTTES1, BOTTES2, BOTTES3, BOTTES4, BOTTES5}
	public enum BACKGROUND {BACKGROUND1, BACKGROUND2, BACKGROUND3, BACKGROUND4, BACKGROUND5}
	private CASQUE casqueActuel;
	private ARMURE armureActuelle;
	private CAPE capeActuelle;
	private BOTTES bottesActuelles;
	private BACKGROUND backgroundActuel;
	private String nom;
	private Color couleurNom;
	private List<Animal.ANIMAL> animals;
	
	private static Hero instance;
	
	
	public static Hero getInstance() {
		if(instance == null) {
		instance = new Hero();
		}
		return instance;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Color getCouleurNom() {
		return couleurNom;
	}
	public void setCouleurNom(Color couleurNom) {
		this.couleurNom = couleurNom;
	}
	public CASQUE getCasqueActuel() {
		return casqueActuel;
	}
	public void setCasqueActuel(CASQUE casqueActuel) {
		this.casqueActuel = casqueActuel;
	}
	public ARMURE getArmureActuelle() {
		return armureActuelle;
	}
	public void setArmureActuelle(ARMURE armureActuelle) {
		this.armureActuelle = armureActuelle;
	}
	public CAPE getCapeActuelle() {
		return capeActuelle;
	}
	public void setCapeActuelle(CAPE capeActuelle) {
		this.capeActuelle = capeActuelle;
	}
	public BOTTES getBottesActuelles() {
		return bottesActuelles;
	}
	public void setBottesActuelles(BOTTES bottesActuelles) {
		this.bottesActuelles = bottesActuelles;
	}
	public BACKGROUND getBackgroundActuel() {
		return backgroundActuel;
	}
	public void setBackgroundActuel(BACKGROUND backgroundActuel) {
		this.backgroundActuel = backgroundActuel;
	}
	public void ajouterAnimal(Animal.ANIMAL animal) {
		System.out.println("Animal ajouté " + animal.toString());
		this.animals.add(animal);
	}
	@Override
	public String exporterJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String exporterXML() {
		// TODO Auto-generated method stub
		String xml = "";
		xml+="<nom><titre>"+nom+"</titre>";
		xml+="<couleurNom>"+couleurNom.toString()+"</couleurNom></nom>";
		xml+= "<casque>"+casqueActuel.toString()+"</casque>";
		xml+="<armure>"+armureActuelle.toString()+"</armure>";
		xml+="<cape>"+capeActuelle.toString()+"</cape>";
		xml+="<bottes>"+bottesActuelles.toString()+"</bottes>";
		xml+="<background>"+backgroundActuel.toString()+"</background>";
		xml+="<animals>";
		for (Animal.ANIMAL animal : animals) {
			xml+="<animal>"+animal.toString()+"</animal>";
		}
		return xml;
	}
}
