package crosswords.persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import crosswords.model.Scheme;

public class MyConfigReader implements ConfigReader{
	private Scheme board;
	private int size;
	
	public Scheme getBoard() {
		return board;
	}
	public int getSize() {
		return size;
	}
	public MyConfigReader(Reader reader) throws IOException, BadFileFormatException {
		if(reader==null) throw new NullPointerException();
		BufferedReader bf=new BufferedReader(reader);
		String line;
		line=bf.readLine().trim();
		this.size=parseFirstLine(line);
		this.board=parseOtherLines(bf);
 //VAFFANGUUUUULO
	}
	private int parseFirstLine(String line) throws BadFileFormatException {
		String[] tokens=line.split("//t");
		if(tokens.length!=2) throw new BadFileFormatException();
			if(!tokens[0].trim().equals("DIM")) throw new BadFileFormatException();
		
		String[] dim=tokens[1].split("x");
		int size;
		try {
			size=Integer.parseInt(dim[1].trim());
		}
		catch(NumberFormatException e) {
			throw new BadFileFormatException();
		}
		return size;
	}
	private Scheme parseOtherLines(BufferedReader reader) throws BadFileFormatException, IOException {
		if(reader==null) throw new NullPointerException("riga nullo");
		String line=reader.readLine();
		int row=0;
		Scheme board=new Scheme(this.getSize());
		while((line=reader.readLine().trim())!=null) {
			String[] tokens=line.split("//t");
			if(tokens.length!=this.getSize()) throw new BadFileFormatException();
			int[] tokensInt=new int[this.getSize()];
			for(int i=0; i<this.getSize(); i++) {
				if(tokens[i].equals("#")) {
					tokensInt[i]=0;
				}else try {
					tokensInt[i]=Integer.parseInt(tokens[i]);
				}catch(NumberFormatException e) {
					throw new BadFileFormatException();
				}

				
			}
			board.setCellRow(row, tokensInt);
			row++;
		
		}
		return board;
		
	}
	@Override
	public Scheme getScheme() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
