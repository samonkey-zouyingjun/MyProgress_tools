package com.example.tony.myapplication;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

public class TesterTest {

    @Test
    public void test1() {
        Tester tester = new Tester();
        assertEquals(2,tester.test());
    }
}