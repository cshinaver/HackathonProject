package parser

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class RedditDataParserTest {
    private val redditDataParser = RedditDataParser()

    @Test
    fun testSampleDataGetsParsed() {
        val authorComments = redditDataParser.parseRedditSampleData()
        assertEquals(10000, authorComments.size)
    }
}