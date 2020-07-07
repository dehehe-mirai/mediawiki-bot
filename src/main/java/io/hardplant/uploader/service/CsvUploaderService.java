package io.hardplant.uploader.service;

public interface CsvUploaderService {

	boolean uploadWikiFromCsv(String id, String pwd, String csvContent);
    
}