package org.gui.shadow.persistence;

import java.util.ArrayList;
import org.gui.shadow.dto.TypeDTO;
import org.gui.shadow.dto.UserDTO;

/**
 * @author David Soler <aensoler@gmail.com>
 *
 */
public interface IPersistenceFacade {

	public void initDB();

	public UserDTO getUser(String userId);

	public ArrayList<TypeDTO> getTypes();
}
