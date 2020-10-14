package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity  
@Table(name="question123")
public class Question {    

@Id   
@GeneratedValue(strategy=GenerationType.TABLE)  
private long id;    
private String qname;    

@OneToMany(cascade = CascadeType.ALL)  
@JoinColumn(name="qid")  
@OrderColumn(name="type")  
private List<Answer> answers= new ArrayList<Answer>(); 


public List<Answer> getAnswers() {
	return answers;
}
public void setAnswers(List<Answer> answers) {
	this.answers = answers;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getQname() {  
  return qname;  
}  
public void setQname(String qname) {  
  this.qname = qname;  
  
}    

public Question() {
	
}

public Question(String qname) {
	super();
	this.qname = qname;  
}

}  