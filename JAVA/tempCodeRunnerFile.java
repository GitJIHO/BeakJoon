
        // dist[X] = 0;
        // while(!pq.isEmpty()) {
        //     Node cur = pq.poll();
        //     for (Node next : graph.get(cur.end)) {
        //         if (dist[next.end] > dist[cur.end] + cur.weight) {
        //             dist[next.end] = dist[cur.end] + cur.weight;
        //             pq.offer(new Node(next.end, dist[next.end]));
        //         }
        //     }
        // }