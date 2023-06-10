//Create package
package pDealer;

import pVehicle.*;
import pDetails.*;
import java.util.*;

//class to create new object to store dealer information
class InfoDealer extends Details
{
	static int newid=400;
	int id;
	InfoDealer(String uname, String pass, String name, String city, String phone,String email)
	{
		id=newid++;
		userdetails(uname,pass,name,city,phone,email);
	}
}

//class to create vector list of dealers
public class Dealer
{
	
	//local variables for information
	public ArrayList<String> Did=new ArrayList<String>();
	public ArrayList<String> Duname=new ArrayList<String>();
	public ArrayList<String> Dname=new ArrayList<String>();
	public ArrayList<String> Dcity =new ArrayList<String>();
	public ArrayList<String> Dphone=new ArrayList<String>();
	public ArrayList<String> Demail=new ArrayList<String>();
	
	public List<InfoDealer> v=new ArrayList<>();

	public InfoDealer loggedinDealer;
	//to create and add new dealer to the vector list
	public void addDealer(String uname, String pass, String name, String city, String phone,String email)
	{
		InfoDealer dealer = new InfoDealer(uname,pass,name,city,phone,email);
		v.add(dealer);
	}
	
	//make sure for unique usernames
	public boolean checkDUsername(String uname)
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
	
	//to find dealer object info
	public void findDealer(String uname) {
		for(int i=0; i<v.size(); i++) {
			if(v.get(i).uname.equals(uname))
			{
				loggedinDealer =v.get(i);
				break;
			}
		}
	}
	
	//to display all vehicles
	public void displayAllDealers()
	{
		for(int i=0; i<v.size(); i++)
		{
			InfoDealer temp = v.get(i);
			Dname.add(temp.name);
			Did.add(Integer.toString(temp.id));
			Duname.add(temp.uname);
			Dcity.add(temp.city);
			Dphone.add(temp.phone);
			Demail.add(temp.email);
		}
	}

	//clear all temp vectors
	public void clearall()
	{
		Duname.clear();
		Dcity.clear();
		Dphone.clear();
		Demail.clear();
		Did.clear();
		Dname.clear();
	}

	//create list with all dealer names
	public String[] DealerList() {
		String[] list= new String[v.size()+1];
		list[0]="";
		for(int i=0;i<v.size();i++) {
			list[i+1]=v.get(i).uname;
		}
		return list;
	}
	
	//to get current user info
	public boolean loginDealer(String uname, String pass)
	{
		boolean flag=false;
		for(int i=0; i<v.size(); i++)
		{
			if(v.get(i).uname.equals(uname) && v.get(i).pass.equals(pass))
			{
				flag=true;
				loggedinDealer=v.get(i);
				break;
			}
		}
		return flag;
	}
	
	//to get dealer details
	public String DealerDetails(int i)
	{
		if(i==0)
			return loggedinDealer.uname;
		else if(i==1)
			return loggedinDealer.name;
		else if(i==2)
			return loggedinDealer.city;
		else if(i==3)
			return loggedinDealer.phone;
		else if(i==4)
			return loggedinDealer.email;
		else if(i==5)
			return Integer.toString(loggedinDealer.id);
		else
			return null;
	}
	

	//Delete a dealer along with his vehicles
	public void deleteDealer(String dealer, Vehicle vh)
	{
		for(int i=0; i<v.size(); i++)
		{
			if(v.get(i).uname.equals(dealer))
			{
				v.remove(v.get(i));
				vh.deleteAllVehicle(dealer);
				break;
			}
		}
	}
	
	//Placeholder
	public static void main(String[] args)
	{
	
	}
}
