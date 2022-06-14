package com.bruijs.thomas.rentathingopt3.model;

public class ViewInfo {
    final String PATH, TITLE;

    public ViewInfo(String path, String title) {
        PATH = path;
        TITLE = title;
    }

    public String getPath() {
        return PATH;
    }

    public String getTitle() {
        return TITLE;
    }
}
