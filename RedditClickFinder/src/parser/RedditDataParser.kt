package parser

import java.io.File

class RedditDataParser {
    private val SAMPLE_DATA_FILE = "sample_data.json"
    private val jsonParser = JsonParser()

    fun parseRedditSampleData(): List<AuthorComment> {
        val content = File(SAMPLE_DATA_FILE).readText()
        return parseStringIntoAuthorComments(content)
    }

    private fun parseStringIntoAuthorComments(content: String): List<AuthorComment> {
        return jsonParser.parseJsonIntoAuthorComments(content)
    }
}