package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;





@Entity
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstNameAr;
	private String firstNameFr;
	private String lastNameAr;
	private String lastNameFr;
	private String password;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String cin;
	private String phone;
	private String job;
	private String jobPlace;
	private String pachalikForReport;
	private String roleForReport;
	private String districtForReport;
	private String count;
	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}
	private String annexeForReport;
	public String getPachalikForReport() {
		return pachalikForReport;
	}


	public void setPachalikForReport(String pachalikForReport) {
		this.pachalikForReport = pachalikForReport;
	}


	public String getRoleForReport() {
		return roleForReport;
	}


	public void setRoleForReport(String roleForReport) {
		this.roleForReport = roleForReport;
	}


	public String getDistrictForReport() {
		return districtForReport;
	}


	public void setDistrictForReport(String districtForReport) {
		this.districtForReport = districtForReport;
	}


	public String getAnnexeForReport() {
		return annexeForReport;
	}


	public void setAnnexeForReport(String annexeForReport) {
		this.annexeForReport = annexeForReport;
	}
	@Column(unique = true)
	private String username;
	private String photoName;
	    private String confirmPass;
	@ManyToOne()
	@JsonIgnore
	private Annexe annexe;
	@ManyToOne()
	@JsonIgnore
	private District district;
	@ManyToOne()
	@JsonIgnore
	private Pachalik pachalik;
	@ManyToOne()
	
	private AppRole role;

	public AppUser(int id, String username, String password, String email, AppRole role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	

	@JsonIgnore
	public Pachalik getPachalik() {
		return pachalik;
	}


@JsonProperty
	public void setPachalik(Pachalik pachalik) {
		this.pachalik = pachalik;
	}



	public AppUser(String firstNameAr, String firstNameFr, String lastNameAr, String lastNameFr, String password,
			String email, String cin, String phone, String job, String jobPlace, String username, String photoName,
			String confirmPass, Annexe annexe, District district, Pachalik pachalik, AppRole role) {
		super();
		this.firstNameAr = firstNameAr;
		this.firstNameFr = firstNameFr;
		this.lastNameAr = lastNameAr;
		this.lastNameFr = lastNameFr;
		this.password = password;
		this.email = email;
		this.cin = cin;
		this.phone = phone;
		this.job = job;
		this.jobPlace = jobPlace;
		this.username = username;
		this.photoName = photoName;
		this.confirmPass = confirmPass;
		this.annexe = annexe;
		this.district = district;
		this.pachalik = pachalik;
		this.role = role;
	}



	public String getConfirmPass() {
		return confirmPass;
	}



	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}


	@JsonIgnore
	public District getDistrict() {
		return district;
	}


@JsonProperty
	public void setDistrict(District district) {
		this.district = district;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public AppUser(String firstNameAr, String firstNameFr, String lastNameAr, String lastNameFr, String password,
			String email, String cin, String phone, String job, String jobPlace, String username, String photoName,
			String confirmPass, Annexe annexe, District district, AppRole role) {
		super();
		this.firstNameAr = firstNameAr;
		this.firstNameFr = firstNameFr;
		this.lastNameAr = lastNameAr;
		this.lastNameFr = lastNameFr;
		this.password = password;
		this.email = email;
		this.cin = cin;
		this.phone = phone;
		this.job = job;
		this.jobPlace = jobPlace;
		this.username = username;
		this.photoName = photoName;
		this.confirmPass = confirmPass;
		this.annexe = annexe;
		this.district = district;
		this.role = role;
	}



	public AppUser(String password, String username) {
		super();
		this.password = password;
		this.username = username;
	}



	public AppUser(int id, String firstNameAr, String firstNameFr, String lastNameAr, String lastNameFr,
			String password, String email, String cin, String phone, String job, String jobPlace, String username,
			String photoName, Annexe annexe, AppRole role) {
		super();
		this.id = id;
		this.firstNameAr = firstNameAr;
		this.firstNameFr = firstNameFr;
		this.lastNameAr = lastNameAr;
		this.lastNameFr = lastNameFr;
		this.password = password;
		this.email = email;
		this.cin = cin;
		this.phone = phone;
		this.job = job;
		this.jobPlace = jobPlace;
		this.username = username;
		this.photoName = photoName;
		this.annexe = annexe;
		this.role = role;
	}



	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public AppRole getRole() {
		return role;
	}


@JsonProperty
	public void setRole(AppRole role) {
		this.role = role;
	}


@JsonIgnore
	public Annexe getAnnexe() {
		return annexe;
	}
@JsonProperty
	public void setAnnexe(Annexe annexe) {
		this.annexe = annexe;
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
	public String getJobPlace() {
		return jobPlace;
	}
	public void setJobPlace(String jobPlace) {
		this.jobPlace = jobPlace;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	
	 
}
