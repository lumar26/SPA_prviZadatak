package main;

import java.util.ArrayList;

import labis.exception.LabisException;
import labis.niz.ANiz;

public class Niz extends ANiz {
	@Override
	public int[] spojiDva(int[] a, int[] b) throws LabisException {
		if (a == null || b == null)
			throw new LabisException("Nisu prosledjena dva niza");
		int[] c = new int[a.length + b.length];

		for (int i = a.length - 1, j = 0; i >= 0; i--, j++) {
			c[j] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			c = ubaciSortirano(c, b[i]);
		}

		return c;
	}

	public int[] ubaciSortirano(int[] c, int x) {
		int j;
		for (j = 0; j < c.length && x < c[j]; j++)
			;
		// ovde sam dobio od kog treba da pomeram udesno da bih ubacio element
		for (int i = c.length - 1; i > j; i--) {
			c[i] = c[i - 1];
		}
		c[j] = x;
		return c;
	}

	public static int ravnotezniIndeks(int[] niz) {

		int[] leviProlaz = new int[niz.length];
		leviProlaz[0] = 0;
		for (int i = 1; i < niz.length; i++) {
			leviProlaz[i] = leviProlaz[i - 1] + niz[i - 1];
		}
		//dal ovde ovaj desni treba da bude nula ili poslednji element
		int desniProlaz = 0;
		for (int i = leviProlaz.length - 1; i > 0; i--) {
			if (desniProlaz == leviProlaz[i])
				return i;
			desniProlaz += niz[i];
		}

		return -1;
	}
	
	public static void elementiVeciOdSvihDesno(int[] niz) { // ne racuna se poslednji lelement
		ArrayList<Integer> rez = new ArrayList<Integer>();
		int max = niz[niz.length - 1];
		for (int i = niz.length - 2; i >= 0; i--) {
			if(niz[i] > max) {
				max = niz[i];
				rez.add(max);
			}
		}
		
		System.out.println("Elementi niza koji sa svoje desne strane imaju samo elemente koji su manji od njih su: ");
		for (Integer element : rez) {
			System.out.print(element + " ");
		}
	}
	
	public static void nizNastaoMnozenjem(int[] niz) {
		int prethodni, trenutni, sledeci;
		for (int i = 0, j = 1, k = 2; k < niz.length; i++, j++, k++) {
			prethodni = niz[i];
			trenutni = niz[j];
			sledeci = niz[k];
			niz[i] = prethodni * trenutni;
		}
	}
}
