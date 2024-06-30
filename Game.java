package Q1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Pay Attention! 
 * In Case of dead end - For Example,war declared and a player doesnt have enough cards to play the session -
 * so he will lose the game.
 *
 */
public class Game{
	
	
	 private static ArrayList<Card>player1Deck = new ArrayList<>();
	 private static ArrayList<Card>player2Deck = new ArrayList<>();

	
	/**
	 * Empty Constructor
	 */
	public Game() {
		
		
	}
	
	
	/**
	 * Main part of the program
	 * @param args
	 */
	public static void main(String[]args) {
		
		JOptionPane.showMessageDialog(null, "Welcome to 'War!' Cards Game");
		JOptionPane.showMessageDialog(null, "Lets Play!");
		CardsPackage fullDeck = new CardsPackage();
	
		dealToPlayers(fullDeck,player1Deck,player2Deck);
		runGame(player1Deck,player2Deck);
	}
	

	/**
	 * Dealing the deck to the players
	 * @param fullDeck - the given deck
	 * @param player1Deck - building up player1 deck
	 * @param player2Deck - building up player2 deck
	 */
	public static void dealToPlayers(CardsPackage fullDeck , ArrayList<Card>player1Deck ,ArrayList<Card>player2Deck ) {
		
		for(int i = 0 ; i < fullDeck.getsize()/2 ;i++) {
			player1Deck.add(fullDeck.dealCard());
			player2Deck.add(fullDeck.dealCard());
		}
		System.out.println(player1Deck);
		System.out.println(player2Deck);

	}
	
	/**
	 * The engine of the game - playing each round according to the given rules will declare on a winner when a player will hold the whole deck
	 * @param player1Deck
	 * @param player2Deck
	 */
	public static void runGame(ArrayList<Card>player1Deck,ArrayList<Card>player2Deck) {
		
		while(!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
			Card player1Play = player1Deck.remove(player1Deck.size()-1);//Removing cards from the top of the deck
			Card player2Play = player2Deck.remove(player2Deck.size()-1);
			compare(player1Play,player2Play);
		}
		
		if(player1Deck.isEmpty()) //Winning condition 
			 JOptionPane.showMessageDialog(null, "Player 2 Wins the game!");
		else if(player2Deck.isEmpty())
			  JOptionPane.showMessageDialog(null, "Player 1 Wins the game!");
		

		
	}
	
	/**
	 * Comparing each player hand
	 * @param player1Play - upside card
	 * @param player2Play - upside card
	 */
	public static void compare(Card player1Play, Card player2Play) {
		if(player1Play.getVal() > player2Play.getVal()) { //If player1 has a stronger hand
			JOptionPane.showMessageDialog(null, "Player 1 Plays: " + player1Play  +"\nPlayer 2 Plays: " + player2Play);
            JOptionPane.showMessageDialog(null, "Player 1 Wins The Round!");
            player1Deck.add(0,player2Play);//Adding the cards to the bottom of the deck
			player1Deck.add(0,player1Play);//Adding the cards to the bottom of the deck
		}
		else if(player1Play.getVal() < player2Play.getVal()) { // If player2 has a stronger hand
			JOptionPane.showMessageDialog(null, "Player 1 Plays: " + player1Play + "\nPlayer 2 Plays: " + player2Play);
            JOptionPane.showMessageDialog(null, "Player 2 Wins The Round!");
			player2Deck.add(0,player1Play);//Adding the cards to the bottom of the deck
			player2Deck.add(0,player2Play);//Adding the cards to the bottom of the deck
		}else if(player1Play.getVal() == player2Play.getVal()) { //In case of tie - going to a war
			JOptionPane.showMessageDialog(null, "Player 1 Plays: " + player1Play + "\nPlayer 2 Plays: " + player2Play);
			JOptionPane.showMessageDialog(null, "It's A War!\nReveal The Next 2 Playes And Winner Will Declare After Third Play");
			war(player1Play,player2Play);
             }
		}
		
	
	/**
	 * War session - if the card are equals then we will continue according the rules
	 * @param player1Deck - deck of player1
	 * @param player2Deck - deck of player2
	 * @return the cards whom being collected in the session
	 */
	public static void war(Card player1Play,Card player2Play) {
		ArrayList<Card>warSession = new ArrayList<Card>(); //Creating a list for this session
		Card player1WarCard = player1Play ,player2WarCard = player2Play;
		 warSession.add(player1Play);
	     warSession.add(player2Play);
		
	     for (int i = 0; i < 2; i++) {
	            if (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
	            	 player1WarCard = player1Deck.remove(player1Deck.size()-1);
	            	 player2WarCard = player2Deck.remove(player2Deck.size()-1);

	                warSession.add(player1WarCard); // Remove from the top of the deck
	                warSession.add(player2WarCard); // Remove from the top of the deck
	                JOptionPane.showMessageDialog(null, "Player 1 -  "+(i+1)+" Play: " + player1WarCard + "\nPlayer 2 - "+(i+1)+" Play: "+ player2WarCard);
	            }
	        }

	        if (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
	             player1WarCard = player1Deck.remove(player1Deck.size()-1); // Remove from the top of the deck
	             player2WarCard = player2Deck.remove(player2Deck.size()-1); // Remove from the top of the deck
	        }
	        
	        if(player1Deck.isEmpty() || player2Deck.isEmpty()) // In case of dead end
	        	if(player1WarCard.getVal() == player2WarCard.getVal())
	        		return;
	        
            compare(player1WarCard, player2WarCard);

	    }
	
}
