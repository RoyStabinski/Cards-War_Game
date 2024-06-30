package Q1;

public class Card {
	
	private String suit; // Suit of card (Shape)
	private String face; // Face of card (Number)
	private int val; // Value of card
	
	/**
	 * Empty Constructor
	 */
	public Card() {
		
	}
	
	/**
	 * Two-argument constructor initializes card's face and suit
	 * @param cardFace - Initialize face of the card
	 * @param cardSuit - Initialize suit of card
	 */
	public Card(String face,String suit) {
		this.face = face;
		this.suit = suit;
		this.val = faceRank(face); //Value of the face in order to compare afterwards in the game between the cards
	}
	
	
	/**
	 * Return a string representation of card
	 */
	public String toString() {
		return face + " " + suit;
	}
	
	/**
	 * Sets the card
	 * @param card - setting by 2 parameters face and suit
	 */
	public void setCard(Card card) {
		face = card.getFace();
		suit = card.getSuit();
	}
	
	/**
	 * Setting the face of the card
	 * @param face
	 */
	public void setFace(String face) {
		this.face = face; 
	}
	
	/**
	 * Setting the suit of the card
	 * @param suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	/**
	 * Setting the numeric value of card
	 * @param val
	 */
	public void setVal(int val) {
		this.val = val;
	}
	
	/**
	 * Returns the face of the card
	 * @return face
	 */
	public String getFace() {
		return face;
	}
	
	/**
	 * Returns the suit of the card
	 * @return suit
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * Returns the numeric value of card
	 * @return value
	 */
	public int getVal() {
		return val;
	}
	
	/**
	 * Setting the faces in enum database
	 */
	public enum Face{
		Deuce,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King
	}
	
	/**
	 * Setting the suits in enum database
	 */
	public enum Suit{
		Hearts,Spades,Diamonds,Clubs
	}
	
	/**
	 * Setting numeric values for every face
	 * @param face
	 * @return numeric value of cards face
	 */
	public int faceRank(String face) {
	
		if(face == "Deuce")
			return 2;
		else if(face == "Three")
			return 3;
		else if(face == "Four")
			return 4;
		else if(face == "Five")
			return 5;
		else if(face == "Six")
			return 6;
		else if(face == "Seven")
			return 7;
		else if(face == "Eight")
			return 8;
		else if(face == "Nine")
			return 9;
		else if(face == "Ten")
			return 10;
		else if(face == "Jack")
			return 11;
		else if(face == "Queen")
			return 12;
		else if(face == "King")
			return 13;
		else if(face == "Ace")
			return 14;
		else
			return 0;
		
	}
}
