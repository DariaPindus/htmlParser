package com.rakuten;

import com.rakuten.valueparsers.*;

public class ItemParserFactory implements Parser {

    private Parser getParser(String fileName) {
        if (fileName.contains("apple"))
            return getAppleItemParser();
        else if (fileName.contains("general"))
            return getGeneralItemParser();
        else if (fileName.contains("car"))
            return getCarItemParser();
        else
            throw new IllegalArgumentException("Probably parser not implemented yet");
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

    private Parser getAppleItemParser() {
        return new AmazonItemParser(
                new AmazonNameParser(),
                new AmazonByLineCategoryParser(),
                new AmazonPriceBoxValueParser());
    }

    @Override
    public Item parse(String input) {
        return getParser(input).parse(input);
    }
}
