package com.usu.sudokuSolver.board.test;

import com.usu.sudokuSolver.board.SudokuBoard;
import com.usu.sudokuSolver.solution.RecursiveBruteSudokuSolver;
import com.usu.sudokuSolver.template.SudokuSolver;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SudokuSolver4x4Test {

    String[][] sudoku = {
    		{"2", "-", "-", "1"},
    		{"1", "-", "-", "4"},
    		{"-", "-", "4", "-"},
    		{"-", "2", "-", "-"}
    };

    private String[] sortedLine = {"1","2","3","4"};

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
        for (int i = 0; i < 4; i++) {
            assertTrue(arrayPassed(sb.getRow(i)));
            assertTrue(arrayPassed(sb.getColumn(i)));
        }
    }
    
    private boolean arrayPassed(String[] toVerify) {
        String[] copy = Arrays.copyOf(toVerify, 4);
        Arrays.sort(copy);
        return Arrays.equals(sortedLine, copy);
    }
    
    String[][] sudoku1 = {
    		{"4", "9", "-", "1"},
    		{"-", "-", "-", "2"},
    		{"3", "-", "2", "-"},
    		{"-", "4", "-", "3"}
    };
    
    SudokuBoard sb2 = new SudokuBoard(sudoku1);
    
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
    		{"4", "1", "-", "1"},
    		{"-", "-", "-", "2"},
    		{"3", "-", "2", "-"},
    		{"-", "4", "-", "3"}
    };
    
    @Test
    public void testContainDuplicateRow_NullValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(null));
    }
    
    @Test
    public void testContainDuplicateRow_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku2));
    }
    
    String[][] sudoku6 = {
    		{"4", "-", "2", "1"},
    		{"-", "-", "-", "2"},
    		{"3", "-", "2", "-"},
    		{"-", "4", "-", "3"}
    };
    
    @Test
    public void testContainDuplicate_NullValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(null));
    }
    
    @Test
    public void testContainDuplicate_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku6));
    }
    
    String[][] sudoku3 = {
    		{"2", "-", "-", "1"},
    		{"1", "-", "-", "4"},
    		{"-", "-", "4", "-"},
    		{"-", "2", "-", "-"},
    		{"2"}
    };
    
    @Test
    public void testSizeRow_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku3));
    }
    
    String[][] sudoku4 = {
    		{"2", "-", "-", "1"},
    		{"1", "-", "-", "4", "2"},
    		{"-", "-", "4", "-"},
    		{"-", "2", "-", "-"}
    };
    
    @Test
    public void testSizeColumn_CorrectValue() {
    	SudokuSolver.symbols = sortedLine;
    	assertFalse(SudokuSolver.isSudokuBoardValid(sudoku4));
    }
    
    String[][] sudoku5 = {
    		{"4", "-", "-", "1"},
    		{"-", "-", "-", "-"},
    		{"3", "-", "-", "-"},
    		{"-", "-", "-", "3"}
    };
    
    SudokuBoard sb1 = new SudokuBoard(sudoku5);
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