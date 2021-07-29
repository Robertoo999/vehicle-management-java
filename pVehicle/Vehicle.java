//Create package
package pVehicle;

import java.util.*;

//class to create new object to store vehicle information
class InfoVehicle
{
	Scanner sc=new Scanner(System.in);
	public String dealer,register="Available",customer;
	String brand,model,color,type,fuel,year,price;
	static int newid=100;
	int id=0,custid,dealid;
	InfoVehicle(String dealer,int dealid, String brand, String model, String type, String year, String color,String fuel, String price)
	{
		this.dealer = dealer;
		this.dealid = dealid;
		this.brand=brand;
		this.model=model;
		this.type=type;
		this.year=year;
		this.color=color;
		this.fuel=fuel;
		this.price=price;
		id=newid++;
		
	}
}

//class to create vector list of vehicles
public class Vehicle
{
	//local variables for information
	public ArrayList<String> Vid=new ArrayList<String>();
	public ArrayList<String> Vbrand=new ArrayList<String>();
	public ArrayList<String> Vmodel=new ArrayList<String>();
	public ArrayList<String> Vtype=new ArrayList<String>();
	public ArrayList<String> Vcolor=new ArrayList<String>();
	public ArrayList<String> Vyear=new ArrayList<String>();
	public ArrayList<String> Vfuel=new ArrayList<String>();
	public ArrayList<String> Vprice=new ArrayList<String>();
	public ArrayList<String> Cid=new ArrayList<String>();
	public ArrayList<String> Cname=new ArrayList<String>();
	public ArrayList<String> Vstatus=new ArrayList<String>();
	public ArrayList<String> Did=new ArrayList<String>();
	public ArrayList<String> Dname=new ArrayList<String>();
	
	//storing vehicle info
	public Vector<InfoVehicle> v=new Vector<InfoVehicle>();
	
	//storing registered vehicle info
	Vector <InfoVehicle> rv=new Vector<InfoVehicle>();
	
	//to create and add new vehicle to the vector list
	public void addVehicle(String dealer,int dealid, String brand, String model, String type, String year, String color,String fuel, String price)
	{
		InfoVehicle vehicle = new InfoVehicle(dealer, dealid,brand,model,type,year,color,fuel,price);
		v.add(vehicle);
	}
	
	//to delete vehicle from vector list
	public void removeVehicle(String ID)
	{
		int index=Integer.valueOf(ID);
		for(int i=0; i<v.size(); i++)
		{
			if(v.get(i).id==index)
			{
				v.remove(v.get(i));
				break;
			}
		}
		for(int j=0;j<rv.size();j++)
		{
			if(rv.get(j).id==index)
			{
				rv.remove(rv.get(j));
				break;
			}
		}
	}
	
	//to delete all vehicles of given dealer
	public void deleteAllVehicle(String dealer)
	{
		for(int i=0; i<v.size(); i++)
		{
			if(v.get(i).dealer.equals(dealer))
			{
				v.remove(v.get(i));
				if(v.get(i).register.equals("Pending"))
					rv.remove(v.get(i));
			}
		}
	}
	
	//to print details of vehicle of a given dealer
	public void vehicleDetails(String uname)
	{
		InfoVehicle temp;
		for(int i=0; i<v.size(); i++)
		{
			if(v.get(i).dealer.equals(uname))
			{
				temp = v.get(i);
				Vid.add(Integer.toString(temp.id));
				Vbrand.add(temp.brand);
				Vmodel.add(temp.model);
				Vtype.add(temp.type);
				Vcolor.add(temp.color);
				Vyear.add(temp.year);
				Vfuel.add(temp.fuel);
				Vprice.add(temp.price);
				Vstatus.add(temp.register);
			}
		}
	}
	
	//clear all temp vectors
	public void clearall()
	{
		Cid.clear();
		Cname.clear();
		Vid.clear();
		Vbrand.clear();
		Vmodel.clear();
		Vprice.clear();
		Vstatus.clear();
		Vtype.clear();
		Vcolor.clear();
		Vyear.clear();
		Vfuel.clear();
		Did.clear();
		Dname.clear();
	}
	
	//to print customer requests of given dealer
	public void requestDetails(String uname)
	{
		InfoVehicle temp;
		for(int i=0; i<rv.size(); i++)
		{
			if(rv.get(i).dealer.equals(uname))
			{
				temp = rv.get(i);
				Cid.add(Integer.toString(temp.custid));
				Cname.add(temp.customer);
				Vid.add(Integer.toString(temp.id));
				Vbrand.add(temp.brand);
				Vmodel.add(temp.model);
				Vprice.add(temp.price);
				Vstatus.add(temp.register);
			}
		}
	}
	
	
	//to print dealer orders of given customer
		public void orderDetails(String uname)
		{
			InfoVehicle temp;
			for(int i=0; i<rv.size(); i++)
			{
				if(rv.get(i).customer.equals(uname))
				{
					temp = rv.get(i);
					Did.add(Integer.toString(temp.dealid));
					Dname.add(temp.dealer);
					Vid.add(Integer.toString(temp.id));
					Vbrand.add(temp.brand);
					Vmodel.add(temp.model);
					Vprice.add(temp.price);
					Vstatus.add(temp.register);
				}
			}
		}
	
	//to buy vehicle
	public void buyVehicle(int id, String customer, int custid)
	{
		for(int i=0; i<v.size();i++)
		{
			if(v.get(i).id == id)
			{
				registerVehicle(v.get(i), customer, custid);
				break;
			}
		}
	}
	
	//to register vehicle to customer and inform dealer
	public void registerVehicle(InfoVehicle temp, String buyer, int buyerid)
	{
		temp.register="Pending";
		temp.customer=buyer;
		temp.custid=buyerid;
		rv.add(temp);
	}
	
	//to accept request of customer
	public void acceptRequest(String dealer, int ID)
	{
		for(int i=0; i<rv.size(); i++)
		{
			if(rv.get(i).dealer.equals(dealer) && rv.get(i).id==ID)
			{
				InfoVehicle temp = rv.get(i);
				v.remove(temp);
				temp.register="Accepted";
				break;
			}
		}
		
	}
	
	//deny request from customer
	public void denyRequest(String dealer, int ID)
	{
		for(int i=0; i<rv.size(); i++)
		{
			if(rv.get(i).dealer.equals(dealer) && rv.get(i).id==ID)
			{
				InfoVehicle temp = rv.get(i);
				temp.register="Available";
				temp.customer=null;
				rv.remove(temp);
				break;
			}
		}
	}
	
	//cancel order by customer
	public void cancelOrder(String customer, int ID)
	{
		for(int i=0; i<rv.size(); i++)
		{
			if(rv.get(i).customer.equals(customer) && rv.get(i).id==ID)
			{
				InfoVehicle temp = rv.get(i);
				temp.register="Available";
				temp.customer=null;
				rv.remove(temp);
				break;
			}
		}
	}
	
	//cancel all orders when deleting customer account
	public void cancelAllOrders(String customer)
	{
		for(int i=0; i<rv.size(); i++)
		{
			if(rv.get(i).customer.equals(customer) && rv.get(i).register.equals("Pending"))
			{
				InfoVehicle temp = rv.get(i);
				temp.register="Available";
				temp.customer=null;
				rv.remove(temp);
			}
			else if(rv.get(i).customer.equals(customer) && rv.get(i).register.equals("Accepted"))
			{
				InfoVehicle temp = rv.get(i);
				rv.remove(temp);
			}
		}
	}

	
	//to display all vehicles
	public void displayAllVehicles()
	{
		for(int i=0; i<v.size(); i++)
		{
			InfoVehicle temp = v.get(i);
			if(temp.register.equals("Available")) {
				Did.add(Integer.toString(temp.dealid));
				Dname.add(temp.dealer);
				Vid.add(Integer.toString(temp.id));
				Vbrand.add(temp.brand);
				Vmodel.add(temp.model);
				Vtype.add(temp.type);
				Vcolor.add(temp.color);
				Vyear.add(temp.year);
				Vfuel.add(temp.fuel);
				Vprice.add(temp.price);
				Vstatus.add(temp.register);
			}
		}
	}
	
	//get list for table for sorting vehicle list
	public void displaySortedVehicles(String dealer, String brand, String type, String fuel) {
		displayAllVehicles();
		if(!dealer.equals("")) {
			for(int i=0;i<Vid.size();i++) {
				if(!Dname.get(i).equals(dealer)) {
					deleteVector(i);
					i--;
					}
			}
		}
		if(!brand.equals("")) {
			for(int i=0;i<Vid.size();i++) {
				if(!Vbrand.get(i).equals(brand)) {
					deleteVector(i);
					i--;
					}
			}
		}
		if(!type.equals("")) {
			for(int i=0;i<Vid.size();i++) {
				if(!Vtype.get(i).equals(type)) {
					deleteVector(i);
					i--;
					}
			}
		}
		if(!fuel.equals("")) {
			for(int i=0;i<Vid.size();i++) {
				if(!Vfuel.get(i).equals(fuel)) {
					deleteVector(i);
					i--;
					}
			}
		}
	}
	
	//simple function to remove elements from temp vectors for index i
	private void deleteVector(int i) {
		Did.remove(i);
		Dname.remove(i);
		Vid.remove(i);
		Vbrand.remove(i);
		Vmodel.remove(i);
		Vtype.remove(i);
		Vcolor.remove(i);
		Vyear.remove(i);
		Vfuel.remove(i);
		Vprice.remove(i);
		Vstatus.remove(i);
	}
	
		//Placeholder
	public static void main(String args[])
	{
	
	}
}
