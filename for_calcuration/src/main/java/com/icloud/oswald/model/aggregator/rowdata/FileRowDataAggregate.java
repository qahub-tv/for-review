package com.icloud.oswald.model.aggregator.rowdata;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Iterator;
import com.icloud.oswald.model.aggregator.Aggregate;
import com.icloud.oswald.model.iterator.rowdata.FileRowDataIterator;

public class FileRowDataAggregate implements Aggregate {

    private List<String> rowData = new ArrayList<>();

    @Override
    public Iterator iterator(String value)throws IOException {
        Path filePath = Paths.get(value);
        rowData = Files.readAllLines(filePath);
        return new FileRowDataIterator<FileRowDataAggregate>(this);
    }

    public List<String> getList() {
        List<String> values = new ArrayList<>();
        values.addAll(rowData);
        return values;
    }
}