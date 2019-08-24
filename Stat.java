/*
* Stat.java
* Author: Jamison Johnson
* Submission Date: 11/11/2018
*
* Purpose: This program defines the stat class. It has several methods such as getData, setData, min, max, and mode.
* The main method is at the bottom of the file to test the methods.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/


public class Stat {

	
	private double[] data;
	
	// makes a stat object with 0.0
	public Stat()
	{
		double[] array = {0.0};
		data = array;
	}
	
	// makes a stat object with the values in an array
	public Stat(double[] d)
	{
		double[] array = new double[d.length];
		for (int i = 0; i < d.length; i++)
			array[i] = d[i];
		data = array;
	}
	
	// returns a data object's data
	public double[] getData()
	{
		double[] array = new double[data.length];
		for (int i = 0; i < data.length; i++)
			array[i] = data[i];
		return array;
		
	}
	
	// changes the data in a data object
	public void setData(double[] d)
	{
		double[] array = new double[d.length];
		for (int i = 0; i < d.length; i++)
			array[i] = d[i];
		data = array;
	}
	
	// returns whether two data objects are equals
	public boolean equals(Stat s)
	{
		double[] arr1 = getData();
		double[] arr2 = s.getData();
		for(int i = 0; i < arr2.length; i++)
		{
			if (arr1[i] != arr2[i])
			{
				return false;
			}
		}
		return true;
	}
	
	// returns the contents of stat object as a string
	public String toString()
	{
		String string = "[";
		double[] array = getData();
		for (int i = 0; i < array.length; i++)
		{
			string += array[i];
			if (i != array.length - 1)
				string += ", ";
		}
		string += "]";
		return string;
	}
	
	// calculates the min of stat object
	public double min()
	{
		double[] array = getData();
		double min = array[0];
		for (double value : array)
		{
			if (value < min)
				min = value;
		}
		return min;
	}
	
	// calculates the max of stat object
	public double max()
	{
		double[] array = getData();
		double max = array[0];
		for (double value : array)
		{
			if (value > max)
				max = value;
		}
		return max;
	}
	
	// calculates the average of stat object
	public double average()
	{
		double[] array = getData();
		double sum = 0.0;
		for (double value : array)
			sum += value;
		return sum / array.length;
	}
	
	// calculates the mode of stat object
	public double mode()
	{
		double[] array = getData();
		int count = 0;
		int highestCount = 0;
		double mode = 0.0;
		for (double possibleValue : array) //for each value (the variable is possibleValue because each value could be the mode)
		{
			count = 0;
			for (double value : array) //counts the instances of each possibleValue
			{
				if (value == possibleValue)
					count ++;
			}
			
			if (count > highestCount) //if the count is higher than the current mode, the new mode is the current value
			{
				highestCount = count;
				mode = possibleValue;
			}
			else if (count == highestCount && possibleValue != mode) // if the count is equal to the highest and the possibleValue is not the same as the current mode
			{
				mode = Double.NaN;
			}
		}
		return mode;
	}



	public static void main(String[] args)
	{
		double[] data = {-5.3, 2.5, 88.9, 0, 0.0, 28, 16.5, 88.9, 109.5, -90, 88.9};
		Stat stat1 = new Stat(data);
		
		double[] data2 = {1, 2, 3};
		Stat stat2 = new Stat(data2);
		
		double[] data3 = {1, 2, 3};
		Stat stat3 = new Stat(data3);
		
		System.out.println(stat1.toString());
		System.out.println("Output should be: [-5.3, 2.5, 88.9, 0, 0.0, 28, 16.5, 88.9, 109.5, -90, 88.9, 0.0]");
			
		
		if (stat2.equals(stat3))
			System.out.println("Get and Equals method test Successful");
		else
			System.out.println("Get and Equals method test failed");
		
		if (stat2.equals(stat3))
			System.out.println("Equals method test Successful");
		else
			System.out.println("Equals method test failed");
		
		if (stat2.min() == 1)
			System.out.println("Min method test Successful");
		else
			System.out.println("Min method test failed");
		
		if (stat1.max() == 109.5)
			System.out.println("Max method test Successful");
		else
			System.out.println("Max method test failed");
		
		double[] newData = {-5.3, 2.5, 88.9, 0, 0.0, 28, 16.5, 88.9, 109.5, -90, 88.9};
		stat2.setData(newData);
		
		if (stat2.equals(stat1))
			System.out.println("Set method test Successful");
		else
			System.out.println("Set method test Failed");
		
		double[] test = {1, 2, 3};
		stat2.setData(test);
		
		System.out.println(stat1.average());
		System.out.println("Average should be around: 29.8");
		System.out.println(stat2.mode());
		System.out.println("Mode should be equal to NaN");
		System.out.println(stat1.mode());
		System.out.println("Mode should be equal to 88.9");
		
		
	}
}
