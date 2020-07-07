package io.hardplant.cmmn;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.fastily.jwiki.core.Wiki;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.hardplant.sync.service.impl.TestConfig;
import okhttp3.HttpUrl;

@SpringBootTest
@ContextConfiguration(classes = { TestConfig.class })
public class WikiEditorTest {

    @Value("${wiki.endpoint}")
    private String endpoint;
    
    @Value("${wiki.id}")
    private String id;

    @Value("${wiki.pwd}")
    private String pwd;

    @Test
    public void testOverwriteFails() {
        WikiEditor editor = new WikiEditor(new Wiki.Builder().withDomain("publictestwiki.com").build());

        // Not Logged On
        assertFalse(editor.overwrite("bottest", "test", "봇 자동 업로드"), "로그인 없이 업로드됨");
    }
    
    @Test
    public void testOverwriteWithLogon() {
        WikiEditor editor = new WikiEditor(new Wiki.Builder().withApiEndpoint(HttpUrl.parse(endpoint)).build());
        editor.logon(id, pwd);
        assertTrue(editor.overwrite("bottest", "test", "봇 자동 업로드"), "로그인 실패");
    }

}
