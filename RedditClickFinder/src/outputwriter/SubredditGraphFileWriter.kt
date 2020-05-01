package outputwriter

import graphgenerator.Edge
import graphgenerator.SubredditNode
import org.json.simple.JSONArray
import org.json.simple.JSONObject

class SubredditGraphFileWriter {
    fun writeSubredditNodesToJson(nodes: List<SubredditNode>) : String {
        val jsonNodes = JSONArray()
        for (node in nodes) {
            // Get subreddit name
            val jsonNode = JSONObject()
            val subreddit = node.name
            val edges = JSONArray()
            for (edge in node.authorEdges.values) {
                val jsonEdge = generateJsonEdge(edge)
                edges.add(jsonEdge)
            }
            jsonNode.put("subreddit", subreddit)
            jsonNode.put("edges", edges)
            jsonNodes.add(jsonNode)
        }
        return jsonNodes.toJSONString()
    }

    private fun generateJsonEdge(edge: Edge): JSONObject {
        val jsonEdge = JSONObject()
        val src = edge.src
        val dest = edge.dest
        val weight = edge.weight

        jsonEdge.put("src", src)
        jsonEdge.put("dest", dest)
        jsonEdge.put("weight", weight)
        return jsonEdge
    }
}