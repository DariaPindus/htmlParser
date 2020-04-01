package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonVehiclePriceParser implements StringValueParser {
    private static final String SELECTOR = ".vdp-new-vehicle-pricing-tab-content > .a-box-inner:last-child";

    @Override
    public String parseValue(Document doc) {
        Elements parentRow = doc.select(SELECTOR);
        assertParseSucceeded(parentRow, SELECTOR);
        return parentRow.last().children().first().text().trim();
    }
}
