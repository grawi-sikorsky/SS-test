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
        // ( a * bc != def )
        for (Integer a = 0; a < 10; ++a) {
            for (Integer bc = 0; bc < 100; ++bc) {
                for (Integer def = 0; def < 1000; ++def) {
                    if (a * bc == def) {

                        String digits = String.valueOf(a) + String.valueOf(bc) + String.valueOf(def);
                        Set<Character> charsSet = digits.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                        if (charsSet.size() != digits.length()) {
                            // powtarzajace sie znaki
                            break;
                        } else {
                            listaA.add(Arrays.asList(String.valueOf(a), String.valueOf(bc), String.valueOf(def)));
                            break;
                        }
                    }
                }
            }
        }

        // equation B Right
        // max i = 9, max gh = 99, max def = 999
        // ( def = gh * i )
        // nie trzeba? wydaje sie to byc odwrotnoscia pierwszej petli... reverse?
        for (Integer i = 0; i < 10; ++i) {
            for (Integer gh = 0; gh < 100; ++gh) {
                for (int def = 0; def < 1000; ++def) {
                    if (def == gh * i) {

                        String digits = String.valueOf(def) + String.valueOf(gh) + String.valueOf(i);
                        Set<Character> charsSet = digits.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                        if (charsSet.size() != digits.length()) {
                            // powtarzajace sie znaki
                            break;
                        } else {
                            listaB.add(Arrays.asList(String.valueOf(def), String.valueOf(gh), String.valueOf(i)));
                            break;
                        }
                    }
                }
            }
        }

        // Scalenie obu stron rownan
        for (int i = 0; i < listaA.size(); ++i) {
            for (int j = 0; j < listaB.size(); ++j) {
                // na liscie A, 3 cyfrowa czesc rownania znajduje sie na indeksie 2, w liscie B na indeksie 0.
                if (listaA.get(i).get(2).equals(listaB.get(j).get(0))) {

                    listaC.add(Arrays.asList(listaA.get(i).get(0),
                            listaA.get(i).get(1),
                            listaA.get(i).get(2),
                            listaB.get(j).get(1),
                            listaB.get(j).get(2)));
                }
            }
        }

        for (List<String> possibility : listaC) {
            StringBuilder digits = new StringBuilder();
            Map<Character, Integer> charMap = new HashMap<Character, Integer>();

            for (int i = 0; i < possibility.size(); ++i) {
                digits.append(String.valueOf(possibility.get(i)));
            }
            String temp = digits.toString();

            // filtr
            for (int i = 0; i < temp.length(); ++i) {
                if (charMap.containsKey(temp.charAt(i))) {
                    break;
                } else {
                    charMap.put(temp.charAt(i), 1);
                }
                if (charMap.size() == 9) {
                    System.out.print("Wynik: ");
                    System.out.println(possibility);
                }
            }
        }

        System.out.println("Czas wykonania metody: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}