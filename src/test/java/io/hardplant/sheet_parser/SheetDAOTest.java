package io.hardplant.sheet_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SheetDAOTest {

    @BeforeEach
    public void setup() {

    }

    @Test
    public void test() throws Exception {
        List<List<Object>> datas = new SheetDAO().getDatas("사쿠라기 마노");

        // #FILENAME:
        assertEquals(1, datas.get(0).size());
        
        // headers (id, name, text, trans):
        assertEquals(5, datas.get(1).size());
    }
}
    