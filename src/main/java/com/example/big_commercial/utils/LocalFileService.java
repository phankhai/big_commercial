package com.example.big_commercial.utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class LocalFileService {

    public static String exportFileExcel(String rootDir, String dir, String nameFile) {
        String extension = "EXCEL_FILE_EXTENSION";
        nameFile = StringUtils.cleanPath(nameFile.replaceFirst("[.][^.]+$", "").replaceAll(" ", "") + "_" + UUID.randomUUID() + extension);
        String path = rootDir + File.separator + dir;
        File file = new File(path);
        File myFile = new File(path + File.separator + nameFile);
        try {
            if (file.exists()) {
                myFile.createNewFile();
            } else {
                boolean b = file.mkdirs();
                myFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path + File.separator + nameFile;
    }

}
