package uniandes.algorithms.sorting;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GeneradorDeDatos {
public static void main(String[] args) {
	String outFilename = "data/UnMillon.txt";
	try (PrintStream out = new PrintStream(outFilename)) {
		for(int i=0;i<1000000;i++) {
			out.println(Math.random()*1000000);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
