package org.effectivejava.examples.chapter07.item47;

import java.math.BigDecimal;

/**
 * prefer BigDecimal, int and long for precise computing to float and double
 * @author Administrator
 *
 */
public class ApproximateAndPreciseCompute {

	public static void main(String[] args) {
		// approximate compute of double(or float) type
		double funds = 1.00;
		int itemBought = 0;
		for(double price = 0.10; funds >= price; price += 0.10){
			itemBought++;
			funds -= price;
		}
		System.out.println(itemBought + " items bought.");
		System.out.println("Money left over: $" + funds);
		
		System.out.println("---------------------------");
		
		// precise compute of BigDecimal(or int, long) type
		// using long for range beyond 10^18. BigDecimal is slow, and of trouble
		// using int for range below 10^9
		// using long for range below 10^18
		final BigDecimal TEN_CENTS = new BigDecimal("0.10");
		BigDecimal funds1 = new BigDecimal("1.00");
		int itemBought1 = 0;
		for(BigDecimal price = TEN_CENTS; funds1.compareTo(price) >= 0; price = price.add(TEN_CENTS)){
			itemBought1++;
			funds1 = funds1.subtract(price);
		}
		System.out.println(itemBought1 + " items bought.");
		System.out.println("Money left over: $" + funds1);
	}
}
