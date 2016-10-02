package com.usu.perceptron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class InputParser {
	
	static Map<Integer, Integer> actualOutput = new HashMap<Integer, Integer>();
	static double learningRate = 0.001;
	static double error = 0.0, deltaWeight = 0;
	
	public static void main(String[] args) throws Exception {
		Map<Integer, Perceptron> perceptronInputs = new HashMap<Integer, Perceptron>();
		perceptronInputs = readInputs(perceptronInputs);
		
		for(int i = 0; i < 1000 || error == 0.0001; i++) {
			for (Integer key : perceptronInputs.keySet()) {
				actualOutput.put(key, calculateOutput(perceptronInputs, key));
			}
			
			calculateError(perceptronInputs);
			
			calculateDeltaWeight(perceptronInputs);
		}
	}
	
	public static Map<Integer, Perceptron> readInputs(Map<Integer, Perceptron> perceptronInputs) throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("files/Data.txt"));
		String line;
		Perceptron iv;
		int key = 0;
		while ((line = in.readLine()) != null) {
			if(!line.contains("X1")) {
				iv = new Perceptron();
				String[] tokens = line.split("\t");
				iv.setX1(Double.parseDouble(tokens[0]));
				iv.setX2(Double.parseDouble(tokens[1]));
				iv.setTargetOutput(Integer.parseInt(tokens[2]));
				
				perceptronInputs.put(key++, iv);
			}
		}
		in.close();
		
		return perceptronInputs;
	}
	
	public static int calculateOutput(Map<Integer, Perceptron> perceptronInputs, int key) {
		Perceptron perceptron = perceptronInputs.get(key);
		
		double sum = perceptron.getW0() + perceptron.getX1() * perceptron.getW1() + perceptron.getX2() * perceptron.getW2();
		
		return (sum > perceptron.getThreshold()) ? 1 : 0;
	}
	
	public static void calculateError(Map<Integer, Perceptron> perceptronInputs) {
		for (Integer key : perceptronInputs.keySet()) {
			error += actualOutput.get(key) - perceptronInputs.get(key).getTargetOutput();
		}
	}
	
	public static void calculateDeltaWeight(Map<Integer, Perceptron> perceptronInputs) {
		for (Integer key : perceptronInputs.keySet()) {
			deltaWeight = learningRate * perceptronInputs.get(key).getX1() * error;
			perceptronInputs.get(key).setW1(perceptronInputs.get(key).getW1() + deltaWeight);
			deltaWeight = learningRate * perceptronInputs.get(key).getX2() * error;
			perceptronInputs.get(key).setW2(perceptronInputs.get(key).getW2() + deltaWeight);
		}
	}
}