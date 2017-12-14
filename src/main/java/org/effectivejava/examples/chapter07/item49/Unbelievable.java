// What does this program do? - Page 222
package org.effectivejava.examples.chapter07.item49;

public class Unbelievable {
	static Integer i;

	public static void main(String[] args) {
		// when mixed maniputing base type and boxing base type, boxing base type will be auto-unboxed
		// auto-unboxing of null object reference will throw NullPointerException
		if (i == 42)
			System.out.println("Unbelievable");
	}
}