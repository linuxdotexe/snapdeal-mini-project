package com.snapdeal;

import java.util.Map;

import com.snapdeal.util.ReadData;
import com.snapdeal.util.WriteData;

public class Main {
	
	// Main method. Performs the task.
	public static void main(String[] args) throws Exception {
		// Setup driver to perform task in Chrome
		AppAutomation.setupDriver("chrome");
		// Read input data from Input.xlsx
		String inputData = ReadData.getExcelData();
		// Perform Search operation of the task
		AppAutomation.search(inputData);
		// Perform sort operation of the task
		AppAutomation.sort();
		// Extract required output
		Map<String, String> outputData = AppAutomation.returnTopFive();
		// Write output data to Output.xlsx
		WriteData.outputData(outputData);
		
		// Setup driver to perform task in Edge
		AppAutomation.setupDriver("edge");
		// Perform search operation of the task
		AppAutomation.search(inputData);
		// Perform sort operation of the task
		AppAutomation.sort();
		// Extract required output
		outputData = AppAutomation.returnTopFive();
		// Write output data to Output.xlsx
		WriteData.outputData(outputData);
	}
}
