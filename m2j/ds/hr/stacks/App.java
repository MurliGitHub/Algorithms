package m2j.ds.hr.stacks;

import java.math.BigDecimal;

public class App {
	public static void main(String[] args) {
		Double f= (double) 1620;
		Double el= (double) 85;
		
		BigDecimal b = new BigDecimal(f);
		b=b.setScale(4, 4).stripTrailingZeros();
		BigDecimal c = new BigDecimal(el);
		c= c.setScale(4, 4).stripTrailingZeros();
		System.out.println(b);
		System.out.println(c);
		
//		BigDecimal mult = b.multiply(c);
//		System.out.println("Multi: "+mult);
		
		BigDecimal mult = BigDecimal.ZERO;
		BigDecimal sum = BigDecimal.ZERO;
		
		mult = mult.add(b.multiply(c));
		System.out.println("Multi: "+mult);
		
		sum = sum.add(b);
		System.out.println("Sum: "+ sum);
		
		mult = getScaledBigDecimal(mult);
		System.out.println("Str mult: "+mult);
		sum = getScaledBigDecimal(sum);
		System.out.println("Str sum: "+sum);

		BigDecimal weightedSum = mult.divide(sum, 4);
		
		
		System.out.println("Div: "+weightedSum);
		
		BigDecimal bDecimal = new BigDecimal(3.000);
		System.out.println("trail zeoro: "+getScaledBigDecimal(bDecimal));
	}
	
	private static BigDecimal getScaledBigDecimal(BigDecimal value) {
		if (value == null)
			return null;
		
		value = value.setScale(4, 4).stripTrailingZeros();
		return value;
	}

}
