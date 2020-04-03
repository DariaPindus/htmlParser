package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonNameForVehicleParser extends StringFieldParser {
    public AmazonNameForVehicleParser() {
        super("#product-title > h1");
    }

    @Override
    public String parseValue(Document doc) {
        Elements nameDiv = doc.select(SELECTOR);
        return nameDiv.first().select("h1").first().text();
    }
}
