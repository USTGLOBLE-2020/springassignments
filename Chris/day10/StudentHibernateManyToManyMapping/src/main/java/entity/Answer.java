package entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity  
@Table(name="answer123")  
public class Answer {   
@Id  
@GeneratedValue(strategy=GenerationType.TABLE)  
private long id;

@ManyToMany(cascade = CascadeType.ALL)  
@JoinTable(name = "question_answer",
joinColumns = { @JoinColumn(name = "question_id")},
inverseJoinColumns = { @JoinColumn (name = "answer_id")})

private Set<Question> question= new HashSet<>();
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
public Set<Question> getQuestion() {
	return question;
}
public void setQuestion(Set<Question> question) {
	this.question = question;
}
public Answer() {
	
}

public Answer(String answername,String postedBy) {
	super();
	this.answername = answername;
	this.postedBy=postedBy;
}




}