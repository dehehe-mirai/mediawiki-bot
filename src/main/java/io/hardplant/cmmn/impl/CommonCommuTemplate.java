package io.hardplant.cmmn.impl;

import java.util.List;

import io.hardplant.cmmn.ITemplate;

public class CommonCommuTemplate implements ITemplate {

    public String idolName;

    public List<MorningSelectionTable> morningTables;

    public List<AuditionSelectionTable> auditionTables;

    @Override
    public String getTitle() {
        return idolName + "/공통 커뮤";
    }

    public String getMorningTableContent() {
        String content = "";
        for (MorningSelectionTable table : morningTables) {
            content += "{{틀:커뮤 아침 요약"
                    + String.format("\n | CommuName = [[%s/공통/Morning%s|Morning%s]]", idolName,
                            getMaruByNum(table.CommuName), getMaruByNum(table.CommuName))
                    + "\n | Intro_JP = " + table.IntroJP + "\n | Intro_KR = " + "\n | Choice1_JP = " + table.Choice1_JP
                    + "\n | Choice1_KR = " + table.Choice1_KR + "\n | Choice2_JP = " + table.Choice2_JP
                    + "\n | Choice2_KR = " + table.Choice2_KR + "\n | Choice3_JP = " + table.Choice3_JP
                    + "\n | Choice3_KR = " + table.Choice3_KR + "\n}}";
            content += "\n";
        }
        return content;
    }

    public String getAuditionTableContent() {
        String content = "";
        for (AuditionSelectionTable table : auditionTables) {
            content += "{{틀:커뮤 오디션 전 요약"
                    + String.format("\n | CommuName = [[%s/공통/W.I.N.G/オーディション前%s|오디션 전%s]]", idolName,
                            getMaruByNum(table.CommuName), getMaruByNum(table.CommuName))
                    + "\n | Intro_JP = " + "\n | Intro_KR = " + "\n | Choice1_JP = " + table.Choice1_JP
                    + "\n | Choice1_KR = " + table.Choice1_KR + "\n | Choice2_JP = " + table.Choice2_JP
                    + "\n | Choice2_KR = " + table.Choice2_KR + "\n | Choice3_JP = " + table.Choice3_JP
                    + "\n | Choice3_KR = " + table.Choice3_KR + "\n}}";
            content += "\n";
        }
        return content;
    }

    @Override
    public String toContent() {

        return "<div class='mw-collapsible mw-collapsed'>" 
                + "\n=== W.I.N.G. 공통 ==="
                + "\n<div class='mw-collapsible-content'>"
                + getWingAuditionAfter(0)
                + getWingAuditionAfter(1)
                + getWingAuditionAfter(2)
                + getWingSeason1Pass()
                + getWingSeason1Fail()
                + getWingSeason2Pass()
                + getWingSeason2Fail()
                + getWingSeason3Pass()
                + getWingSeason3Fail()
                + getWingSeason4Pass()
                + getWingSeason4Fail()
                + getWingSemiFinalBefore()
                + getWingSemiFinalPass()
                + getWingFinalBefore()
                + getWingFinalPass()
                + "\n</div></div>"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== 팬 감사제 공통 ===\n"
                + "\n<div class='mw-collapsible-content'>\n"
                + getFanRehersalBefore()
                + getFanRehersalAfter()
                + getFanFinaleBefore()
                + getFanFinaleAfter()
                + getFanFinaleMVP()
                + "\n</div></div>"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== G.R.A.D 공통 ===\n"
                + "\n<div class='mw-collapsible-content'>\n"
                + getGradQualifierBefore()
                + getGradQualifierWin()
                + getGradQualifierLose()
                + getGradRevive()
                + getGradDefeatOne()
                + getGradDefeatTwoBefore()
                + getGradDefeatTwoAfter()
                + "\n</div></div>"
                + "\n=== W.I.N.G. 선택지 ==="
                + "\n<div class='mw-collapsible-content'>" 
                + "\n</div></div>\n"
                + "\n=== 감사제 선택지 ==="
                + "\n<div class='mw-collapsible-content'>" 
                + "\n</div></div>\n"
                + "\n=== G.R.A.D. 선택지 ==="
                + "\n<div class='mw-collapsible-content'>" 
                + "\n</div></div>\n"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== 아침 이벤트 ===\n"
                + "\n<div class='mw-collapsible-content'>\n" 
                + getMorningTableContent()
                + "\n</div></div>"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== 오디션 전 ===\n"
                + "\n<div class='mw-collapsible-content'>\n"
                + getAuditionTableContent()
                + "\n</div></div>"
                + "\n";
    }

    private String getWingSeason1Pass() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン1（クリア）|シーズン1（クリア）]]", idolName)
        + "\n | CommuNameKR = 시즌 1 클리어"
        + "\n}}";
    }

    private String getWingSeason1Fail() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン1（失敗）|シーズン1（失敗）]]", idolName)
        + "\n | CommuNameKR = 시즌 1 실패"
        + "\n}}";
    }

    private String getWingSeason2Pass() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン2（クリア）|シーズン2（クリア）]]", idolName)
        + "\n | CommuNameKR = 시즌 2 클리어"
        + "\n}}";
    }

    private String getWingSeason2Fail() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン2（失敗）|シーズン2（失敗）]]", idolName)
        + "\n | CommuNameKR = 시즌 2 실패"
        + "\n}}";
    }

    private String getWingSeason3Pass() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン3（クリア）|シーズン3（クリア）]]", idolName)
        + "\n | CommuNameKR = 시즌 3 클리어"
        + "\n}}";
    }

    private String getWingSeason3Fail() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン3（失敗）|シーズン3（失敗）]]", idolName)
        + "\n | CommuNameKR = 시즌 3 실패"
        + "\n}}";
    }

    private String getWingSeason4Pass() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン4（クリア）|シーズン4（クリア）]]", idolName)
        + "\n | CommuNameKR = 시즌 4 클리어"
        + "\n}}";
    }

    private String getWingSeason4Fail() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/シーズン4（失敗）|シーズン4（失敗）]]", idolName)
        + "\n | CommuNameKR = 시즌 4 실패"
        + "\n}}";
    }

    private String getWingSemiFinalBefore() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/準決勝前コミュ|準決勝前コミュ]]", idolName)
        + "\n | CommuNameKR = 준결승 전"
        + "\n}}";
    }

    private String getWingSemiFinalPass() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/準決勝後コミュ|準決勝後コミュ]]", idolName)
        + "\n | CommuNameKR = 준결승 후"
        + "\n}}";
    }


    private String getWingFinalBefore() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/決勝前コミュ|決勝前コミュ]]", idolName)
        + "\n | CommuNameKR = 결승 전"
        + "\n}}";
    }

    private String getWingFinalPass() {
        return "\n{{틀:커뮤 요약 small"
        + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/決勝後コミュ|決勝後コミュ]]", idolName)
        + "\n | CommuNameKR = 결승 후"
        + "\n}}";
    }

    private String getWingAuditionAfter(int num) {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/W.I.N.G/オーディション後%s|オーディション後%s]]", idolName, getMaruByNum(num), getMaruByNum(num))
            + "\n | CommuNameKR = 오디션 후%s" + getMaruByNum(num)
            + "\n}}";
    }
    
    private String getFanRehersalBefore() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/감사제/リハーサル前|リハーサル前]]", idolName)
            + "\n | CommuNameKR = 리허설 전"
            + "\n}}";
    }

    private String getFanRehersalAfter() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/감사제/リハーサル後|リハーサル後]]", idolName)
            + "\n | CommuNameKR = 리허설 후"
            + "\n}}";
    }

    private String getFanFinaleBefore() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/감사제/感謝祭本番前|感謝祭本番前]]", idolName)
            + "\n | CommuNameKR = 본방 전"
            + "\n}}";
    }

    private String getFanFinaleAfter() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/감사제/感謝祭本番後（通常）|感謝祭本番後（通常）]]", idolName)
            + "\n | CommuNameKR = 본방 후 (통상)"
            + "\n}}";
    }

    private String getFanFinaleMVP() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/감사제/感謝祭本番後（MVP）|感謝祭本番後（MVP）]]", idolName)
            + "\n | CommuNameKR = 본방 후 (MVP)"
            + "\n}}";
    }

    
    private String getGradQualifierBefore() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/G.R.A.D/予選前コミュ|予選前コミュ]]", idolName)
            + "\n | CommuNameKR = 예선 전"
            + "\n}}";
    }

    private String getGradQualifierWin() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/G.R.A.D/予選後コミュ 勝利|予選後コミュ 勝利]]", idolName)
            + "\n | CommuNameKR = 예선 승리"
            + "\n}}";
    }

    private String getGradQualifierLose() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/G.R.A.D/予選後コミュ 敗北|予選後コミュ 敗北]]", idolName)
            + "\n | CommuNameKR = 예선 패배"
            + "\n}}";
    }

    private String getGradRevive() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/G.R.A.D/敗者復活前コミュ|敗者復活前コミュ]]", idolName)
            + "\n | CommuNameKR = 패자부활전"
            + "\n}}";
    }

    private String getGradDefeatOne() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/G.R.A.D/G.R.A.D.敗退コミュ%s|G.R.A.D.敗退コミュ%s]]", idolName, getMaruByNum(0), getMaruByNum(0))
            + "\n | CommuNameKR = 패배" + getMaruByNum(0)
            + "\n}}";
    }

    private String getGradDefeatTwoBefore() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/G.R.A.D/G.R.A.D.敗退コミュ%s前|G.R.A.D.敗退コミュ%s前]]", idolName, getMaruByNum(1), getMaruByNum(1))
            + "\n | CommuNameKR = 패배 전" + getMaruByNum(1)
            + "\n}}";
    }

    private String getGradDefeatTwoAfter() {
        return "\n{{틀:커뮤 요약 small"
            + String.format(" | CommuNameJP = [[%s/공통/G.R.A.D/G.R.A.D.敗退コミュ%s後|G.R.A.D.敗退コミュ%s後]]", idolName, getMaruByNum(1), getMaruByNum(1))
            + "\n | CommuNameKR = 패배 후" + getMaruByNum(1)
            + "\n}}";
    }

    /**
     * getMaruByNum returns Circle Number (①).
     * Warning : n returns (n+1). (ex: 0 returns (1))
     * @param num
     * @return String (Circle Number)
     */
    private String getMaruByNum(int num) {
        final String[] maru = { "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩", "⑪", "⑫", "⑬", "⑭", "⑮" };
        return maru[num];
    }
}