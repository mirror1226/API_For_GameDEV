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
	// ������IP���˿ں�
	private static final String SERVERIP = "127.0.0.1";
	// private static final String SERVERIP = "10.140.6.25";
	private static final int SERVERPORT = 54321;
	//private static Thread mThread = null;
	private static Socket mSocket = null;

	private static BufferedReader mBufferedReader = null;
	private static PrintWriter mPrintWriter = null;

	private static String mStrMSG = "";
	
	/*
	 * ���캯��
	*/
	public APIs()
	{
		//Init();
	}

	/*
	 * ��ʼ��
	 * 
	 */
	public void Init() {
		try {
			// ���ӷ�����
			mSocket = new Socket(SERVERIP, SERVERPORT);

			// ȡ�����������
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

	// �̣߳�������������������Ϣ
	//private static Runnable mRunnable = new Runnable() {
	//	public void run() {
			/*
			while (true) {
				try {
					if ((mStrMSG = mBufferedReader.readLine()) != null) {
						// ��Ϣ����
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
	 * ��Ϸע��
	 * ��������Ϸ����
	 * ����ֵ��ע��ɹ�����1�����򷵻�0
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
	 * ��Ϸע��
	 * ��������Ϸ����
	 * ����ֵ��ע��ɹ�����1�����򷵻�0
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
	 * ���ע��
	 * ��������Ϸ���� ������� ������� ��ҵ绰 �������
	 * ����ֵ��ע��ɹ�����1�����򷵻�0
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
	 * ���ע��
	 * ��������Ϸ���� �������
	 * ����ֵ��ע���ɹ�����1�����򷵻�0
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
	 * ��ҵ�¼
	 * ��������Ϸ���� ������� �������
	 * ����ֵ����¼�ɹ�����1�����򷵻�0
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
	 * �������
	 * ��������Ϸ���� �������
	 * ����ֵ�����߳ɹ�����1�����򷵻�0
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
	 * ��ҷ��ͺ�������
	 * ��������Ϸ���� ��������������� �������������
	 * ����ֵ�����ͳɹ�����1�����򷵻�0
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
	 * ���ͬ���������
	 * ��������Ϸ���� ��������������� �������������
	 * ����ֵ�����ͳɹ�����1�����򷵻�0
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
	 * ��Ҿܾ���������
	 * ��������Ϸ���� ��������������� �������������
	 * ����ֵ�����ͳɹ�����1�����򷵻�0
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
	 * ���ݹؼ��ֲ�ѯ�û�
	 * ��������Ϸ���� �û����� ��ѯ�ؼ���
	 * ����ֵ���ɹؼ���ƥ�䵽���û��б�ArrayList<Player>
	 *      ���б��е�Player����ֻ��playerName�ɶ�
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
	 * ��ѯ���ߺ���
	 * ��������Ϸ���� �������
	 * ����ֵ�������ߺ�����ɵ�ArrayList<Player>
	 *      ���б��е�Player����ֻ��playerName�ɶ�
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
	 * ��ѯ������Ϣ
	 * ��������Ϸ���� ������� ��������
	 * ����ֵ�����غ��ѵ�Player����
	 *      ����playerName��playerTele��playerEmail�ɶ�
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
	 * ��ұ���λ��
	 * ��������Ϸ���� ������� ���γ�� ��Ҿ���
	 * ����ֵ��check�ɹ�����1�����򷵻�0
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
	 * ��������ܱߺ���
	 * ��������Ϸ���� ������� ���γ�� ��Ҿ���
	 * ����ֵ�����ܱ��û����ɵ�ArrayList<Player>
	 *      ����playerName,lat,lng�ɶ�
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
	 * ���׼����Ϸ
	 * ��������Ϸ���� �������
	 * ����ֵ��׼���ɹ�����1�����򷵻�0
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
	 * ���ȡ��׼��
	 * ��������Ϸ���� �������
	 * ����ֵ��ȡ���ɹ�����1�����򷵻�0
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
	 * ��ҿ�ʼ��Ϸ
	 * ��������Ϸ���� �������
	 * ����ֵ����Ϸ��ʼ����1�����򷵻�0
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
	 * ��ҽ�����Ϸ
	 * ��������Ϸ���� �������
	 * ����ֵ����Ϸ��������1�����򷵻�0
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
