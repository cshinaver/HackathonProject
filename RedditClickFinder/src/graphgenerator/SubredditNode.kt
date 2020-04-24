package graphgenerator

data class Edge(val src: String, val dest: String, val weight: Int)

data class SubredditNode(val subreddit: String, val authorEdges: MutableList<Edge>)