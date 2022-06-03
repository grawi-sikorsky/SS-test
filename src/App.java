import java.util.Scanner;
import java.util.Timer;

public class App {
    public static void main(String[] args) throws Exception {
        Solver solver = new Solver();
        EquationSolver eqsolver = new EquationSolver();
        Scanner in = new Scanner(System.in);

        // System.out.print("Podaj ilosc kolumn lub rzedow piramidy: ");
        // System.out.println("Liczba bloków w piramidzie: " + solver.countBlocks( in.nextInt() ));
        // System.out.println("=================================================================");

        // System.out.print("Podaj ilosc kolumn lub rzedow piramidy: ");
        // Integer blockCount=0, blockCol=0, blockRow=0,blockLayer=0;
        // blockCount = in.nextInt();
        // System.out.print("Podaj kolumnę: "); 
        // blockCol = in.nextInt();
        // System.out.print("Podaj wiersz: "); 
        // blockRow = in.nextInt();
        // System.out.print("Podaj warstwe: "); 
        // blockLayer = in.nextInt();
        // System.out.println(solver.getBlockNumber(blockCount,blockRow,blockCol,blockLayer));

        
        eqsolver.solve();
        //eqsolver.test();
    }
}
