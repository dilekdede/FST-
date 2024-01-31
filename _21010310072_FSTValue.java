package _21010310072_Dilek_Dede;

public class _21010310072_FSTValue {
	private String kosul;
	private String gecis;
	private String cikis;
	private String deger;

	public _21010310072_FSTValue() {
	}

	public _21010310072_FSTValue(String kosul, String gecis, String cikis, String deger) {
		this.kosul = kosul;
		this.gecis = gecis;
		this.cikis = cikis;
		this.deger = deger;
	}

	public String getKosul() {
		return kosul;
	}

	public void setKosul(String kosul) {
		this.kosul = kosul;
	}

	public String getGecis() {
		return gecis;
	}

	public void setGecis(String gecis) {
		this.gecis = gecis;
	}

	public String getDeger() {
		return deger;
	}

	public void setDeger(String deger) {
		this.deger = deger;
	}

	public String getCikis() {
		return cikis;
	}

	public void setCikis(String cikis) {
		this.cikis = cikis;
	}

	public String toString() {
		return "FSTValue{" + "kosul='" + kosul + '\'' + ", gecis='" + gecis + '\'' + ", cikis='" + cikis + '\''
				+ ", deger='" + deger + '\'' + '}';
	}

}
