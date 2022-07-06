package org.formation.hibernate.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conseiller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String firstName;
	private LocalDate DOB;
	private int salary;
	private String numeroConseiller;
	private LocalDate dateCreation;

	public Conseiller() {
	}

	public Conseiller(String name, String firstName, LocalDate dOB, int salary) {
		super();
		this.name = name;
		this.firstName = firstName;
		DOB = dOB; // ? This ?
		this.salary = salary;
		this.dateCreation = LocalDate.now();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, numeroConseiller);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conseiller other = (Conseiller) obj;
		return id == other.id && Objects.equals(numeroConseiller, other.numeroConseiller);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getNumeroConseiller() {
		return numeroConseiller;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", name=" + name + ", firstName=" + firstName + ", DOB=" + DOB + ", salary="
				+ salary + ", numeroConseiller=" + numeroConseiller + ", dateCreation=" + dateCreation + "]";
	}

}
