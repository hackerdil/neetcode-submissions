class Solution {
    private static final int indexSlide = 5;
    private static final String separator = "_";
    public String slideForward(String s){
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
           arr[i] +=  indexSlide;
        }
        return new String(arr);
    }
    public String slideBackward(String s){
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
           arr[i] -=  indexSlide;
        }
        return new String(arr);
    }
    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return null;
        }
        int[] sizes = new int[strs.size()];
        int counter = 0;
        for(String s:strs){
            sizes[counter] = s.length();
            counter++;
        }
        String sizesString = String.valueOf(strs.size()) + separator;
        for(int i : sizes){
            sizesString+=String.valueOf(i)+separator;
        }
        
        String encodedString = sizesString + "_";
        /*for(String s:strs){
            encodedString +=slideForward(s);
        }*/
        for(String s:strs){
            encodedString +=s;
            }
        
        return encodedString;
    }

    public List<String> decode(String str) {
        
        System.out.println(str);
        List<String> result = new ArrayList<>();
        if(str == null){
            return result;
        }
        char[] charArr = str.toCharArray();


        int sizeStartIndex =0;
        int stringStartIndex =0;
        int numberOfStrings = 0;
        for(int i = 0;i < charArr.length; i++){
            if(charArr[i] == separator.toCharArray()[0]){
                sizeStartIndex = i+1;
                break;
            }
            numberOfStrings = numberOfStrings*10 + (charArr[i] - '0');
        }
        int[] stringSizes = new int[numberOfStrings];
       
        int counter = 0;
        for(int i = sizeStartIndex; i<charArr.length; i++){
            if(charArr[i] == separator.toCharArray()[0]){
                if(charArr[i+1] == separator.toCharArray()[0]){
                    stringStartIndex = i+2;
                    break;
                }
                else{
                    counter++;
                    continue;
                }
            }
            stringSizes[counter] = stringSizes[counter] *10 + (charArr[i] - '0');
            
        }
        
        String str1 = "";
        int indexCounter = 0;
        counter = 0;
        // sadece bos
        // bosla biten
        boolean isNull = true;
        for(int n : stringSizes){
            if(n!=0){isNull=false;
            break;}
        }
        if(isNull){
            for(int i = 0; i< stringSizes.length; i++){
                result.add(new String(""));
            }
            return result;
        }
        System.out.println(stringStartIndex);
         for(int i = stringStartIndex; i< charArr.length; i++){
            
           if(counter == stringSizes[indexCounter]){
            counter = 0;
            result.add(str1);
            indexCounter++;
            str1 = "";
            i--;
           }
           else{
            counter++;
            str1 += charArr[i];
            
           }
           if(i+1 == charArr.length){
                
                result.add(str1);
               if(indexCounter+1<stringSizes.length) {
                if(stringSizes[indexCounter+1] == 0){

                for(int j = indexCounter+1; j < stringSizes.length ; j++){
                    result.add(new String(""));
                }
            }
            }
                break;
            }
            
         }
         /*for(int i = 0; i<result.size();i++){
            result.set(i, slideBackward(result.get(i)));
         }*/
         for(int i = 0; i<result.size();i++){
            result.set(i, result.get(i));
         }
         
        return result;
    }
}
