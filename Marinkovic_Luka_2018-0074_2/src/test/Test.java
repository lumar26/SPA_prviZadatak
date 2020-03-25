package test;

import labis.exception.LabisException;
import labis.liste.ADSLista;
import labis.test.ListGenerator;
import main.DSLista;
import main.Niz;
import main.Stek;

public class Test {

	public static void main(String[] args) {
//		ADSLista lista = new DSLista();
//		ListGenerator.napraviDSListuCommon(lista, new int[] {1, 6, 9}, false);
//		ListGenerator.ispisiDSListu(lista.prvi);
//		try {
//			lista.popuniListu();
//		} catch (LabisException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println();
//		ListGenerator.ispisiDSListu(lista.prvi);
//		
//		try {
//			System.out.println(lista.elementUSredini().podatak);
//		} catch (LabisException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		Niz niz = new Niz();
//		int[] a =  {1, 2, 9};
//		int[] b = {1, 3, 3, 5, 7};
//		int[] noviNiz = null;
//		try {
//			 noviNiz = niz.spojiDva(a, b);
//		} catch (LabisException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for (int i = 0; i < noviNiz.length; i++) {
//			System.out.print(noviNiz[i]);
//		}
		int[] niz = new int[] {4, -2, -1, -1, 2, 0, 1};
		System.out.println("Ravnotezni indeks je: "  + Niz.ravnotezniIndeks(niz));
		Niz.elementiVeciOdSvihDesno(niz);
		
			
		
	}

}
