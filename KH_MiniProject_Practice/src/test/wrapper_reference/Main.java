package test.wrapper_reference;

public class Main {

	public static void main(String[] args) {
		Boolean b = false;
		String str = "test";
		
		// boolean test
//		Sub sub = new Sub(b);
//		sub.setB(true);
		
//		b = true;
		
//		sub.getList().add(b);
//		b = true;
		
//		System.out.println("main : " + b);
//		System.out.println("sub : " + sub.getB());
//		System.out.println("sub list : " + sub.getList().get(0));
		
		// String test
//		Sub sub = new Sub(str);
//		
//		sub.getList().add(str);
//		
//		str += "2";
//		
//		System.out.println("main : " + str);
//		System.out.println("sub : " + sub.getStr());
//		System.out.println("sub list : " + sub.getList().get(0));
		
		// StringBuilder test
		StringBuilder sb = new StringBuilder();
		sb.append("test");
		
		Sub sub = new Sub(sb);
		
		sb.append("2");
		
		System.out.println("main : " + sb);
		System.out.println("sub : " + sub.getSb());
	}
}
