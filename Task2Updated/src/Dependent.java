
public class Dependent {

	private String Essn;
	private String Dependentname;
	private char Sex;
	private String Bdate;
	private String Relationship;
	
	public Dependent()
	{
		
	}
	public Dependent(String Essn, String Dependentname, char Sex, String Bdate,  String Relationship)
	{
		this.Essn = Essn;
		this.Dependentname=Dependentname;
		this.Sex=Sex;
		this.Bdate=Bdate;
		this.Relationship=Relationship;
	}
 
	public String getEssn() {
		return Essn;
	}
 
	public void setEssn(String Essn) {
		this.Essn = Essn;
	}
 
	public String getDependentName() {
		return Dependentname;
	}
 
	public void setDependentName(String Dependentname) {
		this.Dependentname = Dependentname;
	}

	public char getSex() {
		return Sex;
	}
	
	public void setSex(char Sex) {
		this.Sex = Sex;
	}
	
	public String getBdate() {
		return Bdate;
	}
 
	public void setBdate(String Bdate) {
		this.Bdate = Bdate;
	}
	
	public String getRelationship() {
		return Relationship;
	}
	public void setRelationship(String Relationship) {
		this.Relationship = Relationship;
	}
}
