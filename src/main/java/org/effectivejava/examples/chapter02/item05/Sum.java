package org.effectivejava.examples.chapter02.item05;

public class Sum {
	// Hideously slow program! Can you spot the object creation?
	public static void main(String[] args) {
		long start = System.nanoTime();
		Long sum = 0L; // constantly auto-unboxing and auto-boxing
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		long end = System.nanoTime();
		System.out.println(end - start);
		
		start = end;
		long sum1 = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum1 += i;
		}
		end = System.nanoTime();
		System.out.println(end - start);
	}
}
