package com.icloud.oswald.model.rowdata;

import java.util.List;
import java.nio.file.Path;

public interface Rowdata {

    public List<String> getValues(Path value) throws Exception;

}