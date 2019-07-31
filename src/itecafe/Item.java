package itecafe;

public class Item {
    private int cate;
    private int no;
    private String name;
    private int price;
    
    public Item(int cate, int no, String name, int price){
        this.cate = cate;
        this.no = no;
        this.name = name;
        this.price = price;
    }
    
    public int getCate(){return cate;}
    public int getNo(){return no;}
    public String getName(){return name;}
    public int getPrice(){return price;}
    
    public void setNo(int no){this.no = no;}
    public void setName(String name){this.name = name;}
    public void setPrice(int price){this.price = price;}
    
}
