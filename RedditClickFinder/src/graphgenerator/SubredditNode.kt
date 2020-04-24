package graphgenerator

data class Edge(val src: SubredditNode, val dest: SubredditNode, val weight: Int)

data class SubredditNode(val subreddit: String, val authorEdges: MutableList<Edge>)