
package pokemoninput;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Administrator
 */
public class Pokemoninput {

    static int i = 1;
    static int j = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Scanner s1 = new Scanner(new FileInputStream("fight records.txt"));
            while (s1.hasNextLine()) {
                if (s1.next().equals("PVP")) {
                    i++;
                } else {
                    j++;
                }
                s1.nextLine();

            }
        } catch (FileNotFoundException e) {
            System.out.print("");

        }
        run();
    }

    public static void run() {
        int play = 1;
        try {
            Scanner s = new Scanner(System.in);
            PrintWriter p = new PrintWriter(new FileOutputStream("fight records.txt", true));
            
            while (play != 2) {
                System.out.println("Hello!!Welcome to pokemon world!\nPlease select the mode:");
                System.out.print("[0]PVP [1]PVE [2]exit\nPlease enter the number:");
                play = s.nextInt();
                if (play == 0) {
                    pvp p1 = new pvp();
                    if (p1.getresult() == 1) {
                        p.print("PVP Round " + i + ":Team B win  " + p1.getApokemon() + "   " + p1.getBpokemon());
                        p.println();
                    } else {
                        p.print("PVP Round " + i + ":Team A win  " + p1.getApokemon() + "   " + p1.getBpokemon());
                        p.println();
                    }
                    i++;
                }
                if (play == 1) {
                    pve p2 = new pve();
                    if (p2.getresult() == 1) {
                        p.print("PVE Round " + j + ":Team B win  " + p2.getApokemon() + "   " + p2.getBpokemon());
                        p.println();
                    } else {
                        p.print("PVE Round " + j + ":Team A win  " + p2.getApokemon() + "   " + p2.getBpokemon());
                        p.println();
                    }
                    j++;
                }
            }
            p.close();
        } catch (FileNotFoundException e) {
            System.out.print("file not found");
        } catch (Exception i) {
            run();
        }
    }
}
