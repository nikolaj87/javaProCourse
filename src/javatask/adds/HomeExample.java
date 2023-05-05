
package javatask.adds;


    public class HomeExample {
        public static void main(String[] args) {

            System.out.println(getWord("Java##", "Ja"));
            System.out.println(getWord("Ja#va###", ""));
            System.out.println(getWord("##Ja####va#", "v"));
            System.out.println(getWord("#Hello#World#","HellWorl"));
        }

        public static boolean getWord(String str, String str2) {
            String newString = "";

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '#' && newString.length() > 0) {
                    newString = newString.substring(0, newString.length() - 1);
                } else if (str.charAt(i) != '#'){
                    newString += str.charAt(i);
                }
            }
            return newString.equals(str2);
        }
    }


