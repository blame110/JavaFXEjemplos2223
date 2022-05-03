package org.openfx.PrimeraVentana;

public class SystemInfo {

	public static String javaVersion() {
		return System.getProperty("java.version");
	}

	public static String javafxVersion() {
		int modif = 0;
		return System.getProperty("javafx.version");
	}

}