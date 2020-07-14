package io.hardplant.cmmn.impl;

import io.hardplant.cmmn.ITemplate;

public class CommuTableTemplate implements ITemplate {
    
    public String title;
    public int rowNum = 0;

    private StringBuilder template = new StringBuilder();
    private CommuTable table;

    public CommuTableTemplate() {
        template.append("{{커뮤테이블");
    }

    public CommuTableTemplate setTable(CommuTable table) {
        this.table = table;

        this.setTitle();

        if (table.commus == null)
            return this;

        if (table.info != null) {
            template.append("|info = " + table.info);
        }

        if (table.translator != null) {
            template.append("|translator = " + table.translator + "|text =");
        }

        for (CommuRow row : table.commus) {
            this.addRow(row);
        }

        return this;
    }

    public String toContent() {
        template.append("\n}}\n\n\n{{출처 한패시트|origin=https://docs.google.com/spreadsheets/d/12NpZ_Tq0OMAePUn-Wuu9lH0202L5f9nvJc1pEI5CM8M}}");
        return template.toString();
    }

	public String getTitle() {
		return this.title;
    }
    
    private CommuTableTemplate setTitle() {
        if (table != null) {
            this.title = table.rawName;
        }

        return this;
    }

    public CommuTableTemplate addRow(CommuRow row) {
        addRow(row.id, row.name, row.text, row.trans);

        return this;
    }

    public CommuTableTemplate addRow(String id, String character, String text, String trans) {
        template.append("\n {{커뮤대사|id=").append(id)
                .append("|name={{커뮤아이콘|").append(character)
                .append("}}|text=").append(text.replace("\\", ""))
                .append("|trans=").append(trans.replace("\\", ""))
                .append("|anchor=").append(rowNum++)
                .append("|")
                .append("}}");

        return this;
    }
}