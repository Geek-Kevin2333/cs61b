public class OffByN implements CharacterComparator{
    int diff;
    public OffByN(int N){
    this.diff=N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        if(x+diff==y||x-diff==y) return true;
        return false;
    }
}
