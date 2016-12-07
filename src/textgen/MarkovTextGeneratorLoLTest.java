package textgen;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MarkovTextGeneratorLoLTest {

    MarkovTextGeneratorLoL simpleMarkovText;
    String simpleTextString;
    String simpleNewTextString;

    @Before
    public void setUp() throws Exception {
        simpleMarkovText = new MarkovTextGeneratorLoL(new Random(42));
        simpleTextString = "hi there hi Leo";
        simpleNewTextString = "hello you hi hi";
    }

    @Test
    public void train() throws Exception {
        simpleMarkovText.train(simpleTextString);

        assertEquals(
                "Check simple text training",
                "hi: there->Leo->\nthere: hi->\nLeo: hi->\n",
               simpleMarkovText.toString()
        );
    }

    @Test
    public void generateText() throws Exception {
        simpleMarkovText.train(simpleTextString);

        String out = simpleMarkovText.generateText(3);

        if (!out.equals("hi Leo hi") && !out.equals("hi there hi")){
            fail("Check generator");
        }

        if (simpleMarkovText.generateText(0) != "")
            fail("The text generator shouldn't produce anything when zero words are requested.");
    }

    @Test
    public void retrain() throws Exception {
        simpleMarkovText.train(simpleTextString);
        simpleMarkovText.retrain(simpleNewTextString);

        String out = simpleMarkovText.generateText(4);

        System.out.println(simpleMarkovText.toString());

        if (!out.equals("hello you hi hi") && !out.equals("hello you hi hello")){
            fail("Check generator");
        }    }

    @Test
    public void generateTextBeforeTrain(){
        /** Generating text before training */
        assertEquals("Generating text before training",
                "  ",
                simpleMarkovText.generateText(3)
                );
    }


    // ** Test #8: Running train() on a generator that has already been trained...FAILED.
    // Make sure that train() doesn't remove the original word lists.
    // Note that if Test #4 failed, this one will fail too.


}