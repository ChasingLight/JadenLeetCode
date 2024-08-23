package leetbook.graph;

/**
 * @author jinhaodong
 * @date 2024/8/21 18:03
 */
import java.util.*;

public class GraphDFS {
    private final Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    // 添加边
    public void addEdge(int u, int v) {
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    // 深度优先遍历
    public List<Integer> depthFirstSearch() {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        // 遍历所有节点，以确保图不是连通的
        for (Integer node : adjacencyList.keySet()) {
            if (!visited.contains(node)) {
                dfs(node, visited, stack);
            }
        }

        // 结果反转以获得拓扑排序
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // DFS 递归函数
    private void dfs(Integer node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);

        // 遍历所有邻接节点
        List<Integer> neighbors = adjacencyList.getOrDefault(node, Collections.emptyList());
        for (Integer neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, stack);
            }
        }

        // 将节点推入栈中
        stack.push(node);
    }

    public static void main(String[] args) {
        GraphDFS graph = new GraphDFS();

        // 添加图的边
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        List<Integer> topologicalOrder = graph.depthFirstSearch();
        System.out.println("Topological Order: " + topologicalOrder);
    }
}

