package test.object_writeread;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {

		User user = new User("김태훈");

		Crew crew = new Crew();

		crew.getUserList().add(user);
		crew.getUserList().add(new User("최용석"));
		crew.getUserList().add(new User("최선호"));
		crew.getUserList().add(new User("문대훈"));
		crew.getUserList().add(new User("유기용"));
		crew.getUserList().add(new User("서민지"));

		System.out.println(crew);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("crew.txt"))) {

			for (User u : crew.getUserList()) {
				oos.writeObject(u);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("crew.txt"))) {

			crew.getUserList().clear();

			while (true) {
				crew.getUserList().add((User) ois.readObject());
			}

		} catch (EOFException e) {
			System.out.println("파일 읽기 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setName("김태훈2");
		
		System.out.println(crew);
	}

}
