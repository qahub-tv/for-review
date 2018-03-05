package main.java.com.icloud.oswald.model.aggregator.rowdata;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.io.IOException;
import java.util.Iterator;
import main.java.com.icloud.oswald.model.aggregator.Aggregate;
import main.java.com.icloud.oswald.model.iterator.rowdata.FileRowDataIterator;

public class FileRowDataAggregate implements Aggregate {

    private final List<String> fileRowData;

    public FileRowDataAggregate(String filePath) throws IOException {
        Path targetFilePath = Paths.get(filePath);
        this.fileRowData = Files.readAllLines(targetFilePath);
    }

    @Override
    public Iterator iterator() {
        return new FileRowDataIterator<FileRowDataAggregate>(this);
    }

    public List<String> getFileRowData() {
        return fileRowData;
    }
}