// Singleton with static factory - Page 17
package org.effectivejava.examples.chapter02.item03.method;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Elvis implements Serializable{
	
	private static final long serialVersionUID = -3970194959824190370L;
	
	private static final Elvis INSTANCE = new Elvis();

	private Elvis() {
	}

	public static Elvis getInstance() {
		return INSTANCE;
	}

	public void leaveTheBuilding() {
		System.out.println("Whoa baby, I'm outta here!");
	}

	/**
	 * 如果被反序列化的对象的类存在readResolve这个方法，反序列化时它会调用这个方法来返回一个“array”（我也不明白），然后浅拷贝一份，作为返回值，并且无视掉反序列化的值，即使那个字节码已经被解析。 
	 */
	private Object readResolve() {
		// Return the one true Elvis and let the garbage collector
		// take care of the Elvis impersonator.
		return INSTANCE;
	}

	// This code would normally appear outside the class!
	public static void main(String[] args) {
		Elvis s = Elvis.getInstance();
		s.leaveTheBuilding();

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("a.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	        try {
				oos.flush();
		        oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

        FileInputStream fis = null;
        ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("a.txt");
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elvis s1 = null;
        try {
			s1 = (Elvis) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        System.out.println(s == s1); // readResolve method exists, return true; otherwise, return false.
	}
}
