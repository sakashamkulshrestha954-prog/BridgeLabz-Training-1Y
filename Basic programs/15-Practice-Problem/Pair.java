class Pair<T, U>{
    private T first;
    private U second;
    public Pair(T first , U second){
        this.first=first;
        this.second=second;}
        public T getFirst(){
            return first;}
        public U getSecond(){
            return second;}
    }
    public class main{
        public static void main(String[] args){
            Pair<String, Integer> student= new Pair<>("Anmol",20);
            System.out.println("Age " + student.getSecond());}
    }



