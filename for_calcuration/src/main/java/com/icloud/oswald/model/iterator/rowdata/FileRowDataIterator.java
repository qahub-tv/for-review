package main.java.com.icloud.oswald.model.iterator.rowdata;

import main.java.com.icloud.oswald.model.iterator.Iterator;
import main.java.com.icloud.oswald.model.aggregator.rowdata.FileRowDataAggregate;

public class FileRowDataIterator implements Iterator {

    private FileRowDataAggregate rowDataList;

    private int index;

    private int currentIndex;

    public FileRowDataIterator(FileRowDataAggregate rowDataList) {
        this.rowDataList = rowDataList;
        this.index = 0;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return rowDataList.getFileRowData().size() > index;
    }

    @Override
    public Object next() {
        String rowData = rowDataList.getFileRowData().get(index);
        currentIndex = index;
        index++;
        return rowData;
    }

    @Override
    public Object current() {
        return rowDataList.getFileRowData().get(currentIndex);
    }
}