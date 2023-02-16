package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

	final private StringProperty nomcli;
	final private IntegerProperty numtelcli;
	final private IntegerProperty numcnicli;
	final private IntegerProperty prixtick;
	final private IntegerProperty numTick;
	final private ObjectProperty<String> dateEnreg;
	final private StringProperty heureDepart;
	final private IntegerProperty numBus;
	final private StringProperty categorie;
	final private StringProperty destination;
	final private IntegerProperty numbg;
	
	
	public Client(String nomcli, Integer numtelcli, Integer numcnicli, int prixtick,
		int numTick, String dateEnreg,String heureDepart,String categorie,String destination,int numbg,int numBus) {
		super();
		this.nomcli =new  SimpleStringProperty(nomcli);
		this.numtelcli =new SimpleIntegerProperty(numtelcli);
		this.numcnicli = new SimpleIntegerProperty(numcnicli);
		this.prixtick = new SimpleIntegerProperty(prixtick);
		this.numTick = new SimpleIntegerProperty(numTick);
		this.dateEnreg = new SimpleObjectProperty<String>(dateEnreg);
		this.numBus = new SimpleIntegerProperty(numBus);
		this.categorie=new SimpleStringProperty(categorie);
		this.heureDepart=new SimpleStringProperty(heureDepart);
		this.destination=new SimpleStringProperty(destination);
		this.numbg = new SimpleIntegerProperty(numbg);
		
	}
	
	public Client() {
		super();
		this.nomcli =new  SimpleStringProperty();
		this.numtelcli =new SimpleIntegerProperty();
		this.numcnicli = new SimpleIntegerProperty();
		this.prixtick = new SimpleIntegerProperty();
		this.numTick = new SimpleIntegerProperty();
		this.dateEnreg = new SimpleObjectProperty<String>();
		this.numBus = new SimpleIntegerProperty();
		this.categorie=new SimpleStringProperty();
		this.heureDepart=new SimpleStringProperty();
		this.destination=new SimpleStringProperty();
		this.numbg =new SimpleIntegerProperty();
			}
	public final StringProperty nomcliProperty() {
		return this.nomcli;
	}
	

	public final String getnomcli() {
		return this.nomcliProperty().get();
	}
	

	public final void setnomcli(final String nomcli) {
		this.nomcliProperty().set(nomcli);
	}
	

	public final IntegerProperty numtelcliProperty() {
		return this.numtelcli;
	}
	

	public final int getnumtelcli() {
		return this.numtelcliProperty().get();
	}
	

	public final void setnumtelcli(final int numtelcli) {
		this.numtelcliProperty().set(numtelcli);
	}
	

	public final IntegerProperty numcnicliProperty() {
		return this.numcnicli;
	}
	

	public final int getnumcnicli() {
		return this.numcnicliProperty().get();
	}
	

	public final void setnumcnicli(final int numcnicli) {
		this.numcnicliProperty().set(numcnicli);
	}
	

	public final ObjectProperty<String> dateEnregProperty() {
		return this.dateEnreg;
	}
	

	public final String getdateEnreg() {
		return this.dateEnregProperty().get();
	}
	

	public final void setdateEnreg(final String dateEnreg) {
		this.dateEnregProperty().set(dateEnreg);
	}
	

	public final IntegerProperty prixtickProperty() {
		return this.prixtick;
	}
	

	public final int getprixtick() {
		return this.prixtickProperty().get();
	}
	

	public final void setprixtick(final int prixtick) {
		this.prixtickProperty().set(prixtick);
	}
	

	public final StringProperty heureDepartProperty() {
		return this.heureDepart;
	}
	

	public final String getheureDepart() {
		return this.heureDepartProperty().get();
	}
	

	public final void setheureDepart(final String heureDepart) {
		this.heureDepartProperty().set(heureDepart);
	}
	public final IntegerProperty numBusProperty() {
		return this.numBus;
	}
	

	public final int getnumBus() {
		return this.numBusProperty().get();
	}
	

	public final void setnumBus(final int numBus) {
		this.numBusProperty().set(numBus);
	}
	public final StringProperty categorieProperty() {
		return this.categorie;
	}
	

	public final String getcategorie() {
		return this.categorieProperty().get();
	}
	

	public final void setcategorie(final String categorie) {
		this.categorieProperty().set(categorie);
	}
	public final IntegerProperty numTickProperty() {
		return this.numTick;
	}
	

	public final int getnumTick() {
		return this.numTickProperty().get();
	}
	

	public final void setnumTick(final int numTick) {
		this.numTickProperty().set(numTick);
	}
	
	
	public final StringProperty destinationProperty() {
		return this.destination;
	}
	

	public final String getdestination() {
		return this.destinationProperty().get();
	}
	

	public final void setdestination(final String destination) {
		this.destinationProperty().set(destination);
	}
	public final IntegerProperty numbgProperty() {
		return this.numbg;
	}
	

	public final int getnumbg() {
		return this.numbgProperty().get();
	}
	

	public final void setnumbg(final int numbg) {
		this.numbgProperty().set(numbg);
	}
	

	
	
}
