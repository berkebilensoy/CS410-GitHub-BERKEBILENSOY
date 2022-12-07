import java.io.*;
import java.util.*;


public class main {
    public static void main(String args[]) throws FileNotFoundException {


        Scanner s = new Scanner(new File("src/NFA1.txt"));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> alphabet = new ArrayList<String>();
        ArrayList<String> states = new ArrayList<String>();
        ArrayList<String> startState = new ArrayList<String>();
        ArrayList<String> finalState = new ArrayList<String>();
        ArrayList<String> transitions = new ArrayList<String>();
        ArrayList<String>[][] trans;
        ArrayList<String>[][] DFA;


        while (s.hasNext()) {
            list.add(s.next());

        }
        s.close();
        System.out.println(list);
        int b = 1;
        while (!(list.get(b).equals("STATES"))) {
            alphabet.add(list.get(b));
            b++;
        }
        b++;
        while (!(list.get(b).equals("START"))) {
            states.add(list.get(b));
            b++;
        }
        b++;

        while (!(list.get(b).equals("FINAL"))) {
            startState.add(list.get(b));
            b++;
        }
        b++;
        while (!(list.get(b).equals("TRANSITIONS"))) {
            finalState.add(list.get(b));
            b++;
        }
        b++;
        while (!(list.get(b).equals("END"))) {
            transitions.add(list.get(b));
            b++;
        }


        System.out.println(alphabet);
        System.out.println(states);
        System.out.println(startState);
        System.out.println(finalState);
        System.out.println(transitions);


        int alphabetc = alphabet.size();
        int statec = states.size();

        trans = new ArrayList[statec][alphabetc];
        for (int i = 0; i < statec; i++) {
            for (int j = 0; j < alphabetc; j++) {
                trans[i][j] = new ArrayList<>();
            }
        }

            for (int i = 0; i< transitions.size(); i++){
                if(i % 3 == 0){


                    if(transitions.get(i).equals(startState.get(0))){
                        if (transitions.get(i+1).equals(alphabet.get(0))){
                            trans[0][0].add(transitions.get(i+2));
                        }
                        else {
                            trans[0][1].add(transitions.get(i+2));
                        }
                    }
                    else if (transitions.get(i).equals(states.get(1))){
                        if (transitions.get(i+1).equals("0")){
                            trans[1][0].add(transitions.get(i+2));
                        }
                        else {
                            trans[1][1].add(transitions.get(i+2));
                        }
                    }
                    else if (transitions.get(i).equals("C")){
                        if (transitions.get(i+1).equals("0")){
                            trans[2][0].add(transitions.get(i+2));
                        }
                        else {
                            trans[1][1].add(transitions.get(i+2));
                        }
                    }
                }
            }


            System.out.println("TRANSITIONS");
            String statename;
            String lettername;
            for (int i = 0; i < alphabet.size(); i++) {
                lettername = alphabet.get(i);
                System.out.print("   "+lettername + " ");
            }
            System.out.println();

            for (int i = 0; i < trans.length; i++) {
                statename = states.get(i);
                System.out.print(statename + " ");
                for (int j = 0; j < trans[i].length; j++) {
                    for (String k : trans[i][j]) {
                        System.out.print( k + " ");
                    }
                    System.out.print("|");
                }
                System.out.println();


            }




    }






    }


