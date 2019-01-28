
public class WorksOn {

	private String Essn;
	private long Pno;
	private double Hours;
	
	public WorksOn()
	{
		
	}
	public WorksOn(String Essn, long Pno, double Hours)
	{
		this.Essn = Essn;
		this.Pno = Pno;
		this.Hours = Hours;
	}
 
	public String getEssn() {
		return Essn;
	}
 
	public void setEssn(String Essn) {
		this.Essn = Essn;
	}
 
	public long getPno() {
		return Pno;
	}
 
	public void setPno(long Pno) {
		this.Pno = Pno;
	}
	
	public double getHours() {
		return Hours;
	}
 
	public void setHours(double Hours) {
		this.Hours = Hours;
	}
	
	
}
