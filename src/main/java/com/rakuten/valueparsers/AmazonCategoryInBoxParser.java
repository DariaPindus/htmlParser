package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AmazonCategoryInBoxParser extends StringFieldParser {
    public AmazonCategoryInBoxParser(){
        super("#a-page > div.a-container > div:nth-child(3) > div > div.a-fixed-right-grid-col.a-col-right > div > div.a-box-inner > a");
    }
    @Override
    public String parseValue(Document doc) {
        Elements parentBox = doc.select(".a-box-inner");
        return parentBox.first().child(0).text().trim();
    }
}
