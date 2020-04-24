package parser

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class JsonParserTest {
    val testJsonString = "{ \"author\": \"joe\", \"body\": \"message\", \"subreddit\": \"sub1\", \"randomOtherData\": \"bleh\" }\n{ \"author\": \"schmoe\", \"body\": \"message\", \"subreddit\": \"sub2\", \"randomOtherData\": \"bleh\" }\n"
    val jsonParser = JsonParser()

    @Test
    fun testJsonParserCreatesAuthorCommentObjects() {
        val authorComments = jsonParser.parseJsonIntoAuthorComments(testJsonString)
        assertEquals(2, authorComments.size)
        assertEquals("joe", authorComments[0].author)
        assertEquals("sub1", authorComments[0].subreddit)

    }
}