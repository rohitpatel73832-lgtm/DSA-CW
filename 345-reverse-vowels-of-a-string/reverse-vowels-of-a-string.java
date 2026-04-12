class Solution {
    public String reverseVowels(String s) {
        char[] arr=s.toCharArray();
        HashSet<Character> st = new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));
        int i=0;
        int j= arr.length-1;
         while(i<j){
            if(st.contains(arr[i])){
                while(j>=i){
                    if(st.contains(arr[j])){
                        char temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return new String(arr);
    }
}