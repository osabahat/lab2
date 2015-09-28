package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck_Test {

	Deck d;

	@Before
	public void setUp() throws Exception {
		d = new Deck();

	}

	@After
	public void tearDown() throws Exception {
		d = null;
	}

	@Test
	public void TestFullDeck() {
		d.getCards();
		assertTrue(d.getTotalCards() == 52);

		d.drawFromDeck();
		assertTrue(d.getTotalCards() == 51);
	}

	// Test and compare the hand strength of three homemade hands
	
	public void HandTest() {
		// Creating the first hand...this one is a straight flush
		Card c1 = new Card(eSuit.CLUBS, eRank.TWO, false);
		Card c2 = new Card(eSuit.CLUBS, eRank.THREE, false);
		Card c3 = new Card(eSuit.CLUBS, eRank.FOUR, false);
		Card c4 = new Card(eSuit.CLUBS, eRank.FIVE, false);
		Card c5 = new Card(eSuit.CLUBS, eRank.SIX, false);
		Hand straightFlush = new Hand();
		straightFlush.AddCardToHand(c1);
		straightFlush.AddCardToHand(c2);
		straightFlush.AddCardToHand(c3);
		straightFlush.AddCardToHand(c4);
		straightFlush.AddCardToHand(c5);
		
		// Created a one pair hand to compare with the straight flush
		Card c6 = new Card(eSuit.DIAMONDS, eRank.FIVE, false);
		Card c7 = new Card(eSuit.HEARTS, eRank.KING, false);
		Card c8 = new Card(eSuit.SPADES, eRank.JACK, false);
		Card c9 = new Card(eSuit.CLUBS, eRank.SEVEN, false);
		Card c10 = new Card(eSuit.HEARTS, eRank.SEVEN, false);
		Hand onePair = new Hand();
		onePair.AddCardToHand(c6);
		onePair.AddCardToHand(c7);
		onePair.AddCardToHand(c8);
		onePair.AddCardToHand(c9);
		onePair.AddCardToHand(c10);

		straightFlush.EvalHand();
		onePair.EvalHand();

		straightFlush.getHandStrength();
		onePair.getHandStrength();
		
		// Says the hand strength of the straight flush is stronger than the one
		// pairs
		assertTrue(straightFlush.getHandStrength() > onePair.getHandStrength());
		
		Card c11 = new Card(eSuit.DIAMONDS, eRank.SEVEN, false);
		// This hand has three cards of rank 7 and two cards of rank 5. (full house)
		Hand fullHouse = new Hand();
		fullHouse.AddCardToHand(c9);  
		fullHouse.AddCardToHand(c10);
		fullHouse.AddCardToHand(c11);
		fullHouse.AddCardToHand(c4);
		fullHouse.AddCardToHand(c6);
		
		fullHouse.EvalHand();
		fullHouse.getHandStrength();
		
		// Comparing a full house to a one pair, the full house wins.
		assertTrue(fullHouse.getHandStrength() > onePair.getHandStrength());
		
		// Comparing a straight flush to a full house, the straight flush wins. 
		assertTrue(straightFlush.getHandStrength() > fullHouse.getHandStrength());
		
		// Create another one pair hand to compare with the first one
		Card c20 = new Card(eSuit.DIAMONDS, eRank.FIVE, false);
		Card c21 = new Card(eSuit.HEARTS, eRank.ACE, false);
		Card c22 = new Card(eSuit.SPADES, eRank.JACK, false);
		Card c23 = new Card(eSuit.CLUBS, eRank.SEVEN, false);
		Card c24 = new Card(eSuit.HEARTS, eRank.SEVEN, false);
		Hand onePair2 = new Hand();
		onePair2.AddCardToHand(c20);
		onePair2.AddCardToHand(c21);
		onePair2.AddCardToHand(c22);
		onePair2.AddCardToHand(c23);
		onePair2.AddCardToHand(c24);
		
		onePair.EvalHand();
		onePair.getHandStrength();
		onePair2.EvalHand();
		onePair2.getHandStrength();
		
		//Compare onePair to onePair2, onePair2 has Ace so it wins
		assertTrue(onePair2.getHandStrength() > onePair.getHandStrength());
		
		//Create two pair hand
		Card c25 = new Card(eSuit.DIAMONDS, eRank.FIVE, false);
		Card c26 = new Card(eSuit.HEARTS, eRank.FIVE, false);
		Card c27 = new Card(eSuit.SPADES, eRank.JACK, false);
		Card c28 = new Card(eSuit.CLUBS, eRank.SEVEN, false);
		Card c29 = new Card(eSuit.HEARTS, eRank.SEVEN, false);
		Hand twoPair = new Hand();
		twoPair.AddCardToHand(c25);
		twoPair.AddCardToHand(c26);
		twoPair.AddCardToHand(c27);
		twoPair.AddCardToHand(c28);
		twoPair.AddCardToHand(c29);
		
		twoPair.EvalHand();
		twoPair.getHandStrength();
		
		// Compare two pair to one pair, two pair wins
		assertTrue(twoPair.getHandStrength() > onePair.getHandStrength());
		
		// Create hand with three of a kind
		Card c30 = new Card(eSuit.DIAMONDS, eRank.FIVE, false);
		Card c31 = new Card(eSuit.HEARTS, eRank.FIVE, false);
		Card c32 = new Card(eSuit.SPADES, eRank.FIVE, false);
		Card c33 = new Card(eSuit.CLUBS, eRank.SEVEN, false);
		Card c34 = new Card(eSuit.HEARTS, eRank.NINE, false);
		Hand threeOfaKind = new Hand();
		threeOfaKind.AddCardToHand(c30);
		threeOfaKind.AddCardToHand(c31);
		threeOfaKind.AddCardToHand(c32);
		threeOfaKind.AddCardToHand(c33);
		threeOfaKind.AddCardToHand(c34);
		
		threeOfaKind.EvalHand();
		threeOfaKind.getHandStrength();
		
		// Compare two pair and three of a kind, three of a kind wins
		assertTrue(twoPair.getHandStrength() < threeOfaKind.getHandStrength());
		// Compare one pair and three of a kind, three of a kind wins
		assertTrue(onePair.getHandStrength() < threeOfaKind.getHandStrength());
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
