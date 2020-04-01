package com.rakuten;

public class ItemParserFactory {

    public static Item getParser(String fileName) {
        if (fileName.contains("apple"))
            return getAppleParser();
        else return null;
    }

    private static Item getAppleParser() {
        return null;
    }
}
