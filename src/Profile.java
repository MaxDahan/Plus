
public class Profile {
	private String name;
	private String ip;
	private String port;
	private boolean me;
	public Profile(String name, String ip, String port, boolean me) {
		this.ip = ip;
		this.name = name;
		this.me = me;
		this.port = port;
	}
	public String getName() {
		return this.name;
	}
	public String getIP() {
		return this.ip;
	}
	public boolean isMe() {
		return this.me;
	}
	public String getPort() {
		return this.port;
	}
	public String toString() {
		return this.name + "\t" + this.ip;
	}
	public boolean equals(Profile o) {
		return this.name.equals(o.name);
	}
}
