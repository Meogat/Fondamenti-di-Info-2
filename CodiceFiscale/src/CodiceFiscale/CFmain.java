package CodiceFiscale;

public class CFmain {
	public static void main(String[] args) {
		String nome="matteo";
		String cognome="gattobigio";
		String sesso="m";
		String giorno="23";
		String mese="04";
		String anno="2004";
		String comune="Castiglione Del Lago";
		String codice="";
		codice=codice+CF.calcolaCodiceFiscale(nome,cognome,giorno,mese,anno,comune,sesso);
		System.out.println("il codice è: " + codice);
	}
}
