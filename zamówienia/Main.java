package zamówienia;

import java.io.IOException;


public class Main 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		Position firsOrder = new Position("Cukier", 3, 4);
		Position secondOrder = new Position("M¹ka", 4, 3);
		Position thirdOrder = new Position("Chipsy Lays", 1, 5);
		Position fourthOrder = new Position("Cola 2L", 11, 4.5);
		
		Order order = new Order(5);
		order.addPosition(firsOrder);
		order.addPosition(secondOrder);
		order.addPosition(thirdOrder);
		order.addPosition(thirdOrder);
		order.addPosition(fourthOrder);
				
		//Order.saveOrder(order, "training.txt");
		System.out.println(Order.readOrder("training.txt"));
		
	}
}
