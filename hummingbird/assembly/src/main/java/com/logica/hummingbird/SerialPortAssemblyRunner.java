package com.logica.hummingbird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SerialPortAssemblyRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SerialPortAssembly serialPortAssembly = new SerialPortAssembly(args[0]);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Press [ENTER] to quit.");
		try {
			br.readLine();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			serialPortAssembly.closePort();
		}
		


	}

}
