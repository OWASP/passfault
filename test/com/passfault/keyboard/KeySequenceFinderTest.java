/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.passfault.keyboard;

import com.passfault.keyboard.EnglishKeyBoard;
import com.passfault.keyboard.KeySequenceFinder;
import com.passfault.PasswordAnalysis;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cam
 */
public class KeySequenceFinderTest {

    public KeySequenceFinderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of analyze method, of class KeySequenceFinder.
     */
    @Test
    public void testAnalyze_right() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("asdfg");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(6, count);
    }

    /**
     * Test of analyze method, of class KeySequenceFinder.
     */
    @Test
    public void testAnalyze_rightMixed() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("aSdFg");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(6, count);
    }
    
    @Test
    public void testAnalyze_left() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("[poi");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(3, count);
    }
    
    @Test
    public void testAnalyze_upperleft() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("zaq1");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(3, count);
    }
    
    @Test
    public void testAnalyze_upperright() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("zse4");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(3, count);
    }
    @Test
    public void testAnalyze_lowerleft() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("4esz");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(3, count);
    }
    
    @Test
    public void testAnalyze_lowerright() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("1qaz");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(3, count);
    }
    
    @Test
    public void testAnalyze_repeating() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("eeee");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(3, count);
    }
    
    @Test
    public void testAnalyze_extraBeforeAndAfter() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("fredasdfcougar");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(3, count);
    }
    
    @Test
    public void testAnalyze_extraBeforeAndAfter_MixedCase() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("freSdFcougar2WsX");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(4, count);
    }

    @Test
    public void testAnalyze_random() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis("&7U8(b^j(*(l:';");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(1, count);
    }

    @Test
    public void testAnalyze_colon() throws Exception {
        System.out.println("analyze");
        PasswordAnalysis pass = new PasswordAnalysis(":");
        KeySequenceFinder instance = new KeySequenceFinder(new EnglishKeyBoard());
        instance.analyze(pass);
        int count = pass.getPossiblePatternCount();
        assertEquals(0, count);
    }
}