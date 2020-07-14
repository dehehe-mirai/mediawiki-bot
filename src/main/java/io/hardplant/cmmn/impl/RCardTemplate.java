package io.hardplant.cmmn.impl;

import io.hardplant.cmmn.ITemplate;

public class RCardTemplate implements ITemplate{
    boolean is_PCard = true;

    String titleJP;
    String titleKR;
    // ex: Mano
    String idolNameEN;
    // ex: 櫻木真乃
    String idolNameJP;
    // ex: 사쿠라기 마노
    String idolNameKR;

    @Override
    public String getTitle() {
        return String.format("【%s】%s", titleJP, idolNameJP);
    }

    @Override
    public String toContent() {

        return introduce()
            + "\n"+ produceCommu()
            + "\n"+ skillPanel()
            + "\n"+ memoryAppeal()
            + "\n"+ seeAlso();
    }
    public String introduce() {
        String introduce = "{{틀:프로듀스 카드 개요"
            + "\n| Rarity = R"
            + String.format("\n| Unit = %s", UnitUtills.getUnitByJPName(idolNameJP))
            + String.format("\n| Name_JP = 【%s】%s", titleJP, idolNameJP)
            + String.format("\n| Name_KR = 【%s】%s", titleJP, idolNameKR)
            + String.format("\n| Image_name =【%s】%s", titleJP, idolNameJP)
            + "\n| Vo = 50"
            + "\n| Da = 50"
            + "\n| Vi = 50"
            + "\n| Me = 50"
            + "\n| 입수 방법 = 통상 뽑기"
            + "\n| 최초 등장 가챠 = 통상 뽑기"
            + "\n| 가챠 기간 = 2018/04/24"
            + "\n}}"
            + "\n";
        if (is_PCard) {
            introduce += "{{틀:프로듀스 카드 개요"
            + "\n| Rarity = SR"
            + String.format("\n| Unit = %s", UnitUtills.getUnitByJPName(idolNameJP))
            + String.format("\n| Name_JP = 【%s】%s", titleJP, idolNameJP)
            + String.format("\n| Name_KR = 【%s】%s", titleKR, idolNameKR)
            + String.format("\n| Image_name =【%s】%s_SR", titleJP, idolNameJP)
            + "\n| Vo = 50"
            + "\n| Da = 50"
            + "\n| Vi = 50"
            + "\n| Me = 50"
            + "\n| 입수 방법 = 아이돌로드 미션 보상"
            + "\n| 최초 등장 가챠 = -"
            + "\n| 가챠 기간 = -"
            + "\n}}"
            + "\n";

            introduce += "{{틀:프로듀스 카드 개요"
            + "\n| Rarity = SSR"
            + String.format("\n| Unit = %s", UnitUtills.getUnitByJPName(idolNameJP))
            + String.format("\n| Name_JP = 【%s】%s", "アイドルロード", idolNameJP)
            + String.format("\n| Name_KR = 【%s】%s", "아이돌로드", idolNameKR)
            + String.format("\n| Image_name =【%s】%s","アイドルロード", idolNameJP)
            + "\n| Vo = 50"
            + "\n| Da = 50"
            + "\n| Vi = 50"
            + "\n| Me = 50"
            + "\n| 입수 방법 = 아이돌로드 미션 보상"
            + "\n| 최초 등장 가챠 = -"
            + "\n| 가챠 기간 = -"
            + "\n}}"
            + "\n";
        }
        return introduce;
    }

    public String produceCommu() {
        return "== 프로듀스 =="
        + String.format("\n\n{{공통 커뮤/%s}}", idolNameKR); 
    }

    private String skillPanel() {
        String panel = "== 스킬 패널 ==";
        panel += String.format("\n=== R%s===", getTitle())
        + "\n{{틀:스킬 패널"
        + "\n| skill_20_1 = {{Vo}} 7% UP"
        + "\n| color_20_1 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_20_1 = [조건:4턴 이전]<br />[확률:20%]<br />[최대:1회]"
        + "\n| skill_30_1 = {{Vi}} 7% UP"
        + "\n| color_30_1 = {{Color_Dictionary | Vi_Background1}}"
        + "\n| effect_30_1 = [조건:스타 10 이상]<br />[확률:30%]<br />[최대:1회]"
        + "\n| skill_30_2 = {{Vo}} 3% UP"
        + "\n| color_30_2 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_30_2 = {{Vo}} & {{Vi}} 2배 어필/<br />(Link) {{Da}} & {{Vi}} 50% UP[4턴]"
        + "\n| skill_40_1 = {{Da}} & {{Vi}} 40% UP / 주목도 40% UP(☆2)"
        + "\n| color_40_1 = {{Color_Dictionary | Gray_Background1}}"
        + "\n| effect_40_1 = [조건: 3턴 이전]<br />[확률:40%]<br />[最大:1회]"
        + "\n| skill_40_2 = {{Vo}} 7% UP"
        + "\n| color_40_2 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_40_2 = [조건: 3위]<br />[확률:40%]<br />[最大:1회]"
        + "\n| skill_40_3 = {{Da}} 21% UP(☆1)"
        + "\n| color_40_3 = {{Color_Dictionary | Da_Background1}}"
        + "\n| effect_40_3 = [조건: Me 74% 이하]<br />[확률:40%]<br />[最大:1회]"
        + "\n}}"
        + "\n";

        panel += String.format("=== SR%s===", getTitle())
        + "\n{{틀:스킬 패널"
        + "\n| skill_20_1 = {{Vo}} 7% UP"
        + "\n| color_20_1 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_20_1 = [조건:4턴 이전]<br />[확률:20%]<br />[최대:1회]"
        + "\n| skill_30_1 = {{Vi}} 7% UP"
        + "\n| color_30_1 = {{Color_Dictionary | Vi_Background1}}"
        + "\n| effect_30_1 = [조건:스타 10 이상]<br />[확률:30%]<br />[최대:1회]"
        + "\n| skill_30_2 = {{Vo}} 3% UP"
        + "\n| color_30_2 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_30_2 = {{Vo}} & {{Vi}} 2배 어필/<br />(Link) {{Da}} & {{Vi}} 50% UP[4턴]"
        + "\n| skill_40_1 = {{Da}} & {{Vi}} 40% UP / 주목도 40% UP(☆2)"
        + "\n| color_40_1 = {{Color_Dictionary | Gray_Background1}}"
        + "\n| effect_40_1 = [조건: 3턴 이전]<br />[확률:40%]<br />[最大:1회]"
        + "\n| skill_40_2 = {{Vo}} 7% UP"
        + "\n| color_40_2 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_40_2 = [조건: 3위]<br />[확률:40%]<br />[最大:1회]"
        + "\n| skill_40_3 = {{Da}} 21% UP(☆1)"
        + "\n| color_40_3 = {{Color_Dictionary | Da_Background1}}"
        + "\n| effect_40_3 = [조건: Me 74% 이하]<br />[확률:40%]<br />[最大:1회]"
        + "\n}}"
        + "\n";

        panel += String.format("=== SSR【%s】%s===", "アイドルロード", idolNameJP)
        + "\n{{틀:스킬 패널"
        + "\n| skill_20_1 = {{Vo}} 7% UP"
        + "\n| color_20_1 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_20_1 = [조건:4턴 이전]<br />[확률:20%]<br />[최대:1회]"
        + "\n"
        + "\n| skill_30_1 = {{Vi}} 7% UP"
        + "\n| color_30_1 = {{Color_Dictionary | Vi_Background1}}"
        + "\n| effect_30_1 = [조건:스타 10 이상]<br />[확률:30%]<br />[최대:1회]"
        + "\n| skill_30_2 = {{Vo}} 3% UP"
        + "\n| color_30_2 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_30_2 = {{Vo}} & {{Vi}} 2배 어필/<br />(Link) {{Da}} & {{Vi}} 50% UP[4턴]"
        + "\n"
        + "\n| skill_40_1 = {{Da}} & {{Vi}} 40% UP / 주목도 40% UP(☆2)"
        + "\n| color_40_1 = {{Color_Dictionary | Gray_Background1}}"
        + "\n| effect_40_1 = [조건: 3턴 이전]<br />[확률:40%]<br />[最大:1회]"
        + "\n| skill_40_2 = {{Vo}} 7% UP"
        + "\n| color_40_2 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_40_2 = [조건: 3위]<br />[확률:40%]<br />[最大:1회]"
        + "\n| skill_40_3 = {{Da}} 21% UP(☆1)"
        + "\n| color_40_3 = {{Color_Dictionary | Da_Background1}}"
        + "\n| effect_40_3 = [조건: Me 74% 이하]<br />[확률:40%]<br />[最大:1회]"
        + "\n"
        + String.format("\n| skill_50_1 = %sアピール++++ (☆4)", UnitUtills.getJPNameShort(idolNameJP))
        + "\n| color_50_1 = {{Color_Dictionary | Vi_Background1}}"
        + "\n| effect_50_1 = {{Vi}} 3.5배 어필<br />(Link){{Vi}} 1.5배 어필"
        + "\n"
        + "\n| skill_50_2 = {{Vi}} 상한 UP (☆3)"
        + "\n| color_50_2 = {{Color_Dictionary | Vi_Background1}}"
        + "\n| effect_50_2 = {{Vi}} 상한 +75"
        + "\n"
        + "\n| skill_50_3 = {{Vi}} 15% UP (☆1)"
        + "\n| color_50_3 = {{Color_Dictionary | Vi_Background1}}"
        + "\n| effect_50_3 = [조건:스타 4 이하]<br />[확률:30%]<br />[최대:1회]"
        + "\n"
        + "\n| skill_50_4 = {{Vi}} 45% UP (☆2)"
        + "\n| color_50_4 = {{Color_Dictionary | Vi_Background1}}"
        + String.format("\n| effect_50_4 = [조건:%s]<br />[확률:30%%]<br />[최대:1회]", UnitUtills.getKRNameShort(idolNameKR))
        + "\n}}"
        + "\n";
        return panel;
    }
    
    private String memoryAppeal() {
        return "== 추억 어필 =="
           + String.format("\n=== R%s ===", getTitle())
           + "\n{{틀:추억 어필 R"
           + "\n | Name1 = 色とりどりの羽根"
           + "\n | Name3 = [輝く]色とりどりの羽根"
           + "\n | Link1 = 전관객에게 {{Vo}} 1.0배 어필"
           + "\n | Link3 = 전관객에게 {{Vo}} 1.5배 어필"
           + "\n}}"
           + "\n"
           + String.format("=== SR%s ===", getTitle())
           + "{{틀:추억 어필"
           + "\n | Name1 = 色とりどりの羽根"
           + "\n | Name5 = [輝く]色とりどりの羽根"
           + "\n | Link1 = 전관객에게 {{Vo}} 1.0배 어필"
           + "\n | Link3 = 전관객에게 {{Vo}} 1.5배 어필"
           + "\n}}"
           + "\n"
           + String.format("=== SSR【%s】%s ===", "アイドルロード", idolNameJP)
           + "{{틀:추억 어필"
           + "\n | Name1 = 色とりどりの羽根"
           + "\n | Name5 = [輝く]色とりどりの羽根"
           + "\n | Effect3 = {{Vi}} 0.2배 어필"
           + "\n | Effect4 = {{Vi}} 0.5배 어필"
           + "\n | Effect5 = {{Vi}} 1배 어필"
           + "\n | Link1 = 전관객에게 {{Vo}} 1.0배 어필"
           + "\n | Link3 = 전관객에게 {{Vo}} 1.5배 어필"
           + "\n}}";
    }

    public String seeAlso() {
        return "== 같이 보기 =="
        + String.format("\nhttps://wikiwiki.jp/shinycolors/【%s】%s", titleJP, idolNameJP)
        + "\n{{#set:"
        + "\n| 카드 종류 = P"
        + String.format("\n| 이름 = %s", titleJP)
        + "\n| 레어도 = R"
        + String.format("\n| 카드명 = 【%s】)", titleJP, idolNameJP)
        + String.format("\n| 아이콘 = [[File:Icon %s P R 01.png]]", idolNameEN)
        + "\n}}"
        + "\n[[Category:카드 | P]]";
    }

    public String getTitleJP() {
        return titleJP;
    }

    public void setTitleJP(String titleJP) {
        this.titleJP = titleJP;
    }

    public String getTitleKR() {
        return titleKR;
    }

    public void setTitleKR(String titleKR) {
        this.titleKR = titleKR;
    }

    public String getIdolNameEN() {
        return idolNameEN;
    }

    public void setIdolNameEN(String idolNameEN) {
        this.idolNameEN = idolNameEN;
    }

    public String getIdolNameJP() {
        return idolNameJP;
    }

    public void setIdolNameJP(String idolNameJP) {
        this.idolNameJP = idolNameJP;
    }

    public String getIdolNameKR() {
        return idolNameKR;
    }

    public void setIdolNameKR(String idolNameKR) {
        this.idolNameKR = idolNameKR;
    }

    public RCardTemplate(String titleJP, String titleKR, String idolNameEN, String idolNameJP, String idolNameKR) {
        this.titleJP = titleJP;
        this.titleKR = titleKR;
        this.idolNameEN = idolNameEN;
        this.idolNameJP = idolNameJP;
        this.idolNameKR = idolNameKR;
    }
}