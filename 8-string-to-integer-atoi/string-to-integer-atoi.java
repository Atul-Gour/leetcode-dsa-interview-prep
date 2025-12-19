class Solution {
    public int myAtoi(String s) {
        int n  = s.length();
        
        int index = 0;
        while(index < n && s.charAt(index)==' '){
            index++;
        }
        if(index>=n)return 0;
        char c= s.charAt(index);
        if(Character.isLetter(c))return 0;

        boolean isNegative = false;

        if(s.charAt(index)=='-' || s.charAt(index)=='+'){
            if(s.charAt(index)=='-') isNegative = true;
            index++;
        }

        StringBuilder sb = new StringBuilder();
        while(index<n && Character.isDigit(s.charAt(index))){

            if (sb.length() != 0){
                long num = Long.parseLong(sb.toString());

                if(isNegative){
                    num= num * -1;
                    if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
                else if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }

            sb.append(s.charAt(index));
            index++;
        }
        if (sb.length() == 0) return 0;

        long num = Long.parseLong(sb.toString());

        if(isNegative){
            num= num * -1;
            if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        else if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int)num;
    }
}       