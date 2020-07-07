package io.hardplant.uploader.service.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.hardplant.cmmn.WikiEditor;
import io.hardplant.cmmn.impl.CommuRow;
import io.hardplant.cmmn.impl.CommuTable;
import io.hardplant.cmmn.impl.CommuTableTemplate;
import io.hardplant.uploader.service.CsvUploaderService;

@Service
public class CsvUploaderServiceImpl implements CsvUploaderService{

    private final String[] commuTableRow = new String[]{"id", "name", "text", "trans"};
    
    @Autowired
    private CsvDAO csvDao;

    @Override
    public boolean uploadWikiFromCsv(String id, String pwd, String csvPath) {
        WikiEditor wikiEditor = new WikiEditor(id, pwd);
        Path path = Paths.get(csvPath);

        CommuTable commuTable = new CommuTable();
        List<CommuRow> commuData = csvDao.readTableWithRowname(commuTableRow, csvPath);
        
        commuTable.setId(path.getFileName().toString());
        
        CommuTableTemplate template = new CommuTableTemplate();
        
        for (CommuRow row : commuData) {
            if (row.id == "info") {
                commuTable.setInfo(row.name);
            } else {
                template.addRow(row);
            }
        }

        wikiEditor.overwrite(csvPath, template.toContent(), "봇에 의한 자동 업로드");

        return true;
    }
}