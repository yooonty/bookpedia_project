package 자바DB연결;

public class StarVO {
	private int no;
	private int star;
	private String comment;
	private int pick;
	private int read;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPick() {
		return pick;
	}
	public void setPick(int pick) {
		this.pick = pick;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String id;

	@Override
	public String toString() {
		return "StarVO [no=" + no + ", star=" + star + ", comment=" + comment + ", pick=" + pick + ", read=" + read
				+ ", id=" + id + "]";
	}
	
	
}
