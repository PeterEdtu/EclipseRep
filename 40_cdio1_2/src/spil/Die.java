package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @version 1.0
 */

public class Die {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * 
	 * @param MAX_FACE_VALUE Maximumsværdi for faceValue.
	 * @param faceValue      Den side terningen ligger på efter et kast. [1;6]
	 */
	private final int MAX_FACE_VALUE = 6;
	private int faceValue = 1;

	/**
	 * Giver faceValue en tilfældig værdi i intervallet [1;6]
	 * Bruger getFaceValue() metoden til at returnere faceValue.
	 * 
	 * @return getFaceValue()
	 */
	public int roll() {
		faceValue = (int) (Math.random() * MAX_FACE_VALUE) + 1;
		return getFaceValue();
	}

	/**
	 * Getter metode for variable faceValue.
	 * Returnere værdien af faceValue variable.
	 * 
	 * Værdien af variablen bliver ikke tjekket, da 
	 * roll() metoden er den eneste vej til at manipulere
	 * værdien af variable faceValue, hvilket kun er i det ønskede
	 * interval, [1;6].
	 * 
	 * @return faceValue
	 */
	public int getFaceValue() {
		return faceValue;
	}

}
