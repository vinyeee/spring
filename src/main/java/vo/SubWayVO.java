package vo;

public class SubWayVO {
	private String line;
	private String time;
	private int ride;
	private int takeoff;
	private String linep;
	public SubWayVO() {
	}
	public SubWayVO(String line, String time, int ride, int takeoff, String linep) {
		this.line = line;
		this.time = time;
		this.ride = ride;
		this.takeoff = takeoff;
		this.linep = linep;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getRide() {
		return ride;
	}
	public void setRide(int ride) {
		this.ride = ride;
	}
	public int getTakeoff() {
		return takeoff;
	}
	public void setTakeoff(int takeoff) {
		this.takeoff = takeoff;
	}
	public String getLinep() {
		return linep;
	}
	public void setLinep(String linep) {
		this.linep = linep;
	}
}
