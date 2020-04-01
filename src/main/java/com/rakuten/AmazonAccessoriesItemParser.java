package com.rakuten;

import org.jsoup.nodes.Document;

public class AmazonAccessoriesItemParser extends AmazonItemParser {

    public AmazonAccessoriesItemParser() {
        nameParser = this::nameParser;
        categoryParser = this::categoryParser;
        priceParser = this::priceParser;
    }

    private String nameParser(Document doc) {
        return "";
    }

    private String categoryParser(Document doc) {
        return "";
    }

    private String priceParser(Document doc) {
        return "";
    }
}
