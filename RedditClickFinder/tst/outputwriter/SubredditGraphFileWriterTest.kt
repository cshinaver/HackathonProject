package outputwriter

import graphgenerator.Edge
import graphgenerator.SubredditNode
import org.json.simple.JSONObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import parser.JsonParser

internal class SubredditGraphFileWriterTest {
    val subredditGraphFileWriter = SubredditGraphFileWriter()
    val jsonParser = JsonParser()

    @Test
    fun testGraphGetsWrittenToString() {
        val subredditNode = SubredditNode("eww", hashMapOf(
                Pair("eww", Edge("eww", "nasty", 1)),
                Pair("nasty", Edge("nasty", "eww", 1))
        ))
        val serializedNode = subredditGraphFileWriter.writeSubredditNodesToJson(listOf(subredditNode))
        val jsonNode = jsonParser.parseStringIntoJsonArray(serializedNode)
        val firstEntry: JSONObject = jsonNode[0] as JSONObject
        assertEquals("eww", firstEntry["subreddit"])
    }
}