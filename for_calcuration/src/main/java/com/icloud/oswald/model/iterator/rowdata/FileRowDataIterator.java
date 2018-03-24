package com.icloud.oswald.model.iterator.rowdata;

import java.util.Iterator;
import com.icloud.oswald.model.aggregator.rowdata.FileRowDataAggregate;

public class FileRowDataIterator<T extends FileRowDataAggregate> implements Iterator {

    private T rowDataList;

    private int index;

    public FileRowDataIterator(T rowDataList) {
        this.rowDataList = rowDataList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return rowDataList.getList().size() > index;
    }

    @Override
    public Object next() {
        String rowData = rowDataList.getList().get(index);
        index++;
        return rowData;
    }
}