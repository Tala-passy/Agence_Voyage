package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Chauffeur {
	final private IntegerProperty idch ;
	final private StringProperty nomch;
	final private StringProperty prch;
	final private IntegerProperty ntch;
	final private IntegerProperty imma;

	
	
	public Chauffeur(int idch, String nomch, String prch,int ntch,int imma) {
		super();
		this.nomch =new  SimpleStringProperty(nomch);
		this.idch =new SimpleIntegerProperty(idch);
		this.ntch = new SimpleIntegerProperty(ntch);
		this.prch=new SimpleStringProperty(prch);
		this.imma=new SimpleIntegerProperty(imma);
	}
	public Chauffeur() {
		super();
		this.nomch =new  SimpleStringProperty();
		this.idch =new SimpleIntegerProperty();
		this.ntch = new SimpleIntegerProperty();
		this.prch=new SimpleStringProperty();
		this.imma =new SimpleIntegerProperty();
	
	}
	public final StringProperty nomchProperty() {
		return this.nomch;
	}
	

	public final String getnomch() {
		return this.nomchProperty().get();
	}
	

	public final void setnomch(final String nomch) {
		this.nomchProperty().set(nomch);
	}
	

	public final IntegerProperty idchProperty() {
		return this.idch;
	}
	

	public final int getidch() {
		return this.idchProperty().get();
	}
	

	public final void setidch(final int idch) {
		this.idchProperty().set(idch);
	}
	

	public final IntegerProperty ntchProperty() {
		return this.ntch;
	}
	

	public final int getntch() {
		return this.ntchProperty().get();
	}
	

	public final void setntch(final int ntch) {
		this.ntchProperty().set(ntch);
	}
	
	public final StringProperty prchProperty() {
		return this.prch;
	}
	

	public final String getprch() {
		return this.prchProperty().get();
	}
	

	public final void setprch(final String prch) {
		this.prchProperty().set(prch);
	}
	public final IntegerProperty immaProperty() {
		return this.imma;
	}
	

	public final int getimma() {
		return this.immaProperty().get();
	}
	

	public final void setimma(final int imma) {
		this.immaProperty().set(imma);
	}
	
}
