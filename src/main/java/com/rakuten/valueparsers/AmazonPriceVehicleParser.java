package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class AmazonPriceVehicleParser extends StringFieldParser {

    public AmazonPriceVehicleParser() {
        super("#product-price div.vdp-new-vehicle-pricing-tab-content > div.a-box-inner > div:last-child > div:nth-child(2) > span");
    }

    @Override
    public String parseValue(Document doc) {
        Element element = doc.select(SELECTOR).first();
        return element.text() ;
    }
}
