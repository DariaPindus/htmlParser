package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonNameByTitleParser extends StringFieldParser {

    public AmazonNameByTitleParser() {
        super("#productTitle");
    }

    @Override
    public String parseValue(Document doc) {
        Elements name = doc.select(SELECTOR);
        return name.first().text().trim();
    }

}
