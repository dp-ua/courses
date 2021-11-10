package com.epam.files;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class FileWalker {

    public static final Logger LOG = LoggerFactory.getLogger(FileWalker.class);

    @SneakyThrows
    public static void main(String[] args) {
        walk("C:\\work\\sap-bhyb\\datahub-62\\src\\");
    }

    private static void walk(String walkPath) throws IOException {
        if (walkPath == null) {
            LOG.error("Can't find walkPath variable!");
            throw new IOException("Can't find walkPath variable");
        }

        File currentPath = new File(walkPath).getCanonicalFile();

        Path absPath = Paths.get(currentPath.getAbsolutePath());
        LocalDate dateLimit = LocalDate.now().minusMonths(3);

        Files.walk(absPath)
                .filter(path -> !Files.isDirectory(path))
                .filter(path -> {
                    LocalDate fileDate = Instant
                            .ofEpochMilli(new File(path.toString()).lastModified())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    return fileDate.isAfter(dateLimit);
                })
                //todo add filter for Only new logs
                .forEach(path -> {
                    LocalDate localDate = Instant
                            .ofEpochMilli(new File(path.toString()).lastModified())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                    LOG.info((localDate.isAfter(dateLimit) ? "[NEW]" : "[OLD]") + " " + path.toString());
                });
    }

}
