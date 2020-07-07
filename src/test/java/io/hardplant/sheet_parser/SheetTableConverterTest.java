package io.hardplant.sheet_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.hardplant.cmmn.impl.CommuRow;
import io.hardplant.cmmn.impl.CommuTable;

public class SheetTableConverterTest {

    @Test
    public void testConvert() {
        SheetTableConverter converter = new SheetTableConverter();

        List<List<Object>> datas = getMockData();

        List<CommuTable> commutables = converter.sheetToTableDatas(datas);

        assertEquals(2, commutables.size());
        // Commu 1
        CommuTable table1 = commutables.get(0);
        assertEquals("P", table1.type);
        assertEquals("SR-1", table1.id);
        assertEquals("ショッピング日和", table1.name);
        assertEquals(2, table1.commus.size());
        assertEquals("", table1.translator);

        CommuRow table1Commu1 = table1.commus.get(0);

        assertEquals("select", table1Commu1.id);
        assertEquals("", table1Commu1.name);
        assertEquals("似合うと思うな", table1Commu1.text);
        assertEquals("어울린다고 생각해.", table1Commu1.trans);

        CommuRow table1Commu2 = table1.commus.get(1);

        assertEquals("0000000000000", table1Commu2.id);
        assertEquals("", table1Commu2.name);
        assertEquals("★選択肢①【似合うと思うな】", table1Commu2.text);
        assertEquals("★선택지①【어울린다고 생각해】", table1Commu2.trans);

        // Commu 2
    }

    private List<List<Object>> getMockData() {
        
        List<List<Object>> data = new ArrayList<>();
        
        for (int i = 0; i < 15; i++) {
            data.add(new ArrayList<>());
        }

        data.get(0).add("#FILENAME: P\\SR-1\\ショッピング日和.csv");

        data.get(1).add("");
        data.get(1).add("id");
        data.get(1).add("name");
        data.get(1).add("text");
        data.get(1).add("trans");

        data.get(2).add("");
        data.get(2).add("select");
        data.get(2).add("");
        data.get(2).add("似合うと思うな");
        data.get(2).add("어울린다고 생각해.");

        data.get(3).add("");
        data.get(3).add("0000000000000");
        data.get(3).add("");
        data.get(3).add("★選択肢①【似合うと思うな】");
        data.get(3).add("★선택지①【어울린다고 생각해】");

        data.get(4).add("");
        data.get(4).add("info");
        data.get(4).add("produce_events/200100301.json");
        
        data.get(5).add("译者");

        data.get(6).add("#EOF");
        
        data.get(7).add("#FILENAME: P\\SR-1\\ショッピング日和.csv");

        data.get(8).add("");
        data.get(8).add("id");
        data.get(8).add("name");
        data.get(8).add("text");
        data.get(8).add("trans");

        data.get(9).add("");
        data.get(9).add("select");
        data.get(9).add("");
        data.get(9).add("似合うと思うな");
        data.get(9).add("어울린다고 생각해.");

        data.get(10).add("");
        data.get(10).add("0000000000000");
        data.get(10).add("");
        data.get(10).add("★選択肢①【似合うと思うな】");
        data.get(10).add("★선택지①【어울린다고 생각해】");

        data.get(11).add("");
        data.get(11).add("info");
        data.get(11).add("produce_events/200100301.json");

        data.get(12).add("译者");

        data.get(13).add("#EOF");
        
        return data;
    }

}
    
