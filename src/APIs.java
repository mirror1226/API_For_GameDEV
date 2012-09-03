import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class APIs {
	// 服务器IP、端口号
	private static final String SERVERIP = "127.0.0.1";
	// private static final String SERVERIP = "10.140.6.25";
	private static final int SERVERPORT = 54321;
	//private static Thread mThread = null;
	private static Socket mSocket = null;

	private static BufferedReader mBufferedReader = null;
	private static PrintWriter mPrintWriter = null;

	private static String mStrMSG = "";
	
	/*
	 * 构造函数
	*/
	public APIs()
	{
		//Init();
	}

	/*
	 * 初始化
	 * 
	 */
	public void Init() {
		try {
			// 连接服务器
			mSocket = new Socket(SERVERIP, SERVERPORT);

			// 取得输入输出流
			mBufferedReader = new BufferedReader(new InputStreamReader(
					mSocket.getInputStream()));
			mPrintWriter = new PrintWriter(mSocket.getOutputStream(), true);

			//mThread = new Thread(mRunnable);
			//mThread.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}
	
	public void Cleanup() {
		try {
			mSocket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
		
	}

	// 线程：监听服务器发来的消息
	//private static Runnable mRunnable = new Runnable() {
	//	public void run() {
			/*
			while (true) {
				try {
					if ((mStrMSG = mBufferedReader.readLine()) != null) {
						// 消息换行
						mStrMSG += "\n";
						//System.out.print(mStrMSG);
					}
				} catch (Exception e) {
				}
			}
			*/
	//	}
	//};
	
	/*
	 * 游戏注册
	 * 参数：游戏名称
	 * 返回值：注册成功返回1，否则返回0
	 */
	public int GameReg(String gameName)
	{
		Init();
		
		String strSend = "#010101#" + gameName + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			//System.out.print(mStrMSG);
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 游戏注销
	 * 参数：游戏名称
	 * 返回值：注册成功返回1，否则返回0
	 */
	public int GameUnReg(String gameName)
	{
		Init();
		
		String strSend = "#010102#" + gameName + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			//System.out.print(mStrMSG);
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
		//return mStrMSG;
	}
	
	/*
	 * 玩家注册
	 * 参数：游戏名称 玩家名称 玩家密码 玩家电话 玩家邮箱
	 * 返回值：注册成功返回1，否则返回0
	 */
	public int PlayerReg(String gameName, Player player, String psd) {
		Init();
		
		String strSend = "#010201#" + gameName + "$" + 
	                      player.GetPlayerName() + "&" + 
				          psd + "&" + 
	                      player.GetPlayerTele() + "&" + 
				          player.GetPlayerEmail() + "\n";
		System.out.println(strSend);
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 玩家注销
	 * 参数：游戏名称 玩家名臣
	 * 返回值：注销成功返回1，否则返回0
	 */
	public int PlayerUnReg(String gameName, String playerName) {
		Init();
		String strSend = "#010202#" + gameName + "$" + playerName + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 玩家登录
	 * 参数：游戏名称 玩家名称 玩家密码
	 * 返回值：登录成功返回1，否则返回0
	 */
	public int PlayerLogin(String gameName, String playerName, String psd) {
		Init();
		String strSend = "#010203#" + gameName + "$" + 
	                      playerName + "&" + 
				          psd + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 玩家下线
	 * 参数：游戏名称 玩家名称
	 * 返回值：下线成功返回1，否则返回0
	 */
	public int PlayerLogout(String gameName, String playerName) {
		Init();
		String strSend = "#010204#" + gameName + "$" + playerName + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 玩家发送好友请求
	 * 参数：游戏名称 发送请求玩家名称 被请求玩家名称
	 * 返回值：发送成功返回1，否则返回0
	 */
	public int RequestForFriend(String gameName, String playerName, Message msg) {
		Init();
		String strSend = "#010211#" + gameName + "$" + 
				          playerName + "&" + 
				          msg.GetMsgTo() + "&" + msg.GetContent() + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 玩家同意好友请求
	 * 参数：游戏名称 发送请求玩家名称 被请求玩家名称
	 * 返回值：发送成功返回1，否则返回0
	 */
	public int AckForFriend(String gameName, String playerName, Message msg) {
		Init();
		String strSend = "#010212#" + gameName + "$" + 
				          playerName + "&" + 
				          msg.GetMsgTo() + "&" + msg.GetContent() + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 玩家拒绝好友请求
	 * 参数：游戏名称 发送请求玩家名称 被请求玩家名称
	 * 返回值：发送成功返回1，否则返回0
	 */
	public int RefForFriend(String gameName, String playerName, Message msg) {
		Init();
		String strSend = "#010213#" + gameName + "$" + 
				playerName + "&" + 
		        msg.GetMsgTo() + "&" + msg.GetContent() + "\n";
        mPrintWriter.print(strSend);
        mPrintWriter.flush();
        try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 根据关键字查询用户
	 * 参数：游戏名称 用户名称 查询关键字
	 * 返回值：由关键字匹配到的用户列表ArrayList<Player>
	 *      该列表中的Player对象只有playerName可读
	 */
	public ArrayList<String> SearchFriendByKey(String gameName, String playerName, String key) {
		Init();
		String strSend = "#010216#" + gameName + "$" + 
	                      playerName + "&" + key + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        
        ArrayList<String> result = null;
        try {
			mStrMSG = mBufferedReader.readLine();
			String[] players = mStrMSG.split("#");
	        result = new ArrayList<String>();
	        
	        for (int i=1; i<players.length; i++) {
	        	result.add(players[i]);
	        }
	        Cleanup();
	        return result;
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
        
        
	}
	
	/*
	 * 查询在线好友
	 * 参数：游戏名称 玩家名称
	 * 返回值：由在线好友组成的ArrayList<Player>
	 *      该列表中的Player对象只有playerName可读
	 */
	public ArrayList<String> SearchFriendOnline(String gameName, String playerName) {
		Init();
		String strSend = "#010217#" + gameName + "$" + 
                          playerName + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        
        ArrayList<String> result = null;
        try {
			mStrMSG = mBufferedReader.readLine();
			String[] players = mStrMSG.split("#");
	        result = new ArrayList<String>();
	        
	        for (int i=1; i<players.length; i++) {
	        	result.add(players[i]);
	        }
	        Cleanup();
	        return result;
		} catch (IOException e) {
			e.printStackTrace();
			return result;
		}
        
	}
	
	/*
	 * 查询好友信息
	 * 参数：游戏名称 玩家名称 好友名称
	 * 返回值：返回好友的Player对象
	 *      其中playerName，playerTele，playerEmail可读
	 */
	public Player GetFriendInfo(String gameName, String playerName, String friendName) {
		Init();
		String strSend = "#010218#" + gameName + "$" + 
				          playerName + "&" + 
				          friendName + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        
        Player friendFound = null;
        try {
			mStrMSG = mBufferedReader.readLine();
			String friendInfo = mStrMSG.split("#")[1];
	        String[] info = friendInfo.split("&");
	        String friendTele = info[1];
	        String friendEmail = info[2];
	        
	        friendFound = new Player(friendName, friendTele, friendEmail);
	        Cleanup();
	        return friendFound;
		} catch (IOException e) {
			e.printStackTrace();
			return friendFound;
		}       
	}
	
	/*
	 * 玩家报到位置
	 * 参数：游戏名称 玩家名称 玩家纬度 玩家经度
	 * 返回值：check成功返回1，否则返回0
	 */
	public int PlayerCheck(String gameName, String playerName, Location loc) {
		Init();
		String strSend = "#010221#" + gameName + "$" + 
				          playerName + "&" + 
				          loc.GetLat() + "&" + 
	                      loc.GetLng() + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        
        try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}
	}
	
	/*
	 * 玩家搜索周边好友
	 * 参数：游戏名称 玩家名称 玩家纬度 玩家经度
	 * 返回值：由周边用户构成的ArrayList<Player>
	 *      其中playerName,lat,lng可读
	 */
	public HashMap<String, Location> GetPlayersNearby(String gameName, String playerName, Location loc) {
		Init();
		String strSend = "#010222#" + gameName + "$" + 
				          playerName + "&" + 
				          loc.GetLat() + "&" + 
	                      loc.GetLng() + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        
        HashMap<String, Location> result = null;        
        try {
        	result = new HashMap<String, Location>();
        	mStrMSG = mBufferedReader.readLine();
			String[] players = mStrMSG.split("#");
	        
	        for (int i=1; i<players.length; i++) {
	        	String[] playerInfo = players[i].split("&");
	        	String player = playerInfo[0];
	        	String latStr = playerInfo[1];
	        	String lngStr = playerInfo[2];
	        	Location location = new Location(Double.parseDouble(latStr), Double.parseDouble(lngStr));
	        	
	        	result.put(player, location);
	        }
	        Cleanup();
	        return result;		
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return result;
		}      
	}
	
	/*
	 * 玩家准备游戏
	 * 参数：游戏名称 玩家名称
	 * 返回值：准备成功返回1，否则返回0
	 */
	public int ReadyForGame(String gameName, String playerName) {
		Init();
		String strSend = "#010205#" + gameName + "$" + playerName + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}        
	}
	
	/*
	 * 玩家取消准备
	 * 参数：游戏名称 玩家名称
	 * 返回值：取消成功返回1，否则返回0
	 */
	public int CancelReadyForGame(String gameName, String playerName) {
		Init();
		String strSend = "#010206#" + gameName + "$" + playerName + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}        
	}
	
	/*
	 * 玩家开始游戏
	 * 参数：游戏名称 玩家名称
	 * 返回值：游戏开始返回1，否则返回0
	 */
	public int StartForGame(String gameName, String playerName) {
		Init();
		String strSend = "#010208#" + gameName + "$" + playerName + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}        
	}
	
	/*
	 * 玩家结束游戏
	 * 参数：游戏名称 玩家名称
	 * 返回值：游戏结束返回1，否则返回0
	 */
	public int EndForGame(String gameName, String playerName) {
		Init();
		String strSend = "#010209#" + gameName + "$" + playerName + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        try {
			mStrMSG = mBufferedReader.readLine();
			
			if (mStrMSG.compareTo("0") == 0) {
				Cleanup();
				return 0;
			}
			else {
				Cleanup();
				return 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return 0;
		}        
	}
	
	public ArrayList<Message> GetMessage(String gameName, String playerName) {
		Init();
		String strSend = "#010207#" + gameName + "$" + playerName + "\n";
		mPrintWriter.print(strSend);
        mPrintWriter.flush();
        
        ArrayList<Message> result = null;
        try {
        	mStrMSG = mBufferedReader.readLine();
        	
        	String[] msgs = mStrMSG.split("#");
        	result = new ArrayList<Message>();
        	
        	for (int i=1; i<msgs.length; i++) {
        		String[] temp = msgs[i].split("&");
        		int type = Integer.parseInt(temp[0]);
        		String dateTmp = temp[1];
        		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        		Date date = df.parse(dateTmp);
        		String msgTo = temp[2];
        		String content = "";
        		if (temp.length == 4) content = temp[3];
        		
        		result.add(new Message(type, msgTo, content, date));     
        	}
        	
        	Cleanup();
        	return result;
        } catch (IOException e) {
			e.printStackTrace();
			Cleanup();
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
			Cleanup();
			return result;
		}      
	}
	
}
