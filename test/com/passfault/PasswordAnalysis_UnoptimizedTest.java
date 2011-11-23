/* ©Copyright 2011 Cameron Morris
 *
 * This file is part of Passfault.
 *
 * Passfault is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Passfault is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Passfault.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.passfault;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PasswordAnalysis_UnoptimizedTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void randomNumbers() {
		PasswordAnalysis_Unoptimized pa = new PasswordAnalysis_Unoptimized("1234");
		PathCost patterns = pa.calculateHighestProbablePatterns();
		
		List<PasswordPattern> list = patterns.getPath();
		assertEquals(1, list.size());
		double result = patterns.getTotalCost();	
		System.out.println("cost="+result);
		double expected = Math.pow(10,4);
		assertEquals(expected, result, 0.5);
	}
	
	@Test
	public void onePattern_Middle() {
		PasswordAnalysis_Unoptimized pa = new PasswordAnalysis_Unoptimized("1234");
		pa.foundPattern(new PasswordPattern(1, 2, "23", 4, "testPattern"));
		
		PathCost patterns = pa.calculateHighestProbablePatterns();
		
		List<PasswordPattern> list = patterns.getPath();
		assertEquals(3, list.size());
		double result = patterns.getTotalCost();	
		System.out.println("cost="+result);
		patterns.getTotalCost();
		double expected = Math.pow(10,2)*4;
		assertEquals(expected, result, 0.5);
	}

	@Test
	public void onePattern_End() {
		PasswordAnalysis_Unoptimized pa = new PasswordAnalysis_Unoptimized("1234");
		pa.foundPattern(new PasswordPattern(2, 2, "34", 4, "testPattern"));
		
		PathCost patterns = pa.calculateHighestProbablePatterns();
		
		List<PasswordPattern> list = patterns.getPath();
		assertEquals(2, list.size());
		double result = patterns.getTotalCost();		
		System.out.println("cost="+result);
		double expected = Math.pow(10,2)*4;
		assertEquals(expected, result, 0.5);
	}
	

	@Test
	public void onePattern_beginning() {
		PasswordAnalysis_Unoptimized pa = new PasswordAnalysis_Unoptimized("1234");
		pa.foundPattern(new PasswordPattern(0, 2, "12", 4, "testPattern"));
		
		PathCost patterns = pa.calculateHighestProbablePatterns();
		
		List<PasswordPattern> list = patterns.getPath();
		assertEquals(2, list.size());
		double result = patterns.getTotalCost();
		System.out.println("cost="+result);
		double expected = Math.pow(10,2)*4;
		assertEquals(expected, result, 0.5);
	}
	
	@Test
	public void twoPattern_middle() {
		PasswordAnalysis_Unoptimized pa = new PasswordAnalysis_Unoptimized("12345");
		pa.foundPattern(new PasswordPattern(1, 1, "2", 2, "testPattern"));
		pa.foundPattern(new PasswordPattern(3, 1, "4", 2, "testPattern"));
		
		PathCost patterns = pa.calculateHighestProbablePatterns();
		
		List<PasswordPattern> list = patterns.getPath();
		assertEquals(5, list.size());
		double result = patterns.getTotalCost();
		System.out.println("cost="+result);
		
		double expected = Math.pow(10,3)*4;
		assertEquals(expected, result, 0.5);
	}

	@Test
	public void onePattern_overlap(){
		PasswordAnalysis_Unoptimized pa = new PasswordAnalysis_Unoptimized("12345");
		pa.foundPattern(new PasswordPattern(1, 2, "23", 15, "worstPattern"));
		pa.foundPattern(new PasswordPattern(1, 2, "23", 4, "bestPattern"));
		pa.foundPattern(new PasswordPattern(1, 2, "23", 20, "worsePattern"));
		pa.foundPattern(new PasswordPattern(1, 2, "23", 23, "worserPattern"));
		
		PathCost patterns = pa.calculateHighestProbablePatterns();
		
		List<PasswordPattern> list = patterns.getPath();
		assertEquals(3, list.size());
		double result = patterns.getTotalCost();
		System.out.println("cost="+result);
		double expected = Math.pow(10,3)*4;
		assertEquals(expected, result, 0.5);
	}
	
	@Test
	public void twoPattern_overlap(){
		PasswordAnalysis_Unoptimized pa = new PasswordAnalysis_Unoptimized("12345");
		pa.foundPattern(new PasswordPattern(1, 1, "2", 15, "worstPattern"));
		pa.foundPattern(new PasswordPattern(1, 1, "2", 4, "bestPattern"));
		pa.foundPattern(new PasswordPattern(1, 1, "2", 20, "worsePattern"));
		pa.foundPattern(new PasswordPattern(1, 1, "2", 23, "worserPattern"));
		
		pa.foundPattern(new PasswordPattern(2, 2, "34", 15, "worstPattern"));
		pa.foundPattern(new PasswordPattern(2, 2, "34", 20, "worsePattern"));
		pa.foundPattern(new PasswordPattern(2, 2, "34", 23, "worserPattern"));
		pa.foundPattern(new PasswordPattern(2, 2, "34", 4, "bestPattern"));
		
		pa.foundPattern(new PasswordPattern(4, 1, "5", 15, "worstPattern"));
		pa.foundPattern(new PasswordPattern(4, 1, "5", 20, "worsePattern"));
		pa.foundPattern(new PasswordPattern(4, 1, "5", 4, "bestPattern"));
		pa.foundPattern(new PasswordPattern(4, 1, "5", 23, "worserPattern"));
		
		PathCost patterns = pa.calculateHighestProbablePatterns();
		
		List<PasswordPattern> list = patterns.getPath();
		assertEquals(4, list.size());
		double result = patterns.getTotalCost();
		System.out.println("cost="+result);
		double expected = Math.pow(10,1)*4*4*4;
		assertEquals(expected, result, 0.5);
	}
}
