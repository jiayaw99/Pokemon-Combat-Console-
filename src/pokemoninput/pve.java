
package pokemoninput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class pve {

    private int win, c = 0;
    private int[] num = new int[6];
    private String choosepoke[] = new String[6];
    private String Apokemon[] = new String[3];
    private String Bpokemon[] = new String[3];
    private String pokemon[] = new String[25];
    private String poketype[] = new String[25];
    public pve() {
        Random r = new Random();
        int stk[] = new int[25];
        int def[] = new int[25];
        double hp[] = new double[25];
        int spd[] = new int[25];
        String skill[][] = new String[25][4];
        String skitype[][] = new String[25][4];
        int pow[][] = new int[25][4];
        int acu[][] = new int[25][4];
        int Aspdacc = 0;
        int Bspdacc = 0;
        int choosemove;
        double damage;
        double damagemul;
        int posi;
        //Team A
        double maxhp[] = new double[3];
        String Apoketype[] = new String[3];
        int Astk[] = new int[3];
        int Adef[] = new int[3];
        double Ahp[] = new double[3];
        int Aspd[] = new int[3];
        String Askill[][] = new String[3][4];
        String Askitype[][] = new String[3][4];
        int Apow[][] = new int[3][4];
        int Aacu[][] = new int[3][4];

        //Team B
        String Bpoketype[] = new String[3];
        int Bstk[] = new int[3];
        int Bdef[] = new int[3];
        double Bhp[] = new double[3];
        int Bspd[] = new int[3];
        String Bskill[][] = new String[3][4];
        String Bskitype[][] = new String[3][4];
        int Bpow[][] = new int[3][4];
        int Bacu[][] = new int[3][4];
        try {
            Scanner s1 = new Scanner(new FileInputStream("pokemon.txt"));
            while (s1.hasNextLine()) {
                for (int i = 0; i < 25; i++) {

                    pokemon[i] = s1.nextLine();
                    poketype[i] = s1.nextLine();
                    stk[i] = Integer.parseInt(s1.nextLine());
                    def[i] = Integer.parseInt(s1.nextLine());
                    hp[i] = Double.parseDouble(s1.nextLine());
                    spd[i] = Integer.parseInt(s1.nextLine());
                    for (int j = 0; j < 4; j++) {
                        skill[i][j] = s1.nextLine();
                        skitype[i][j] = s1.nextLine();
                        pow[i][j] = Integer.parseInt(s1.nextLine());
                        acu[i][j] = Integer.parseInt(s1.nextLine());
                    }
                    if (s1.hasNextLine()) {
                        s1.skip(s1.nextLine());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        displaypo();
        Scanner s2 = new Scanner(System.in);
        System.out.println("Team A:Please choose your first pokemon");
        num[c] = s2.nextInt() - 1;
        checkvalid();
        choosepoke[c] = pokemon[num[c]];
        checkpokemon();
        c++;
        System.out.println("Team A:Please choose your second pokemon");
        num[c] = s2.nextInt() - 1;
        checkvalid();
        choosepoke[c] = pokemon[num[c]];
        checkpokemon();
        c++;
        System.out.println("Team A:Please choose your third pokemon");
        num[c] = s2.nextInt() - 1;
        checkvalid();
        choosepoke[c] = pokemon[num[c]];
        checkpokemon();

        for (int i = 3; i < 6; i++) {

            num[i] = r.nextInt(25);
            choosepoke[i] = pokemon[num[i]];
            int b = 0;
            while (b < i) {
                if (choosepoke[i].equals(choosepoke[b])) {
                    num[i] = r.nextInt(25);
                    choosepoke[i] = pokemon[num[i]];
                    b = 0;
                } else {
                    b++;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Apokemon[i] = choosepoke[i];
                Apoketype[i] = poketype[num[i]];
                Astk[i] = stk[num[i]];
                Adef[i] = def[num[i]];
                Ahp[i] = hp[num[i]];
                maxhp[i] = hp[num[i]];
                Aspd[i] = spd[num[i]];
                Askill[i][j] = skill[num[i]][j];
                Askitype[i][j] = skitype[num[i]][j];
                Apow[i][j] = pow[num[i]][j];
                Aacu[i][j] = acu[num[i]][j];

                Bpokemon[i] = choosepoke[i + 3];
                Bpoketype[i] = poketype[num[i + 3]];
                Bstk[i] = stk[num[i + 3]];
                Bdef[i] = def[num[i + 3]];
                Bhp[i] = hp[num[i + 3]];
                Bspd[i] = spd[num[i + 3]];
                Bskill[i][j] = skill[num[i + 3]][j];
                Bskitype[i][j] = skitype[num[i + 3]][j];
                Bpow[i][j] = pow[num[i + 3]][j];
                Bacu[i][j] = acu[num[i + 3]][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Team A picked:" + Apokemon[i] + "(" + Apoketype[i] + ")");
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Team B picked:" + Bpokemon[i] + "(" + Bpoketype[i] + ")");
        }
        int i = 0;
        int j = 0;
        Scanner s = new Scanner(System.in);
        int check;
        int select;
        String temp;
        int temp1;
        int select1 = 5;
        double temp2;
        int potion = 3;
        int stkboost = 3;
        int defboost = 3;
        int acuboost = 3;
        int spdboost = 3;
        int checkbag;
        while ((Ahp[0] > 0.5 || Ahp[1] > 0.5 || Ahp[2] > 0.5) && (Bhp[0] > 0.5 || Bhp[1] > 0.5 || Bhp[2] > 0.5)) {
            while ((Ahp[0] > 0.5 || Ahp[1] > 0.5 || Ahp[2] > 0.5) && (Bhp[0] > 0.5 || Bhp[1] > 0.5 || Bhp[2] > 0.5)) {

                if (Ahp[i] < 0.5) {
                    System.out.println("Team A:" + Apokemon[i] + " fainted");
                    if (Ahp[i + 1] > 0.5) {
                        System.out.println(Apokemon[i + 1] + " is switched out");
                        i++;
                    } else {
                        System.out.println(Apokemon[i + 2] + " is switched out");
                        i = i + 2;
                    }
                }

                if (Bhp[j] < 0.5) {
                    System.out.println("Team B:" + Bpokemon[j] + " fainted");
                    System.out.println(Bpokemon[j + 1] + " is switched out");
                    j++;
                }

                Aspdacc += Aspd[i];
                Bspdacc += Bspd[j];
                if (Aspdacc >= 100) {
                    int su = 0;
                    for (int count = 0; count < 3; count++) {
                        if (Ahp[count] > 0.5) {
                            su++;
                        }
                    }
                    if (su >= 2) {
                        System.out.println("Team B " + Bpokemon[j] + " is " + Bpoketype[j] + "-type");
                        suggestion(Bpoketype[j], Apokemon[i], Apoketype[i]);
                        System.out.println("[0]Attack [1]Switch pokemon [2]Bag");
                        check = s.nextInt();
                        if (check == 2) {
                            System.out.print("[0]Potion:" + potion + " [1]Strength booster:" + stkboost + " [2]defense booster:" + defboost
                                    + " [3]Accuracy booster:" + acuboost + " [4]Speed booster:" + spdboost + " [5]back" + "\nPlease enter the number:");
                            checkbag = s.nextInt();
                            if (checkbag == 0) {
                                if (potion == 0) {
                                    System.out.println("There is no potion in your bag");
                                    break;
                                } else {
                                    System.out.println("HP of " + Apokemon[i] + " has been restored");
                                    potion -= 1;
                                    Ahp[i] = maxhp[i];
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 1) {
                                if (stkboost == 0) {
                                    System.out.println("There is no strength booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Strength of " + Apokemon[i] + " has been boosted 50 points");
                                    stkboost -= 1;
                                    Astk[i] += 50;
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 2) {
                                if (defboost == 0) {
                                    System.out.println("There is no defense booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Defense of " + Apokemon[i] + " has been boosted 50 points");
                                    defboost -= 1;
                                    Adef[i] += 50;
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 3) {
                                if (acuboost == 0) {
                                    System.out.println("There is no accuracy booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Accurary of all skills of " + Apokemon[i] + " has been boosted 10 points");
                                    acuboost -= 1;
                                    for (int boo = 0; boo < 4; boo++) {
                                        Aacu[i][boo] += 10;
                                    }
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 4) {
                                if (spdboost == 0) {
                                    System.out.println("There is no speed booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Speed of " + Apokemon[i] + " has been boosted 10 points");
                                    spdboost -= 1;
                                    Aspd[i] += 10;
                                    Aspdacc -= 100;
                                }
                            } else {
                                Aspdacc -= Aspd[i];
                                Bspdacc -= Bspd[j];
                                break;
                            }

                        }
                        if (check == 1 && su == 3) {
                            for (int count = 0; count < 3; count++) {
                                if (count != i) {
                                    System.out.print("[" + count + "]" + Apokemon[count] + "(" + Apoketype[count] + ")" + " ");
                                }
                            }
                            System.out.print(" [3]back\nPlease enter the number:");
                            select = s.nextInt();
                            if (select == 1 || select == 2) {
                                temp = Apokemon[i];
                                Apokemon[i] = Apokemon[select];
                                Apokemon[select] = temp;
                                temp = Apoketype[i];
                                Apoketype[i] = Apoketype[select];
                                Apoketype[select] = temp;
                                temp1 = Astk[i];
                                Astk[i] = Astk[select];
                                Astk[select] = temp1;
                                temp1 = Adef[i];
                                Adef[i] = Adef[select];
                                Adef[select] = temp1;
                                temp2 = maxhp[i];
                                maxhp[i] = maxhp[select];
                                maxhp[select] = temp2;
                                temp2 = Ahp[i];
                                Ahp[i] = Ahp[select];
                                Ahp[select] = temp2;
                                temp1 = Aspd[i];
                                Aspd[i] = Aspd[select];
                                Aspd[select] = temp1;
                                for (int k = 0; k < 4; k++) {
                                    temp = Askill[i][k];
                                    Askill[i][k] = Askill[select][k];
                                    Askill[select][k] = temp;
                                    temp = Askitype[i][k];
                                    Askitype[i][k] = Askitype[select][k];
                                    Askitype[select][k] = temp;
                                    temp1 = Apow[i][k];
                                    Apow[i][k] = Apow[select][k];
                                    Apow[select][k] = temp1;
                                    temp1 = Aacu[i][k];
                                    Aacu[i][k] = Aacu[select][k];
                                    Aacu[select][k] = temp1;

                                }
                                System.out.println("Team A:" + Apokemon[i] + " is switched out");
                                Aspdacc -= 100;
                            } else {
                                Aspdacc -= Aspd[i];
                                Bspdacc -= Bspd[j];
                                break;
                            }
                        } else if (check == 1 && su == 2) {
                            for (int count = 0; count < 3; count++) {
                                if (count != i && Ahp[count] > 0.5) {
                                    System.out.println("[" + count + "]" + Apokemon[count] + "(" + Apoketype[count] + ") [3]back\nPlease enter the number:");
                                    select1 = s.nextInt();
                                }
                            }

                            if (select1 == 2) {
                                temp = Apokemon[i];
                                Apokemon[i] = Apokemon[select1];
                                Apokemon[select1] = temp;
                                temp = Apoketype[i];
                                Apoketype[i] = Apoketype[select1];
                                Apoketype[select1] = temp;
                                temp1 = Astk[i];
                                Astk[i] = Astk[select1];
                                Astk[select1] = temp1;
                                temp1 = Adef[i];
                                Adef[i] = Adef[select1];
                                Adef[select1] = temp1;
                                temp2 = maxhp[i];
                                maxhp[i] = maxhp[select1];
                                maxhp[select1] = temp2;
                                temp2 = Ahp[i];
                                Ahp[i] = Ahp[select1];
                                Ahp[select1] = temp2;
                                temp1 = Aspd[i];
                                Aspd[i] = Aspd[select1];
                                Aspd[select1] = temp1;
                                for (int k = 0; k < 4; k++) {
                                    temp = Askill[i][k];
                                    Askill[i][k] = Askill[select1][k];
                                    Askill[select1][k] = temp;
                                    temp = Askitype[i][k];
                                    Askitype[i][k] = Askitype[select1][k];
                                    Askitype[select1][k] = temp;
                                    temp1 = Apow[i][k];
                                    Apow[i][k] = Apow[select1][k];
                                    Apow[select1][k] = temp1;
                                    temp1 = Aacu[i][k];
                                    Aacu[i][k] = Aacu[select1][k];
                                    Aacu[select1][k] = temp1;
                                }
                                System.out.println("Team A:" + Apokemon[i] + " is switched out");
                                Aspdacc -= 100;
                            } else {
                                Aspdacc -= Aspd[i];
                                Bspdacc -= Bspd[j];
                                break;
                            }
                        }
                    } else {
                        System.out.println("Team B " + Bpokemon[j] + " is " + Bpoketype[j] + "-type");
                        suggestion(Bpoketype[j], Apokemon[i], Apoketype[i]);
                        System.out.println("[0]Attack [1]Bag");
                        check = s.nextInt();
                        if (check == 1) {
                            System.out.print("[0]Potion:" + potion + " [1]Strength booster:" + stkboost + " [2]defense booster:" + defboost
                                    + " [3]Accuracy booster:" + acuboost + " [4]Speed booster:" + spdboost + " [5]back" + "\nPlease enter the number:");
                            checkbag = s.nextInt();
                            if (checkbag == 0) {
                                if (potion == 0) {
                                    System.out.println("There is no potion in your bag");
                                    break;
                                } else {
                                    System.out.println("HP of " + Apokemon[i] + " has been restored");
                                    potion -= 1;
                                    Ahp[i] = maxhp[i];
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 1) {
                                if (stkboost == 0) {
                                    System.out.println("There is no strength booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Strength of " + Apokemon[i] + " has been boosted 50 points");
                                    stkboost -= 1;
                                    Astk[i] += 50;
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 2) {
                                if (defboost == 0) {
                                    System.out.println("There is no defense booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Defense of " + Apokemon[i] + " has been boosted 50 points");
                                    defboost -= 1;
                                    Adef[i] += 50;
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 3) {
                                if (acuboost == 0) {
                                    System.out.println("There is no accuracy booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Accurary of all skills of " + Apokemon[i] + " has been boosted 10 points");
                                    acuboost -= 1;
                                    for (int boo = 0; boo < 4; boo++) {
                                        Aacu[i][boo] += 10;
                                    }
                                    Aspdacc -= 100;
                                }
                            } else if (checkbag == 4) {
                                if (spdboost == 0) {
                                    System.out.println("There is no speed booster in your bag");
                                    break;
                                } else {
                                    System.out.println("Speed of " + Apokemon[i] + " has been boosted 10 points");
                                    spdboost -= 1;
                                    Aspd[i] += 10;
                                    Aspdacc -= 100;
                                }
                            } else {
                                Aspdacc -= Aspd[i];
                                Bspdacc -= Bspd[j];
                                break;
                            }

                        }
                    }
                    if (Aspdacc >= 100 && Bspdacc >= 100) {
                        System.out.print("Team A pokemon:" + Apokemon[i] + " HP:");
                        System.out.printf("%.0f\n", Ahp[i]);
                        System.out.print("Team B pokemon:" + Bpokemon[j] + " HP:");
                        System.out.printf("%.0f\n", Bhp[j]);
                        Aspdacc -= 100;

                        System.out.println("[0]" + Askill[i][0] + "-" + Askitype[i][0] + " [1]" + Askill[i][1] + "-" + Askitype[i][1] + " [2]" + Askill[i][2] + "-" + Askitype[i][2] + " [3]" + Askill[i][3] + "-" + Askitype[i][3] + " [4]back");
                        System.out.print("Which move to use:");
                        choosemove = s.nextInt();
                        if (choosemove > 3 || choosemove < 0) {
                            Aspdacc -= Aspd[i];
                            Bspdacc -= Bspd[j];
                            break;
                        }
                        System.out.println(Apokemon[i] + " use " + Askill[i][choosemove]);
                        posi = r.nextInt(100);
                        if (posi < Aacu[i][choosemove]) {
                            damagemul = getdamagemul(Askitype[i][choosemove], Bpoketype[j]);
                            damage = (((Astk[i] * 1.0 * Apow[i][choosemove] / Bdef[j]) / 20) + 2) * damagemul;
                            System.out.printf("damage:%.1f", damage);
                            Bhp[j] -= damage;
                            checkeffective(damagemul);
                        } else {
                            System.out.println("Missed");
                        }

                        Bspdacc -= 100;
                        choosemove = r.nextInt(4);
                        System.out.println(Bpokemon[j] + " use " + Bskill[j][choosemove]);
                        posi = r.nextInt(100);
                        if (posi < Bacu[j][choosemove]) {
                            damagemul = getdamagemul(Bskitype[j][choosemove], Apoketype[i]);
                            damage = (((Bstk[j] * 1.0 * Bpow[j][choosemove] / Adef[i]) / 20) + 2) * damagemul;
                            Ahp[i] -= damage;
                            System.out.printf("damage:%.1f", damage);
                            checkeffective(damagemul);
                        } else {
                            System.out.println("Missed");
                        }
                    } else if (Aspdacc >= 100) {
                        System.out.print("Team A pokemon:" + Apokemon[i] + " HP:");
                        System.out.printf("%.0f\n", Ahp[i]);
                        System.out.print("Team B pokemon:" + Bpokemon[j] + " HP:");
                        System.out.printf("%.0f\n", Bhp[j]);
                        Aspdacc -= 100;
                        System.out.println("[0]" + Askill[i][0] + "-" + Askitype[i][0] + " [1]" + Askill[i][1] + "-" + Askitype[i][1] + " [2]" + Askill[i][2] + "-" + Askitype[i][2] + " [3]" + Askill[i][3] + "-" + Askitype[i][3] + " [4]back");
                        System.out.print("Which move to use:");
                        choosemove = s.nextInt();
                        if (choosemove > 3 || choosemove < 0) {
                            Aspdacc -= Aspd[i];
                            Bspdacc -= Bspd[j];
                            break;
                        }
                        System.out.println(Apokemon[i] + " use " + Askill[i][choosemove]);
                        posi = r.nextInt(100);
                        if (posi < Aacu[i][choosemove]) {
                            damagemul = getdamagemul(Askitype[i][choosemove], Bpoketype[j]);
                            damage = (((Astk[i] * 1.0 * Apow[i][choosemove] / Bdef[j]) / 20) + 2) * damagemul;
                            Bhp[j] -= damage;
                            System.out.printf("damage:%.1f", damage);
                            checkeffective(damagemul);
                        } else {
                            System.out.println("Missed");
                        }

                    } else {
                        System.out.print("Team A pokemon:" + Apokemon[i] + " HP:");
                        System.out.printf("%.0f\n", Ahp[i]);
                        System.out.print("Team B pokemon:" + Bpokemon[j] + " HP:");
                        System.out.printf("%.0f\n", Bhp[j]);
                        Bspdacc -= 100;
                        choosemove = r.nextInt(4);
                        System.out.println(Bpokemon[j] + " use " + Bskill[j][choosemove]);
                        posi = r.nextInt(100);
                        if (posi < Bacu[j][choosemove]) {
                            damagemul = getdamagemul(Bskitype[j][choosemove], Apoketype[i]);
                            damage = (((Bstk[j] * 1.0 * Bpow[j][choosemove] / Adef[i]) / 20) + 2) * damagemul;
                            Ahp[i] -= damage;
                            System.out.printf("damage:%.1f", damage);
                            checkeffective(damagemul);
                        } else {
                            System.out.println("Missed");
                        }
                    }
                }

            }
        }
        if (Ahp[0] < 0.5 && Ahp[1] < 0.5 && Ahp[2] < 0.5) {
            System.out.println(Apokemon[2] + " is fainted" + "\nAll pokemons of Team A are fainted!!!\nTeam B win");
            win = 1;
        } else {
            System.out.println(Bpokemon[2] + " is fainted" + "\nAll pokemons of Team B are fainted!!!\nTeam A win");
            win = 0;
        }
    }

    public static double getdamagemul(String move, String poketype) {
        double damagemul;
        if (move.equals("grass")) {
            if (poketype.equals("water")) {
                damagemul = 2.0;
            } else if (poketype.equals("fire")) {
                damagemul = 0.5;
            } else if (poketype.equals("flying")) {
                damagemul = 0.5;
            } else if (poketype.equals("dragon")) {
                damagemul = 0.5;
            } else {
                damagemul = 1.0;
            }
        } else if (move.equals("water")) {
            if (poketype.equals("fire")) {
                damagemul = 2.0;
            } else if (poketype.equals("grass")) {
                damagemul = 0.5;
            } else if (poketype.equals("dragon")) {
                damagemul = 0.5;
            } else {
                damagemul = 1.0;
            }
        } else if (move.equals("fire")) {
            if (poketype.equals("grass")) {
                damagemul = 2.0;
            } else if (poketype.equals("water")) {
                damagemul = 0.5;
            } else if (poketype.equals("ice")) {
                damagemul = 2.0;
            } else if (poketype.equals("dragon")) {
                damagemul = 0.5;
            } else {
                damagemul = 1.0;
            }
        } else if (move.equals("ice")) {
            if (poketype.equals("flying")) {
                damagemul = 2.0;
            } else if (poketype.equals("water")) {
                damagemul = 0.5;
            } else if (poketype.equals("grass")) {
                damagemul = 2.0;
            } else if (poketype.equals("fire")) {
                damagemul = 0.5;
            } else if (poketype.equals("dragon")) {
                damagemul = 2.0;
            } else {
                damagemul = 1.0;
            }
        } else if (move.equals("flying")) {
            if (poketype.equals("grass")) {
                damagemul = 2.0;
            } else {
                damagemul = 1.0;
            }
        } else if (move.equals("dragon")) {
            if (poketype.equals("dragon")) {
                damagemul = 2.0;
            } else {
                damagemul = 1.0;
            }
        } else {
            damagemul = 1.0;
        }
        return damagemul;
    }

    public static void checkeffective(double dm) {
        if (dm == 2.0) {
            System.out.println("-super effective");
        }
        if (dm == 0.5) {
            System.out.println("-not effective");
        }
        if (dm == 1.0) {
            System.out.println("");
        }
    }

    public static void suggestion(String enemytype, String current, String currenttype) {
        if (enemytype.equals("grass")) {
            if (currenttype.equals("fire") || currenttype.equals("ice") || currenttype.equals("flying")) {
                System.out.println("Your " + current + " is the best counter");
            } else {
                System.out.println("fire/ice/flying-type pokemon is recommended");
                System.out.println("Your current pokemon is " + current + "(" + currenttype + ")");
            }
        }
        if (enemytype.equals("water")) {
            if (currenttype.equals("grass")) {
                System.out.println("Your " + current + " is the best counter");
            } else {
                System.out.println("grass-type pokemon is recommended");
                System.out.println("Your current pokemon is " + current + "(" + currenttype + ")");
            }
        }
        if (enemytype.equals("fire")) {
            if (currenttype.equals("water")) {
                System.out.println("Your " + current + " is the best counter");
            } else {
                System.out.println("water-type pokemon is recommended");
                System.out.println("Your current pokemon is " + current + "(" + currenttype + ")");
            }
        }
        if (enemytype.equals("ice")) {
            if (currenttype.equals("fire")) {
                System.out.println("Your " + current + " is the best counter");
            } else {
                System.out.println("fire-type pokemon is recommended");
                System.out.println("Your current pokemon is " + current + "(" + currenttype + ")");
            }
        }
        if (enemytype.equals("flying")) {
            if (currenttype.equals("ice")) {
                System.out.println("Your " + current + " is the best counter");
            } else {
                System.out.println("ice-type pokemon is recommended");
                System.out.println("Your current pokemon is " + current + "(" + currenttype + ")");
            }
        }
        if (enemytype.equals("dragon")) {
            if (currenttype.equals("dragon") || currenttype.equals("ice")) {
                System.out.println("Your " + current + " is the best counter");
            } else {
                System.out.println("dragon/ice-type pokemon is recommended");
                System.out.println("Your current pokemon is " + current + "(" + currenttype + ")");
            }
        }

    }

    public void displaypo() {
        int l = 1;
        for (int i = 0; i < 25; i++, l++) {
            if (i >= 9) {
                System.out.printf("[%2s]%-9s-%-10s", i + 1, pokemon[i],poketype[i]);
            } else {
                System.out.printf("[%s]%-10s-%-10s", i + 1, pokemon[i],poketype[i]);
            }
            if (l % 5 == 0) {
                System.out.println("");
            }
        }
    }

    public void checkpokemon() {
        int b = 0;
        Scanner s = new Scanner(System.in);
        while (b < c) {
            if (choosepoke[c].equals(choosepoke[b])) {
                System.out.println(choosepoke[c] + " has been chosen,please choose again:");
                num[c] = s.nextInt() - 1;
                choosepoke[c] = pokemon[num[c]];
                b = 0;
            } else {
                b++;
            }
        }

        System.out.println(choosepoke[c] + " has been chosen");
    }

    public int getresult() {
        return win;
    }

    public String getApokemon() {
        return "Team A pokemon:" + Apokemon[0] + "  " + Apokemon[1] + "  " + Apokemon[2];
    }

    public String getBpokemon() {
        return "Team B pokemon:" + Bpokemon[0] + "  " + Bpokemon[1] + "  " + Bpokemon[2];
    }

    public void checkvalid() {
        Scanner s = new Scanner(System.in);
        while (num[c] > 24 || num[c] < 0) {
            System.out.println("Please enter a valid number");
            num[c] = s.nextInt() - 1;
        }
    }
}