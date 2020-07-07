package io.hardplant.uploader.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.hardplant.cmmn.impl.CommuRow;

public class CsvDAOTest {
    private String testPath;

    private final String[] commuTableRow = new String[] { "id", "name", "text", "trans" };

    @BeforeEach
    public void setup() {
        String path = "src/test/resources/";
 
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        testPath = absolutePath + "/mano/P/SR-1/sample.csv";
    }

    @Test
    public void testCsvDaoReads() throws Exception {
        CsvDAO CsvDAO = new CsvDAO();

        List<CommuRow> rows = CsvDAO.readTableWithRowname(commuTableRow, testPath);
        
        assertEquals("123213", rows.get(1).getId());
        assertEquals("aaaa", rows.get(1).getName());
        assertEquals("bbbb", rows.get(1).getText());
        assertEquals("cccc", rows.get(1).getTrans());
    }
}
    