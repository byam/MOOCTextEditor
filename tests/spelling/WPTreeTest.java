package spelling;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WPTreeTest {
    @Test
    public void findPath() throws Exception {
        WPTree wpTree = new WPTree();
//        List<String> path = wpTree.findPath("time", "theme");
//        List<String> path = wpTree.findPath("pool", "spoon");
        List<String> path = wpTree.findPath("stools", "moon");
        System.out.println(Arrays.toString(path.toArray()));
    }
}

//pool, stools, tools, fools, fool, pool, spool, spoon, soon, moon
//      stools, tools, fools, fool, pool, spool, spoon, soon, moon.
