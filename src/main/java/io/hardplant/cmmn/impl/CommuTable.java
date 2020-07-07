package io.hardplant.cmmn.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * type: P or S id: Unique ID or "select" name: name of commu
 */
public class CommuTable {
    private static final Logger logger = LoggerFactory.getLogger(CommuTable.class);

    public String type;
    public String id;
    public String rawName;
    public String name;
    public String info;
    public String translator;
    
    public List<CommuRow> commus = new ArrayList<>();

    public List<CommuRow> getCommus() {
        return this.commus;
    }

    public void fileheaderToInfo(String nameString) {
        if (!nameString.startsWith("#FILENAME")) {
            logger.error("Invalid arugment:", nameString);
        }
        String[] names = nameString.split(":");
        rawName = names[1].trim();
        rawName = rawName.substring(0, rawName.length() - 4);

        // String[] args = names[1].split("\\\\");

        // type = args[0].trim();
        // id = args[1];
        // // prune ".csv"
        // name = args[2].substring(0, args[2].length() - 4);
    }

    public void setCommus(List<CommuRow> commus) {
        this.commus = commus;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTranslator() {
        return this.translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public CommuTable() {
    }
}