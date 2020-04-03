package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonCategoryByLineParser extends StringFieldParser {
    public AmazonCategoryByLineParser() {
        super("#bylineInfo");
    }
    @Override
    public String parseValue(Document doc) {
        Elements name = doc.select(SELECTOR);
        return name.first().text().trim();
    }
}
