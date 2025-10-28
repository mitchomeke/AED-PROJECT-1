import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Mooshak-style testing using JUnit.
 * This class runs multiple test cases by comparing program output with expected output files.
 */
public class Tests {

    // Test sequence definition
    @Test public void test01() { runTest("input1", "output1"); }
    @Test public void test02() { runTest("input2", "output2"); }
    @Test public void test03() { runTest("input3", "output3"); }
    @Test public void test04() { runTest("input4", "output4"); }
    @Test public void test05() { runTest("input5", "output5"); }
    @Test public void test06() { runTest("input6", "output6"); }
    @Test public void test07() { runTest("input7", "output7"); }
    @Test public void test08() { runTest("input8", "output8"); }
    @Test public void test09() { runTest("input9", "output9"); }
    @Test public void test10() { runTest("input10", "output10"); }
    @Test public void test11() { runTest("input11", "output11"); }
    @Test public void test12() { runTest("input12", "output12"); }
    @Test public void test13() { runTest("input13", "output13"); }
    @Test public void test14() { runTest("input14", "output14"); }
    @Test public void test15() { runTest("input15", "output15"); }
    @Test public void test16() { runTest("input16", "output16"); }
    @Test public void test17() { runTest("input17", "output17"); }
    @Test public void test18() { runTest("input18", "output18"); }

    private static final File TEST_DIRECTORY = new File("C:\\Users\\PC\\IdeaProjects\\AED Project 1\\src\\tests");
    private PrintStream originalOut;
    private final ByteArrayOutputStream testOutput = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        // Save original System.out and redirect to our stream
        originalOut = System.out;
        System.setOut(new PrintStream(testOutput));

        // Set default locale for consistent number formatting
        Locale.setDefault(Locale.US);
    }

    @After
    public void tearDown() {
        // Restore original System.out
        System.setOut(originalOut);
    }

    /**
     * Executes a single test case
     * @param inputFile Name of the input file
     * @param expectedOutputFile Name of the expected output file
     */
    private void runTest(String inputFile, String expectedOutputFile) {
        File input = new File(TEST_DIRECTORY, inputFile);
        File expectedOutput = new File(TEST_DIRECTORY, expectedOutputFile);

        logTestInfo(input, expectedOutput);

        try {
            // Read test files
            String inputContent = readFile(input);
            String expectedContent = readFile(expectedOutput);

            displayTestContents(inputContent, expectedContent);

            // Execute the test
            executeProgram(input);

            // Verify results
            verifyOutput(expectedContent);

        } catch (Exception e) {
            handleTestError(e);
        }
    }

    /**
     * Logs test information to the console
     */
    private void logTestInfo(File input, File expectedOutput) {
        originalOut.println("🧪 Running Test:");
        originalOut.println("   Input: " + input.getAbsolutePath());
        originalOut.println("   Expected: " + expectedOutput.getAbsolutePath());
    }

    /**
     * Displays test input and expected output for debugging
     */
    private void displayTestContents(String inputContent, String expectedContent) {
        originalOut.println("📥 INPUT ============");
        originalOut.println(inputContent);
        originalOut.println("✅ EXPECTED OUTPUT =============");
        originalOut.println(expectedContent);
        originalOut.println("🔄 ACTUAL OUTPUT =============");
    }

    /**
     * Executes the main program with the given input file
     */
    private void executeProgram(File input) throws Exception {
        // Redirect System.in to read from input file
        System.setIn(new FileInputStream(input));

        // Clear previous test output
        testOutput.reset();

        // Execute main method using reflection
        Class<?> mainClass = Class.forName("Main");
        mainClass.getMethod("main", String[].class)
                .invoke(null, new Object[] { new String[0] });
    }

    /**
     * Verifies that actual output matches expected output
     */
    private void verifyOutput(String expectedContent) {
        String actualOutput = testOutput.toString();
        originalOut.println(actualOutput);

        String normalizedExpected = normalizeLineEndings(expectedContent);
        String normalizedActual = normalizeLineEndings(actualOutput);

        assertEquals("Output does not match expected result",
                normalizedExpected, normalizedActual);

        originalOut.println("✅ TEST PASSED!");
        originalOut.println("=================================");
    }

    /**
     * Handles test execution errors
     */
    private void handleTestError(Exception e) {
        originalOut.println("❌ TEST FAILED!");
        e.printStackTrace(originalOut);
        fail("Test execution failed: " + e.getMessage());
    }

    /**
     * Reads entire file content as string
     */
    private String readFile(File file) throws Exception {
        return new String(Files.readAllBytes(file.toPath()));
    }

    /**
     * Normalizes line endings to Unix-style (\n) for consistent comparison
     */
    private String normalizeLineEndings(String text) {
        return text.replaceAll("\r\n", "\n")
                .replaceAll("\r", "\n");
    }
}
