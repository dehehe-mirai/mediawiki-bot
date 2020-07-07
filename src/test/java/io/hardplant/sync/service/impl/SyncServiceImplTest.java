package io.hardplant.sync.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.hardplant.cmmn.impl.CommuTable;
import io.hardplant.cmmn.impl.CommuTableTemplate;
import io.hardplant.sheet_parser.SheetTableConverter;
import io.hardplant.sync.service.SyncService;

@SpringBootTest
@ContextConfiguration(classes = { TestConfig.class })
public class SyncServiceImplTest {

    @Resource
    private SyncService syncService;

    @Value("${wiki.id}")
    private String id;

    @Value("${wiki.pwd}")
    private String pwd;

    @Test
    public void Test_getTemplateFromSheet() {
        assertNotNull(syncService);

        List<CommuTableTemplate> templates = syncService.getTemplateFromSheet("사쿠라기 마노");
        
        assertNotNull(templates);
    }


    @Test
    public void Test_uploadWikiFromTemplateData() {
        List<CommuTableTemplate> templates = getTestTemplates();

        assertEquals("P\\SR-1\\ショッピング日和", templates.get(0).title);

        assertTrue(syncService.logonWiki("Hardplant2", "1q2w3e4r"));
        
        syncService.syncWikiFromTemplates("", templates);
    }
    
    @Test
    public void Test_syncWikiWithSheet() {
        assertEquals("", "\\".replace("\\", ""));
        assertTrue(syncService.logonWiki(id, pwd));
        String[] names = new String[]{
            "사쿠라기 마노", "하치미야 메구루", "카자노 히오리",
            "츠키오카 코가네", "미츠미네 유이카", "시라세 사쿠야", "유코쿠 키리코", "타나카 마미미",
            "코미야 카호", "아리스가와 나츠하", "소노다 치요코", "모리노 린제", "사이죠 쥬리",
            "오사키 아마나", "오사키 텐카", "쿠와야마 치유카",
            "세리자와 아사히", "마유즈미 후유코", "이즈미 메이",
            "아사쿠라 토오루", "히구치 마도카", "이치카와 히나나", "후쿠마루 코이토"
        };
        
        for(String name : names) {
            syncService.syncWikiWithSheet(name);
        }
    }

    private List<CommuTableTemplate> getTestTemplates() {
        // Ready template
        List<CommuTableTemplate> templates= new ArrayList();
        List<CommuTable> tables = getTables();

        for (CommuTable table : tables) {
            CommuTableTemplate template = new CommuTableTemplate();
            template.setTable(table);

            templates.add(template);
        }
        return templates;
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
    