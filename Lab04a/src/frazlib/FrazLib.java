package frazlib;

import frazione.Frazione;

public class FrazLib{
	public static Frazione sum(Frazione[] tutte) {
		Frazione f=new Frazione(0,1);
		for (int k=0; k<tutte.length && tutte[k]!= null; k++){
			 f=f.sum(tutte[k]);
			 }
		return f;
	}

	public static Frazione mul(Frazione[] tutte) {
		Frazione f=new Frazione(1,1);
		for (int k=0; k<tutte.length && tutte[k]!= null; k++){
			f=f.mul(tutte[k]);
			 }
		return f;
	}
}


