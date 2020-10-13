package entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;



@Entity  
@Table(name="question123")
public class Question {    

@Id   
@GeneratedValue(strategy=GenerationType.TABLE)  
private long id;    
private String qname;    

@ManyToMany(cascade = CascadeType.ALL)  
@JoinTable(name = "question_answer",
joinColumns = { @JoinColumn(name = "question_id")},
inverseJoinColumns = { @JoinColumn (name = "answer_id")})

private Set<Answer> answer= new HashSet<>();



public Set<Answer> getAnswer() {
	return answer;
}
public void setAnswer(Set<Answer> answer) {
	this.answer = answer;
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