package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @version 1.0
 */

public class Player {

	/**
	 * Indkapslede klasse variabler, "fields."
	 *
	 * @param MAX_SCORE maksimale score for en spiller
	 * @param id spiller id
	 * @param name spillernavn
	 * @param score spillerens score
	 */
	private final int MAX_SCORE = 40;
	private int id;
	private String name;
	private int score;

	/**
	 * Class constructor med to parametre int id og String name.
	 *
	 * @param id spiller id
	 * @param name spillernavn
	 */
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Metoden addToScore() der ligger int amount til score.
	 *
	 * @param amount addition til spillerens score
	 */
	public void addToScore(int amount) {
		score += amount;
	}

	/**
	 * Hvis score er større eller lig med 40, har spilleren vundet.
	 * 
	 * @return true hvis score >= MAX_SCORE
	 * @return false hvis ovenstående ikke er sandt
	 */
	public boolean hasWon() {
		if (score >= MAX_SCORE) {
			System.out.println("[" + id + "] " + name + " has won! Congratulations!\n");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gettermetode for id
	 * 
	 * @return id spiller id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gettermetode for name
	 * 
	 * @return name spiller navn
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gettermetode for score
	 * 
	 * @return score spillerens score
	 */
	public int getScore() {
		return score;
	}

}
