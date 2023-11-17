package google;

public class lc685 {
    /**
     * Input: edges = [[1,2],[1,3],[2,3]]
     * Output: [2,3]
     * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that
     * represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.
     * @param edges
     * @return
     * Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes.
     * If there are multiple answers, return the answer that occurs last in the given 2D-array.
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
//        1) Check whether there is a node having two parents.
//                If so, store them as candidates A and B, and set the second edge invalid.
//        2) Perform normal union find.
//          If the tree is now valid
//              simply return candidate B
//          else if candidates not existing
//              we find a circle, return current edge;
//          else
//              remove candidate A instead of B.
        int[] can1 = {-1,-1};
        int[] can2 = {-1,-1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            }else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) continue;
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) ==child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }


    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
