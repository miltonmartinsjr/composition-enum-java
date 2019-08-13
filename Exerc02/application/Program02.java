package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderEx02;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatusEx02;

public class Program02 {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		Locale.setDefault(Locale.US);
		Scanner imput = new Scanner(System.in);
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = imput.nextLine();
		System.out.print("Email: ");
		String email = imput.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(imput.next());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatusEx02 status = OrderStatusEx02.valueOf(imput.next());
		
		OrderEx02 order = new OrderEx02(new Date(), status, client);
		
		System.out.print("How many items to this order? ");
		int items = imput.nextInt();
		
		for(int i=1; i<=items; i++) {
			System.out.println();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			imput.nextLine();
			String productName = imput.nextLine();
			System.out.print("Product Price: ");
			double productPrice = imput.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int productQuantity = imput.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
			
			order.addItem(orderItem);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMARY");
		System.out.println(order);
				
		imput.close();
	}

}
