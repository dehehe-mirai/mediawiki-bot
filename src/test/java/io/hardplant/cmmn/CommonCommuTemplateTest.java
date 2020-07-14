package io.hardplant.cmmn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.hardplant.cmmn.impl.AuditionSelectionTable;
import io.hardplant.cmmn.impl.CommonCommuTemplate;
import io.hardplant.cmmn.impl.MorningSelectionTable;
import io.hardplant.cmmn.impl.UnitUtills;
import io.hardplant.sheet_parser.DataSheetDAO;
import io.hardplant.sheet_parser.SheetCommonCommuConverter;

public class CommonCommuTemplateTest {
    @Test
    public void testTemplate() throws Exception {
        
        SheetCommonCommuConverter converter = new SheetCommonCommuConverter();
        DataSheetDAO dao = new DataSheetDAO();
        
        CommonCommuTemplate template = new CommonCommuTemplate();
        template.idolName = "사쿠라기 마노";
        
        List<List<Object>> data1 = dao.getMorningDatas(UnitUtills.getKRNameShort(template.idolName) + "_P");
        
        template.morningTables = converter.sheetToMorningTables(data1);

        List<List<Object>> data2 = dao.getAuditionDatas(UnitUtills.getKRNameShort(template.idolName) + "_P");
        
        template.auditionTables = converter.sheetToAuditionTables(data2);
        
        String result = template.toContent();
        
        assertNotNull(result);
    }
}