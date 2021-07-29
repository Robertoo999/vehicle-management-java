package pDetails;

//class to add location details of user

public class Details
{
	public String uname, pass, name, region, email, phone;
	public void userdetails(String uname, String pass, String name, String region, String phone,String email)
	{
		this.uname=uname;
		this.pass=pass;
		this.name=name;
		this.region=region;
		this.phone=phone;
		this.email=email;
	}
}
