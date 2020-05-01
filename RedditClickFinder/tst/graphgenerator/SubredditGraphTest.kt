package graphgenerator

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

internal class SubredditGraphTest {

    private lateinit var graph : SubredditGraph

    @Before
    fun beforeEach() {
        graph = SubredditGraph()
    }

    @Test
    fun addEdgeTest() {
        val nodeA = SubredditNode("r/youtubeHaiku", hashMapOf())
        val nodeB = SubredditNode("r/videos", hashMapOf())
        graph.addEdge(nodeA, nodeB)

        assertEquals(graph.size, 1)
        assertEquals(graph.getNode("r/youtubeHaiku"), nodeA)
        assertEquals(graph.getNode("r/videos"), nodeB)
    }
}