package graphgenerator

import parser.AuthorComment

/**
 * Make me a graph and I'll tell you once and for all that every poster to r/boston secretly loves r/nyc.
 */
object GraphGenerator {

    // TODO will replace with Charles' sexy BTREE
    private fun createAuthorMap(authorComments: List<AuthorComment>) : HashMap<String, MutableList<SubredditNode>> {
        val authorMap : HashMap<String, MutableList<SubredditNode>> = HashMap()

        authorComments.forEach {
            val newNode = SubredditNode(it.subreddit, hashMapOf())
            if (authorMap.containsKey(it.author)) {
                authorMap[it.author]!!.add(newNode)
            } else {
                authorMap[it.author] = mutableListOf(newNode)
            }
        }

        return authorMap
    }

    fun generate(authorComments: List<AuthorComment>): SubredditGraph {
        val authorMap = createAuthorMap(authorComments)
        val graph = SubredditGraph()

        authorMap.entries.forEach {
            val adjacentNodes = it.value
            for (i in (0 until adjacentNodes.size)) {
                for (k in (i + 1 until adjacentNodes.size)) {
                    val srcNode = adjacentNodes[i]
                    val destNode = adjacentNodes[k]
                    graph.addEdge(srcNode, destNode)
                }
            }
        }

        return graph
    }
}