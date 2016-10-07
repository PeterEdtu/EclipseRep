package test;

import spil.Die;
import spil.Player;

public class DiceCup {

	private Die die1;
	private Die die2;
	
	public DiceCup() {
		die1 = new Die();
		die2 = new Die();
	}

	public int shakeOneDie(Player player) {
		System.out.println("[" + player.getId() + "] " + player.getName() + " rolling...");
		int roll = die1.roll();
		System.out.println("[" + player.getId() + "] " + player.getName() + " got " + roll + "!");
		return roll;
	}

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
	
	public int onlyShakeTwoDice(Player player) {
		System.out.println("[" + player.getId() + "] " + player.getName() + " rolling...");
		int roll1 = die1.roll();
		int roll2 = die2.roll();
		System.out.println("[" + player.getId() + "] " + player.getName() + " got " + roll1 + ", " + roll2 + "!");
		player.addToScore(roll1 + roll2);
		return roll1 + roll2;
	}

}
