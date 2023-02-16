package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Vehicule {
	final private StringProperty imma;
	final private IntegerProperty numbus;
	final private StringProperty typebus;
	final private IntegerProperty nbrplc;
	final private StringProperty etat;
	final private StringProperty marque;
	final private StringProperty itineraire;
		
	
	public Vehicule( String imma,int numbus,String typebus, int nbrplc,String etat,String marque,String itineraire) {
		super();
		this.typebus =new  SimpleStringProperty(typebus);
		this.numbus =new SimpleIntegerProperty(numbus);
		this.nbrplc = new SimpleIntegerProperty(nbrplc);
		this.etat=new SimpleStringProperty(etat);
		this.imma = new SimpleStringProperty(imma);
		this.marque = new SimpleStringProperty(marque);
		this.itineraire = new SimpleStringProperty(itineraire);
	}
	public Vehicule() {
		super();
		this.typebus =new  SimpleStringProperty();
		this.numbus =new SimpleIntegerProperty();
		this.nbrplc = new SimpleIntegerProperty();
		this.imma = new SimpleStringProperty();
		this.etat=new SimpleStringProperty();
		this.itineraire = new SimpleStringProperty();
		this.marque = new SimpleStringProperty();
		
	}
	
	public final StringProperty immaProperty() {
		return this.imma;
	}
	
	public final String getImma() {
		return this.immaProperty().get();
	}
	
	public final void setImma(final String imma) {
		this.immaProperty().set(imma);
	}
	
	public final IntegerProperty numbusProperty() {
		return this.numbus;
	}
	
	public final int getNumbus() {
		return this.numbusProperty().get();
	}
	
	public final void setNumbus(final int numbus) {
		this.numbusProperty().set(numbus);
	}
	
	public final StringProperty typebusProperty() {
		return this.typebus;
	}
	
	public final String getTypebus() {
		return this.typebusProperty().get();
	}
	
	public final void setTypebus(final String typebus) {
		this.typebusProperty().set(typebus);
	}
	
	public final IntegerProperty nbrplcProperty() {
		return this.nbrplc;
	}
	
	public final int getNbrplc() {
		return this.nbrplcProperty().get();
	}
	
	public final void setNbrplc(final int nbrplc) {
		this.nbrplcProperty().set(nbrplc);
	}
	
	public final StringProperty etatProperty() {
		return this.etat;
	}
	
	public final String getEtat() {
		return this.etatProperty().get();
	}
	
	public final void setEtat(final String etat) {
		this.etatProperty().set(etat);
	}
	public final StringProperty marqueProperty() {
		return this.marque;
	}
	
	public final String getMarque() {
		return this.marqueProperty().get();
	}
	
	public final void setMarque(final String marque) {
		this.marqueProperty().set(marque);
	}
	
	public final StringProperty itineraireProperty() {
		return this.itineraire;
	}
	
	public final String getItineraire() {
		return this.itineraireProperty().get();
	}
	
	public final void setItineraire(final String itineraire) {
		this.itineraireProperty().set(itineraire);
	}
	
	
	
}
