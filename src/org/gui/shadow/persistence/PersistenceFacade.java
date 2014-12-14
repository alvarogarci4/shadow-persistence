package org.gui.shadow.persistence;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.gui.shadow.dto.FieldDTO;
import org.gui.shadow.dto.StudyDTO;
import org.gui.shadow.dto.TypeDTO;
import org.gui.shadow.dto.UserDTO;

/**
 * @author David Soler <aensoler@gmail.com>
 *
 */
public class PersistenceFacade implements IPersistenceFacade {

	private static DatabaseHandler databaseHandler;

	/**
	 * 
	 */
	public PersistenceFacade(String databaseName) {
		if (databaseName == null || databaseName.isEmpty()) {
			databaseName = Config.DATABASE_NAME;
		}

		databaseHandler = new SQLiteHandler(databaseName);
	}

	public void initDB() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(Config.DATABASE_SCHEMA);

		Scanner scanner = new Scanner(inputStream);
		String sql = scanner.useDelimiter("\\A").next();
		scanner.close();

		databaseHandler.update(sql);
	}

	public UserDTO getUser(String userId) {
		UserDTO userDTO = new UserDTO();

		String sql = "SELECT * FROM users WHERE login='"+userId+"'";

		ResultSet resultSet = databaseHandler.retrieve(sql);

		try {
			if (resultSet.next()) {
				userDTO.setLogin(userId);
				userDTO.setPassword(resultSet.getString("password"));
				userDTO.setDni(resultSet.getInt("dni"));
				userDTO.setName(resultSet.getString("name"));
				userDTO.setSurname(resultSet.getString("surname"));
				userDTO.setNia(resultSet.getInt("nia"));
				userDTO.setPhone(resultSet.getInt("phone"));
				userDTO.setAddress(resultSet.getString("address"));
				userDTO.setEmail(resultSet.getString("email"));
				userDTO.setStudy(new StudyDTO(resultSet.getString("study")));
				userDTO.setFields(getUserFields(userId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userDTO;
	}

	public ArrayList<TypeDTO> getTypes() {
		ArrayList<TypeDTO> typesDTO = new ArrayList<TypeDTO>();

		ResultSet resultSet = databaseHandler.retrieve("SELECT name FROM types");

		try {
			while (resultSet.next()) {
				typesDTO.add(new TypeDTO(resultSet.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return typesDTO;
	}

	private ArrayList<FieldDTO> getUserFields(String userId) {
		ArrayList<FieldDTO> fieldsDTO = new ArrayList<FieldDTO>();

		String sql = "SELECT * FROM fields_users WHERE user_id='"+userId+"'";

		ResultSet resultSet = databaseHandler.retrieve(sql);
		try {
			while (resultSet.next()) {
				FieldDTO fieldDTO = new FieldDTO();
				fieldDTO.setType(new TypeDTO(resultSet.getString("name")));
				fieldDTO.setValue(resultSet.getString("value"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fieldsDTO;
	}

}
