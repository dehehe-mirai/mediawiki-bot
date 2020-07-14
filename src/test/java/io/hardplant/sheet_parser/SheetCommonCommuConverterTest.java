package io.hardplant.sheet_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.hardplant.cmmn.impl.AuditionSelectionTable;
import io.hardplant.cmmn.impl.CommonCommuTemplate;
import io.hardplant.cmmn.impl.MorningSelectionTable;

public class SheetCommonCommuConverterTest {

    @Test
    public void testConvert() throws Exception {
        SheetCommonCommuConverter converter = new SheetCommonCommuConverter();

        List<List<Object>> datas = new DataSheetDAO().getMorningDatas("마노_P");
        
        List<MorningSelectionTable> tables = converter.sheetToMorningTables(datas);

        assertEquals(15, tables.size());
        for (MorningSelectionTable morningSelectionTable : tables) {
            assertNotNull(morningSelectionTable.getChoice1_JP());
            assertNotNull(morningSelectionTable.getChoice2_JP());
            assertNotNull(morningSelectionTable.getChoice3_JP());

            assertNotNull(morningSelectionTable.getChoice1_KR());
            assertNotNull(morningSelectionTable.getChoice2_KR());
            assertNotNull(morningSelectionTable.getChoice3_KR());
        }

        CommonCommuTemplate template = new CommonCommuTemplate();
        template.morningTables = tables;
        String content = template.getMorningTableContent();
        assertNotNull(content);
    }
    
    @Test
    public void testConvertAudition() throws Exception {
        SheetCommonCommuConverter converter = new SheetCommonCommuConverter();

        List<List<Object>> datas = new DataSheetDAO().getAuditionDatas("마노_P");
        
        List<AuditionSelectionTable> tables = converter.sheetToAuditionTables(datas);

        assertEquals(6, tables.size());
        for (AuditionSelectionTable table : tables) {
            assertNotNull(table.getChoice1_JP());
            assertNotNull(table.getChoice2_JP());
            assertNotNull(table.getChoice3_JP());

            assertNotNull(table.getChoice1_KR());
            assertNotNull(table.getChoice2_KR());
            assertNotNull(table.getChoice3_KR());
        }
        
        CommonCommuTemplate template = new CommonCommuTemplate();
        template.auditionTables = tables;
        String content = template.getAuditionTableContent();
        assertNotNull(content);
    }
}