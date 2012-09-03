import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class APIs {
	// 服务器IP、端口号
	private static final String SERVERIP = "218.193.190.194";
	// private static final String SERVERIP = "10.140.6.25";
	private static final int SERVERPORT = 54321;
	private static Thread mThread = null;
	private static Socket mSocket = null;

	private static BufferedReader mBufferedReader = null;
	private static PrintWriter mPrintWriter = null;

	private static String mStrMSG = "";
	
	/*
	 * 构造函数
	*/
	public APIs()
	{
		Init();
	}

	/*
	 * 初始化
	 * 
	 */
	public static void Init() {
		try {
			// 连接服务器
			mSocket = new Socket(SERVERIP, SERVERPORT);

			// 取得输入输出流
			mBufferedReader = new BufferedReader(new InputStreamReader(
					mSocket.getInputStream()));
			mPrintWriter = new PrintWriter(mSocket.getOutputStream(), true);

			mThread = new Thread(mRunnable);
			mThread.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}

	// 线程：监听服务器发来的消息
	private static Runnable mRunnable = new Runnable() {
		public void run() {
			while (true) {
				try {
					if ((mStrMSG = mBufferedReader.readLine()) != null) {
						// 消息换行
						mStrMSG += "\n";
						System.out.print(mStrMSG);
					}
				} catch (Exception e) {
				}
			}
		}
	};
	
	/*
	 * 游戏注册
	 * 参数：游戏名称
	 * 返回值：注册成功返回1，否则返回0
	 */
	public String GameReg(String gameName)
	{
		String strSend = "#010101#五子棋" + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		return mStrMSG;
	}
	
	
}
