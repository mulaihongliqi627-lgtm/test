public class Date {
    public int year;
    public int month;
    public int day;
    public void setDate(int year,int month,int day){//设置日期
        this.year=year;
        this.month=month;
        this.day=day;
        this.printDate();
    }
    public Date(){
        this(2025,1,4);
    }

    @Override
    public String toString() {
        return "Date{" +
                "month=" + month +
                ", day=" + day +
                '}';
    }

    public Date(int year, int month, int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public void printDate(){//打印日期
        System.out.println("今天的日期是"+year+"/"+month+"/"+day);
    }

    public static void main(String[] args) {
        Date date=new Date();
        //date.printDate();
        System.out.println(date);
    }
}
