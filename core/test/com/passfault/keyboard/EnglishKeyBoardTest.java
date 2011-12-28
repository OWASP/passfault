/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.passfault.keyboard;

import com.passfault.keyboard.EnglishKeyBoard;
import com.passfault.keyboard.KeySequenceFinder;
import com.passfault.PathCost;
import com.passfault.PasswordAnalysis;
import com.passfault.PasswordResults;
import java.util.Map;
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
public class EnglishKeyBoardTest {

    public EnglishKeyBoardTest() {
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
     * Test of generateKeyboard method, of class EnglishKeyBoard.
     */
    @Test
    public void testGenerateKeyboard_horizontal() throws Exception {
        System.out.println("generateKeyboard");
        KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
        String expectedPatternName = KeySequenceFinder.HORIZONTAL;
        assertPattern(finder, new PasswordAnalysis("1234567890-="), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("!@#$%^&*()_+"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("qwertyuiop[]\\"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("QWERTYUIOP{}|"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("asdfghjkl;'"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("ASDFGHJKL:"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("zxcvbnm,./"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("ZXCVBNM<>?"), expectedPatternName);
    }

   @Test
    public void testGenerateKeyboard_horizontalMixed() throws Exception {
        System.out.println("generateKeyboard");
        KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
        String expectedPatternName = KeySequenceFinder.HORIZONTAL;
        assertPattern(finder, new PasswordAnalysis("12#456&890-="), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("!2#$5^&8()_+"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("qweRTyuiop[]\\"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("QweRTYuIoP{}|"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("asDFghjkl;'"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("ASDFghJKL:"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("zxCVbnm,./"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("ZXCvbNM<>?"), expectedPatternName);
    }

    @Test
    public void testGenerateKeyboard_diagnol() throws Exception {
        System.out.println("diags");
        KeySequenceFinder finder = new KeySequenceFinder(new EnglishKeyBoard());
        String expectedPatternName = KeySequenceFinder.DIAGONAL;
        assertPattern(finder, new PasswordAnalysis("1qaz"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("2wsx"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("3edc"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("4rfv"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("5tgb"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("6yhn"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("7ujm"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("8ik,"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("9ol."), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("0p;/"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("-['"), expectedPatternName);

        assertPattern(finder, new PasswordAnalysis("]'/"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("=[;."), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("-pl,"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("0okm"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("9ijn"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("8uhb"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("7ygv"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("6tfc"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("5rdx"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("4esz"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("3wa"), expectedPatternName);

        assertPattern(finder, new PasswordAnalysis("!QAZ"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("@WSX"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("#EDC"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("$RFV"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("%TGB"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("^YHN"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("&UJM"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("*IK<"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("(OL>"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis(")P:?"), expectedPatternName);
        assertPattern(finder, new PasswordAnalysis("_{\""), expectedPatternName);
    }

  private void assertPattern(KeySequenceFinder finder, PasswordResults pass, String expectedPatternName) throws Exception {
    finder.analyze(pass);
    PathCost cost = pass.calculateHighestProbablePatterns();
    assertEquals(1, cost.getPath().size());
    assertEquals(expectedPatternName, cost.getPath().get(0).getName());
  }

}