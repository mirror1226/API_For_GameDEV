import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class ClientTalk {
	public static void main(String args[]){
		try{
			Socket socket = new Socket("127.0.0.1", 54321);
			System.out.println(InetAddress.getLocalHost());
			
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String readline;
			
			//readline = "#010101#test";
			//readline = "#010201#test$mirror&123&123&test@sjtu.edu.cn";
			//readline = "#010202#mirror$test";
			//readline = "#010203#test$test&123&Íæ¼ÒIPµØÖ·";
			//readline = "#010221#test$test&1.111&1.221";
			//readline = "#010222#test$mirror&1.111&1.222";
			//readline = "#010211#test$mirror&test";
			//readline = "#010212#test$mirror&test";
			//readline = "#010216#test$mirror&t";
			//readline = "#010217#test$test";
			readline = "#010218#test$test&mirror";
			os.println(readline);
			os.flush();
			System.out.println("Server:" + is.readLine());
		
					
			
			
			//NewUser
			//readline = "NewUser,test2,123456,123456";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//Login
			//readline = "Login,test1,123456";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//Logout
			//readline = "Logout,mirror";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//FillVCard
			//readline = "FillVCard,test2,654321,test2@sjtu.edu.cn";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//Check
			//readline = "Check,test1,12.1111,13.1451";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//Show VCard
			//readline = "ShowVCard,mirror";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//Show Nearby
			//readline = "ShowNearby,mirror,12.1111,13.1452";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//Search User
			//readline = "SearchUser,mirror,test";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//ExchangeReq
			//readline = "ExchangeReq,test1,test2";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//ExchangeAck
			//readline = "ExchangeAck,test1,mirror,YES";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//ShowMessage
			//readline = "ShowMessage,test1";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			//FindOnlineFriend
			//readline = "FindOnlineFriend,mirror";
			//os.println(readline);
			//os.flush();
			//System.out.println("Server:" + is.readLine());
			
			os.close();
			is.close(); 
			socket.close();
		} 
		catch (Exception e){
			System.out.println("error:" + e);
		}
	}

}
