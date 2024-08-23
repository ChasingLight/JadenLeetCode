package leetbook.graph;

/**
 * 图的拓扑排序（Topological Sorting）是一种线性排序方法，主要用于有向无环图（DAG, Directed Acyclic Graph）。
 * 它的核心思想是对节点进行排序，使得对于每条有向边 (u, v)，节点 u 排在节点 v 的前面。
 *
 * @author jinhaodong
 * @date 2024/8/22 11:34
 */
import java.util.*;

public class GraphBFS {
    private final Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    // 添加边
    public void addEdge(int u, int v) {
        adjacencyList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    // 基于BFS的拓扑排序（Kahn's 算法）
    public List<Integer> topologicalSort() {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topologicalOrder = new ArrayList<>();

        // 初始化所有节点的入度
        for (Integer node : adjacencyList.keySet()) {
            inDegree.put(node, 0);
        }

        // 计算每个节点的入度
        for (Integer node : adjacencyList.keySet()) {
            for (Integer neighbor : adjacencyList.get(node)) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        // 将所有入度为0的节点加入队列
        for (Integer node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.add(node);
            }
        }

        // 进行拓扑排序
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            topologicalOrder.add(node);

            for (Integer neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 检查是否有环
        if (topologicalOrder.size() != inDegree.size()) {
            throw new RuntimeException("The leetbook.graph has a cycle, topological sort not possible.");
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS();

        // 添加图的边
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 4);
        graph.addEdge(4, 1);

        List<Integer> topologicalOrder = graph.topologicalSort();
        System.out.println("Topological Sort: " + topologicalOrder);
    }
}

