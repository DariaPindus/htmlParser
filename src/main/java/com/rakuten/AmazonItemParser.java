package com.rakuten;

import com.rakuten.valueparsers.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Arrays;

public class AmazonItemParser implements Parser {
    protected final StringParserFactory nameParser;
    protected final StringParserFactory categoryParser;
    protected final StringParserFactory priceParser;

    public AmazonItemParser() {
        nameParser = new StringParserFactory(
                "name",
                Arrays.asList(new AmazonNameByTitleParser(), new AmazonNameForVehicleParser()));

        categoryParser = new StringParserFactory(
                "category",
                Arrays.asList(new AmazonCategoryInBoxParser(), new AmazonCategoryFromBreadcrumbsParser(), new AmazonCategoryByLineParser()));

        priceParser = new StringParserFactory(
                "price",
                Arrays.asList(new AmazonPriceByPriceIdParser(), new AmazonPriceFromSelectedBoxParser(), new AmazonPriceVehicleParser()));
    }

    @Override
    public Item parse(String input) {
        Document doc = Jsoup.parse(input, "UTF-8");

        return new Item(nameParser.parseField(doc),
                categoryParser.parseField(doc),
                priceParser.parseField(doc));
    }

}
