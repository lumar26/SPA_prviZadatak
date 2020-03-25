package main;

import labis.exception.LabisException;
import labis.stek.AStek;

public class Stek extends AStek{

	public Stek(int kapacitet) {
		super(kapacitet);
	}
	
	@Override
	public void ispisiStekObrnuto() throws LabisException {
		if(this == null) throw new LabisException();
		
		
		for (int i = 0; i < this.brojElemenata(); i++) {
			
		}
	}

}
