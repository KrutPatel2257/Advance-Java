import java.io.*;

//Student implements Serializable to convert its object into byte stream.
class Student implements Serializable{
	String enrollno;
	String name;
	
	public void setEnrollno(String enrollno){
		this.enrollno = enrollno;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getEnrollno(){
		return enrollno;
	}
	
	public String getName(){
		return name;
	}
}