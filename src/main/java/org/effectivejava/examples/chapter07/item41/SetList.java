// What does this program print? - Page 194
package org.effectivejava.examples.chapter07.item41;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		for (int i = -3; i < 3; i++) {
			set.add(i);
			list.add(i);
		}

		for (int i = 0; i < 3; i++) {
			set.remove(i); // remove(E)
			list.remove(i); // remove(index)
//			list.remove(Integer.valueOf(i)); // remove(E)
		}

		System.out.println(set + " " + list);
	}
}
