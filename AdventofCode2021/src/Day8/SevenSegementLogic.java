/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Day8;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class SevenSegementLogic {

/* segments = new HashMap<>();
    segments.put("A", UNKNOWN);
    segments.put("B", UNKNOWN);
    segments.put("C", UNKNOWN);
    segments.put("D", UNKNOWN);
    segments.put("E", UNKNOWN);
    segments.put("F", UNKNOWN);
    segments.put("G", UNKNOWN);
     */
    public HashMap<String, Character> getSegments() {
        return segments;
    }



private HashMap<String, Character> segments;
private final int ZERO =0;//?
private final char UNKNOWN = 'z';
//uniques
private char[] zero;
private char[] one;
private char[] two;
private char[] three;
private char[] four;
private char[] five;
private char[] six;
private char[] seven;
private char[] eight; 
private char[] nine;

public SevenSegementLogic(){

    segments = new HashMap<>(); 
    segments.put("A", UNKNOWN);
    segments.put("B", UNKNOWN);
    segments.put("C", UNKNOWN);
    segments.put("D", UNKNOWN);
    segments.put("E", UNKNOWN);
    segments.put("F", UNKNOWN);
    segments.put("G", UNKNOWN);

    zero = new char[6];
    two = new char[5];
    three = new char[5];
    five = new char[5];
    six = new char[6];
    nine = new char[6];
 }

//find 1,4,7,8 - can do THAT purely by length

    public int countUniques(String[] output){

        int count =ZERO;
        for(int i=0;i<output.length;i++){
            count += uniqueHelper(output[i]);
        }
        return count;
    }
    private int uniqueHelper(String str){

        int count = ZERO;
        if(str.length() == 2 || str.length() == 4|| str.length() == 3|| str.length() == 7){

            count++;
        }

        return count;
    }
//1,4,7,8,A,G,E,D
//A B C D E F G
//A == 7(1) - ok, no req
//G == 9(A - 4) == 6 segments (3 poss) -- BUT! i KNOW the 4 MUST have B,C,D,F
//E == 8(A - G - 4) - no req
//D == 3(A - G - 1) - 5 segments
//B ==  4(D - 1) - 6 segments 
// C == 2(A - G - E - D) - 5 segments
// F == 1(C) - unique
/*  0:      1:      2:      3:      4:
 aaaa    ....    aaaa    aaaa    ....
b    c  .    c  .    c  .    c  b    c
b    c  .    c  .    c  .    c  b    c
 ....    ....    dddd    dddd    dddd
e    f  .    f  e    .  .    f  .    f
e    f  .    f  e    .  .    f  .    f
 gggg    ....    gggg    gggg    ....

  5:      6:      7:      8:      9:
 aaaa    aaaa    aaaa    aaaa    aaaa
b    .  b    .  .    c  b    c  b    c
b    .  b    .  .    c  b    c  b    c
 dddd    dddd    ....    dddd    dddd
.    f  e    f  .    f  e    f  .    f
.    f  e    f  .    f  e    f  .    f
 gggg    gggg    ....    gggg    gggg*/
    public String decodeOutput(String[] info){
        String output = "";
            for(int i =0; i< info.length;i++){
                if(!info[i].isEmpty()){
                    output += decode(info[i]);
                }
            }
        return output;
    }
private String decode(String digit){
    char[] digit_bits = digit.toCharArray();
    //System.out.println("Digit: " + digit);
    String temp ="";
    int size = digit_bits.length;
    if(size == 6){
        temp = sixDigit(digit_bits);
    }
    if(size == 5){
        temp = fiveDigit(digit_bits);
    }
    if(size == 7){temp = "8";}
    if(size == 4){temp = "4";}
    if(size == 3){temp = "7";}
    if(size == 2){temp = "1";}
    return temp;
}
    private String sixDigit(char[] arr){
        Arrays.sort(arr);
        String  str = "";
        if(zero_test(arr)){str = "0";}
        if(six_test(arr)){str = "6";}
        if(nine_test(arr)){str = "9";}
        return str;
    }
    private String fiveDigit(char[] arr){
        Arrays.sort(arr);
        String str = "";
        if(two_test(arr)){str = "2";}
        if(three_test(arr)){str= "3";}
        if(five_test(arr)){str= "5";}
        return str;
    }
private boolean two_test(char[] arr){
    Arrays.sort(two);
    for(int i =0; i<arr.length;i++){if(arr[i] != two[i]) return false;}
    return true;
}
private boolean three_test(char[] arr){
    Arrays.sort(three);
    for(int i =0; i<arr.length;i++){if(arr[i] != three[i]) return false;}
    return true;
}
private boolean five_test(char[] arr){
    Arrays.sort(five);
    for(int i =0; i<arr.length;i++){if(arr[i] != five[i]) return false;}
    return true;
}
private boolean zero_test(char[] arr){
    Arrays.sort(zero);
    for(int i =0; i<arr.length;i++){if(arr[i] != zero[i]) return false;}
    return true;
}
private boolean six_test(char[] arr){
    Arrays.sort(six);
    for(int i =0; i<arr.length;i++){if(arr[i] != six[i]) return false;}
    return true;
}
private boolean nine_test(char[] arr){
    Arrays.sort(nine);
    for(int i =0; i<arr.length;i++){if(arr[i] != nine[i]) return false;}
    return true;
}
public void unscramble(){

    zero[0] = segments.get("A");
    zero[1] = segments.get("B");
    zero[2] = segments.get("C");
    zero[3] = segments.get("E");
    zero[4] = segments.get("F");
    zero[5] = segments.get("G");

    two[0] = segments.get("A");
    two[1] = segments.get("C");
    two[2] = segments.get("D");
    two[3] = segments.get("E");
    two[4] = segments.get("G");

    three[0]= segments.get("A");
    three[1] = segments.get("C");
    three[2] = segments.get("D");
    three[3] = segments.get("F");
    three[4] = segments.get("G");

    five[0] = segments.get("A");
    five[1] = segments.get("B");
    five[2] = segments.get("D");
    five[3] = segments.get("F");
    five[4] = segments.get("G");

    six[0] = segments.get("A");
    six[1] = segments.get("B");
    six[2] = segments.get("D");
    six[3] = segments.get("E");
    six[4] = segments.get("F");
    six[5] = segments.get("G");

    nine[0] = segments.get("A");
    nine[1] = segments.get("B");
    nine[2] = segments.get("C");
    nine[3] = segments.get("D");
    nine[4] = segments.get("F");
    nine[5] = segments.get("G");

}
    public void findSegments(String[] info){

        findA();
        findG(info);
        findE();
        findD(info);
        findB();
        findC(info);
        findF();
    }
//A == 7(1) - ok, no req
    private void findA(){
       /* System.out.println("???");
        boolean test = true;
        for(int i =0; i<seven.length;i++){
            for(int j =0; j<one.length; j++){   
                if(seven[i] == one[j]){test = false;}
            }
            if(test){segments.put("A", seven[i]);}
            test = true;
        }*/
        int x = -1;
        Arrays.sort(one);
        for(int i =0;i<seven.length;i++){
            x = Arrays.binarySearch(one, seven[i]);
            System.out.println("X: " + x);
            System.out.println("ONE: " + Arrays.toString(one));
            System.out.println("ONE: " + Arrays.toString(seven));
            System.out.println("ELEMENT: " + seven[i]);
            if(x<0){segments.put("A", seven[i]);}
        }
    }
//G == 9(A - 4) == 6 segments (3 poss) -- BUT! i KNOW the 4 MUST have B,C,D,F
    private void findG(String[] info){
        for(int i=0; i<info.length;i++){
            if(info[i].length() == 6 && segments.get("G") == UNKNOWN){
                findG_Helper(info[i]);
            }
        }
    }
    private void findG_Helper(String poss_nine){
        char[] poss_nine_arr = poss_nine.toCharArray();
        boolean checker = true;
        int pos =0;
        //System.out.println("nine? " + poss_nine);
        while(checker && pos<four.length){

            checker = testFour(four[pos], poss_nine_arr);
           // checker = testFour(four[i], poss_nine_arr);
            pos++;
        }
        if(checker){
            //System.out.println("nine: " + poss_nine);
            for(int i =0; i<poss_nine_arr.length;i++){
                if(poss_nine_arr[i] != segments.get("A") && !is_Four(poss_nine_arr[i])){
                    segments.put("G", poss_nine_arr[i]);
                }
            }
        }
    }
    private boolean testFour(char ch, char[] arr){
        for(int i =0; i<arr.length; i++){
            if(ch == arr[i]){return true;}
        }
        return false;
    }
    private boolean is_Four(char ch){
        for(int i =0; i<four.length;i++){
            if(ch == four[i]){return true;}
        }
        return false;
    }
//E == 8(A - G - 4) - no req
    private void findE(){
        for(int i =0;i<eight.length;i++){
            if(eight[i] != segments.get("A") && eight[i] != segments.get("G") && !is_Four(eight[i])){
                segments.put("E", eight[i]);
            }
        }
    }
//D == 3(A - G - 1) - 5 segments
    private void findD(String[] info){
        for(int i =0;i< info.length;i++){
         if(info[i].length() == 5 && segments.get("D") == UNKNOWN){
            findD_Helper(info[i]);
        }
        }
    }
    private void findD_Helper(String poss_three){
        //System.out.println("POSS 3: " + poss_three);
        char[] poss_three_arr = poss_three.toCharArray();
        boolean checker = true;
        int i =0;
        while(checker && i<one.length){
            checker = testOne(one[i], poss_three_arr);
            i++;
         
        }
        if(checker){
            //System.out.println("POSS 3 success: " + poss_three);
            checker = test_A(poss_three_arr);
        }
        if(checker){
            //System.out.println("POSS 3 success 2.0: " + poss_three);
            checker = test_G(poss_three_arr);
        }
        if(checker){
            //System.out.println("POSS 3 success 3.0: " + poss_three);
            for(int itr =0; itr<poss_three_arr.length; itr++){
                if(poss_three_arr[itr] != segments.get("A") && poss_three_arr[itr] != segments.get("G") && !is_One(poss_three_arr[itr])){
                    //System.out.println("WHAT" + poss_three_arr[itr]);
                    segments.put("D", poss_three_arr[itr]);
                }
            }
        }
    }
//B ==  4(D - 1) - 6 segments 
private void findB(){

    for(int i =0; i<four.length;i++){
        if(four[i] != segments.get("D") && ! is_One(four[i])){
            segments.put("B", four[i]);
        }
    }
}
//C == 2(A - G - E - D) - 5 segments
private void findC(String[] info){
    for(int i=0; i<info.length;i++){
        if(info[i].length()==5 && segments.get("C") == UNKNOWN){
            findC_Helper(info[i]);
        }
    }
}
private void findC_Helper(String poss_two){
    char[] poss_two_arr = poss_two.toCharArray();
    boolean checker = true;
    checker = test_A(poss_two_arr);
    if(checker){
        checker = test_G(poss_two_arr);
    }
    if(checker){checker = test_E(poss_two_arr);}
    if(checker){checker = test_D(poss_two_arr);}
    if(checker){
        for(int i =0; i<poss_two_arr.length;i++){
            if(test_AGED(poss_two_arr[i])){
                segments.put("C", poss_two_arr[i]);
            }
        }
    }    
}
    private void findF(){
        for(int i =0; i<one.length;i++){
            if(one[i] != segments.get("C")){
                segments.put("F", one[i]);
            }
        }
    }
private boolean test_AGED(char ch){
    return ch != segments.get("A") && ch != segments.get("G") && ch != segments.get("E") && ch != segments.get("D");
}
    private boolean is_One(char ch){
        for(int i=0; i<one.length;i++){if(ch == one[i]){return true;}}
        return false;
    }
    private boolean testOne(char ch, char[] arr){
        for(int i =0; i<arr.length;i++){if(ch == arr[i]){return true;}
        }
        return false;
    }
    private boolean test_A(char[] arr){
        for(int i =0; i<arr.length;i++){if(arr[i] == segments.get("A")){return true;}
        }
        return false;
    }
    private boolean test_G(char[] arr){
        for(int i =0; i<arr.length;i++){if(arr[i] == segments.get("G")){return true;}
        }
        return false;
    }
    private boolean test_E(char[] arr){
        for(int i =0;i<arr.length;i++){if(arr[i] == segments.get("E")){return true;}
        }
        return false;
    }
    private boolean test_D(char[] arr){
        for(int i =0;i<arr.length;i++){if(arr[i] == segments.get("D")){return true;}
        }
        return false;
    }
    public void findUniques(String[] info){

        //System.out.println("FINDUNIQUES :  " + Arrays.toString(info));
        for(int i =0; i<info.length;i++){
            findUniqueHelper(info[i]);
        }
    }
    private void findUniqueHelper(String str){
        switch(str.length()){
            case 2:
                one = str.toCharArray();
                break;
            case 4:
                four = str.toCharArray();
                break;
            case 3:
                seven = str.toCharArray();
                break;
            case 7:
                eight = str.toCharArray();
                break;
        }
    }

public void printChars(){
    System.out.println("ARRAYS:");
    System.out.println("ONE: " + Arrays.toString(one));
    System.out.println("FOUR: " + Arrays.toString(four));
    System.out.println("SEVEN: " + Arrays.toString(seven));
    System.out.println("EIGHT: " + Arrays.toString(eight));
}
}
