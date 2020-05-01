package graphgenerator

/**
 * The Reddit Author Edge.
 *
 * An edge is an author who has commented in two subreddit vertices.
 * The weight of an edge tracks how many authors have commented in both subs.
 */
data class Edge(val src: String, val dest: String, val weight: Int)

fun Edge.invert() : Edge {
    return Edge(this.dest, this.src, weight)
}

fun Edge.addWeight(weight: Int = 1) : Edge {
    return Edge(this.dest, this.src, this.weight + weight)
}

data class SubredditNode(val name: String, val authorEdges: HashMap<String, Edge>)