public class Date {
    public int year;
    public int month;
    public int day;
//    public void setDate(int y,int m,int d){
//        year=y;
//        month=m;
//        day=d;
//    }
    //当形参名字与成员变量名相同时,使用this引用
    public void setDate(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public Date(int year,int month,int day){//构造方法初始化
        this.year=year;
        this.month=month;
        this.day=day;
        System.out.println("Date(int ,int,int)方法被引用了");
    }


    public void printDate(){
        System.out.println(this.year+"/"+this.month+"/"+this.day);
    }

    public static void main(String[] args) {
        //构造三个日期类型的对象
        //Date day1=new Date();
        //Date day2=new Date();
        //Date day3=new Date();
        //设置日期
//        day1.setDate(2021,4,2);
//        day2.setDate(2022,6,6);
//        day3.setDate(2025,5,27);
//        //打印日期
//        day1.printDate();
//        day2.printDate();
//        day3.printDate();
        Date date=new Date(2025,5,27);
        date.printDate();
        //通过new对象后加.可以访问对象的属性
        System.out.println(date.year);
        System.out.println(date.month);
        System.out.println(date.day);


    }

}
