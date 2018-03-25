package com.icloud.oswald.model.rowdata.text;

import java.util.List;
import java.lang.SecurityException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import com.icloud.oswald.model.rowdata.Rowdata;

public class Text implements Rowdata {

    @Override
    public List<String> getValues(Path value) throws IOException, SecurityException {
        return Files.readAllLines(value, StandardCharsets.UTF_8);
    }

}