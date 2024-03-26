package LCR;

import java.util.*;

public class LCR_111 {
    class Edge{
        int to;
        double value;
        Edge( int t, double v){
            to = t;
            value = v;
        }
    }
    public HashMap<Integer, List<Edge>> graph = new HashMap<>();
    public HashMap<String, Integer> mapId = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nodeNum = 0;
        for (int i = 0; i < values.length; i++){
            List<String> eq = equations.get(i);
            String a = eq.get(0), b = eq.get(1);
            if (!mapId.containsKey(a)) mapId.put(a, nodeNum++);
            if (!mapId.containsKey(b)) mapId.put(b, nodeNum++);
            double vatob = values[i];
            double vbtoa = 1 / vatob;
            int indexA = mapId.get(a);
            List<Edge> alist = graph.getOrDefault(indexA, new ArrayList<>());
            alist.add(new Edge(indexA, vatob));
            graph.put(indexA, alist);
            int indexB = mapId.get(b);
            List<Edge> blist = graph.getOrDefault(indexB, new ArrayList<>());
            blist.add(new Edge(indexB, vbtoa));
            graph.put(indexB, blist);
        }
        int len = queries.size();
        double[] res = new double[len];
        double[] multiMap = new double[nodeNum];
        Arrays.fill(multiMap, 1.0);
        for (int i = 0; i < len; i++){
            List<String> q = queries.get(i);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(mapId.get(q.getFirst()));
            while (!queue.isEmpty()){
                int cur = queue.poll();
                List<Edge> edge = graph.get(cur);
                for (Edge e : edge){
                    int to = e.to;
                    multiMap[to] *= e.value;
                    if (mapId.get(q.getLast()) == to)
                        res[i] = multiMap[to];
                }
            }
        }
        return res;
    }
}

