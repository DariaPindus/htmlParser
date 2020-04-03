package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;

import java.util.List;

public class StringParserFactory {

    private final String parameterName;
    private final List<StringFieldParser> strategies;

    public StringParserFactory(String parameterName, List<StringFieldParser> strategies) {
        this.parameterName = parameterName;
        this.strategies = strategies;
    }

    public String parseField(Document doc) {
        StringFieldParser parser = strategies
                .stream()
                .filter(strategy -> strategy.isApplicable(doc))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Couldn't find valid parser for parameter " + parameterName));
        return parser.parseValue(doc);
    }
}
