import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DEMO {
	private APIs apis = new APIs();
	
	public void GameReg() {
		String result = "";
		if (apis.GameReg("game222") == 1) result = "Game registed successfully!";
		else result = "Game name duplicated!";
		
		System.out.println(result);
	}
	
	public void GameUnReg() {
		String result = "";
		if (apis.GameUnReg("game222") == 1) result = "Game un-registed successfully!";
		else result = "Game un-registed failed!";
		
		System.out.println(result);
	}
	
	public void PlayerReg() {
		String result = "";
		Player player = new Player("mirror4444", "66666", "mirror4444@sjtu.edu.cn");
		if (apis.PlayerReg("game222", player, "12345") == 1) result = "Player registed successfully!";
		else result = "Player name duplicated || password error!";
		System.out.println(result);
	}
	
	public void PlayerUnReg() {
		String result = "";
		String player = "mirror";
		if (apis.PlayerUnReg("game222", player) == 1) result = "Player un-registed successfully!";
		else result = "Player un-registed failed!";
		System.out.println(result);
	}
	
	public void PlayerLogin() {
		String result = "";
		String player = "mirror4444";
		String psd = "12345";
		if (apis.PlayerLogin("game222", player, psd) == 1) result = "Player login successfully!";
		else result = "Username || Password error!";
		System.out.println(result);
	}
	
	public void PlayerLogout() {
		String result = "";
		String player = "mirror4444";
		if (apis.PlayerLogout("game222", player) == 1) result = "Player logout successfully!";
		else result = "Player logout failed!";
		System.out.println(result);
	}
	
	public void RequestForFriend() {
		String result = "";
		int type = 1;
		String msgFrom = "mirror1111";
		String msgTo = "mirror3333";
		String content = "Request for friend.";
		Date date = null;
		
		Message msg = new Message(type, msgTo, content, date);
		if (apis.RequestForFriend("game222", msgFrom, msg) == 1) result = "Request submitted!";
		else result = "Request error!";
		System.out.println(result);
	}
	
	public void AckForFriend() {
		String result = "";
		int type = 1;
		String msgFrom = "mirror1111";
		String msgTo = "mirror3333";
		String content = "Agree for friend.";
		Date date = null;
		Message msg = new Message(type, msgTo, content, date);
		if (apis.AckForFriend("game222", msgFrom, msg) == 1) result = "Ack submitted!";
		else result = "Ack error!";
		System.out.println(result);
	}
	
	public void RefForFriend() {
		String result = "";
		int type = 1;
		String msgFrom = "mirror1111";
		String msgTo = "mirror3333";
		String content = "Refuse for friend.";
		Date date = null;
		
		Message msg = new Message(type, msgTo, content, date);
		if (apis.RefForFriend("game222", msgFrom, msg) == 1) result = "Refuse submitted!";
		else result = "Refuse error!";
		System.out.println(result);
	}
	
	public void SearchFriendByKey() {
		String player = "mirror1111";
		ArrayList<String> result = apis.SearchFriendByKey("game222", player, "mirror");
		for (int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public void SearchFriendOnline() {
		String player = "mirror1111";
		ArrayList<String> result = apis.SearchFriendOnline("game222", player);
		for (int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public void GetFriendInfo() {
		String player = "mirror1111";
		String friend = "mirror2222";
		Player friendFound = apis.GetFriendInfo("game222", player, friend);
		System.out.println("friend:" + friendFound.GetPlayerName());
		System.out.println("tele  :" + friendFound.GetPlayerTele());
		System.out.println("email :" + friendFound.GetPlayerEmail());
	}
	
	public void PlayerCheck() {
		String result = "";
		String player = "mirror2222";
		Location loc = new Location(1.111, 2.222);
		if (apis.PlayerCheck("game222", player, loc) == 1) result = "Player check successfully!";
		else result = "Check failed!";
		System.out.println(result);
	}
	
	public void GetPlayersNearby() {
		String player = "mirror2222";
		Location loc = new Location(1.112, 2.222);
		HashMap<String, Location> result = apis.GetPlayersNearby("game222", player, loc);
		for (String playerFound : result.keySet()) {
			System.out.println("player:" + playerFound + 
					"; latitude:" + result.get(playerFound).GetLat() + 
					"; Longitude:" + result.get(playerFound).GetLng());
		}
	}
	
	public void ReadyForGame() {
		String result = "";
		String playerName = "mirror1111";
				
		if (apis.ReadyForGame("game222", playerName) == 1) result = "Player ready for game!";
		else result = "Game ready failed!";
		System.out.println(result);
	}
	
	public void CancelReadyForGame() {
		String result = "";
		String playerName = "mirror1111";
				
		if (apis.CancelReadyForGame("game222", playerName) == 1) result = "Player left!";
		else result = "Game cancel failed!";
		System.out.println(result);
	}
	
	public void StartForGame() {
		String result = "";
		String playerName = "mirror1111";
				
		if (apis.StartForGame("game222", playerName) == 1) result = "Player start a game!";
		else result = "Game start failed!";
		System.out.println(result);
	}
	
	public void EndForGame() {
		String result = "";
		String playerName = "mirror1111";
				
		if (apis.EndForGame("game222", playerName) == 1) result = "Player end a game!";
		else result = "Game ending failed!";
		System.out.println(result);
	}
	
	public void GetMessage() {
		String playerName = "mirror1111";
		String gameName = "game222";
		
		ArrayList<Message> result = apis.GetMessage(gameName, playerName);
		for (int i=0; i<result.size(); i++) {
			System.out.println("Type:" + result.get(i).GetMessageType() + 
					"; Date:" + result.get(i).GetDate() +
					"; MsgTo:" + result.get(i).GetMsgTo() +
					"; Content:" + result.get(i).GetContent());
		}
	}

}
