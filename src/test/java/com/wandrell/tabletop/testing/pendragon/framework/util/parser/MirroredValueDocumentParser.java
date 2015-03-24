package com.wandrell.tabletop.testing.pendragon.framework.util.parser;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wandrell.pattern.parser.Parser;

public final class MirroredValueDocumentParser implements
        Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
                                               .getLogger(MirroredValueDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public MirroredValueDocumentParser() {
        super();
    }

    @Override
    public final Collection<Collection<Object>> parse(final Document doc) {
        final Collection<Collection<Object>> colData;

        colData = new LinkedHashSet<Collection<Object>>();
        for (final Element node : doc.getRootElement().getChildren()) {
            colData.add(readNode(node));
        }

        return colData;
    }

    private final Collection<Object> readNode(final Element node) {
        final Collection<Object> data;
        final Integer value;
        final Integer mirrored;

        data = new LinkedList<Object>();

        value = Integer.parseInt(node.getChild("value").getText());
        mirrored = Integer.parseInt(node.getChild("mirror").getText());

        getLogger().debug(
                String.format("Read dice value %d and its mirror %d", value,
                        mirrored));

        data.add(value);
        data.add(mirrored);

        return data;
    }

}
