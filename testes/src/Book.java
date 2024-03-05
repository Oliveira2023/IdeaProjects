public class Book implements Comparable<Book> {
    public String nome;
    public double price;
    public Book(String name, double cost) {
        this.nome = name;
        this.price = cost;
    }
    @Override
    public int compareTo(Book book){
        int lenB = nome.length();
        int lenb = book.nome.length();
        int minlen = Math.min(lenb, lenB);

        for (int i = 0; i< minlen; i++){
            int str1 = (int)nome.charAt(i);
            int str2 = (int)book.nome.charAt(i);

            if (str1 != str2){
                System.out.println("loop for !=");
                return str1 - str2;
            }
        }
        if (lenB != lenb){
            System.out.println("loop for len");
            return lenB - lenb;
        } else {
            System.out.println("loop str iguais");
            return 0;
        }

    }
}
