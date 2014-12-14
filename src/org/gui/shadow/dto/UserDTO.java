package org.gui.shadow.dto;

import java.util.ArrayList;

/**
 * @author David Soler <aensoler@gmail.com>
 *
 */
public class UserDTO {

	private String login;
	private String password;
	private int dni;
	private String name;
	private String surname;
	private int nia;
	private int phone;
	private String address;
	private String email;
	private StudyDTO study;
	private ArrayList<FieldDTO> fields;

	public UserDTO() {}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the nia
	 */
	public int getNia() {
		return nia;
	}

	/**
	 * @param nia the nia to set
	 */
	public void setNia(int nia) {
		this.nia = nia;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the study
	 */
	public StudyDTO getStudy() {
		return study;
	}

	/**
	 * @param study the study to set
	 */
	public void setStudy(StudyDTO study) {
		this.study = study;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the fields
	 */
	public ArrayList<FieldDTO> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(ArrayList<FieldDTO> fields) {
		this.fields = fields;
	}

}
