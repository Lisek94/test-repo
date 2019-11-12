package zamówienia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Order implements Serializable
{
	int maxSizeToOrder, howManyAdd;
	Position orders[];

	public Order()
	{
		maxSizeToOrder = 10;
		this.orders = new Position[maxSizeToOrder];		
	}
	
	public Order(int maxSizeToOrder)
	{
		this.maxSizeToOrder = maxSizeToOrder;
		this.orders = new Position[maxSizeToOrder];
	}
	
	public void addPosition(Position position)
	{
		for (int i = 0; i < orders.length; i++) 
		{
			if (position.equals(orders[i])) 
			{
				orders[i].howManyPieces += position.howManyPieces;
				break;
			}
			else if(orders[i]==null)
			{
				orders[i]=position;
				howManyAdd++;
				break;
			}
		}		
	}
		
	public double calculateValueForOrder()
	{
		double result = 0;	
		for (int i = 0; i < orders.length; i++) 
		{
			if(orders[i]!=null) 
			{
				result += orders[i].calculateValue();
			}			
		}		
		return result;
	}
	
	public void deletePosition(int indeks)
	{
		orders[indeks-1] = null;
	}
	
	public void editPosition(int indeks)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("nazwa/liczba/cena?");
		String output = scan.nextLine();
		if (output.equals("nazwa")) 
		{
			System.out.println("wpisz wartoœæ");
			orders[indeks-1].productName = scan.nextLine();
		} 
		else if(output.equals("liczba"))
		{
			System.out.println("wpisz wartoœæ");
			orders[indeks-1].howManyPieces = scan.nextInt();
		}
		else if (output.equals("cena"))
		{
			System.out.println("wpisz wartoœæ");
			orders[indeks-1].price = scan.nextDouble();
		}
		scan.close();
	}
	
	public static void saveOrder(Order o, String fileName) throws IOException 
	{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
		objectOutputStream.writeObject(o);
		objectOutputStream.close();
	}
	
	public static Order readOrder(String fileName) throws IOException, ClassNotFoundException
	{
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
		Order order = (Order) objectInputStream.readObject();
		objectInputStream.close();
		return order;
	}
	
	public String toString()
	{
		System.out.println("Zamówienie:");
		for (int i = 0; i < orders.length; i++) {
			if(orders[i]!=null)
				{
				System.out.println(orders[i]);
				}
		}
		Double result = calculateValueForOrder();			
		result.toString();
		String resultAsString = String.format("%.2f", result);
		return "\nRazem:   " + resultAsString+ " z³";	
	}	
}