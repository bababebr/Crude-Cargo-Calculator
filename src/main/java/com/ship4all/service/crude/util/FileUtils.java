package com.ship4all.service.crude.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class FileUtils {

  private final static String FILES_FOLDER_PATH = "C:\\Users\\unior1234\\IdeaProjects\\Crude-Cargo-Calculator\\src\\main\\resources\\csvFiles\\s%s%s";

  public static File multiFileToFile(@NotNull MultipartFile multipartFile, String fileName, String fileExtension) {
    log.info("Start converting Multi Fiel to File");
    String filePath = String.format(FILES_FOLDER_PATH, fileName, fileExtension);
    try {
      InputStream initialStream = multipartFile.getInputStream();
      byte[] buffer = new byte[initialStream.available()];
      initialStream.read(buffer);
      File targetFile = new File(filePath);
      System.out.println(targetFile.getAbsolutePath());
      if (!targetFile.exists()) {
        targetFile.createNewFile();
      }
      try (OutputStream outputStream = new FileOutputStream(targetFile)) {
        outputStream.write(buffer);
      }
      log.info("File converted and saved to - {}", filePath);
      return targetFile;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<String[]> csvToStringArray(@NotNull File csvFile, Boolean deleteFileFromDisk) {
    log.info("Start converting CSV file to rows list.");
    boolean isDeleted = Boolean.FALSE;
    try {
      CSVReader reader = new CSVReader(new FileReader(csvFile));
      List<String[]> rows = reader.readAll();
      if(deleteFileFromDisk) {
        reader.close();
        isDeleted = csvFile.delete();
      }
      log.info("CSV file converted to rows, input file deleted - {}", isDeleted);
      return rows;
        } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (CsvException e) {
      throw new RuntimeException(e);
    }
  }
}