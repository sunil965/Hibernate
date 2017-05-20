package com.hibernate_bidirectional.DTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="COUNTRY")
public class Country {
	@Id
	@Column(name="Country_ID")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private int code;
	
	@Column(name="Country_Name")
	private String name;
	
	@Column(name="Language")
	private String language;
	
	@Column(name="Population")
	private int population;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	/*@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="President", referencedColumnName="P_ID")*/
	private President president;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public President getPresident() {
		return president;
	}

	public void setPresident(President president) {
		this.president = president;
	}
}
