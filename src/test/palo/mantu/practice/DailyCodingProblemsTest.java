package palo.mantu.practice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import palo.mantu.practice.dailycodingproblem.dcp001.IntegerPairAsSum;
import palo.mantu.practice.dailycodingproblem.dcp002.ProductAllButSelf;
import palo.mantu.practice.dailycodingproblem.dcp003.BinaryTreeSerializer;
import palo.mantu.practice.dailycodingproblem.dcp004.MissingPositiveInteger;
import palo.mantu.practice.dailycodingproblem.dcp005.Cons;
import palo.mantu.practice.dailycodingproblem.dcp006TODO.XorLinkedList;
import palo.mantu.practice.dailycodingproblem.dcp007.MessageDecoder;
import palo.mantu.practice.dailycodingproblem.dcp008.UnivalSubtree;
import palo.mantu.practice.dailycodingproblem.dcp009.NonAdjacentIntegerSum;
import palo.mantu.practice.dailycodingproblem.dcp010.Scheduler;
import palo.mantu.practice.dailycodingproblem.dcp011.Autocomplete;
import palo.mantu.practice.dailycodingproblem.dcp012.StaircaseClimbSteps;
import palo.mantu.practice.dailycodingproblem.dcp013.LongestSubstringMinChars;
import palo.mantu.practice.dailycodingproblem.dcp014.PiMonteCarlo;
import palo.mantu.practice.dailycodingproblem.dcp015.RandomFromStream;
import palo.mantu.practice.dailycodingproblem.dcp016.OrderIdLog;
import palo.mantu.practice.dailycodingproblem.dcp017.LongestFilePathLength;
import palo.mantu.practice.dailycodingproblem.dcp018.MaximumValueSubarray;
import palo.mantu.practice.dailycodingproblem.dcp019.PaintHouseMinimumCost;
import palo.mantu.practice.dailycodingproblem.dcp020TODO.LinkedListIntersection;
import palo.mantu.practice.dailycodingproblem.dcp021.MinRoomFromTimeIntervals;
import palo.mantu.practice.dailycodingproblem.dcp021.MinRoomFromTimeIntervals.TimeInterval;
import palo.mantu.practice.dailycodingproblem.dcp022.SentenceFromWords;
import palo.mantu.practice.dailycodingproblem.dcp023TODO.MatrixMinSteps;
import palo.mantu.practice.dailycodingproblem.dcp024.BinaryTreeLock;
import palo.mantu.practice.dailycodingproblem.dcp025.RegexMatcher;
import palo.mantu.practice.dailycodingproblem.dcp061.IntegerExponentiation;
import palo.mantu.practice.dailycodingproblem.dcp062.MatrixTopLeftToBottomRight;
import palo.mantu.practice.dailycodingproblem.dcp063.MatrixWordSearch;
import palo.mantu.practice.dailycodingproblem.dcp071.Random5FromRandom7;
import palo.mantu.practice.dailycodingproblem.dcp072TODO.GraphLargestValuePath;
import palo.mantu.practice.dailycodingproblem.dcp073.ReverseSinglyLinkedList;
import palo.mantu.practice.dailycodingproblem.dcp074.MultiplicationTable;
import palo.mantu.practice.dailycodingproblem.dcp085.IntegerBitwiseOperation;
import palo.mantu.practice.dailycodingproblem.dcp086.InvalidParentheses;
import palo.mantu.practice.datastructure.BinaryTree;
import palo.mantu.practice.datastructure.SinglyLinkedList;

public class DailyCodingProblemsTest {
    @Test
    @DisplayName("Daily Coding Problem #1 - First integer pair as sum in array")
    public void searchIntegerPairAsSum() {
        IntegerPairAsSum o = new IntegerPairAsSum();

        assertArrayEquals(new int[] { 1, 4 }, o.search(new int[] { 4, 1, 3, 9, 7 }, 8));
        assertArrayEquals(new int[] { 0, 3 }, o.search(new int[] { 4, 1, 9, 4, 2 }, 8));
        assertNull(o.search(new int[] { 3, 2, 1, 4, 0 }, 8));

        assertArrayEquals(new int[] { 0, 3 }, o.searchSorted(new int[] { 1, 3, 4, 7, 9 }, 8));
        assertArrayEquals(new int[] { 2, 3 }, o.searchSorted(new int[] { 1, 2, 4, 4, 9 }, 8));
        assertNull(o.searchSorted(new int[] { 0, 1, 2, 3, 4 }, 8));

        assertArrayEquals(new int[] { 0, 3 }, o.searchSortedRecursive(new int[] { 1, 3, 4, 7, 9 }, 8, 0, 4));
        assertArrayEquals(new int[] { 2, 3 }, o.searchSortedRecursive(new int[] { 1, 2, 4, 4, 9 }, 8, 0, 4));
        assertNull(o.searchSortedRecursive(new int[] { 0, 1, 2, 3, 4 }, 8, 0, 4));
    }

    @Test
    @DisplayName("Daily Coding Problem #2 - Product of all elements except current in array")
    public void productAllButSelf() {
        ProductAllButSelf o = new ProductAllButSelf();

        assertArrayEquals(new int[] { 120, 60, 40, 30, 24 }, o.product(new int[] { 1, 2, 3, 4, 5 }));
        assertArrayEquals(new int[] { 2, 3, 6 }, o.product(new int[] { 3, 2, 1 }));
    }

    @Test
    @DisplayName("Daily Coding Problem #3 - Serialize binary tree to string")
    public void serializeBinaryTree() {
        BinaryTreeSerializer o = new BinaryTreeSerializer();

        BinaryTree bt1 = new BinaryTree("root", new BinaryTree("left", new BinaryTree("left.left"), null),
                new BinaryTree("right"));
        assertEquals("root left left.left # # # right # # ", o.serialize(bt1));

        BinaryTree bt2 = new BinaryTree("root", new BinaryTree("left"), null);
        assertEquals("root left # # # ", o.serialize(bt2));

        BinaryTree bt3 = new BinaryTree("root", null, new BinaryTree("right"));
        assertEquals("root # right # # ", o.serialize(bt3));
    }

    @Test
    @DisplayName("Daily Coding Problem #3 - Deserialize string to binary tree")
    public void deserializeBinaryTree() {
        BinaryTreeSerializer o = new BinaryTreeSerializer();

        String bt1 = "root left left.left # # # right # # ";
        assertEquals("root left left.left # # # right # # ", o.serialize(o.deserialize(bt1)));

        String bt2 = "root left # # # ";
        assertEquals("root left # # # ", o.serialize(o.deserialize(bt2)));

        String bt3 = "root # right # # ";
        assertEquals("root # right # # ", o.serialize(o.deserialize(bt3)));
    }

    @Test
    @DisplayName("Daily Coding Problem #4 - First missing positive integer in array")
    public void searchMissingPositiveInteger() {
        MissingPositiveInteger o = new MissingPositiveInteger();

        assertEquals(2, o.search(new int[] { 3, 4, -1, 1 }));
        assertEquals(3, o.search(new int[] { 1, 2, 0 }));
    }

    @Test
    @DisplayName("Daily Coding Problem #5 - Pair of integers")
    public void pair() {
        Cons o = new Cons(3, 4);

        assertArrayEquals(new int[] { 3, 4 }, o.pair());
    }

    @Test
    @DisplayName("Daily Coding Problem #5 - First element of integer pair")
    public void car() {
        Cons o = new Cons(3, 4);

        assertEquals(3, o.car());
    }

    @Test
    @DisplayName("Daily Coding Problem #5 - Last element of integer pair")
    public void cdr() {
        Cons o = new Cons(3, 4);

        assertEquals(4, o.cdr());
    }

    @Test
    @DisplayName("Daily Coding Problem #6 - XOR Linked List")
    public void TODOxorLinkedList() {
        XorLinkedList o = new XorLinkedList();

        assertTrue(false);
    }

    @Test
    @DisplayName("Daily Coding Problem #7 - Number of ways to decode message")
    public void countMessageDecodeWays() {
        MessageDecoder o = new MessageDecoder();

        assertEquals(0, o.count(null, 0, null));
        assertEquals(1, o.count("", 0, null));
        assertEquals(0, o.count("011", 3, null));
        assertEquals(3, o.count("12345", 5, new Integer[5]));
        assertEquals(1, o.count("27345", 5, new Integer[5]));
        assertEquals(3, o.count("111", 3, new Integer[3]));
    }

    @Test
    @DisplayName("Daily Coding Problem #8 - Unival subtree count of binary tree")
    public void countUnivalSubtree() {
        UnivalSubtree o = new UnivalSubtree();

        BinaryTree root = new BinaryTree(0);
        root.insert(1);
        root.insert(0);
        root.insert(1);
        root.insert(0);
        root.insert(1);
        assertEquals(5, o.count(root)[0]);
    }

    @Test
    @DisplayName("Daily Coding Problem #9 - Largest sum of non adjacent integers in array")
    public void nonAdjacentIntegerSum() {
        NonAdjacentIntegerSum o = new NonAdjacentIntegerSum();

        assertEquals(110, o.search(new int[] { 5, 5, 10, 100, 10, 5 }));
        assertEquals(4, o.search(new int[] { 1, 2, 3 }));
        assertEquals(20, o.search(new int[] { 1, 20, 3 }));
        assertEquals(13, o.search(new int[] { 2, 4, 6, 2, 5 }));
        assertEquals(10, o.search(new int[] { 5, 1, 1, 5 }));
    }

    @Test
    @DisplayName("Daily Coding Problem #10 - Scheduler with given function and time")
    public void schedule() {
        Scheduler o = new Scheduler();

        assertNotNull(o);
    }

    @Test
    @DisplayName("Daily Coding Problem #11 - Matching list based on query (autocomplete)")
    public void searchByPrefix() {
        Autocomplete o = new Autocomplete();

        assertEquals(asList("a", "aba", "abc", "acd"), o.search(asList("abc", "acd", "bcd", "def", "a", "aba"), "a"));
        assertEquals(asList("bcd"), o.search(asList("abc", "acd", "bcd", "def", "a", "aba"), "b"));
        assertEquals(asList("deal", "deer"), o.search(asList("dog", "deer", "deal"), "de"));
    }

    @Test
    @DisplayName("Daily Coding Problem #12 - Number of ways to climb staircase")
    public void countClimbStaircaseWays() {
        StaircaseClimbSteps o = new StaircaseClimbSteps();

        assertEquals(1, o.count(0));
        assertEquals(1, o.count(1));
        assertEquals(2, o.count(2));
        assertEquals(3, o.count(3));
        assertEquals(5, o.count(4));

        assertEquals(1, o.count(0, null));
        assertEquals(1, o.count(1, null));
        assertEquals(2, o.count(2, new int[] { 1, 2 }));
        assertEquals(3, o.count(3, new int[] { 1, 2 }));
        assertEquals(5, o.count(4, new int[] { 1, 2 }));
    }

    @Test
    @DisplayName("Daily Coding Problem #13 - Longest substring length")
    public void longestSubstringMinimumCharacters() {
        LongestSubstringMinChars o = new LongestSubstringMinChars();

        assertEquals(3, o.length("abcba", 2));
        assertEquals(7, o.length("aabacbebebe", 3));
    }

    @Test
    @DisplayName("Daily Coding Problem #14 - PI value by Monte Carlo method")
    public void piByMonteCarloMethod() {
        PiMonteCarlo o = new PiMonteCarlo();

        double pi = o.pi();
        assertTrue(pi > 3.14 && pi < 3.15);
    }

    @Test
    @DisplayName("Daily Coding Problem #15 - Random element from stream with uniform probability")
    public void randomFromStream() {
        RandomFromStream o = new RandomFromStream();

        int[] stream = { 0, 1, 2, 3, 4 };
        assertTrue(o.random(stream, 0) == 0);
        assertTrue(o.random(stream, 1) >= 0 && o.random(stream, 1) <= 1);
        assertTrue(o.random(stream, 2) >= 0 && o.random(stream, 2) <= 2);
        assertTrue(o.random(stream, 3) >= 0 && o.random(stream, 3) <= 3);
        assertTrue(o.random(stream, 4) >= 0 && o.random(stream, 4) <= 4);
    }

    @Test
    @DisplayName("Daily Coding Problem #16 - Order id log")
    public void orderIdLog() {
        OrderIdLog o = new OrderIdLog();

        o.record(1);
        o.record(11);
        o.record(111);
        assertEquals(1, o.getRecordId(0));
        assertEquals(11, o.getRecordId(1));
        assertEquals(111, o.getRecordId(2));
    }

    @Test
    @DisplayName("Daily Coding Problem #17 - Longest file path of directory structure")
    public void searchLongestFilePathLength() {
        LongestFilePathLength o = new LongestFilePathLength();

        assertEquals(32,
                o.search("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    @Test
    @DisplayName("Daily Coding Problem #18 - Maximum value sub array")
    public void searchMaximumValueSubarray() {
        MaximumValueSubarray o = new MaximumValueSubarray();

        assertEquals(asList(10, 7, 8, 8), o.search(new int[] { 10, 5, 2, 7, 8, 7 }, 3));
        assertEquals(asList(3, 3, 4, 5, 5, 5, 6), o.search(new int[] { 1, 2, 3, 1, 4, 5, 2, 3, 6 }, 3));
        assertEquals(asList(10, 10, 10, 15, 15, 90, 90), o.search(new int[] { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 }, 4));
    }

    @Test
    @DisplayName("Daily Coding Problem #19 - Minimum cost to paint houses")
    public void minimumCostToPaintHouses() {
        PaintHouseMinimumCost o = new PaintHouseMinimumCost();

        assertTrue(false);
    }

    @Test
    @DisplayName("Daily Coding Problem #20 - Intersection of two linked lists")
    public void TODOsearchLinkedListIntersection() {
        LinkedListIntersection o = new LinkedListIntersection();

        assertTrue(false);
    }

    @Test
    @DisplayName("Daily Coding Problem #21 - Minimum rooms from time intervals")
    public void minimumRoomsFromTimeIntervals() {
        MinRoomFromTimeIntervals o = new MinRoomFromTimeIntervals();

        List<TimeInterval> times = new ArrayList<>();
        times.add(o.new TimeInterval(30, 75));
        times.add(o.new TimeInterval(0, 50));
        times.add(o.new TimeInterval(60, 150));
        assertEquals(2, o.count(times));
    }

    @Test
    @DisplayName("Daily Coding Problem #22 - Sentence from words")
    public void searchSentenceFromWords() {
        SentenceFromWords o = new SentenceFromWords();

        assertEquals(asList("the", "quick", "brown", "fox"),
                o.search("thequickbrownfox", asList("quick", "brown", "the", "fox")));
        assertEquals(asList("bed", "bath", "and", "beyond"),
                o.search("bedbathandbeyond", asList("bed", "bath", "badbath", "and", "beyond")));
    }

    @Test
    @DisplayName("Daily Coding Problem #23 - Minimum steps to reach end from begin coordinate of matrix")
    public void TODOminimumStepsMatrix() {
        MatrixMinSteps o = new MatrixMinSteps();

        assertTrue(false);
    }

    @Test
    @DisplayName("Daily Coding Problem #24 - Binary tree lock, unclock and is locked")
    public void lockBinaryTree() {
        BinaryTreeLock o = new BinaryTreeLock();

        BinaryTree bt = new BinaryTree(10, new BinaryTree(8), new BinaryTree(12));
        bt.insert(7);
        bt.insert(9);
        bt.insert(13);
        bt.insert(14);

        assertFalse(o.isLocked(bt));
        assertTrue(o.lock(bt));
        assertTrue(o.unlock(bt));
    }

    @Test
    @DisplayName("Daily Coding Problem #25 - Regular expression matching with . and *")
    public void matchRegex() {
        RegexMatcher o = new RegexMatcher();

        assertTrue(o.match("ray", "ra."));
        assertFalse(o.match("raymond", "ra."));
        assertTrue(o.match("chat", ".*at"));
        assertFalse(o.match("chats", ".*at"));
    }

    @Test
    @DisplayName("Daily Coding Problem #61 - Integer exponentiation")
    public void integerExponentiation() {
        IntegerExponentiation o = new IntegerExponentiation();

        assertEquals(8.0, o.pow(2, 3), 0.1);
        assertEquals(0.5, o.pow(2, -1), 0.1);
    }

    @Test
    @DisplayName("Daily Coding Problem #62 - Number of ways to get to bottom right from top left of matrix")
    public void matrixBottomRightToTopLeft() {
        MatrixTopLeftToBottomRight o = new MatrixTopLeftToBottomRight();

        assertEquals(2, o.count(2, 2));
        assertEquals(70, o.count(5, 5));
    }

    @Test
    @DisplayName("Daily Coding Problem #63 - 2D matrix word search")
    public void matrixWordSearch() {
        MatrixWordSearch o = new MatrixWordSearch();

        char[][] words = new char[][] { { 'F', 'A', 'C', 'I' }, { 'O', 'B', 'Q', 'P' }, { 'A', 'N', 'O', 'B' },
                { 'M', 'A', 'S', 'S' } };
        assertTrue(o.search(words, "FACI"));
        assertTrue(o.search(words, "MASS"));
        // assertTrue(o.search(words, "ASS"));

        assertTrue(o.search(words, "FOAM"));
        assertTrue(o.search(words, "IPBS"));
        // assertTrue(o.search(words, "PBS"));
    }

    @Test
    @DisplayName("Daily Coding Problem #71 - Random 5 from Random 7 with uniform probability")
    public void random5FromRandom7() {
        Random5FromRandom7 o = new Random5FromRandom7();

        int rand = o.rand5();
        assertTrue(rand > 0 && rand < 6);
    }

    @Test
    @DisplayName("Daily Coding Problem #72 - Largest valur path of graph")
    public void TODOgraphLargestValuePath() {
        GraphLargestValuePath o = new GraphLargestValuePath();

        assertTrue(false);
    }

    @Test
    @DisplayName("Daily Coding Problem #73 - Reverse sinlgy linked list")
    public void reverseSinglyLinkedList() {
        ReverseSinglyLinkedList o = new ReverseSinglyLinkedList();

        SinglyLinkedList node = new SinglyLinkedList(1);
        node.add(2, node.length);
        node.add(3, node.length);
        assertEquals("3 2 1", o.reverse(node).toString());
    }

    @Test
    @DisplayName("Daily Coding Problem #74 - Number of appearances in multiplication table")
    public void multiplicationTableAppearanceCount() {
        MultiplicationTable o = new MultiplicationTable();

        assertEquals(4, o.count(6, 12));
        assertEquals(4, o.count(10, 20));
        assertEquals(4, o.count(25, 25));
    }

    @Test
    @DisplayName("Daily Coding Problem #85 - Integer bitwise operation")
    public void integerBitwiseOperation() {
        IntegerBitwiseOperation o = new IntegerBitwiseOperation();

        assertEquals(100, o.intbit(100, 200, 1));
        assertEquals(200, o.intbit(100, 200, 0));
    }

    @Test
    @DisplayName("Daily Coding Problem #86 - Count of invalid parentheses")
    public void invalidParenthesesCount() {
        InvalidParentheses o = new InvalidParentheses();

        assertEquals(1, o.count("()())()"));
        assertEquals(2, o.count(")("));
    }
}