package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;

public abstract class StringFieldParser {
    protected final String SELECTOR ;

    protected StringFieldParser(String selector) {
        SELECTOR = selector;
    }

    public abstract String parseValue(Document doc);

    public boolean isApplicable(Document doc) {
        return !doc.select(SELECTOR).isEmpty();
    }
}
