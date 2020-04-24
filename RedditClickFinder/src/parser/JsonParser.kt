package parser

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser

class JsonParser {
    private val parser = JSONParser()

    fun parseJsonIntoAuthorComments(jsonString: String) : List<AuthorComment> {
        // split into lines
        val commentLines = jsonString.split("\n")

        return commentLines
                .filter { it.isNotEmpty() }
                .map { parser.parse(it) as JSONObject }
                .map { AuthorComment(it["author"] as String, it["subreddit"] as String, it["body"] as String) }
    }
}