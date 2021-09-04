package ood;

public class Person {
   public final String name;
   public final String id;
   
   public Person(String name, String id) {
       this.name = name;
       this.id = id;
   }

   public String getNews(Read read) {
       return read.getContent();
   }

   public static void main(String[] args) {
       Read news = new News();
       Read book = new Book();

       System.out.println(news.getContent());
       System.out.println(book.getContent());
   }
}
