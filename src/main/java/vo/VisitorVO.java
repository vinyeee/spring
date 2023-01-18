package vo;

public class VisitorVO {
	int id;
	String name;
	String writedate;
	String memo;
	
	
	public VisitorVO() {
		super();
	}
	public VisitorVO(String name, String memo) {
		this.name = name;
		this.memo = memo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	
}