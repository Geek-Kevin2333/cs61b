public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if(x>y) {
            if(x==y+1)
            return true;
            return false;
        }
        if(x<y){
            if(x==y-1) return true;
            return false;
        }
        if(x==y)return false;
    return true;
    }
}
