//Create package
package pCustomer;

import pVehicle.*;
import pDetails.*;
import java.util.*;

//class to create new object to store Customer information
class InfoCustomer extends Details
{
	static int newid=300;
	int id=0;
	InfoCustomer(String uname, String pass, String name, String region, String phone,String email)
	{
		id=newid++;
		userdetails(uname,pass,name,region,phone,email);		
	}
}

//class to create vector list of dealers
public class Customer
{
	
	//local variables for information
	public ArrayList<String> Cid=new ArrayList<String>();
	public ArrayList<String> Cuname=new ArrayList<String>();
	public ArrayList<String> Cname=new ArrayList<String>();
	public ArrayList<String> Cregion=new ArrayList<String>();
	public ArrayList<String> Cphone=new ArrayList<String>();
	public ArrayList<String> Cemail=new ArrayList<String>();
	
	public Vector<InfoCustomer> v=new Vector<InfoCustomer>();
	
	public InfoCustomer loggedinCustomer;
	//to create and add new Customer to the vector list
	public void addCustomer(String uname, String pass, String name, String region, String phone,String email)
	{
		InfoCustomer customer = new InfoCustomer(uname,pass,name,region,phone,email);
		v.add(customer);
	}
	
	//to display all the customers
	public void displayAllCustomers()
	{
		for(int i=0; i<v.size(); i++)
		{
			InfoCustomer temp = v.get(i);
			Cname.add(temp.name);
			Cid.add(Integer.toString(temp.id));
			Cuname.add(temp.uname);
			Cregion.add(temp.region);
			Cphone.add(temp.phone);
			Cemail.add(temp.email);
		}
	}
	
	//clear all temp vectors
	public void clearall()
	{
		Cuname.clear();
		Cregion.clear();
		Cphone.clear();
		Cemail.clear();
		Cid.clear();
		Cname.clear();
	}
	
	//make sure for unique usernames
		public boolean checkCUsername(String uname)
		{
			boolean flag=false;
			for(int i=0; i<v.size(); i++)
			{
				if(v.get(i).uname.equals(uname))
				{
					flag=true;
					break;
				}
			}
			return flag;
		}
	
	//find customer using customer username
	public void findCustomer(String uname) {
		for(int i=0; i<v.size(); i++) {
			if(v.get(i).uname.equals(uname))
			{
				loggedinCustomer =v.get(i);
				break;
			}
		}
	}
	
	//to display customer info
	public String CustomerDetails(int i)
	{
		if(i==0)
			return loggedinCustomer.uname;
		else if(i==1)
			return loggedinCustomer.name;
		else if(i==2)
			return loggedinCustomer.region;
		else if(i==3)
			return loggedinCustomer.phone;
		else if(i==4)
			return loggedinCustomer.email;
		else if(i==5)
			return Integer.toString(loggedinCustomer.id);
		else
			return null;
	}
	
	//login for Customer
	public boolean loginCustomer(String uname, String pass, Vehicle vh)
	{
		boolean flag=false;
		for(int i=0; i<v.size(); i++)
		{
			if(v.get(i).uname.equals(uname) && v.get(i).pass.equals(pass))
			{
				flag=true;
				loggedinCustomer=v.get(i);
				break;
			}
			else
				flag=false;
		}
		return flag;
	}
	
	//Delete a Customer along with his vehicles
	public void deleteCustomer(String customer, Vehicle vh)
	{
		for(int i=0; i<v.size(); i++)
		{
			if(v.get(i).uname.equals(customer))
			{
				v.remove(v.get(i));
				vh.cancelAllOrders(customer);
				break;
			}
		}
	}
	
	//Placeholder
	public static void main(String args[])
	{
	
	}
}
