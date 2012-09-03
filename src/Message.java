import java.util.Date;


public class Message {
	private int type;
	private String msgTo;
	private String content;
	private Date date;
	
	public Message(int t, String to, String content, Date date) {
		type = t;
		msgTo = to;
		this.content = content;
		this.date = date;
	}
	
	public int GetMessageType() {return type;}
	public String GetMsgTo() {return msgTo;}
	public String GetContent() {return content;}
	public Date GetDate() {return date;}

}
