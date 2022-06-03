import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EquationSolver {

    List<List<String>> listaA = new ArrayList<>();
    List<List<String>> listaB = new ArrayList<>();

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
        StringBuilder digs = new StringBuilder();
        for (Integer i = 0; i < listaA.size(); ++i) {
            for (Integer j = 0; j < listaB.size(); ++j) {

                
                System.out.println(listaA.get(i).get(2).toString());
                String digs1 = String.valueOf(listaA.get(i).toString() + listaB.get(j).toString());

                Set<Character> charsSet = digs.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                if (charsSet.size() != digs.length()) {
                    digs.setLength(0);
                } else {
                    digs.setLength(0);
                }
            }
        }

        System.out.println("Czas wykonania metody: " + (System.currentTimeMillis() - startTime) + " ms");
    }

}
