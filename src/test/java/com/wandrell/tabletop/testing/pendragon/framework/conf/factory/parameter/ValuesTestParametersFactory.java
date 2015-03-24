package com.wandrell.tabletop.testing.pendragon.framework.conf.factory.parameter;

import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.jdom2.Document;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.pattern.parser.xml.XMLFileParser;
import com.wandrell.tabletop.testing.pendragon.framework.conf.ValuesConf;
import com.wandrell.tabletop.testing.pendragon.framework.util.parser.MirroredValueDocumentParser;
import com.wandrell.util.ResourceUtils;

public final class ValuesTestParametersFactory {

    private static final ValuesTestParametersFactory instance = new ValuesTestParametersFactory();

    public static final ValuesTestParametersFactory getInstance() {
        return instance;
    }

    private static final Iterator<Object[]> getParameters(
            final Collection<Collection<Object>> valuesTable) {
        final Collection<Object[]> result;

        result = new LinkedList<Object[]>();
        for (final Collection<Object> values : valuesTable) {
            result.add(values.toArray());
        }

        return result.iterator();
    }

    private ValuesTestParametersFactory() {
        super();
    }

    public final Iterator<Object[]> getValueAndMirror() throws Exception {
        return getParameters(getValueAndMirrorValues());
    }

    private final Collection<Collection<Object>> getValueAndMirrorValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new MirroredValueDocumentParser();

        return parserParams.parse(parserFile.parse(ResourceUtils
                .getClassPathReader(ValuesConf.MIRRORED)));
    }

}
