package _21010310072_Dilek_Dede;

import java.util.Scanner;

public class _21010310072_Main {

	public static void main(String[] args) {

		_21010310072_Okutma okutma = new _21010310072_Okutma();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Lütfen birinci input'u giriniz:");
		String input1 = scanner.nextLine();
		okutma.oku(input1);
		System.out.println();
		System.out.println("Lütfen ikinci input'u giriniz:");
		String input2 = scanner.nextLine();
		okutma.oku(input2);

	}

}
