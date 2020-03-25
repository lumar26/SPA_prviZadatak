package main;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;
import labis.test.ListGenerator;

public class JSLista extends AJSLista {

	@Override
	public int izbaciTrenutni(CvorJSListe t) throws LabisException {
		if (this.prvi == null)
			throw new LabisException();
		if (t == this.prvi) {
			this.prvi = null;
			return t.podatak;
		}
		CvorJSListe pom = this.prvi;
		while (pom.sledeci != null && t != pom.sledeci) {
			pom = pom.sledeci;
		}
		pom.sledeci = pom.sledeci.sledeci;
		return t.podatak;
	}

	@Override
	public void invertovanjeSaPomocnom() throws LabisException {
		if (this.prvi == null)
			throw new LabisException();
		if (this.prvi.sledeci == null)
			return;
		CvorJSListe prethodni = null, trenutni = this.prvi, predstojeci = null;
		while (trenutni != null) {
			predstojeci = trenutni.sledeci;
			trenutni.sledeci = prethodni;
			prethodni = trenutni;
			trenutni = predstojeci;
		}
		this.prvi = prethodni;

	}

	@Override
	public int zbirElemenataUCiklicnoj() throws LabisException {
		if (this.prvi == null)
			throw new LabisException();
		if (this.prvi.sledeci == this.prvi)
			return this.prvi.podatak;
		CvorJSListe pom = this.prvi;
		int suma = 0;
		while (pom.sledeci != this.prvi) {
			suma += pom.podatak;
			pom = pom.sledeci;
		}
		suma += pom.podatak;
		return suma;
	}

	@Override
	public void ispisiObrnuto(CvorJSListe prvi) throws LabisException {
		if (prvi == null) {
			return;
		}
		ispisiObrnuto(prvi.sledeci);
		System.out.print(prvi.podatak + "\t");
	}
	
	@Override
	public CvorJSListe klonirajRekurzivno(CvorJSListe pom) throws LabisException {
		if (pom == null)
			return null;
		return new CvorJSListe(pom.podatak, klonirajRekurzivno(pom.sledeci));
		
	}


	public static void main(String[] args) {
		JSLista lista = new JSLista();
		JSLista lista2 = new JSLista();

		ListGenerator.napraviJSListuCommon(lista, new int[] { 1, 4, 7, 4, 6 }, false);
		try {
			lista2.prvi = lista.klonirajRekurzivno(lista.prvi);
		} catch (LabisException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			lista.ispisiObrnuto(lista.prvi);
			System.out.println();
			lista2.ispisiObrnuto(lista2.prvi);
		} catch (LabisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
