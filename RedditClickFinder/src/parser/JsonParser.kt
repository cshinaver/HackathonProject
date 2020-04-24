package parser

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser

class JsonParser {
    fun parseJsonIntoAuthorComments(jsonString: String) : List<AuthorComment> {
        // split into lines
        val commentLines = jsonString.split("\n")

        // parse each line
        val authorComments: MutableList<AuthorComment> = mutableListOf()
        val parser = JSONParser()
        for (line in commentLines) {
            if (line.isEmpty()) continue
            val jsonObject: JSONObject = parser.parse(line) as JSONObject
            val authorComment = AuthorComment(jsonObject["author"] as String, jsonObject["subreddit"] as String, jsonObject["body"] as String)
            authorComments.add(authorComment)
        }
        return authorComments
    }
}