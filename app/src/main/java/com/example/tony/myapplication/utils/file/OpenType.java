package com.example.tony.myapplication.utils.file;

public interface OpenType {
    String open_type_apk = "apk";
    String open_type_back = "back";
    String open_type_excel = "excel";
    String open_type_file = "file";
    String open_type_html = "html";
    String open_type_movie = "movie";
    String open_type_music = "music";
    String open_type_ota = "ota";
    String open_type_other = "other";
    String open_type_pdf = "pdf";
    String open_type_pic = "pic";
    String open_type_ppt = "ppt";
    String open_type_subtitile = "subtitile";
    String open_type_txt = "txt";
    String open_type_word = "word";
    String open_type_zip = "zip";

    /*支持music格式*/
    String[] types_music = new String[]{"aac", "amr", "ape", "dts", "flac", "m4a", "m4p", "m4r", "mid", "midi", "mp1", "mp2", "mp3", "mp5", "mpa", "mpga", "ogg", "wav", "wma"};
    /*支持电影格式*/
    String[] types_movie = new String[]{"3dm", "3dv", "3g2", "3gp", "3gpp", "3gpp2", "asf", "avi", "dat", "divx", "f4v", "flv", "iso", "lge", "m2t", "m2ts", "m4b", "m4p", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "pmp", "psr", "ram", "rm", "rmvb", "tp", "ts", "vob", "webm", "wmv", "mts"};
    /*支持图片格式*/
    String[] types_pic = new String[]{"bmp", "gif", "jfif", "jpeg", "jpg", "png", "tiff"};
    /*支持文本格式*/
    String[] types_txe = new String[]{"epub", "fb2", "pdb", "rtf", "txt"};
    /*支持word格式*/
    String[] types_word = new String[]{"doc", "docx"};
    /*支持excel格式*/
    String[] types_excel = new String[]{"xls", "xlsx"};
    /*支持ppt格式*/
    String[] types_ppt = new String[]{"ppt", "pptx"};
    /*支持zip格式*/
    String[] tupes_zip = new String[]{"zip", "rar"};
}
