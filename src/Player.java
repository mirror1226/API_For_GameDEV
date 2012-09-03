
public class Player {

	private String playerName;
	private String playerTele;
	private String playerEmail;
	//private String playerPsd;
	
	
	
	public Player(String name, String tele, String email) {
		playerName = name;
		playerTele = tele;
		playerEmail = email;
	}
	
	
	
	public String GetPlayerName() {return playerName;}
	public String GetPlayerTele() {return playerTele;}
	public String GetPlayerEmail() {return playerEmail;}
		
}
