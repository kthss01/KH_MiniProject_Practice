package test.wrapper_reference;

import java.util.ArrayList;

public class Sub {

	private Boolean b;
	private ArrayList list;
	private String str;
	private StringBuilder sb;
	
	public Sub() {
		list = new ArrayList<>();
	}

	public Sub(Boolean b) {
		this();
		this.b = b;
	}

	public Sub(String str) {
		this();
		this.str = str;
	}

	public Sub(StringBuilder sb) {
		this.sb = sb;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}

	public Boolean getB() {
		return b;
	}

	public void setB(Boolean b) {
		this.b = b;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public StringBuilder getSb() {
		return sb;
	}
}
