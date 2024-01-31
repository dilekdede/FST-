package _21010310072_Dilek_Dede;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _21010310072_Okutma {
	String[] durumlardizi = null;
	String[] alfabedizisi = null;
	String[] ciktidizisi = null;
	String[] parcalar = null;
	String baslangic = null;
	char[] charArray = { '(', ')' };

	public void oku(String input1) {
		try {
			File myObj = new File("dosya.txt");
			Scanner myReader = new Scanner(myObj);
			List<_21010310072_FSTValue> fstValues = new ArrayList<>();

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();

				if (data.startsWith("Q = {")) {
					String icerik = data.substring(data.indexOf("{") + 1, data.indexOf("}"));
					durumlardizi = icerik.split(",");
					for (int i = 0; i < durumlardizi.length; i++) {
						durumlardizi[i] = durumlardizi[i];
					}
				} else if (data.startsWith("∑ = {")) {
					String icerik = data.substring(data.indexOf("{") + 1, data.indexOf("}"));
					alfabedizisi = icerik.split(",");
					for (int i = 0; i < alfabedizisi.length; i++) {
						alfabedizisi[i] = alfabedizisi[i];
					}

				} else if (data.startsWith("г = {")) {
					String icerik = data.substring(data.indexOf("{") + 1, data.indexOf("}"));
					ciktidizisi = icerik.split(",");
					for (int i = 0; i < ciktidizisi.length; i++) {
						ciktidizisi[i] = ciktidizisi[i];
					}
				} else if (data.startsWith("q0 =")) {
					if (data.split("=").length > 0)
						baslangic = data.split("=")[1].trim();

				} else if (data.startsWith("δ")) {
					parcalar = data.split("\t");

				} else {

					for (int i = 0; i < durumlardizi.length; i++) {

						String deger = "q" + (i + 1);
						if (data.startsWith(deger)) {
							String[] kosullar = data.split("\t");

							for (int j = 0; j < kosullar.length; j++) {
								String kosul = kosullar[0];
								String gecis = parcalar[j];

								if (kosullar[j].startsWith(String.valueOf(charArray[0]))) {
									String kosulParantezsiz = kosullar[j].substring(1, kosullar[j].length() - 1);
									String[] kosulDegerleri = kosulParantezsiz.split(",");
									String kosulDegeri = gecis + "/" + kosulDegerleri[1].trim();
									String cikis = kosulDegerleri[0];

									_21010310072_FSTValue fst = new _21010310072_FSTValue(kosul, gecis, cikis,
											kosulDegeri);
									fstValues.add(fst);
								}
							}
						}
					}
				}

			}
			myReader.close();

			String[] input = new String[input1.length()];
			for (int i = 0; i < input1.length(); i++) {
				input[i] = String.valueOf(input1.charAt(i));
			}

			fstOutput(baslangic, input, ciktidizisi, fstValues);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fstOutput(String baslangic, String[] input, String[] ciktiler, List<_21010310072_FSTValue> durumlar) {
		System.out.println("\n");
		String basla = baslangic;
		String cikisDurum = "";
		String cikis = "";

		for (int i = 0; i < input.length; i++) {

			for (int j = 0; j < ciktiler.length; j++) {
				String giris = input[i];
				String cikti = ciktiler[j];
				String deger = giris + "/" + cikti.trim();

				List<_21010310072_FSTValue> gelenDurumlar = getDurum(basla, durumlar);

				for (_21010310072_FSTValue fst : gelenDurumlar) {
					if (fst.getDeger().equalsIgnoreCase(deger)) {
						cikisDurum = cikisDurum + fst.getKosul() + " ";
						cikis = cikis + cikti + " ";
						basla = fst.getCikis();
						break;
					}
				}

			}
		}

		System.out.println("Durumlar: " + cikisDurum);
		System.out.println("Cikti: " + cikis);
	}

	private List<_21010310072_FSTValue> getDurum(String durum, List<_21010310072_FSTValue> durumlar) {
		List<_21010310072_FSTValue> list = new ArrayList<>();
		for (_21010310072_FSTValue fst : durumlar) {
			if (fst.getKosul().equalsIgnoreCase(durum)) {
				list.add(fst);
			}
		}

		return list;
	}
}
