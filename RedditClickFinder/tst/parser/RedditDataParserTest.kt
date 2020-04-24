package parser

import org.junit.jupiter.api.Test

internal class RedditDataParserTest {
    private val redditDataParser = RedditDataParser()

    @Test
    fun testSampleDataGetsParsed() {
        val authorComments = redditDataParser.parseRedditSampleData()
        println(authorComments.size)
    }
}