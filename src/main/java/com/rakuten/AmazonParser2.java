package com.rakuten;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AmazonParser2 implements Parser {

    private final String NAME_SELECTOR = "productTitle";
    private final String CATEGORY_SELECTOR ="";

    @Override
    public Item parse(String input) {
        assertFileExists(input);

        File source = new File(input);
        return parseFile(source);
    }

    private Item parseFile(File input) {
        try {
            Document doc = Jsoup.parse(input, "UTF-8");
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private Item parseHtml(Document doc) {
        String name = doc.select("#").toString();
        String category = "";
        String price = "";

        return new Item(name, category, price );
    }

    private void assertFileExists(String input) {
        if (!Files.exists(Paths.get(input)))
            throw new IllegalArgumentException("File " + input + "doesn't exist");
    }
}
