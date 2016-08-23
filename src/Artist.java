/**
 * Music Player, Part 1
 * Artist class
 *
 * @author Meriel Stein
 * @version 1/23/2016
 * 
 */


public class Artist {
	 
	private String firstName, lastName;
	 
	/**default constructor*/
	    public Artist(){
	        this.firstName = "(first name unknown)";
	        this.lastName = "(last name unknown)";
	    }
	    
	    public Artist(String firstName, String lastName){
	        this.firstName = firstName;
	        this.setLastName(lastName);
	    }
	    
	    public String getFirstName(){
	        return firstName;
	    }
	    
	    public void setFirstName(String firstName){
	    	this.firstName = firstName;
	    }
	    
	    public String getLastName(){
	        return lastName;
	    }
	    
	    public void setLastName(String lastName){
	    	if (lastName.length() == 0){
	    		this.lastName = "(last name unknown)";
	    	}
	    	else{
	    		this.lastName = lastName;
	    	}
	    }
	    
	    @Override
	    public String toString(){
	    	if (firstName.equals("")){
	    		return lastName;
	    	}
	    	return firstName+" "+lastName;
	    }
}

