package com.example.tony.myapplication.utils.file;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileTypeTest {

    @Test
    public void isApkFile() {

    }

    @Test
    public void isBDMV() {
    }

    @Test
    public void isText(){
        boolean isTxt = FileType.isTxtFile("/text.txt");
        assertEquals(isTxt,true);
    }
}