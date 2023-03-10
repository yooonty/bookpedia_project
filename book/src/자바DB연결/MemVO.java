package 자바DB연결;

public class MemVO {
	private String id;
	private String pw;
	private String nickName;
	private String let;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLet() {
		return let;
	}
	public void setLet(String let) {
		this.let = let;
	}
	
	@Override
	public String toString() {
		return "MemVO [id=" + id + ", pw=" + pw + ", nickName=" + nickName + ", let=" + let + "]";
	}
	
	
	
}
