package io.hardplant.uploader.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.hardplant.uploader.service.CsvUploaderService;

public class CsvController {
    
    @Autowired
    private CsvUploaderService csvUploaderService;

    @PostMapping(value = "upload.do")
    public String csvToWiki() {
        String id = "";
        String pwd = "";

        String csvContent = "";

        csvUploaderService.uploadWikiFromCsv(id, pwd, csvContent);

        return "";
    }
}