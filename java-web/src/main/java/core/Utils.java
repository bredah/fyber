package core;

import java.io.File;

/**
 * Utility helper class
 * 
 * @author bredah
 * @version 0.1
 * @since 20170807
 */
public class Utils {
	/**
	 * Path absolute to main RESOURCE
	 * 
	 * @return Full path to resource
	 */
	public static String getPathResourceMain() {
		return new File("src/main/resources").getAbsoluteFile() + "/";
	}

	/**
	 * Path absolute to test RESOURCE
	 * 
	 * @return Full path to resource
	 */
	public static String getPathResourceTest() {
		return new File("src/test/resources").getAbsoluteFile() + "/";
	}

	/**
	 * Get current System Operation
	 * 
	 * @return OS name
	 */
	public static OperationSystem getOS() {
		String strOS = System.getProperty("os.name").toLowerCase();
		if (strOS.contains("win")) {
			return OperationSystem.WINDOWS;
		}
		if (strOS.contains("mac")) {
			return OperationSystem.MAC;
		}
		if (strOS.contains("nix")) {
			return OperationSystem.LINUX;
		}
		return OperationSystem.UNDEFINED;
	}
}
