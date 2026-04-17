class Box<T>{
    private T value;
    public void set(T value){
        this.value=value;}
    public T get(){
        return value;}
}
public class main{
    public static void main(String[] args){
        Box<Integer> intBox = new Box<>();
        intBox.set(7);
        System.out.println("Integer value "+ intBox.get());
        Box<String> strBox = new Box<>();
        strBox.set("Assignment");
        System.out.println("String value "+ strBox.get());
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(5.07);
        System.out.println("Double value "+ doubleBox.get());}}


