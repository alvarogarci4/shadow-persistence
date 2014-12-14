package org.gui.shadow.dto;

/**
 * @author David Soler <aensoler@gmail.com>
 *
 */
public class FieldDTO {

	private TypeDTO type;
	private String value;

	/**
	 * 
	 */
	public FieldDTO() {}

	/**
	 * @return the type
	 */
	public TypeDTO getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeDTO type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
