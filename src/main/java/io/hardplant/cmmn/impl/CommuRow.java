package io.hardplant.cmmn.impl;


public class CommuRow {
    public String id;
    public String name;
    public String text;
    public String trans;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getText() {
        return this.text;
    }

    public String getTrans() {
        return this.trans;
    }

    public CommuRow(String id, String name, String text, String trans) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.trans = trans;
    }
    
}