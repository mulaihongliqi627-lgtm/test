public class Person {
    String name;
    String gender;
    int age;
    public Person(String name,String gender,int age){
        this.name=name;
        this.gender=gender;
        this.age=age;
    }
    public String toString(){//重写toString
        return "["+name+","+gender+","+age+"]";
    }

    public static void main(String[] args) {
        Person person =new Person("红莉栖","女",18);
        System.out.println(person);


    }
}
