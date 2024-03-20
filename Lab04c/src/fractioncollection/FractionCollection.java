package fractioncollection;
import frazione.Frazione;

public class FractionCollection {
	private static final int DEFAULT_GROWTH_FACTOR = 2;
	private static final int DEFAULT_PHYSICAL_SIZE = 10;
	private static Frazione[] innerContainer;
	private int size;
	public FractionCollection() {
		innerContainer = new Frazione[DEFAULT_PHYSICAL_SIZE];
		size = 0;
	}
	public FractionCollection(int physicalSize) {
		innerContainer = new Frazione[physicalSize];
		size = 0;
	}
	public FractionCollection(Frazione[] collection) {
		innerContainer = new Frazione[collection.length];
		for (Frazione frazione : collection) {
			if (frazione != null) {
				innerContainer[size] = frazione;
				size++;
			}
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public Frazione get(int x) {
		return innerContainer[x];
	}
	
	public void put(Frazione f) {
		int x=0;
		while(innerContainer[x]!=null) {
			x++;
		}
		if(x!=this.size) {
			innerContainer[x]=f;
		}
		else {
			FractionCollection f1 = new FractionCollection(DEFAULT_GROWTH_FACTOR*this.size);
			for(int i=0; i<this.size;i++) {
				f1.innerContainer[i]=innerContainer[i];
			} f1.innerContainer[x]=f;
			x=0;
			while(f1.innerContainer[x]!=null) {
				innerContainer[x]=f1.innerContainer[x];
				x++;
			}	
		}
	}
	
	public void remove(int n) {
		int x=0;
		while(innerContainer[x]!=null) {
			x++;
		}
		if(x!=n) {
			for(;n<x;n++) {
				innerContainer[n]=innerContainer[n+1];
			}
		}
		else {
			for(;n<x-1;n++) {
				innerContainer[n]=innerContainer[n+1];
			}
			innerContainer[x]=null;
		}
	}
	
	public String toString() {
		int x=0;
		while(innerContainer[x]!=null) {
			x++;
		}
		String str="[";
		for(int i=0; i<x-1; i++) {
			str = str + innerContainer[i].getNum() + "/" + innerContainer[i].getDen() + ",";
		}
		str = str + innerContainer[x].getNum() + "/" + innerContainer[x].getDen() + "]";
		return str;
	}
	
	public FractionCollection sum(FractionCollection collection) {
		if(this.size()!=collection.size()) {return null;}
		else {
			FractionCollection f= new FractionCollection(collection.size());
			for(int i=0; i<collection.size(); i++) {
				f.put(innerContainer[i].sum(collection.innerContainer[i]));
			}
		return f;
		}
	}
	
	public FractionCollection div(FractionCollection collection) {
		if(this.size()!=collection.size()) {return null;}
		else {
			FractionCollection f= new FractionCollection(collection.size());
			for(int i=0; i<collection.size(); i++) {
				f.put(innerContainer[i].div(collection.innerContainer[i]));
			}
		return f;
		}
	}
	
	public FractionCollection mul(FractionCollection collection) {
		if(this.size()!=collection.size()) {return null;}
		else {
			FractionCollection f= new FractionCollection(collection.size());
			for(int i=0; i<collection.size(); i++) {
				f.put(innerContainer[i].mul(collection.innerContainer[i]));
			}
		return f;
		}
	}
	
	public FractionCollection sub(FractionCollection collection) {
		if(this.size()!=collection.size()) {return null;}
		else {
			FractionCollection f= new FractionCollection(collection.size());
			for(int i=0; i<collection.size(); i++) {
				f.put(innerContainer[i].sub(collection.innerContainer[i]));
			}
		return f;
		}
	}
}






