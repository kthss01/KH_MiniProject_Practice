package test.object_writeread;

import java.io.Serializable;
import java.util.ArrayList;

public class Crew implements Serializable {
	private ArrayList<User> userList;

	public Crew() {
		// TODO Auto-generated constructor stub
		userList = new ArrayList<User>();
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (User user : userList) {
			sb.append(user).append("\n");
		}
		
		return sb.toString();
	}

	
}
