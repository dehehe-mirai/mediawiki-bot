# Mediawiki-csv-bot

위키 수정 봇

### Installation

```
git clone 
mvn package
java -jar target/mediawiki-csv-bot.jar
```

### Usage

* `application.properties` 파일에 위키 봇 계정 정보를 입력합니다.

* `Google Sheets API`를 활성한 뒤, `credentials.json` 파일을 `resources` 폴더에 넣습니다.

* 
`SyncServiceImpl`에서 템플릿을 수정한 뒤,  `SyncServiceImplTest`의 `Test_syncWikiWithSheet()`를 실행합니다.