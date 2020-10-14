package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="answer123")  
public class Answer {   
@Id  
@GeneratedValue(strategy=GenerationType.TABLE)  
private long id;


private String answername;    
private String postedBy;  

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

public String getAnswername() {  
    return answername;  
}  
public void setAnswername(String answername) {  
    this.answername = answername;  
}  
public String getPostedBy() {  
    return postedBy;  
}  
public void setPostedBy(String postedBy) {  
    this.postedBy = postedBy;  
}
public Answer() {
	
}

public Answer(String answername,String postedBy) {
	super();
	this.answername = answername;
	this.postedBy=postedBy;
}




}