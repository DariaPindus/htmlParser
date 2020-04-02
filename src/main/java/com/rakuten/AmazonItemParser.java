package com.rakuten;

import com.rakuten.valueparsers.StringValueParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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
        Document doc = Jsoup.parse(input, "UTF-8");

        return new Item(nameParser.parseValue(doc),
                categoryParser.parseValue(doc),
                priceParser.parseValue(doc));
    }

}
