package io.hardplant.cmmn.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitUtills {

    public final static List<String> idolListKR = Arrays.asList("사쿠라기 마노", "카자노 히오리", "하치미야 메구루",

            "츠키오카 코가네", "유코쿠 키리코", "시라세 사쿠야", "타나카 마미미",  "미츠미네 유이카", 

            "코미야 카호", "모리노 린제", "소노다 치요코", "아리스가와 나츠하", "사이죠 쥬리",

            "오사키 아마나", "오사키 텐카", "쿠와야마 치유키",

            "세리자와 아사히", "마유즈미 후유코", "이즈미 메이",

            "아사쿠라 토오루", "히구치 마도카", "후쿠마루 코이토", "이치카와 히나나");

    public final static List<String> idolListKRShort = Arrays.asList("마노", "히오리", "메구루",

            "코가네", "키리코",  "사쿠야", "마미미", "유이카", 

            "카호",  "린제", "치요코", "나츠하", "쥬리", 

            "아마나", "텐카", "치유키",

            "아사히", "후유코", "메이",

            "토오루", "마도카", "코이토", "히나나");
    public final static List<String> idolListJP = Arrays.asList("櫻木真乃", "風野灯織", "八宮めぐる",

            "月岡恋鐘", "幽谷霧子", "白瀬咲耶", "田中摩美々", "三峰結華",

            "小宮果穂", "杜野凛世", "園田智代子", "有栖川夏葉", "西城樹里",

            "大崎甘奈", "大崎甜花", "桑山千雪",

            "芹沢あさひ", "黛冬優子", "和泉愛依",

            "浅倉透", "樋口円香", "福丸小糸", "市川雛菜");
    public final static List<String> idolListJPShort = Arrays.asList("真乃", "灯織", "めぐる",

            "恋鐘", "霧子", "咲耶", "摩美々", "結華",

            "果穂", "凛世", "智代子", "夏葉", "樹里",

            "甘奈", "甜花", "千雪",

            "あさひ", "優子", "愛依",

            "透", "円香", "小糸", "雛菜");
    public final static List<String> idolListEN = Arrays.asList("Mano", "Hiori", "Meguru",

            "Kogane", "Kiriko", "Sakyua", "Mamimi", "Yuika",

            "Kaho", "Rinze", "Chiyoko", "Natsuha", "Juri",

            "Amana", "Tenka", "Chiyuki",

            "Asahi", "Fuyuko", "Mei",

            "Toru", "Madoka", "Koito", "Hinana");

    public static String getUnitByJPName(String nameJP) {
        final String[] unitName = { "illumi", "antica", "afterschool", "alstromeria", "straylight", "noctchill" };

        int idx = idolListJP.indexOf(nameJP);

        if (idx < 3)
            return unitName[0]; // illumi
        if (idx < 8)
            return unitName[1]; // antica
        if (idx < 13)
            return unitName[2]; // afterschool
        if (idx < 16)
            return unitName[3]; // alsme
        if (idx < 19)
            return unitName[4]; // stray
        if (idx < 23)
            return unitName[5]; // notchill

        return "";
    }

    public static String getJPNameByKRName(String nameKR) {
        int idx = idolListKR.indexOf(nameKR);

        return idolListJP.get(idx);
    }

    public static String getENNameByKRName(String nameKR) {
        int idx = idolListKR.indexOf(nameKR);

        return idolListEN.get(idx);
    }

    public static String getKRNameShort(String nameKR) {
        int idx = idolListKR.indexOf(nameKR);

        return idolListKRShort.get(idx);
    }

    public static String getJPNameShort(String idolNameJP) {
        int idx = idolListJP.indexOf(idolNameJP);

        return idolListJPShort.get(idx);
    }
}