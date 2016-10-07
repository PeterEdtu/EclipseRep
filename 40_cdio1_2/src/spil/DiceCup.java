package spil;

/**
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @version 1.0
 */

public class DiceCup {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * Et raflebæger (DiceCup) der indeholder
	 * 2 terninger.
	 *  
	 * @param die1 Terning objekt
	 * @param die2 Terning objekt
	 */
	private Die die1;
	private Die die2;

	/**
	 * Class constructor, som initialisere
	 * klasse objekter. 
	 * 
	 * @param none
	 */
	public DiceCup() {
		die1 = new Die();
		die2 = new Die();
	}

	/**
	 * Metoden shakeOneDice() bruger @param player til at kaste med én terning.
	 * Returnere derefter resultatet af kastet som en int.
	 * 
	 * @param player Spiller der kaster
	 * @return roll resultat af kast
	 */
	public int shakeOneDie(Player player) {
		System.out.println("[" + player.getId() + "] " + player.getName() + " rolling...");
		int roll = die1.roll();
		System.out.println("[" + player.getId() + "] " + player.getName() + " got " + roll + "!");
		return roll;
	}

	/**
	 * Metoden shakeTwoDice() bruger @param player til at kaste med to terninger.
	 * Returnere derefter resultatet af kastet som en int.
	 * 
	 * @param player Spiller der kaster
	 * @return roll1 + roll2 resultat af kast
	 */
	public int shakeTwoDice(Player player) {
		System.out.println("[" + player.getId() + "] " + player.getName() + " rolling...");
		int roll1 = die1.roll();
		int roll2 = die2.roll();
		System.out.println("[" + player.getId() + "] " + player.getName() + " got " + roll1 + ", " + roll2 + "!");
		player.addToScore(roll1 + roll2);

		if (roll1 == roll2) {
			System.out.println("Wow, [" + player.getId() + "] " + player.getName() + " got an extra roll!");
			shakeTwoDice(player);
		}
		return roll1 + roll2;
	}
	
	/*
	 * TODO Test Branch
	 */
	
	/**
	 * @category Test
	 * @param player
	 * @return
	 */
	public int onlyShakeTwoDice(Player player) {
		System.out.println("[" + player.getId() + "] " + player.getName() + " rolling...");
		int roll1 = die1.roll();
		int roll2 = die2.roll();
		System.out.println("[" + player.getId() + "] " + player.getName() + " got " + roll1 + ", " + roll2 + "!");
		player.addToScore(roll1 + roll2);
		return roll1 + roll2;
	}

}
