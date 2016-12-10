package com.usu.sudokuSolver.board.test;

import com.usu.sudokuSolver.board.SudokuBoard;
import com.usu.sudokuSolver.solution.RecursiveBruteSudokuSolver;
import com.usu.sudokuSolver.template.SudokuSolver;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SudokuSolver16x16Test {

    String[][] sudoku = {
    		{"7", "1", "-", "-", "A", "-", "E", "C", "-", "3", "2", "-", "6", "-", "-", "8"},
    		{"6", "-", "2", "-", "-", "-", "-", "-", "-", "-", "E", "-", "D", "C", "-", "6"},
    		{"E", "8", "-", "B", "-", "3", "-", "-", "1", "-", "G", "-", "-", "4", "5", "-"},
    		{"-", "3", "F", "-", "B", "-", "-", "-", "-", "6", "D", "-", "-", "-", "A", "-"},
    		{"-", "E", "-", "-", "F", "C", "B", "-", "-", "9", "-", "D", "-", "3", "-", "-"},
    		{"1", "-", "3", "-", "4", "-", "8", "-", "A", "-", "-", "-", "-", "9", "-", "-"},
    		{"-", "7", "C", "-", "-", "G", "-", "-", "-", "B", "F", "-", "A", "-", "-", "-"},
    		{"-", "-", "-", "-", "-", "-", "5", "-", "2", "4", "8", "-", "C", "D", "6", "-"},
    		{"-", "-", "-", "-", "-", "-", "C", "-", "6", "8", "9", "-", "1", "2", "G", "-"},
    		{"-", "G", "8", "-", "-", "6", "-", "-", "-", "5", "7", "-", "3", "-", "-", "-"},
    		{"C", "-", "E", "-", "3", "-", "A", "-", "B", "-", "-", "-", "-", "7", "-", "-"},
    		{"-", "4", "-", "-", "5", "8", "F", "-", "-", "G", "-", "C", "-", "6", "-", "-"},
    		{"-", "C", "9", "-", "G", "-", "-", "-", "-", "F", "A", "-", "-", "-", "2", "-"},
    		{"B", "A", "-", "E", "-", "2", "-", "-", "G", "-", "5", "-", "-", "1", "9", "-"},
    		{"4", "-", "6", "-", "-", "-", "-", "-", "-", "-", "B", "-", "8", "E", "-", "G"},
    		{"5", "D", "-", "-", "1", "-", "3", "8", "-", "E", "4", "-", "7", "-", "-", "B"}
    };

    private String[] sortedLine = {"1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G"};

    SudokuBoard sb = new SudokuBoard(sudoku);
    RecursiveBruteSudokuSolver ss = new RecursiveBruteSudokuSolver(sb);
    
    @Test(expected = NullPointerException.class)
    public void testIsSolved_NullValues() {
    	Integer row = null, col = null;
    	ss.solve(row, col);
    }
    
    @Test
    public void testIsSolved_Correct() {
    	SudokuSolver.symbols = sortedLine;
    	ss.solve(0, 0);
        for (int i = 0; i < 9; i++) {
            assertTrue(arrayPassed(sb.getRow(i)));
            assertTrue(arrayPassed(sb.getColumn(i)));
        }

    }

    private boolean arrayPassed(String[] toVerify) {
        String[] copy = Arrays.copyOf(toVerify, 9);
        Arrays.sort(copy);
        return Arrays.equals(sortedLine, copy);
    }
    
    String[][] sudoku1 = {
    		{"7", "1", "-", "-", "A", "-", "E", "C", "-", "3", "2", "-", "6", "-", "-", "8"},
    		{"6", "-", "H", "-", "-", "-", "-", "-", "-", "-", "E", "-", "D", "C", "-", "6"},
    		{"E", "8", "-", "B", "-", "3", "-", "-", "1", "-", "G", "-", "-", "4", "5", "-"},
    		{"-", "3", "F", "-", "B", "-", "-", "-", "-", "6", "D", "-", "-", "-", "A", "-"},
    		{"-", "E", "-", "-", "F", "C", "B", "-", "-", "9", "-", "D", "-", "3", "-", "-"},
    		{"1", "-", "3", "-", "4", "-", "8", "-", "A", "-", "-", "-", "-", "9", "-", "-"},
    		{"-", "7", "C", "-", "-", "G", "-", "-", "-", "B", "F", "-", "A", "-", "-", "-"},
    		{"-", "-", "-", "-", "-", "-", "5", "-", "2", "4", "8", "-", "C", "D", "6", "-"},
    		{"-", "-", "-", "-", "-", "-", "C", "-", "6", "8", "9", "-", "1", "2", "G", "-"},
    		{"-", "G", "8", "-", "-", "6", "-", "-", "-", "5", "7", "-", "3", "-", "-", "-"},
    		{"C", "-", "E", "-", "3", "-", "A", "-", "B", "-", "-", "-", "-", "7", "-", "-"},
    		{"-", "4", "-", "-", "5", "8", "F", "-", "-", "G", "-", "C", "-", "6", "-", "-"},
    		{"-", "C", "9", "-", "G", "-", "-", "-", "-", "F", "A", "-", "-", "-", "2", "-"},
    		{"B", "A", "-", "E", "-", "2", "-", "-", "G", "-", "5", "-", "-", "1", "9", "-"},
    		{"4", "-", "6", "-", "-", "-", "-", "-", "-", "-", "B", "-", "8", "E", "-", "G"},
    		{"5", "D", "-", "-", "1", "-", "3", "8", "-", "E", "4", "-", "7", "-", "-", "B"}
    };
    
    @Test
    public void testContainOutlier_NullValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(null));
    }
    
    @Test
    public void testContainOutlier_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku1));
    }
    
    String[][] sudoku2 = {
    		{"7", "1", "-", "-", "A", "-", "E", "C", "-", "3", "2", "-", "6", "-", "-", "8"},
    		{"6", "2", "2", "-", "-", "-", "-", "-", "-", "-", "E", "-", "D", "C", "-", "6"},
    		{"E", "8", "-", "B", "-", "3", "-", "-", "1", "-", "G", "-", "-", "4", "5", "-"},
    		{"-", "3", "F", "-", "B", "-", "-", "-", "-", "6", "D", "-", "-", "-", "A", "-"},
    		{"-", "E", "-", "-", "F", "C", "B", "-", "-", "9", "-", "D", "-", "3", "-", "-"},
    		{"1", "-", "3", "-", "4", "-", "8", "-", "A", "-", "-", "-", "-", "9", "-", "-"},
    		{"-", "7", "C", "-", "-", "G", "-", "-", "-", "B", "F", "-", "A", "-", "-", "-"},
    		{"-", "-", "-", "-", "-", "-", "5", "-", "2", "4", "8", "-", "C", "D", "6", "-"},
    		{"-", "-", "-", "-", "-", "-", "C", "-", "6", "8", "9", "-", "1", "2", "G", "-"},
    		{"-", "G", "8", "-", "-", "6", "-", "-", "-", "5", "7", "-", "3", "-", "-", "-"},
    		{"C", "-", "E", "-", "3", "-", "A", "-", "B", "-", "-", "-", "-", "7", "-", "-"},
    		{"-", "4", "-", "-", "5", "8", "F", "-", "-", "G", "-", "C", "-", "6", "-", "-"},
    		{"-", "C", "9", "-", "G", "-", "-", "-", "-", "F", "A", "-", "-", "-", "2", "-"},
    		{"B", "A", "-", "E", "-", "2", "-", "-", "G", "-", "5", "-", "-", "1", "9", "-"},
    		{"4", "-", "6", "-", "-", "-", "-", "-", "-", "-", "B", "-", "8", "E", "-", "G"},
    		{"5", "D", "-", "-", "1", "-", "3", "8", "-", "E", "4", "-", "7", "-", "-", "B"}
    };
    
    @Test
    public void testContainDuplicateRow_NullValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(null));
    }
    
    @Test
    public void testContainDuplicateRow_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku4));
    }
    
    String[][] sudoku3 = {
    		{"7", "1", "-", "-", "A", "-", "E", "C", "-", "3", "2", "-", "6", "-", "-", "8"},
    		{"6", "-", "2", "-", "-", "-", "-", "-", "-", "-", "E", "-", "D", "C", "-", "6"},
    		{"E", "8", "-", "B", "-", "3", "-", "-", "1", "-", "G", "-", "-", "4", "5", "-"},
    		{"-", "3", "F", "-", "B", "-", "-", "-", "-", "6", "D", "-", "-", "-", "A", "-"},
    		{"-", "E", "-", "-", "F", "C", "B", "-", "-", "9", "-", "D", "-", "3", "-", "-"},
    		{"1", "-", "3", "-", "4", "-", "8", "-", "A", "-", "-", "-", "-", "9", "-", "-"},
    		{"-", "7", "C", "-", "-", "G", "-", "-", "-", "B", "F", "-", "A", "-", "-", "-"},
    		{"-", "1", "-", "-", "-", "-", "5", "-", "2", "4", "8", "-", "C", "D", "6", "-"},
    		{"-", "-", "-", "-", "-", "-", "C", "-", "6", "8", "9", "-", "1", "2", "G", "-"},
    		{"-", "G", "8", "-", "-", "6", "-", "-", "-", "5", "7", "-", "3", "-", "-", "-"},
    		{"C", "-", "E", "-", "3", "-", "A", "-", "B", "-", "-", "-", "-", "7", "-", "-"},
    		{"-", "4", "-", "-", "5", "8", "F", "-", "-", "G", "-", "C", "-", "6", "-", "-"},
    		{"-", "C", "9", "-", "G", "-", "-", "-", "-", "F", "A", "-", "-", "-", "2", "-"},
    		{"B", "A", "-", "E", "-", "2", "-", "-", "G", "-", "5", "-", "-", "1", "9", "-"},
    		{"4", "-", "6", "-", "-", "-", "-", "-", "-", "-", "B", "-", "8", "E", "-", "G"},
    		{"5", "D", "-", "-", "1", "-", "3", "8", "-", "E", "4", "-", "7", "-", "-", "B"}
    };
    
    @Test
    public void testContainDuplicateColumn_NullValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(null));
    }
    
    @Test
    public void testContainDuplicateColumn_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku4));
    }
    
    String[][] sudoku4 = {
    		{"7", "1", "-", "-", "A", "-", "E", "C", "-", "3", "2", "-", "6", "-", "-", "8"},
    		{"6", "-", "2", "-", "-", "-", "-", "-", "-", "-", "E", "-", "D", "C", "-", "6"},
    		{"E", "8", "-", "B", "-", "3", "-", "-", "1", "-", "G", "-", "-", "4", "5", "-"},
    		{"-", "3", "F", "-", "B", "-", "-", "-", "-", "6", "D", "-", "-", "-", "A", "-"},
    		{"-", "E", "-", "-", "F", "C", "B", "-", "-", "9", "-", "D", "-", "3", "-", "-"},
    		{"1", "-", "3", "-", "4", "-", "8", "-", "A", "-", "-", "-", "-", "9", "-", "-"},
    		{"-", "7", "C", "-", "-", "G", "-", "-", "-", "B", "F", "-", "A", "-", "-", "-"},
    		{"-", "-", "-", "-", "-", "-", "5", "-", "2", "4", "8", "-", "C", "D", "6", "-"},
    		{"-", "-", "-", "-", "-", "-", "C", "-", "6", "8", "9", "-", "1", "2", "G", "-"},
    		{"-", "G", "8", "-", "-", "6", "-", "-", "-", "5", "7", "-", "3", "-", "-", "-"},
    		{"C", "-", "E", "-", "3", "-", "A", "-", "B", "-", "-", "-", "-", "7", "-", "-"},
    		{"-", "4", "-", "-", "5", "8", "F", "-", "-", "G", "-", "C", "-", "6", "-", "-"},
    		{"-", "C", "9", "-", "G", "-", "-", "-", "-", "F", "A", "-", "-", "-", "2", "-"},
    		{"B", "A", "-", "E", "-", "2", "-", "-", "G", "-", "5", "-", "-", "1", "9", "-"},
    		{"4", "-", "6", "-", "-", "-", "-", "-", "-", "-", "B", "-", "8", "E", "-", "G"},
    		{"5", "D", "-", "-", "1", "-", "3", "8", "-", "E", "4", "-", "7", "-", "-", "B"},
    		{"2"}
    };
    
    @Test
    public void testSizeRow_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku4));
    }
    
    String[][] sudoku5 = {
    		{"7", "1", "-", "-", "A", "-", "E", "C", "-", "3", "2", "-", "6", "-", "-", "8"},
    		{"6", "-", "2", "-", "-", "-", "-", "-", "-", "-", "E", "-", "D", "C", "-", "6", "1"},
    		{"E", "8", "-", "B", "-", "3", "-", "-", "1", "-", "G", "-", "-", "4", "5", "-"},
    		{"-", "3", "F", "-", "B", "-", "-", "-", "-", "6", "D", "-", "-", "-", "A", "-"},
    		{"-", "E", "-", "-", "F", "C", "B", "-", "-", "9", "-", "D", "-", "3", "-", "-"},
    		{"1", "-", "3", "-", "4", "-", "8", "-", "A", "-", "-", "-", "-", "9", "-", "-"},
    		{"-", "7", "C", "-", "-", "G", "-", "-", "-", "B", "F", "-", "A", "-", "-", "-"},
    		{"-", "-", "-", "-", "-", "-", "5", "-", "2", "4", "8", "-", "C", "D", "6", "-"},
    		{"-", "-", "-", "-", "-", "-", "C", "-", "6", "8", "9", "-", "1", "2", "G", "-"},
    		{"-", "G", "8", "-", "-", "6", "-", "-", "-", "5", "7", "-", "3", "-", "-", "-"},
    		{"C", "-", "E", "-", "3", "-", "A", "-", "B", "-", "-", "-", "-", "7", "-", "-"},
    		{"-", "4", "-", "-", "5", "8", "F", "-", "-", "G", "-", "C", "-", "6", "-", "-"},
    		{"-", "C", "9", "-", "G", "-", "-", "-", "-", "F", "A", "-", "-", "-", "2", "-"},
    		{"B", "A", "-", "E", "-", "2", "-", "-", "G", "-", "5", "-", "-", "1", "9", "-"},
    		{"4", "-", "6", "-", "-", "-", "-", "-", "-", "-", "B", "-", "8", "E", "-", "G"},
    		{"5", "D", "-", "-", "1", "-", "3", "8", "-", "E", "4", "-", "7", "-", "-", "B"}
    };
    
    @Test
    public void testSizeColumn_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku5));
    }
    
    String[][] sudoku6 = {
    		{"7", "1", "-", "-", "A", "-", "E", "C", "-", "3", "2", "-", "6", "-", "-", "8"},
    		{"6", "-", "2", "-", "-", "-", "-", "-", "-", "-", "E", "-", "D", "C", "-", "6"},
    		{"E", "8", "-", "B", "-", "3", "-", "-", "1", "-", "G", "-", "-", "4", "5", "-"},
    		{"-", "3", "F", "-", "B", "-", "-", "-", "-", "6", "D", "-", "-", "-", "A", "-"},
    		{"-", "E", "-", "-", "F", "C", "B", "-", "-", "9", "-", "D", "-", "3", "-", "-"},
    		{"1", "-", "3", "-", "4", "-", "8", "-", "A", "-", "-", "-", "-", "9", "-", "-"},
    		{"-", "7", "C", "-", "-", "G", "-", "-", "-", "B", "F", "-", "A", "-", "-", "-"},
    		{"-", "-", "-", "-", "-", "-", "5", "-", "2", "4", "8", "-", "C", "D", "6", "-"},
    		{"-", "-", "-", "-", "-", "-", "C", "-", "6", "8", "9", "-", "1", "2", "G", "-"},
    		{"-", "G", "8", "-", "-", "6", "-", "-", "-", "5", "7", "-", "3", "-", "-", "-"},
    		{"C", "-", "E", "-", "3", "-", "A", "-", "B", "-", "-", "-", "-", "7", "-", "-"},
    		{"-", "4", "-", "-", "5", "8", "F", "-", "-", "G", "-", "C", "-", "6", "-", "-"},
    		{"-", "C", "9", "-", "G", "-", "-", "-", "-", "F", "A", "-", "-", "-", "2", "-"},
    		{"B", "A", "-", "E", "-", "2", "-", "-", "G", "-", "5", "-", "-", "1", "9", "-"},
    		{"4", "-", "6", "-", "-", "-", "-", "-", "-", "-", "B", "-", "8", "E", "-", "G"},
    		{"5", "D", "-", "-", "1", "-", "3", "8", "-", "E", "4", "-", "7", "-", "-", "B"}
    };
    
    SudokuBoard sb1 = new SudokuBoard(sudoku6);
    RecursiveBruteSudokuSolver ss1 = new RecursiveBruteSudokuSolver(sb1);
    
    @Test(expected = NullPointerException.class)
    public void testIsSolved_NullValues_WrongValue() {
    	Integer row = null, col = null;
    	ss1.solve(row, col);
    }
    
    @Test
    public void testIsSolved_Correct_WrongValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertTrue(ss1.solve(0, 0));        
    }
}