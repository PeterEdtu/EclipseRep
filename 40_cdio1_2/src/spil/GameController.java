package spil;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * dawddw
 * @author Daniel Larsen (s151641)
 * @author Daniel Anusic (s155005)
 * @version 1.0
 */

/* Abstract klasse, så den ikke kan
 * instantieres.
 */
public abstract class GameController {

	/**
	 * Indkapslede klasse variabler, "fields."
	 * 
	 * @param player1 Spiller 1
	 * @param player2 Spiller 2
	 * @param diceCup Raflebæger
	 */
	private static Player player1;
	private static Player player2;
	private static DiceCup diceCup;

	/**
	 * Metode startGame() initialisere spillet. 
	 */
	private static void startGame() {
		/* Laver instans af en Scanner og en DiceCup */
		Scanner input = new Scanner(System.in);
		diceCup = new DiceCup();

		String answer = "n";

		do {
			/* Printer introduktion ud */
			System.out.println("|--------------------------------------------------|");
			System.out.println("|             Welcome to the Dice game!            |");
			System.out.println("| Players, enter your name and prepare for battle! |");
			System.out.println("|--------------------------------------------------|\n");

			/*
			 * Kalder metoden createPlayerName(id, scanner), 
			 * til at få 2 navne fra brugeren i konsollen.
			 */
			String name1 = createPlayerName(1, input);
			String name2 = createPlayerName(2, input);

			/* Laver 2 nye spiller objekter med de 2 fundne navne. */
			player1 = new Player(1, name1);
			player2 = new Player(2, name2);

			/* Giver spillerne information om hvad der sker i spillet lige nu */
			System.out.println("\n[" + player1.getId() + "] " + player1.getName() + " will now roll once against " + "[" + player2.getId() + "] "
					+ player2.getName() + " to see who will roll first in the game!\nPress enter after each round to continue!");

			int roll1;
			int roll2;

			/* Finder ud af hvem der skal kaste først i spillet */
			do {
				roll1 = diceCup.shakeOneDie(player1);
				roll2 = diceCup.shakeOneDie(player2);
			} while (roll1 == roll2);

			/* Fortæller brugeren hvem der starter og begynder det "rigtige" spil. */
			if (roll1 > roll2) {
				System.out.println("\n[" + player1.getId() + "] " + player1.getName() + " will start!");
				input.nextLine();
				playGame(player1, player2, input);
			} else {
				System.out.println("\n[" + player2.getId() + "] " + player2.getName() + " will start!");
				input.nextLine();
				playGame(player2, player1, input);
			}

			/* Spørger om spillerne vil spille igen */
			do {
				System.out.println("Do you want to play again? [y/n]");
				answer = input.nextLine().toLowerCase();

				/* Hvis input er 'n' eller 'N', så stopper spillet. */
				if (answer.equals("n")) break;

			} while (!(answer.equals("y")));

		} while (answer.equals("y"));

		/* Siger tak for spillet, hvis spillerne ikke vil spille igen */
		System.out.println("Thanks for playing!");
		input.close();
	}

	/**
	 * Metoden til det endelige spil, der hvor spillerne skal
	 * kaste to terninger skiftevis.
	 * 
	 * @param firstPlayer Spilleren der starter med at kaste de to terninger
	 * @param lastPlayer Spilleren der kaster efterfølgende @param firstPlayer
	 * @param input Scanner objekt til at give pause mellem hvert kast
	 */
	private static void playGame(Player firstPlayer, Player lastPlayer, Scanner input) {
		while (true) {
			diceCup.shakeTwoDice(firstPlayer);
			showScoreTable(firstPlayer, lastPlayer);
			input.nextLine();

			if (firstPlayer.hasWon()) break;

			diceCup.shakeTwoDice(lastPlayer);
			showScoreTable(firstPlayer, lastPlayer);
			input.nextLine();

			if (lastPlayer.hasWon()) break;
		}
	}

	/**
	 * Metoden showScoreTable() printer en formateret 
	 * table ud af begge spilleres score.
	.	 * 
	 * @param firstPlayer Første score der bliver vist
	 * @param lastPlayer Scoren efterfølgende
	 */
	private static void showScoreTable(Player firstPlayer, Player lastPlayer) {
		NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
		numberFormat.setMinimumIntegerDigits(2);

		String nameFirst = String.format("%1$" + 5 + "s", firstPlayer.getName());
		String nameLast = String.format("%1$" + 5 + "s", lastPlayer.getName());

		String scoreFirst = String.format("%1$" + 3 + "s", numberFormat.format(firstPlayer.getScore()));
		String scoreLast = String.format("%1$" + 3 + "s", numberFormat.format(lastPlayer.getScore()));

		System.out.println("|----------------------------------------|");
		System.out.println(" [" + firstPlayer.getId() + "] " + nameFirst + "\t [" + lastPlayer.getId() + "] " + nameLast);
		System.out.println(" Score: " + scoreFirst + "\t Score: " + scoreLast);
		System.out.println("|----------------------------------------|");
	}

	/**
	 * Metoden createPlayerName() spørger brugeren 
	 * efter et navn til en spiller, med id @param id
	 * og sørger for at der ikke er mellemrum i navnet eller
	 * længden er mindre end 1.
	 * 
	 * public da metoden skal testes.
	 * 
	 * @param id spiller id
	 * @param input Scanner objekt
	 * @return name
	 */
	public static String createPlayerName(int id, Scanner input) {
		String name = "";
		do {
			System.out.print("[" + id + "] Player name: ");
			name = input.nextLine();
		} while (name.length() < 1 || name.contains(" ") || name.length() > 30);
		return name;
	}

	/** 
	 * Main metode, der laver et nyt instans af 
	 * denne klasse Game.
	 */
	public static void main(String[] args) {
		startGame();
	}

}
