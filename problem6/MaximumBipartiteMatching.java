// MaximumBipartiteMatching.java
import java.util.*;

public class MaximumBipartiteMatching {

    private static Map<String, String> match;
    private static Map<String, String> label;

    public static Map<String, String> MaximumMatching(List<String> V, List<String> U, Map<String, List<String>> adj) {
        match = new HashMap<>();
        label = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        while (true) {
            label.clear();
            queue.clear();

            for (String v : V) {
                if (!match.containsKey(v)) {
                    queue.add(v);
                }
            }

            boolean augmented = false;

            while (!queue.isEmpty()) {
                String w = queue.poll();

                if (V.contains(w)) { // w in V
                    for (String u : adj.get(w)) {
                        if (!match.containsKey(u)) {
                            match.put(w, u);
                            match.put(u, w);

                            String v = w;
                            while (label.containsKey(v)) {
                                String prevU = label.get(v);
                                match.remove(v);
                                match.remove(prevU);
                                v = label.get(prevU);
                                match.put(v, prevU);
                                match.put(prevU, v);
                            }

                            augmented = true;
                            break;
                        } else if (match.get(w) != null && match.get(w).equals(u)) {
                            continue;
                        } else if (!label.containsKey(u)) {
                            label.put(u, w);
                            queue.add(u);
                        }
                    }
                } else { // w ∈ U
                    String mateV = match.get(w);
                    if (mateV != null && !label.containsKey(mateV)) {
                        label.put(mateV, w);
                        queue.add(mateV);
                    }
                }
            }

            if (!augmented) {
                break;
            }
        }
        return match;
    }
}

