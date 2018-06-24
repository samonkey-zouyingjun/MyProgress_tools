package com.example.tony.myapplication.utils.file;

import java.io.File;

public class FileTypeManager {
    public static final String OPEN_TYPE_APK = "apk";
    public static final String OPEN_TYPE_EXCEL = "excel";
    public static final String OPEN_TYPE_DIR = "file";
    public static final String OPEN_TYPE_HTML = "html";
    public static final String OPEN_TYPE_MOVIE = "movie";
    public static final String OPEN_TYPE_MUSIC = "music";
    public static final String OPEN_TYPE_OTA = "ota";
    public static final String OPEN_TYPE_OTHER = "other";
    public static final String OPEN_TYPE_PDF = "pdf";
    public static final String OPEN_TYPE_PIC = "pic";
    public static final String OPEN_TYPE_PPT = "ppt";
    public static final String OPEN_TYPE_SUBTITILE = "subtitile";
    public static final String OPEN_TYPE_TXT = "txt";
    public static final String OPEN_TYPE_WORD = "word";
    public static final String OPEN_TYPE_ZIP = "zip";
    public static final String OPEN_TYPE_BDMV = "bdmv";
    public static final String OPEN_TYPE_ISO = "iso";


    public static String getFileType(String path,boolean isDir){
        if (isDir) {
            return OPEN_TYPE_DIR;
        }
        if (isMusicFile(path)) {
            return OPEN_TYPE_MUSIC;
        }
        if (isMovieFile(path)) {
            return OPEN_TYPE_MOVIE;
        }
        if (isPictureFile(path)) {
            return OPEN_TYPE_PIC;
        }
        if (isApkFile(path)) {
            return OPEN_TYPE_APK;
        }
        if(isBDMV(path)){
            return OPEN_TYPE_BDMV;
        }
        if(isIso(path)){
            return OPEN_TYPE_ISO;
        }

        //todo
        /*if (isTxtFile(path)) {
            return OPEN_TYPE_TXT;
        }
        if (isPdfFile(path)) {
            return OPEN_TYPE_PDF;
        }
        if (isWordFile(path)) {
            return OPEN_TYPE_WORD;
        }
        if (isExcelFile(path)) {
            return OPEN_TYPE_EXCEL;
        }
        if (isPptFile(path)) {
            return OPEN_TYPE_PPT;
        }
        if (isHtml32File(path)) {
            return OPEN_TYPE_HTML;
        }

        if (isZIPFile(path)) {
            return OPEN_TYPE_ZIP;
        }
        if (isOtaFile(path)) {
            return OPEN_TYPE_OTA;
        }
        if (isSubtitileFile(path)) {
            return OPEN_TYPE_SUBTITILE;
        }*/
        return OPEN_TYPE_OTHER;
    }

    public static String getFileType(File file) {
        if (file.isDirectory()) {
            return OPEN_TYPE_DIR;
        }
        String path = file.getAbsolutePath();
        if (isMusicFile(path)) {
            return OPEN_TYPE_MUSIC;
        }
        if (isMovieFile(path)) {
            return OPEN_TYPE_MOVIE;
        }
        if (isPictureFile(path)) {
            return OPEN_TYPE_PIC;
        }
        if (isApkFile(path)) {
            return OPEN_TYPE_APK;
        }
        if(isBDMV(path)){
            return OPEN_TYPE_BDMV;
        }
        if(isIso(path)){
            return OPEN_TYPE_ISO;
        }

        //todo
        /*if (isTxtFile(path)) {
            return OPEN_TYPE_TXT;
        }
        if (isPdfFile(path)) {
            return OPEN_TYPE_PDF;
        }
        if (isWordFile(path)) {
            return OPEN_TYPE_WORD;
        }
        if (isExcelFile(path)) {
            return OPEN_TYPE_EXCEL;
        }
        if (isPptFile(path)) {
            return OPEN_TYPE_PPT;
        }
        if (isHtml32File(path)) {
            return OPEN_TYPE_HTML;
        }

        if (isZIPFile(path)) {
            return OPEN_TYPE_ZIP;
        }
        if (isOtaFile(path)) {
            return OPEN_TYPE_OTA;
        }
        if (isSubtitileFile(path)) {
            return OPEN_TYPE_SUBTITILE;
        }*/
        return OPEN_TYPE_OTHER;
    }

    public static boolean isMusicFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("ogg") || ext.equalsIgnoreCase("wav") || ext.equalsIgnoreCase("wma") || ext.equalsIgnoreCase("m4a") || ext.equalsIgnoreCase("ape") || ext.equalsIgnoreCase("dts") || ext.equalsIgnoreCase("flac") || ext.equalsIgnoreCase("mp1") || ext.equalsIgnoreCase("mp2") || ext.equalsIgnoreCase("aac") || ext.equalsIgnoreCase("midi") || ext.equalsIgnoreCase("mid") || ext.equalsIgnoreCase("mp5") || ext.equalsIgnoreCase("mpga") || ext.equalsIgnoreCase("mpa") || ext.equalsIgnoreCase("m4p") || ext.equalsIgnoreCase("amr") || ext.equalsIgnoreCase("m4r")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isMovieFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("avi") || ext.equalsIgnoreCase("wmv") || ext.equalsIgnoreCase("rmvb") || ext.equalsIgnoreCase("mkv") || ext.equalsIgnoreCase("m4v") || ext.equalsIgnoreCase("mov") || ext.equalsIgnoreCase("mpg") || ext.equalsIgnoreCase("rm") || ext.equalsIgnoreCase("flv") || ext.equalsIgnoreCase("pmp") || ext.equalsIgnoreCase("vob") || ext.equalsIgnoreCase("dat") || ext.equalsIgnoreCase("asf") || ext.equalsIgnoreCase("psr") || ext.equalsIgnoreCase("3gp") || ext.equalsIgnoreCase("mpeg") || ext.equalsIgnoreCase("ram") || ext.equalsIgnoreCase("divx") || ext.equalsIgnoreCase("m4p") || ext.equalsIgnoreCase("m4b") || ext.equalsIgnoreCase("mp4") || ext.equalsIgnoreCase("f4v") || ext.equalsIgnoreCase("3gpp") || ext.equalsIgnoreCase("3g2") || ext.equalsIgnoreCase("3gpp2") || ext.equalsIgnoreCase("webm") || ext.equalsIgnoreCase("ts") || ext.equalsIgnoreCase("tp") || ext.equalsIgnoreCase("m2ts") || ext.equalsIgnoreCase("m2t") || ext.equalsIgnoreCase("lge") || ext.equalsIgnoreCase("3dv") || ext.equalsIgnoreCase("3dm") || ext.equalsIgnoreCase("iso")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isPictureFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("gif") || ext.equalsIgnoreCase("bmp") || ext.equalsIgnoreCase("jfif") || ext.equalsIgnoreCase("tiff") || ext.equalsIgnoreCase("tif")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isTxtFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase(OPEN_TYPE_TXT) || ext.equalsIgnoreCase("epub") || ext.equalsIgnoreCase("pdb") || ext.equalsIgnoreCase("fb2") || ext.equalsIgnoreCase("rtf")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isPdfFile(String path) {
        try {
            if (path.substring(path.lastIndexOf(".") + 1).equalsIgnoreCase(OPEN_TYPE_PDF)) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isWordFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("doc") || ext.equalsIgnoreCase("docx")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isExcelFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("xls") || ext.equalsIgnoreCase("xlsx")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isPptFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase(OPEN_TYPE_PPT) || ext.equalsIgnoreCase("pptx")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isHtml32File(String path) {
        try {
            if (path.substring(path.lastIndexOf(".") + 1).equalsIgnoreCase(OPEN_TYPE_HTML)) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isApkFile(String path) {
        try {
            if (path.substring(path.lastIndexOf(".") + 1).equalsIgnoreCase(OPEN_TYPE_APK)) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isZIPFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase(OPEN_TYPE_ZIP) || ext.equalsIgnoreCase("rar")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isOtaFile(String path) {
        try {
            if (path.substring(path.lastIndexOf(".") + 1).equalsIgnoreCase(OPEN_TYPE_ZIP)) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * 字幕文件
     * @param path
     * @return
     */
    public static boolean isSubtitileFile(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("srt") || ext.equalsIgnoreCase("smi") || ext.equalsIgnoreCase("ass") || ext.equalsIgnoreCase("ssa") || ext.equalsIgnoreCase("sub") || ext.equalsIgnoreCase("idx") || ext.equalsIgnoreCase("sami") || ext.equalsIgnoreCase("txt")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isBDMV(String path) {
        File bdmv = new File(new StringBuilder(String.valueOf(path)).append("/BDMV/STREAM").toString());
        if ((bdmv.exists() && bdmv.isDirectory()) || new File(path, "VIDEO_TS.IFO").exists()) {
            return true;
        }
        return new File(path, "VIDEO_TS/VIDEO_TS.IFO").exists();
    }

    public static boolean isIso(String path) {
        try {
            if (path.substring(path.lastIndexOf(".") + 1).equalsIgnoreCase("iso")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
}
