package com.example.tony.myapplication.utils.file;

/**
 * 对应格式所支持的扩展名
 */
public interface ExtSupport {
    
    /*apk扩展名*/
    String type_apk = "apk";
    /*html扩展名*/
    String type_html = "html";
    /*pdf扩展名*/
    String type_pdf = "pdf";
    
    /*支持music扩展名*/
    String[] types_music = new String[]{"aac", "amr", "ape", "dts", "flac", "m4a", "m4p", "m4r", "mid", "midi", "mp1", "mp2", "mp3", "mp5", "mpa", "mpga", "ogg", "wav", "wma"};
    /*支持电影扩展名*/
    String[] types_movie = new String[]{"3dm", "3dv", "3g2", "3gp", "3gpp", "3gpp2", "asf", "avi", "dat", "divx", "f4v", "flv", "iso", "lge", "m2t", "m2ts", "m4b", "m4p", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "pmp", "psr", "ram", "rm", "rmvb", "tp", "ts", "vob", "webm", "wmv", "mts"};
    /*支持图片扩展名*/
    String[] types_pic = new String[]{"bmp", "gif", "jfif", "jpeg", "jpg", "png", "tiff"};
    /*支持文本扩展名*/
    String[] types_txe = new String[]{"epub", "fb2", "pdb", "rtf", "txt"};
    /*支持word扩展名*/
    String[] types_word = new String[]{"doc", "docx"};
    /*支持excel扩展名*/
    String[] types_excel = new String[]{"xls", "xlsx"};
    /*支持ppt扩展名*/
    String[] types_ppt = new String[]{"ppt", "pptx"};
    /*支持zip扩展名*/
    String[] types_zip = new String[]{"zip", "rar"};
    /*支持CUE扩展名*/
    String[] types_cue = new String[]{"ape", "APE", "wav", "WAV", "flac", "FLAC", "dts", "DTS"};
}
