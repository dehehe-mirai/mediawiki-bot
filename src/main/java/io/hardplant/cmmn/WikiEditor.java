package io.hardplant.cmmn;

import org.fastily.jwiki.core.Wiki;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WikiEditor {
    public boolean isLoggedOn;
    private Wiki wiki;

    String id;
    String pwd;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public WikiEditor() {
        wiki = new Wiki.Builder().build();
    }
    
    public WikiEditor(Wiki wiki) {
        this.wiki = wiki;
    }

    public WikiEditor(String id, String pwd) {
        wiki = new Wiki.Builder().build();

        this.id = id;
        this.pwd = pwd;
    }

    public boolean logon(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;

        return this.logon();
    }

    public boolean logon() {
        if (!isLoggedOn) {
            
            isLoggedOn = wiki.login(id, pwd);
        }
        return isLoggedOn;
    }

    public boolean overwrite(String docTitle, String docText, String editSummary) {
        if (isLoggedOn) {
            return wiki.edit(docTitle, docText, editSummary);

        } else {
            logger.error("not logged on");
            return false;
        }
    }

    public boolean appendAfter(String docTitle, String docText, String editSummary) {
        if (isLoggedOn) {
            String content = wiki.getPageText(docTitle);
            wiki.edit(docTitle, content + docText, editSummary);
            return true;

        } else {
            logger.error("not logged on");
            return false;
        }
    }

	public boolean docExists(String title) {
		return wiki.exists(title);
	}

}