package gume;

/**
 * Klasa definise atribute i metode jedne Auto gume.
 * 
 * @author Negra Hodzic
 * @version 0.1.0
 *
 */
public class AutoGuma {
	/**
	 * Atribut marka modela kao string.
	 */
	private String markaModel = null;
	/**
	 * Atribut precnik celobrojnog tipa.
	 */
	private int precnik = 0;
	/**
	 * Atribut sirina.
	 */
	private int sirina = 0;
	/**
	 * Atribut visina.
	 */
	private int visina = 0;

	/**
	 * Vraca marku modela.
	 * 
	 * @return Marka modela.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja marku modela na zadatu vrednost.
	 * 
	 * @param markaModel Marka modela kao string
	 * @throws java.lang.RuntimeException Ako je uneta null vrednost ili ako je duzina stringa manja od 3
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null || markaModel.length() < 3)
			throw new RuntimeException("Morate uneti marku i model");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca precnik gume.
	 * 
	 * @return Precnik gume
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja precnik gume na zadatu vrednost.
	 * 
	 * @param precnik Precnik gume kao int
	 * @throws java.lang.RuntimeException Ako precnik nije izmedju 13 i 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca sirinu gume.
	 * 
	 * @return sirina Sirina gume
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja sirinu gume na zadatu vrednost.
	 * 
	 * @param sirina Sirina gume kao int
	 * @throws java.lang.RuntimeException Ako nije izmedju 135 i 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca visinu gume.
	 * 
	 * @return Visina gume
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu gume na zadatu vrednost.
	 * 
	 * @param visina Visina gume kao int
	 * @throws java.lang.RuntimeException Ako je vece od 95 ili manje od 25
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca sve atribute klase kao formatiran tekst.
	 * @return Klasa AutoGuma kao formatiran tekst 
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi da li su dve auto gume iste. 
	 * 
	 * @return Vraca true ako jesu, false ako nisu.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}