import java.io.Serializable;

public class Card implements Serializable {
	private String type;
	private String hp;
	private String name;
	/**
	 * 
	 * @param t : type
	 * @param h : hp
	 * @param n : name
	 */
	public Card(String t, String h, String n){
		this.type = t;
		this.hp = h;  
		this.name = n;
	}

	public String getType() {
		return type;
	}
	
	public String getHp() {
		return hp;
	}
	
	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setHP(String hp) {
		this.hp = hp;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}