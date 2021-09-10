public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque ans =new LinkedListDeque();
        for(int i=0;i<word.length();i++){
            ans.addLast(word.charAt(i));
        }
        return ans;
    }

    public boolean isPalindrome(String word){
        Deque temp=wordToDeque(word);
        for(int i=0;i<word.length()/2;i++){
            if(temp.get(i)!=temp.get(word.length()-1-i)) return false;
        }
        return true;
    }

    public boolean isPalindrome(String word,CharacterComparator cc){
        Deque temp=wordToDeque(word);
        for (int i=0;i<word.length()/2;i++){
            char a= (char) temp.get(i);
            char b=(char) temp.get(word.length()-1-i);
            if(cc.equalChars(a,b)==false) return false;
        }
        return true;
    }
}
