package zamówienia;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Position implements Serializable
{
	String productName;
	Integer howManyPieces;
	Double price;
	
	public Position() {}
	public Position(String productName,int howManyPieces, double price)
	{
		this.productName = productName;
		this.howManyPieces = howManyPieces;
		this.price = price;
	}
	
	public double calculateValue()
	{		
		double value = howManyPieces*price - calculateValueWithRabat();
		return value;
	}
	
	public double calculateValueWithRabat()
	{
		double value = howManyPieces*price;
		double rabat = 0;
		if(howManyPieces>4&&howManyPieces<11)
		{
			rabat = value-value * 0.95;
		}
		else if(howManyPieces>10&&howManyPieces<21)
		{
			rabat = value-value * 0.9;
		}
		else if(howManyPieces>20)
		{
			rabat = value-value * 0.85;
		}
		
		return rabat;
		
	}
	
	public String toString()
	{		
		howManyPieces.toString();
		String formatHowManyPieces = String.format("%4s", howManyPieces);
		
		price.toString();
		String formatPrice = String.format("%10s", price);	
		
		Double rabat = calculateValueWithRabat();
		rabat.toString();
		String formatRabat = String.format("%4.2f", rabat);
		
		Double calculateValue = calculateValue();
		calculateValue.toString();
		String formatCalculateValue = String.format("%10.2f", calculateValue);
		
		String formatProductName = String.format("%-20s", productName);
		
		String result = formatProductName+formatPrice+" z³"+formatHowManyPieces+" szt"+formatCalculateValue+
				" z³ (-"+formatRabat+" z³)";
		
		return result;		
	}
}