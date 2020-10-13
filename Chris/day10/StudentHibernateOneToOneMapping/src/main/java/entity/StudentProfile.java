package entity;

import javax.persistence.Table;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Table(name = "student_profiles")
public class StudentProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private StudentGender studentGender;

	@Column(name = "birth_of_date")
	private LocalDate birthOfDate;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "studentProfile")
	private Student student;

	public StudentProfile() {

	}

	public StudentProfile( StudentGender studentGender, LocalDate birthOfDate) {
		super();
		
		this.studentGender = studentGender;
		this.birthOfDate = birthOfDate;
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public StudentGender getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(StudentGender studentGender) {
		this.studentGender = studentGender;
	}

	public LocalDate getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(LocalDate birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}