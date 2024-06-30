package Q1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Note - I wasnt sure by the instructions if i wasnt not allowed to use [] array at all - so i used only ArrayList.
 */
public class CardsPackage {
	

	//Declarations
	private final static int CARDS_IN_DECK = 52;
	private final int NUM_OF_SUITS = 4;
	private final int NUM_OF_FACES = 13;
	ArrayList<Card>fullDeck = new ArrayList<>(CARDS_IN_DECK);
	ArrayList<String> facesList = new ArrayList<>();
	ArrayList<String> suitsList = new ArrayList<>();


	/**
	 * Constructor of the class
	 */
	public CardsPackage() {
		createFaceList();
		createSuitList();
		 fullDeck = new ArrayList<Card>(CARDS_IN_DECK);
		for (int i = 0; i < NUM_OF_SUITS ; i++) { // Suit loop
			for (int j = 0; j < NUM_OF_FACES ; j++) { //Face loop
				fullDeck.add(new Card(facesList.get(j),suitsList.get(i))); //Creating the fullDeck by combination of face and suit
			}
		}
		System.out.println(fullDeck);
		shuffle(); //Shuffling the deck in order to to make the cards dealing fair to both players
		System.out.println(fullDeck);


	}
	/**
	 * Shuffling the cards in the deck
	 */
	public void shuffle() {
		Random rn = new Random(); //Pick a random index in the array
		for(int i = 0 ; i < CARDS_IN_DECK;i++) {
			int j = (int)rn.nextInt(CARDS_IN_DECK);//Picking a random index in the array for swapping
			Card temp = fullDeck.get(i);
			fullDeck.set(i,fullDeck.get(j));
			fullDeck.set(j, temp);
		}

	}

	/**
	 * Method for dealing card
	 * @return the card to be dealt
	 */
	public Card dealCard() {

		if(fullDeck.isEmpty())
			return null;//If the fullDeck is empty and there is no more cards to deal

		return fullDeck.remove(0);
	}




	/**
	 * Creating a List with the cards values
	 */
	public void createFaceList() {

		facesList.add("Deuce");
		facesList.add("Three");
		facesList.add("Four");
		facesList.add("Five");
		facesList.add("Six");
		facesList.add("Seven");
		facesList.add("Eight");
		facesList.add("Nine");
		facesList.add("Ten");
		facesList.add("Jack");
		facesList.add("Queen");
		facesList.add("King");
		facesList.add("Ace");
		
		System.out.println(facesList);


	}

	/**
	 * Creating a list with the cards shapes
	 */
	public void createSuitList() {

		suitsList.add("Hearts");
		suitsList.add("Diamonds");
		suitsList.add("Clubs");
		suitsList.add("Spades");
		System.out.println(suitsList);
	}

/**
 * Setting the size of the fullDeck
 * @return size as final , equal to 52
 */
	public int getsize() { 
		return CARDS_IN_DECK;
	}
}
