package com.rizvi.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	@NotBlank(message = "Please Add Department Name")
/*    @Length(max = 5, min = 1)
    @Size(max = 10, min = 0 )
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @Future
    @FutureOrPresent
    @PastOrPresent*/
	private String firstName;
	private String lastName;
	private String email;


	public Student() {
	}


	public Student(Long studentId, String firstName, String lastName, String email) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
