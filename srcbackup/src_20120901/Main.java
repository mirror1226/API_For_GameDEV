import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
	/** Called when the activity is first created. */

	// 服务器IP、端口号
	private static final String SERVERIP = "218.193.190.194";
	// private static final String SERVERIP = "10.140.6.25";
	private static final int SERVERPORT = 54321;
	private static Thread mThread = null;
	private static Socket mSocket = null;

	private static BufferedReader mBufferedReader = null;
	private static PrintWriter mPrintWriter = null;

	private static String mStrMSG = "";

	public static void main(String args[]) {
		try {
			// 连接服务器
			mSocket = new Socket(SERVERIP, SERVERPORT);
			// Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

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

		try {
			String strSend = "#010101#五子棋" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010201#五子棋$changych&12345&12345&cyc@gmail.com" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010201#五子棋$changrui&1245&1345&rui@gmail.com" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010203#五子棋$changych&12345&218.193.190.199" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010203#五子棋$changrui&1245&218.193.190.199" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010205#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010206#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010205#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010208#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010209#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010211#五子棋$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010207#五子棋$changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010212#五子棋$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010216#五子棋$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010217#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010218#五子棋$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010204#五子棋$changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010204#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010202#五子棋$changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010202#五子棋$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010102#五子棋" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();
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

}
