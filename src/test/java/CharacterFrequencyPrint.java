
/*
    Problem statement:
        For a given input String, return an output string with highest frequency of chars as first. 
        Note: For same frequency repeated chars, print in ascending order
    
    Ex1: "this is my nations india"
    Output: iiiiinnnsssaattdhmoy

*/

import java.util.*;
import java.util.stream.Collectors;


public class CharacterFrequencyPrint {

    public static void main(String[] args) {
        String s = "lets write a function to print characters";
        String s1 = " eeerrruuu qqzzvvffpp this is my nations india";
        frequencyOfCharDescOrder(s);
        System.out.println(callToDecend(s));
        frequencyOfCharDescOrder(s1);
        System.out.println(callToDecend(s1));
    }

    static void frequencyOfCharDescOrder(String str) {
        str = str.replaceAll("\\s", "");
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int index = 0; index < str.length(); index++) {
            if(freqMap.containsKey(str.charAt(index))) {
                freqMap.put(str.charAt(index), freqMap.get(str.charAt(index))+1);
            } else {
                freqMap.put(str.charAt(index), 1);
            }
        }


        Map<Integer, List<Character>> multiMap = new HashMap<>();
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            List<Character> ch = new ArrayList<>();
            if(!multiMap.containsKey(entry.getValue())) {
                ch.add(entry.getKey());
                multiMap.put( entry.getValue(), ch);
            } else {
                ch = multiMap.get(entry.getValue());
                ch.add(entry.getKey());
                multiMap.put(entry.getValue(), ch);
            }
        }

        Map<Integer, List<Character>> result = multiMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        StringBuilder sb = new StringBuilder();
        result.entrySet().forEach(entry -> {
            List<Character> ch = entry.getValue();
            for(int i=0; i<ch.size(); i++) {
                for(int j=0; j<entry.getKey(); j++) {
                    sb.append(ch.get(i));
                }
            }
        });
        System.out.println(sb);

    }

    // Sol 2
    public static String callToDecend(String input){

        input = input.replaceAll(" ","").toLowerCase();

        String output = "";
        HashMap<Character, Integer> mapBuild = new HashMap<>();
        HashMap<Integer, List<Character>> mapBuildNew = new HashMap<>();
        List<Integer> repeats = new ArrayList<>();

        for (int i=0; i<input.length(); i++){

            if (mapBuild.get(input.charAt(i)) != null){
                mapBuild.put(input.charAt(i), mapBuild.get(input.charAt(i))+1);
            }
            else {
                mapBuild.put(input.charAt(i), 1);
            }

        }

        for (Character key: mapBuild.keySet()){
            if (!repeats.contains(mapBuild.get(key))){
                repeats.add(mapBuild.get(key));
            }

            if (mapBuildNew.get(mapBuild.get(key)) == null){
                mapBuildNew.put(mapBuild.get(key), new ArrayList<>(Arrays.asList(key)));
            }
            else {
                List<Character> newList = mapBuildNew.get(mapBuild.get(key));
                newList.add(key);
                mapBuildNew.put(mapBuild.get(key), newList);
            }

        }

        Collections.sort(repeats, Collections.reverseOrder());

        for (int z=0; z<repeats.size(); z++){
            Collections.sort(mapBuildNew.get(repeats.get(z)));
            for (int y=0; y<mapBuildNew.get(repeats.get(z)).size(); y++){

                for (int c =1; c<=repeats.get(z); c++){
                    output = output+mapBuildNew.get(repeats.get(z)).get(y);
                }

            }

        }

        return output;
    }

}

