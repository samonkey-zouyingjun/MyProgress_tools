package com.example.tony.myapplication.utils.file;

import android.annotation.SuppressLint;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * todo 统一文件类型管理
 */
public abstract class FileType implements OpenType{
    public static final int APK = 5;
    public static final int DIR = 0;
    public static final int EXCEL = 8;
    public static final int HTML = 10;
    public static final int MOVIE = 2;
    public static final int MUSIC = 1;
    public static final int OTHER = 12;
    public static final int PDF = 6;
    public static final int PIC = 3;
    public static final int PPT = 9;
    public static final int TXT = 4;
    public static final int WORD = 7;
    public static final int ZIP = 11;
    public static final ArrayList<FileType> types = new ArrayList();
    private final int type;

    public static class ArrayType extends FileType {
        private HashSet<String> names = new HashSet();

        public ArrayType(int type, String[] exts) {
            super(type);
            for (String name : exts) {
                this.names.add(name);
            }
        }

        public void addExt(String ext) {
            this.names.add(ext);
        }

        public boolean remove(String ext) {
            return this.names.remove(ext);
        }

        boolean isType(String name, String ext) {
            return this.names.contains(ext);
        }
    }

    public static final class SingleType extends FileType {
        private String ext;

        public SingleType(int type, String ext) {
            super(type);
            this.ext = ext;
        }

        boolean isType(String name, String ext) {
            return this.ext.equals(ext);
        }
    }

    abstract boolean isType(String str, String str2);

    static {
        reset();
    }

    public FileType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public static void initModelType(int model, boolean isXtreamer) {
        if (model == MUSIC && isXtreamer) {
            FileType dbsMusic = new FileType(MUSIC) {
                boolean isType(String name, String ext) {
                    return ext.equalsIgnoreCase("dbs") && FileType.isAudioFile(name.substring(0, (name.length() - ext.length()) - 1));
                }
            };
            FileType dbsMovie = new FileType(MOVIE) {
                boolean isType(String name, String ext) {
                    return ext.equalsIgnoreCase("dbs") && FileType.isMovieFile(name.substring(0, (name.length() - ext.length()) - 1));
                }
            };
            types.add(dbsMusic);
            types.add(dbsMovie);
        } else if (model == APK) {
            types.add(new SingleType(MOVIE, "vp9"));
        }
    }

    public static final void reset() {
        types.clear();
        types.add(new ArrayType(MUSIC,types_music));
        types.add(new ArrayType(MOVIE, types_movie));
        types.add(new ArrayType(PIC, types_pic));
        types.add(new ArrayType(TXT, types_txe));
        types.add(new SingleType(APK, open_type_apk));
        types.add(new SingleType(PDF, open_type_pdf));
        types.add(new ArrayType(WORD, types_word));
        types.add(new ArrayType(EXCEL, types_excel));
        types.add(new ArrayType(PPT, types_ppt));
        types.add(new SingleType(HTML, open_type_html));
        types.add(new ArrayType(ZIP, tupes_zip));
    }

    public static void registerFiletype(int type, String[] exts) {
        types.add(0, new ArrayType(type, exts));
    }

    public static int getType(File file) {
        if (file.isDirectory()) {
            return 0;
        }
        if (isDsfMusic(file.getAbsolutePath())) {
            return MUSIC;
        }
        return getFileType(file.getName());
    }

    public static int getFileType(String name) {
        int p = name.lastIndexOf(".");
        if (p != -1) {
            return getFileType(name, name.substring(p + 1).toLowerCase());
        }
        return 12;
    }

    private static int getFileType(String name, String ext) {
        Iterator it = types.iterator();
        while (it.hasNext()) {
            FileType type = (FileType) it.next();
            if (type.isType(name, ext)) {
                return type.getType();
            }
        }
        return 12;
    }

    public static boolean isType(int type, String fileName) {
        int p = fileName.lastIndexOf(".");
        if (p != -1) {
            String ext = fileName.substring(p + 1).toLowerCase();
            if (type != 12) {
                Iterator it = types.iterator();
                while (it.hasNext()) {
                    FileType fileType = (FileType) it.next();
                    if (fileType.getType() == type && fileType.isType(fileName, ext)) {
                        return true;
                    }
                }
            } else if (getFileType(fileName, ext) == 12) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean isMovieFile(String fileName) {
        return isType(MOVIE, fileName);
    }

    public static boolean isMovieFile(File file) {
        return isType(MOVIE, file.getName()) && !isDsfMusic(file.getAbsolutePath());
    }

    public static boolean isAudioFile(String fileName) {
        return isType(MUSIC, fileName);
    }

    public static boolean isAudioFile(File file) {
        return isType(MUSIC, file.getName()) || isDsfMusic(file.getAbsolutePath());
    }

    public static boolean isDsfMusic(String path) {
        try {
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equalsIgnoreCase("iso")) {
                return isIsoMusic(path);
            }
            if (ext.equalsIgnoreCase("dsf") || ext.equalsIgnoreCase("dff")) {
                return true;
            }
            return false;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public static boolean isIsoMovie(String path) {
        try {
            if (!path.substring(path.lastIndexOf(".") + 1).equalsIgnoreCase("iso") || isIsoMusic(path)) {
                return false;
            }
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private static boolean isIsoMusic(String path) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                return false;
            }
            FileInputStream Input = new FileInputStream(file);
            byte[] buffer = new byte[8];
            Input.skip((long) 1044480);
            Input.read(buffer);
            Input.close();
            if (new String(buffer).equals("SACDMTOC")) {
                return true;
            }
            Input = new FileInputStream(file);
            buffer = new byte[8];
            Input.skip((long) 1052652);
            Input.read(buffer);
            Input.close();
            if (new String(buffer).equals("SACDMTOC")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isPictureFile(String fileName) {
        return isType(PIC, fileName);
    }

    public static boolean isTxtFile(String fileName) {
        return isType(TXT, fileName);
    }

    public static boolean isApkFile(String fileName) {
        return getFileExt(fileName).toLowerCase().equals(open_type_apk);
    }

    public static boolean isPdfFile(String fileName) {
        return getFileExt(fileName).toLowerCase().equals(open_type_pdf);
    }

    public static boolean isWordFile(String fileName) {
        return isType(WORD, fileName);
    }

    public static boolean isExcelFile(String fileName) {
        return isType(EXCEL, fileName);
    }

    public static boolean isPptFile(String fileName) {
        return isType(PPT, fileName);
    }

    public static boolean isHtmlFile(String fileName) {
        return getFileExt(fileName).toLowerCase().equals("html");
    }

    public static boolean isZipFile(String fileName) {
        return isType(ZIP, fileName);
    }

    public static boolean isBDMV(String path) {
        File bdmv = new File(path + "/BDMV/STREAM");
        if ((bdmv.exists() && bdmv.isDirectory()) || new File(path, "VIDEO_TS.IFO").exists()) {
            return true;
        }
        return new File(path, "VIDEO_TS/VIDEO_TS.IFO").exists();
    }

    public static String isCUE(String path) {
        if (!getFileExt(path).toLowerCase().equals("cue")) {
            return null;
        }
        String[] CUE_F = new String[]{"ape", "APE", "wav", "WAV", "flac", "FLAC", "dts", "DTS"};
        String pre = path.substring(0, path.length() - 3);
        for (String str : CUE_F) {
            File file = new File(pre + str);
            if (file.exists()) {
                return file.getPath();
            }
        }
        return null;
    }

    private static String getFileExt(String name) {
        int e = name.lastIndexOf(46);
        return e == -1 ? name : name.substring(e + 1);
    }
}
