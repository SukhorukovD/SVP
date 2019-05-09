package tests;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static source.Main.generate;

public class GenerateTest {

    @Test
    public void testGenerate() {

        int[] pp = {3, 2};
        int rs = 5;

        List<List<Integer>> comb = new ArrayList<List<Integer>>();

        comb.add(new ArrayList<Integer>());
        comb.get(0).add(3);
        comb.get(0).add(2);

        assertEquals(comb, generate(rs, pp));

        pp = new int[2];
        pp[0] = 2;
        pp[1] = 1;
        rs = 4;

        comb = new ArrayList<List<Integer>>();

        comb.add(new ArrayList<Integer>());
        comb.get(0).add(2);
        comb.get(0).add(2);

        comb.add(new ArrayList<Integer>());
        comb.get(1).add(2);
        comb.get(1).add(1);
        comb.get(1).add(1);

        comb.add(new ArrayList<Integer>());
        comb.get(2).add(1);
        comb.get(2).add(1);
        comb.get(2).add(1);
        comb.get(2).add(1);

        assertEquals(comb, generate(rs, pp));
        assertEquals(new ArrayList<ArrayList<Integer>>(), generate(0, new int[]{5, 4}));
        assertEquals(new ArrayList<ArrayList<Integer>>(), generate(1, new int[]{5, 4}));
        comb.clear();
        comb.add(new ArrayList<Integer>());
        comb.get(0).add(1);
        assertEquals(comb, generate(1, new int[]{0, 1}));

        comb.clear();
        comb.add(new ArrayList<Integer>());
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        comb.get(0).add(1);
        assertEquals(comb, generate(10, new int[]{0, 1}));

        comb.clear();
        comb.add(new ArrayList<Integer>());
        comb.get(0).add(1000);
        assertEquals(comb, generate(1000, new int[]{1000}));
    }
}

