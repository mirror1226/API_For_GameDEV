import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
	/** Called when the activity is first created. */

	// ������IP���˿ں�
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
			// ���ӷ�����
			mSocket = new Socket(SERVERIP, SERVERPORT);
			// Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

			// ȡ�����������
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
			String strSend = "#010101#������" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010201#������$changych&12345&12345&cyc@gmail.com" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010201#������$changrui&1245&1345&rui@gmail.com" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010203#������$changych&12345&218.193.190.199" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010203#������$changrui&1245&218.193.190.199" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010205#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010206#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010205#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010208#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010209#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010211#������$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010207#������$changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010212#������$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010216#������$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010217#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010218#������$changrui&changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010204#������$changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010204#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010202#������$changych" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010202#������$changrui" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

			Thread.sleep(1000);
			strSend = "#010102#������" + "\n";
			mPrintWriter.print(strSend);
			mPrintWriter.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// �̣߳�������������������Ϣ
	private static Runnable mRunnable = new Runnable() {
		public void run() {
			while (true) {
				try {
					if ((mStrMSG = mBufferedReader.readLine()) != null) {
						// ��Ϣ����
						mStrMSG += "\n";
						System.out.print(mStrMSG);
					}
				} catch (Exception e) {
				}
			}
		}
	};

}
