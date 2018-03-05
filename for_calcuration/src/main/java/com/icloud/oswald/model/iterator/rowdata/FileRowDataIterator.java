package main.java.com.icloud.oswald.model.iterator.rowdata;

import java.util.Iterator;
import main.java.com.icloud.oswald.model.aggregator.rowdata.FileRowDataAggregate;

public class FileRowDataIterator implements Iterator {

    private FileRowDataAggregate rowDataList;

    private int index;

    public FileRowDataIterator(FileRowDataAggregate rowDataList) {
        this.rowDataList = rowDataList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return rowDataList.getFileRowData().size() > index;
    }

    @Override
    public Object next() {
        String rowData = rowDataList.getFileRowData().get(index);
        index++;
        return rowData;
    }
}