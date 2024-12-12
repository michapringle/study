package ca.mpringle.study.neet.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TimeMapTest {

    @Test
    void timeMapTest() {

        TimeMap sut = new TimeMap();

        assertEquals("", sut.get("alice", 1));
        sut.set("alice", "happy", 1);
        assertEquals("", sut.get("bob", 1));
        assertEquals("happy", sut.get("alice", 1));
        assertEquals("happy", sut.get("alice", 2));
        sut.set("alice", "sad", 3);
        assertEquals("sad", sut.get("alice", 3));
        assertEquals("happy", sut.get("alice", 2));
    }

    @Test
    void timeMapTest2() {

        TimeMap sut = new TimeMap();

        sut.set("key1", "value1", 10);
        assertEquals("", sut.get("key1", 1));
        assertEquals("value1", sut.get("key1", 10));
        assertEquals("value1", sut.get("key1", 11));
    }
}
