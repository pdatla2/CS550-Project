
public class Employee {

	private String Fname;
	private String Minit;
	private String Lname;
	private String ssn;
	private String Bdate;
	private String address;
	private char sex;
	private double salary;
	private String superssn;
	private Long dno;
	private String email;
	
	public Employee()
	{
		
	}
	public Employee(String Fname, String Minit, String Lname, String ssn,  String Bdate, String address, char sex, double salary, String superssn, Long dno, String email){
		this.Fname = Fname;
		this.Minit = Minit;
		this.Lname=Lname;
		this.ssn=ssn;
		this.Bdate=Bdate;
		this.address=address;
		this.sex=sex;
		this.salary=salary;
		this.superssn=superssn;
		this.dno=dno;
		this.email=email;
	}
 
	public String getFname() {
		return Fname;
	}
 
	public void setFname(String Fname) {
		this.Fname = Fname;
	}
 
	public String getMinit() {
		return Minit;
	}
 
	public void setMinit(String Minit) {
		this.Minit = Minit;
	}
	public String getLname() {
		return Lname;
	}
 
	public void setLname(String Lname) {
		this.Lname = Lname;
	}
	public String getSsn() {
		return ssn;
	}
 
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getBdate() {
		return Bdate;
	}
 
	public void setBdate(String Bdate) {
		this.Bdate = Bdate;
	}
	public String getAddress() {
		return address;
	}
 
	public void setAddress(String address) {
		this.address = address;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getSuperssn() {
		return superssn;
	}
	public void setSuperssn(String superssn) {
		this.superssn = superssn;
	}
	public Long getDno() {
		return dno;
	}
	public void setDno(Long dno) {
		this.dno = dno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
