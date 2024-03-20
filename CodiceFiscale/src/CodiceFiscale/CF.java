package CodiceFiscale;

public class CF {
	public static String calcolaCodiceFiscale(String nome, String cognome, String gg, 
			String mm, String yy, String comune, String sex) {
		String codice="";
		codice=codice+ calcolaCognome(cognome)+calcolaNome(nome)+calcolaAnno(yy)+calcolaMese(mm)+calcolaGiornoSesso(gg,sex)+calcolaComune(comune);
		codice=codice+calcolaCarControllo(codice);
		return codice;
	}
/*	public static Boolean verificaCodiceFiscale(String nome, String cognome, String gg, 
			String mm, String yy, String Comune, String sex, String codice) {
		
	}*/
	private static String calcolaCognome(String cognome) {
		int x=cognome.length();
		String vocali="aeiouAEIOU", cgn="";
		char lettera;
		for(int i=0; i<x;i++) {
			lettera=cognome.charAt(i);
			if((vocali.indexOf(lettera)==-1)&&(cgn.length()!=3)) {
				lettera= Character.toUpperCase(lettera);
				cgn= cgn + lettera;
			}
		}
		if(cgn.length()!=3) {
			for(int i=0; i<x;i++) {
				lettera=cognome.charAt(i);
				if((vocali.indexOf(lettera)!=-1)&&(cgn.length()!=3)) {
					lettera= Character.toUpperCase(lettera);
					cgn= cgn + lettera;
				}
			}
		}
		if(cgn.length()!=3) {
			while(cgn.length()!=3) {
				cgn=cgn + "X";
			}
		}
		return cgn;
	}
	private static String calcolaNome(String nome) {
		int x=nome.length();
		String vocali="aeiouAEIOU", nmo="";
		char lettera='x';
		int contaCons=0;
		for(int i=0; i<x;i++) {
			lettera=nome.charAt(i);
			if(vocali.indexOf(lettera)==-1) {
				contaCons++;
			}
		}
		if(contaCons>=4) {
			for(int i=0; i<x;i++) {
				lettera=nome.charAt(i);
				if((i!=1)&&(nmo.length()!=3)){
					if(vocali.indexOf(lettera)==-1) {
						lettera= Character.toUpperCase(lettera);
						nmo=nmo+lettera;
					}
				}
			}
		}
		else if(contaCons==3) {
			for(int i=0; i<x;i++) {
				lettera=nome.charAt(i);
				if(vocali.indexOf(lettera)==-1) {
					lettera= Character.toUpperCase(lettera);
					nmo=nmo+lettera;
				}
			}
		}
		else if(contaCons<3) {
			for(int i=0; i<x;i++) {
				lettera=nome.charAt(i);
				if(vocali.indexOf(lettera)==-1) {
					lettera= Character.toUpperCase(lettera);
					nmo=nmo+lettera;
				}
			}
			for(int i=0; i<x;i++) {
				lettera=nome.charAt(i);
				if((vocali.indexOf(lettera)!=-1)&&(nmo.length()!=3)) {
					lettera= Character.toUpperCase(lettera);
					nmo=nmo+lettera;
				}
			}
			while(nmo.length()<3) {
				nmo=nmo+'X';
			}
		}
		return nmo;
	}
	private static String calcolaAnno(String anno) {
		String ann="";
		if(anno.length()==4) {
			ann=ann+anno.charAt(2);
			ann=ann+anno.charAt(3);
		}
		else {
			ann=ann+"ErroreAnno";
		}
		return ann;
	}
	private static String calcolaMese(String mese) {
		int mmInt=Integer.parseInt(mese);
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String mse="";
		mse=mse+str.charAt(mmInt-1);
		return mse;
	}
	private static String calcolaGiornoSesso(String giorno, String sesso) {
		int ggInt=Integer.parseInt(giorno);
		String gg;
		if((sesso=="m")||(sesso=="M")) {
			if(ggInt<10) {
				gg="0"+ggInt;
			}
			else {
				gg=""+ggInt;
			}
		}
		else if((sesso=="f")||(sesso=="F")) {
			ggInt+=40;
			gg=""+ggInt;
		}
		else {
			return "ErroreGiorno";
		}
		return gg;
	}
	private static String calcolaComune(String comune) {
		return "A000";
	}
	private static String calcolaCarControllo(String codice) {
		int totale=0;
		for(int i=0; i<4;i+=2) {
			char x=codice.charAt(i);
			x=Character.toUpperCase(x);
			int j=0;
			while(x!="BAKPLCQDREVOSFTGUHMINJWZYX".charAt(j)) {
				j++;
			}
			totale+=j;
		}
		for(int i=1; i<5;i+=2) {
			char x=codice.charAt(i);
			x=Character.toUpperCase(x);
			int j=0;
			while(x!="ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(j)) {
				j++;
			}
			totale+=j;
		}
	return ""+"ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(totale%26);
	}
}
