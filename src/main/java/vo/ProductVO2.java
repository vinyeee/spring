package vo;

import java.util.HashMap;

public class ProductVO2 {
	private HashMap<String, Integer> info = new HashMap<String, Integer>();;

	public void setInfo(String name, int count) {
		if (info.size() != 0 && info.containsKey(name))
			info.put(name, info.get(name) + count);
		else {
			info.put(name, count);
		}
	}

	public HashMap<String, Integer> getinfo() {
		return info;
	}
}
