package com.rakuten;

import com.rakuten.valueparsers.StringValueParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AmazonItemParser implements Parser {
    protected StringValueParser nameParser;
    protected StringValueParser categoryParser;
    protected StringValueParser priceParser;

    public AmazonItemParser(StringValueParser nameParser, StringValueParser categoryParser, StringValueParser priceParser) {
        this.nameParser = nameParser;
        this.categoryParser = categoryParser;
        this.priceParser = priceParser;
    }

    @Override
    public Item parse(String input) {
        assertFileExists(input);

        try {
            File source = new File(input);
            Document doc = Jsoup.parse(source, "UTF-8");

            return new Item(nameParser.parseValue(doc),
                    categoryParser.parseValue(doc),
                    priceParser.parseValue(doc));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void assertFileExists(String input) {
        if (!Files.exists(Paths.get(input)))
            throw new IllegalArgumentException("File " + input + "doesn't exist");
    }
}
