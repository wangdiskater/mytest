package mytest.jdk.reflect;


import java.time.LocalDateTime;

public class ReflectUser {
	private int id;
	private String username;
	private LocalDateTime birthday;
	private String sex;
	private String address;

	public ReflectUser(int id, String username, LocalDateTime birthday, String sex, String address) {
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

	public ReflectUser() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ReflectUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", birthday=" + birthday +
				", sex='" + sex + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
