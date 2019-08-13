package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatusEx02;

public class OrderEx02 {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatusEx02 status;
	
	private Client client;
	private List<OrderItem> list = new ArrayList<>();
	

	public OrderEx02(Date moment, OrderStatusEx02 status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatusEx02 getStatus() {
		return status;
	}

	public void setStatus(OrderStatusEx02 status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getList() {
		return list;
	}

	public void addItem(OrderItem item) {
		list.add(item);
	}
	
	public void removeItem(OrderItem item) {
		list.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for(OrderItem obj : list) {
			sum += obj.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : list) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		
	}
	

}
