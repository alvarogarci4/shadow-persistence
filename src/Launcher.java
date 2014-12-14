import org.gui.shadow.persistence.IPersistenceFacade;
import org.gui.shadow.persistence.PersistenceFacade;

/**
 * @author David Soler <aensoler@gmail.com>
 * 
 * Entry point for the JAR runnable when it is packed in this way.
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Creates a new database with the schema */
		if (args.length > 1 && args[0].equals("newDataBase")) {
			IPersistenceFacade persistence = new PersistenceFacade(args[1]);
			persistence.initDB();
		} else {
			System.out.println("Use: COMMAND newDataBase PATH");
		}
	}

}
