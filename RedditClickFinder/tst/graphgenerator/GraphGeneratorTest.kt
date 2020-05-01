package graphgenerator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import parser.AuthorComment

internal class GraphGeneratorTest {

    @Test
    fun generateTest() {
        val authorHans = "Hans"
        val authorKurt = "Kurt"
        val subredditPics = "r/pics"
        val subredditAww = "r/aww"

        val authorComments = listOf(
                AuthorComment(authorHans, subredditPics, "Wow!"),
                AuthorComment(authorHans, subredditAww, "Wow!"),
                AuthorComment(authorKurt, subredditAww, "$authorHans this ain't Rocket League!")
        )

        val graph = GraphGenerator.generate(authorComments)

        assertEquals(graph.getNode(subredditAww)!!.authorEdges.size, 1)
        println(graph)
    }
}