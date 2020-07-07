package io.hardplant.cmmn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.hardplant.cmmn.impl.CommuTable;
import io.hardplant.cmmn.impl.CommuTableTemplate;
import io.hardplant.sheet_parser.SheetTableConverter;

public class CommuTableTemplateTest {

    @BeforeEach
    public void setup() {

    }

    @Test
    public void testCommuTableToTemplate() {
        CommuTableTemplate template = new CommuTableTemplate();
        List<CommuTable> tables = getTables();
        CommuTable table = tables.get(0);

        template.setTable(table);

        assertEquals("P\\SR-1\\ショッピング日和", template.title);
        
        String result = template.toContent();

        assertTrue(result.contains("커뮤대사"));
    }

    private List<CommuTable> getTables() {
        SheetTableConverter converter = new SheetTableConverter();

        List<List<Object>> datas = getMockData();

        return converter.sheetToTableDatas(datas);
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
