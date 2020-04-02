package com.rakuten;

import com.rakuten.valueparsers.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GeneralItemParser implements Parser {

    private Parser getParser(String input) {
        Document doc = Jsoup.parse(input);
        if (isGeneralItem(doc))
            return getGeneralItemParser();
        else if (isCarItem(doc))
            return getCarItemParser();
        else if (isAppleItem(doc))
            return getAppleItemParser();
        else
            throw new IllegalArgumentException("Probably valid parser not implemented yet");
    }

    private boolean isAppleItem(Document doc) {
        return !doc.select("#productTitle").isEmpty() &&
                !doc.select("#bylineInfo").isEmpty() &&
                !doc.select("#priceblock_ourprice").isEmpty();
    }

    private boolean isGeneralItem(Document doc) {
        return !doc.select("#productTitle").isEmpty() &&
                !doc.select("#wayfinding-breadcrumbs_feature_div").isEmpty() &&
                !doc.select("#priceblock_ourprice").isEmpty();
    }

    private boolean isCarItem(Document doc) {
        return !doc.select(".vdp-new-vehicle-pricing-tab-content > .a-box-inner:last-child").isEmpty() &&
                !doc.select("#product-title").isEmpty() &&
                !doc.select(".a-box-inner").isEmpty();
    }

    private Parser getAppleItemParser() {
        return new AmazonItemParser(
                new AmazonNameParser(),
                new AmazonByLineCategoryParser(),
                new AmazonPriceBoxValueParser());
    }

    private Parser getGeneralItemParser() {
        return new AmazonItemParser(new AmazonNameParser(),
                new AmazonCombinedCategoryParser(),
                new AmazonPriceBoxValueParser());
    }

    private Parser getCarItemParser() {
        return new AmazonItemParser(
                new AmazonCarNameValueParser(),
                new AmazonBoxCategoryParser(),
                new AmazonVehiclePriceParser());
    }

    @Override
    public Item parse(String input) {
        return getParser(input).parse(input);
    }
}
