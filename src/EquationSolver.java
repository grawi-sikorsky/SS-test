import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EquationSolver {

    List<List<String>> listaA = new ArrayList<>();
    List<List<String>> listaB = new ArrayList<>();
    List<List<String>> listaC = new ArrayList<>();
    Map<String, String> listaD = new HashMap<>();

    public void solve() {

        long startTime = System.currentTimeMillis();

        // equation A Left
        // max a = 9, max bc = 99, max def = 999
        // while( a * bc != def )

        for (Integer a = 0; a < 10; ++a) {
            for (Integer bc = 0; bc < 100; ++bc) {
                for (Integer def = 0; def < 1000; ++def) {
                    if (a * bc == def) {
                        String sa = String.valueOf(a);
                        String sbc = String.valueOf(bc);
                        String sdef = String.valueOf(def);
                        String digs = String.valueOf(a) + String.valueOf(bc) + String.valueOf(def);

                        Set<Character> charsSet = digs.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                        if (charsSet.size() != digs.length()) {
                            // System.out.println("powtorka: " + sa + " " + sbc +" "+ sdef);
                            break;
                        } else {
                            // System.out.println("bez powtorki: " + sa + " " + sbc + " " + sdef);
                            listaA.add(Arrays.asList(sa, sbc, sdef));
                            break;
                        }
                    }
                }
            }
        }

        // equation B Right
        // max a = 9, max bc = 99, max def = 999
        // while( def = gh * i )
        // nie trzeba? wydaje sie to byc odwrotnoscia pierwszej petli... reverse?
        for (Integer i = 0; i < 10; ++i) {
            for (Integer gh = 0; gh < 100; ++gh) {
                for (int def = 0; def < 1000; ++def) {
                    if (def == gh * i) {
                        String si = String.valueOf(i);
                        String sgh = String.valueOf(gh);
                        String sdef = String.valueOf(def);
                        String digs = String.valueOf(def) + String.valueOf(gh) + String.valueOf(i);

                        Set<Character> charsSet = digs.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                        if (charsSet.size() != digs.length()) {
                            // System.out.println("powtorka: " + sa + " " + sbc +" "+ sdef);
                            break;
                        } else {
                            // System.out.println("bez powtorki: " + sdef + " " + sgh + " " + si);
                            listaB.add(Arrays.asList(sdef, sgh, si));
                            break;
                        }
                    }
                }
            }
        }

        // Compare equations, filter from duplicates
        for (int i = 0; i < listaA.size(); ++i) {
            for (int j = 0; j < listaB.size(); ++j) {

                if (listaA.get(i).get(2).equals(listaB.get(j).get(0))) {
                    // olaboooogaa..
                    listaC.add(Arrays.asList(listaA.get(i).get(0), listaA.get(i).get(1), listaA.get(i).get(2),
                            listaB.get(j).get(1).toString(), listaB.get(j).get(2).toString()));
                }
            }
        }


        for (List<String> possibility : listaC) {
            StringBuilder digits = new StringBuilder();
            Map<Character, Integer> charMap = new HashMap<Character, Integer>();
            int duplicates = 0;
            for (int i = 0; i < possibility.size(); ++i) {
                digits.append(String.valueOf(possibility.get(i)));
            }
            String temp = digits.toString();
            char chararray[] = temp.toCharArray();

            // System.out.println(temp.chars().mapToObj(i -> (char)
            // i).collect(Collectors.groupingBy(Object::toString,Collectors.counting())));

            for (int i = 0; i < temp.length(); ++i) {
                if (charMap.containsKey(temp.charAt(i))) {
                    break;
                } else {
                    charMap.put(temp.charAt(i), 1);
                }
                if (charMap.size() == 9) {
                    System.out.print("bez powtorki: ");
                    System.out.println(possibility);
                }
            }
        }

        System.out.println("Czas wykonania metody: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}