package com.icloud.oswald.model.aggregator;

import java.util.Iterator;
import java.io.IOException;

public interface Aggregate {

    public Iterator iterator(String value) throws IOException;
}