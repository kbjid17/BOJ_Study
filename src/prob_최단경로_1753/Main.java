package prob_최단경로_1753;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static ArrayList<Node>[] list;
    private static int v;
    private static int e;
    private static int start;
    private static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt(); //정점개수
        e = sc.nextInt(); //간선개수
        start = sc.nextInt(); //시작정점
        list = new ArrayList[v + 1]; //정점 인접리스트
        distance = new int[v + 1]; //시작점과 다른 정점간의 최단경로
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        //초기화
        Arrays.fill(distance, INF);
        distance[start] = 0;
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt(); //출발
            int v = sc.nextInt(); //도착지
            int w = sc.nextInt(); //가중치
            list[u].add(new Node(v, w));
        }
        dijkstra();
        for (int i = 1; i <= v; i++) {
            if (distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (distance[vertex] < weight) { //지금께 더 가중치가 크면 갱신할 필요가 없다.
                continue;
            }
            for (int i = 0; i < list[vertex].size(); i++) {//해당 정점과 연결된 것들 탐색
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> { //우선순위큐로 성능개선(안하면 시간초과뜸)
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
