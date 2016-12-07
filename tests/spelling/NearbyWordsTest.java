package spelling;

import org.junit.Test;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class NearbyWordsTest {
    @Test
    public void suggestions() throws Exception {
        String word = "i";
        // Pass NearbyWords any Dictionary implementation you prefer
        Dictionary d = new DictionaryHashSet();
        DictionaryLoader.loadDictionary(d, "data/dict.txt");
        NearbyWords w = new NearbyWords(d);
        List<String> l = w.distanceOne(word, true);
        System.out.println("One away word Strings for for \""+word+"\" are:");
        System.out.println(l+"\n");

        word = "kangaro";
        List<String> suggest = w.suggestions(word, 10);
        System.out.println("Spelling Suggestions for \""+word+"\" are:");
        System.out.println(suggest);
    }

    @Test
    public void deletions() throws Exception {
        Dictionary d = new DictionaryHashSet();
        NearbyWords nearbyWords = new NearbyWords(d);
        List<String> list1 = new ArrayList<>();
        nearbyWords.deletions("abcde", list1, false);

        System.out.println(Arrays.toString(list1.toArray()));

        assertEquals(
                "Check insertions", 5, list1.size()
        );
    }

    @Test
    public void insertions() throws Exception {
        Dictionary d = new DictionaryHashSet();
        NearbyWords nearbyWords = new NearbyWords(d);
        List<String> list1 = new ArrayList<>();
        nearbyWords.insertions("aa", list1, false);

        System.out.println(Arrays.toString(list1.toArray()));

        assertEquals(
                "Check insertions", 76, list1.size()
        );
    }
}