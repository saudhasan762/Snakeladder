
public class SnakeLadder {
	//constants
	public static final int start_position=0;
	public static final int end_position=100;
	public static final int no_play_option=0;
	public static final int ladder_option=1;
	public static final int snake_option=2;
	
	public static int count_dice=0;
	public static int player_position=0;
	public int previous_position=0;
	public int updated_position=0;
	public static int player_one_position=0;
	public static int player_two_position=0;
	public static int select_option;
	
	public static void main(String[] args) {
		SnakeLadder Player1 = new SnakeLadder();
		SnakeLadder Player2 = new SnakeLadder();
		while( player_position >= start_position && player_position <= end_position){
			Player1.rolldice();
			if (select_option == ladder_option)
				Player1.rolldice();
			player_one_position=player_position;
			System.out.println("Player one position "+player_one_position);
			
			if(player_one_position == end_position) {	
				System.out.println("Player One Wins");
				break;
			}	
			
			Player2.rolldice();
			if (select_option == ladder_option)
				Player2.rolldice();
			player_two_position=player_position;
			System.out.println("Player two position "+player_one_position);
			if(player_two_position == end_position) {		
				System.out.println("Player Two Wins");
				break;
			}					
		} 
		System.out.println("Number of dice roll "+count_dice);				
	}
	
	public int rolldice() {
		count_dice = count_dice + 1;
		int value=(int)Math.floor(Math.random()*10 % 6);
		value =value + 1;
		select_option=value % 3;
		
		if( select_option == no_play_option )
			player_position = previous_position;
		
		else if(select_option == ladder_option) {
			updated_position = previous_position + value;
			if( updated_position > end_position )
				player_position=previous_position;
			else if( updated_position == end_position)
				player_position = end_position;
			else
				player_position = updated_position;
			previous_position=player_position;
		}
		
		else {
			updated_position = previous_position - value;
			if(updated_position < start_position)
				player_position = start_position;
			else
				player_position = updated_position;
			previous_position = player_position;
		}
		return count_dice;		
	}
}
