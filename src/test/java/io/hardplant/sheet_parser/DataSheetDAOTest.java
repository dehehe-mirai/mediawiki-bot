package io.hardplant.sheet_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DataSheetDAOTest {
    
    @Test
    public void testMorningData() throws Exception {
        List<List<Object>> datas = new DataSheetDAO().getMorningDatas("마노_P");
        
        assertEquals(3, datas.get(0).size());
    }
    @Test
    public void testAuditionData() throws Exception {
        List<List<Object>> datas = new DataSheetDAO().getAuditionDatas("마노_P");
        
        assertEquals(2, datas.get(0).size());
    }
}