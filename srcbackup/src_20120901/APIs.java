import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class APIs {
	// ������IP���˿ں�
	private static final String SERVERIP = "218.193.190.194";
	// private static final String SERVERIP = "10.140.6.25";
	private static final int SERVERPORT = 54321;
	private static Thread mThread = null;
	private static Socket mSocket = null;

	private static BufferedReader mBufferedReader = null;
	private static PrintWriter mPrintWriter = null;

	private static String mStrMSG = "";
	
	/*
	 * ���캯��
	*/
	public APIs()
	{
		Init();
	}

	/*
	 * ��ʼ��
	 * 
	 */
	public static void Init() {
		try {
			// ���ӷ�����
			mSocket = new Socket(SERVERIP, SERVERPORT);

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
	
	/*
	 * ��Ϸע��
	 * ��������Ϸ����
	 * ����ֵ��ע��ɹ�����1�����򷵻�0
	 */
	public String GameReg(String gameName)
	{
		String strSend = "#010101#������" + "\n";
		mPrintWriter.print(strSend);
		mPrintWriter.flush();
		return mStrMSG;
	}
	
	
}
