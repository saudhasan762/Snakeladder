
public class SnakeLadder {
	//constants
	public static final int startPosition=0;
	public static final int endPosition=100;
	public static final int noPlay=0;
	public static final int ladder=1;
	public static final int snake=2;
	
	public static int diceCount=0;
	public static int playerPosition=0;
	public int previousPosition=0;
	public int updatedPosition=0;
	public static int playerOnePosition=0;
	public static int playerTwoPosition=0;
	public static int selectOption;
	
	public static void main(String[] args) {
		SnakeLadder Player1 = new SnakeLadder();
		SnakeLadder Player2 = new SnakeLadder();
		while( playerPosition >= startPosition && playerPosition <= endPosition){
			Player1.rolldice();
			if (selectOption == ladder)
				Player1.rolldice();
			playerOnePosition = playerPosition;
			System.out.println("Player one position "+playerOnePosition);
			
			if(playerOnePosition == endPosition) {	
				System.out.println("Player One Wins");
				break; }
			
			Player2.rolldice();
			if (selectOption == ladder)
				Player2.rolldice();
			playerTwoPosition = playerPosition;
			System.out.println("Player two position "+playerOnePosition);
			if(playerTwoPosition == endPosition) {		
				System.out.println("Player Two Wins");
				break; }					
		} 
		System.out.println("Number of dice roll "+diceCount);				
	}
	
	public int rolldice() {
		diceCount = diceCount + 1;
		int diceValue = (int)Math.floor(Math.random()*10 % 6);
		diceValue = diceValue + 1;
		selectOption = diceValue % 3;
		
		if( selectOption == noPlay )
			playerPosition = previousPosition;
		
		else if(selectOption == ladder) {
			updatedPosition = previousPosition + diceValue;
			if( updatedPosition > endPosition )
				playerPosition = previousPosition;
			else if( updatedPosition == endPosition)
				playerPosition = endPosition;
			else
				playerPosition = updatedPosition;
			previousPosition = playerPosition;	}
		
		else {
			updatedPosition = previousPosition - diceValue;
			if(updatedPosition < startPosition)
				playerPosition = startPosition;
			else
				playerPosition = updatedPosition;
			previousPosition = playerPosition;	}
		return diceCount;		
	}
}
