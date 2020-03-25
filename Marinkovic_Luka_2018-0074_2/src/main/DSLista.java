package main;

import labis.cvorovi.CvorDSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;

public class DSLista extends ADSLista {

	@Override
	public void popuniListu() throws LabisException {
		if (this.prvi == null)
			throw new LabisException("Lista je prazna");
		if (this.prvi.sledeci == null)
			return;
		CvorDSListe pom = this.prvi;
		while (pom.sledeci != null) {
			pom = pom.sledeci;
			if (Math.abs(pom.podatak - pom.prethodni.podatak) > 1) {
				int zbi = Math.abs(pom.podatak - pom.prethodni.podatak);

				for (int i = 1; i < zbi; i++) {
					CvorDSListe novi = new CvorDSListe(pom.prethodni.podatak + 1, pom.prethodni, pom);
					pom.prethodni.sledeci = novi;
					pom.prethodni = novi;
				}
			}
		}
	}

	@Override
	public CvorDSListe elementUSredini() throws LabisException {
		if (this.prvi == null)
			throw new LabisException();
		if (this.prvi.sledeci == null)
			return this.prvi;
		
		CvorDSListe pom = prvi, dupliPom = prvi;
		while(dupliPom.sledeci != null && dupliPom.sledeci.sledeci != null) {
			pom = pom.sledeci;
			dupliPom = dupliPom.sledeci.sledeci;
		}
		return pom;
		
	}
}
