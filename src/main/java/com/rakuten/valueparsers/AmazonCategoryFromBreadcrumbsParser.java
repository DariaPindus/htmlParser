package com.rakuten.valueparsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AmazonCategoryFromBreadcrumbsParser extends StringFieldParser {
    public AmazonCategoryFromBreadcrumbsParser() {
        super("#wayfinding-breadcrumbs_feature_div");
    }
    
    @Override
    public String parseValue(Document doc) {
        Elements parent = doc.select(SELECTOR);
        Elements listItems = parent.first().children().first().children();
        return concatenateItems(listItems);
    }

    private String concatenateItems(Elements listItems) {
        return IntStream.range(0, listItems.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> listItems.get(i).child(0).text().trim())
                .collect(Collectors.joining(" › "));
    }
}
