package graphgenerator

/**
 * The mighty subreddit graph.
 *
 * Each node is a subreddit.
 * An edge is an author who has commented in both subreddit vertices.
 * The weight of an edge tracks how many authors have commented in both subs, given way to correlated subreddits.
 */
class SubredditGraph {

    private val graph : HashMap<String, SubredditNode> = hashMapOf()
    var size : Int = 0

    fun addEdge(srcNode: SubredditNode, destNode: SubredditNode) {
        if (srcNode.name == destNode.name) {
            return
        } else if (graph.containsKey(srcNode.name) && graph.containsKey(destNode.name)) {
            // Existing edge
            graph[srcNode.name]?.authorEdges?.get(destNode.name)?.addWeight()
            graph[destNode.name]?.authorEdges?.get(srcNode.name)?.addWeight()
        } else {
            // New Edge
            val newEdge = Edge(srcNode.name, destNode.name, 1)
            val newEdgeInverted = newEdge.invert()
            srcNode.authorEdges[newEdge.dest] = newEdge
            destNode.authorEdges[newEdgeInverted.dest] = newEdgeInverted
            graph[srcNode.name] = srcNode
            graph[destNode.name] = destNode
        }
        size++
    }

    fun getNode(subredditName: String): SubredditNode? {
        return graph[subredditName]
    }

    override fun toString(): String {
        return graph.toString()
    }
}