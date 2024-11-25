package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.digester.annotations.rules.SetProperty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Citoyen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstNameAr;
	private String firstNameFr;
	private String lastNameAr;
	private String lastNameFr;

	private String email;
	private String cin;
	private String phone;
	private String job;
	private String photoName;
	private String cin1;
	private String cin2;
	private String acteNaissance;
	@OneToMany(mappedBy = "citoyen")
	private List<Attestation> attestations;
	public List<Attestation> getAttestations() {
		return attestations;
	}
	@ManyToOne()
	@JsonIgnore
	private Sex sex;
	@ManyToOne()
	@JsonIgnore
	private Situation situation;
	@JsonIgnore
	public Situation getSituation() {
		return situation;
	}
	@JsonProperty
	public void setSituation(Situation situation2) {
		this.situation = situation2;
	}
	@JsonIgnore
	public Sex getSex() {
		return sex;
	}
	@JsonProperty
	public void setSex(Sex sexe) {
		this.sex = sexe;
	}
	@ManyToOne()
	@JsonIgnore
	private District district;
	@ManyToOne()
	@JsonIgnore
	private Pachalik pachalik;
	public String getActeNaissance() {
		return acteNaissance;
	}

	public void setActeNaissance(String acteNaissance) {
		this.acteNaissance = acteNaissance;
	}
	private String city;
	private Date dateOfBirth;
	private String passeportId;
	private String town;
	@ManyToOne()
	@JsonIgnore
	private Annexe annexe;
	@ManyToOne()
@JsonIgnore
	private Quartier quartier;
	@ManyToOne()
	@JsonIgnore
	private Rue rue;
	@ManyToOne()
	@JsonIgnore
	private Ruelle ruelle;
	@JsonIgnore
	public Quartier getQuartier() {
		return quartier;
	}
@JsonProperty
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
@JsonIgnore
	public Rue getRue() {
		return rue;
	}
@JsonProperty
	public void setRue(Rue rue) {
		this.rue = rue;
	}
@JsonIgnore
	public District getDistrict() {
		return district;
	}
@JsonProperty
	public void setDistrict(District district) {
		this.district = district;
	}
@JsonIgnore
	public Pachalik getPachalik() {
		return pachalik;
	}
@JsonProperty
	public void setPachalik(Pachalik pachalik) {
		this.pachalik = pachalik;
	}
@JsonIgnore
	public Ruelle getRuelle() {
		return ruelle;
	}
@JsonProperty
	public void setRuelle(Ruelle ruelle) {
		this.ruelle = ruelle;
	}

	
	
	public Citoyen() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	public Citoyen(Integer id, String firstNameAr, String firstNameFr, String lastNameAr, String lastNameFr,
			 String email, String cin, String phone, String job, String photoName, String cin1,
			String cin2, String city, Date dateOfBirth, String passeportId, String town, Annexe annexe, String hay,
			String zanqa, String chari3) {
		super();
		this.id = id;
		this.firstNameAr = firstNameAr;
		this.firstNameFr = firstNameFr;
		this.lastNameAr = lastNameAr;
		this.lastNameFr = lastNameFr;

		this.email = email;
		this.cin = cin;
		this.phone = phone;
		this.job = job;
		this.photoName = photoName;
		this.cin1 = cin1;
		this.cin2 = cin2;
		this.city = city;
		this.dateOfBirth = dateOfBirth;
		this.passeportId = passeportId;
		this.town = town;
		this.annexe = annexe;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstNameAr() {
		return firstNameAr;
	}
	public void setFirstNameAr(String firstNameAr) {
		this.firstNameAr = firstNameAr;
	}
	public String getFirstNameFr() {
		return firstNameFr;
	}
	public void setFirstNameFr(String firstNameFr) {
		this.firstNameFr = firstNameFr;
	}
	public String getLastNameAr() {
		return lastNameAr;
	}
	public void setLastNameAr(String lastNameAr) {
		this.lastNameAr = lastNameAr;
	}
	public String getLastNameFr() {
		return lastNameFr;
	}
	public void setLastNameFr(String lastNameFr) {
		this.lastNameFr = lastNameFr;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getCin1() {
		return cin1;
	}
	public void setCin1(String cin1) {
		this.cin1 = cin1;
	}
	public String getCin2() {
		return cin2;
	}
	public void setCin2(String cin2) {
		this.cin2 = cin2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPasseportId() {
		return passeportId;
	}
	public void setPasseportId(String passeportId) {
		this.passeportId = passeportId;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	@Override
	public String toString() {
		return "Citoyen [id=" + id + ", firstNameAr=" + firstNameAr + ", firstNameFr=" + firstNameFr + ", lastNameAr="
				+ lastNameAr + ", lastNameFr=" + lastNameFr + ", email=" + email + ", cin=" + cin + ", phone=" + phone
				+ ", job=" + job + ", photoName=" + photoName + ", cin1=" + cin1 + ", cin2=" + cin2 + ", acteNaissance="
				+ acteNaissance + ", district=" + district + ", pachalik=" + pachalik + ", city=" + city
				+ ", dateOfBirth=" + dateOfBirth + ", passeportId=" + passeportId + ", town=" + town + ", annexe="
				+ annexe + ", quartier=" + quartier + ", rue=" + rue + ", ruelle=" + ruelle 
				+ ", situation=" + situation + "]";
	}

	@JsonIgnore
	public Annexe getAnnexe() {
		return annexe;
	}
	@JsonProperty
	public void setAnnexe(Annexe annexe) {
		this.annexe = annexe;
	}

	
}
