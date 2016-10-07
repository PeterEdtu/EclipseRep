package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.DiceCup; // Til metoden onlyShakeTwoDice
import spil.Player;

/**
 * @author PeterElHabr
 *
 */
public class JUnit {
	static Player player1;
	static Player player2;
	static DiceCup diceCup;

	@Before
	public void setUp() throws Exception {
		player1= new Player(1,"Daniel");
		player2= new Player(2,"Daniel");
		diceCup=new DiceCup();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		player1=null;
		player2=null;
		diceCup=null;
	}

	@Test
	public final void testPlayerAddToScore() {
		int expected = 5;
		int amount = 5;

		player1.addToScore(amount);

		int result = player1.getScore();

		assertEquals(expected, result);

		player1.addToScore(8);

		expected=13;
		result=player1.getScore();
		assertEquals(expected, result);

		player1.addToScore(-8);

		expected=5;
		result=player1.getScore();
		assertEquals(expected, result);
	}

	@Test
	public final void testPlayerAddToScoreOverflow() {
		//System.out.println(Integer.MAX_VALUE);
		int expected = 2147483647;
		int amount = Integer.MAX_VALUE+1;

		player1.addToScore(amount);

		int result = player1.getScore();

		//System.out.println(result);

		assertEquals(expected, result);
	}

	@Test
	public final void testPlayerAddToScoreUnderflow() {
		int expected = -2147483647;
		int amount = Integer.MIN_VALUE-1;

		player1.addToScore(amount);

		int result = player1.getScore();

		//System.out.println(result);

		assertEquals(expected, result);
	}

	@Test
	public final void testPlayerHasWon() {
		//Begin
		boolean expected = false;
		boolean result;

		result = player1.hasWon();

		assertEquals(expected, result);

		//Test
		player1.addToScore(39);

		result = player1.hasWon();

		assertEquals(expected, result);

		//Test2
		expected=true;
		player1.addToScore(1);

		result = player1.hasWon();

		assertEquals(expected, result);
	}

	@Test
	public final void testDiceCupShakeOneDie(){
		boolean expected = true;
		boolean result;
		
		int rollValue=diceCup.shakeOneDie(player1);
		
		result=(0<rollValue && rollValue<7);

		assertEquals(expected,result);
	}

	@Test
	public final void testDiceCupShakeTwoDice(){
		boolean expected = true;
		boolean result;
		
		int rollValue=diceCup.shakeTwoDice(player1);
		
		result=(1<rollValue && rollValue<13);

		assertEquals(expected,result);
	}

	@Test
	public final void testTC11TC14(){
		boolean expected = true;
		boolean result;
		
		for (int n=0;n<=12000;++n){
			
			int rollValue=diceCup.onlyShakeTwoDice(player1);
			
			result=(1<rollValue && rollValue<13);
			
			assertEquals(expected,result);
		}

	}

}
