package com.icloud.oswald.model.rowdata;

import java.util.List;
import java.lang.SecurityException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import com.icloud.oswald.model.rowdata.Rowdata;

public class Text implements Rowdata {

    @Override
    public List<String> getValues(String value) throws IOException, SecurityException {
        Path path = Paths.get(value);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

}