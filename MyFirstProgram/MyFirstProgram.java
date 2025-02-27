import java.util.Scanner; // untuk bisa membuat dan menerima input dari user
import java.util.*; // untuk bisa pakai utility classes
import java.util.prefs.Preferences; //untuk memnyimpan facts yang sudah dipakai

public class MyFirstProgram { //mendefinisikan kelas utama dalam program karena tidak mengizinkan fungsi-fungsi yang berdiri sendiri jadi sebuah program java harus disimpan dalam suatu class
    public static void main(String[] args) { //sebagai titik masuk program
        //ini adalah array dimana saya simpan semua funfacts tentang java credit ke ken, krn sy malas cari fun factsnya pak
        String[] facts = {"Java is a case-sensitive language!",
                "Java was originally called Oak before being renamed!",
                "The mascot of Java is called Duke!",
                "Java's creator, James Gosling, is known as the father of Java!",
                "Java follows the 'Write Once, Run Anywhere' principle!",
                "The first version of Java was released in 1995!",
                "The name 'java' comes from a coffee grown on the Indonesian island of Java",
                "Android apps are primarily written in Java!",
                "Java does not support multiple inheritance directly!",
                "Java has automatic garbage collection to manage memory!",
                "Java was developed at Sun Microsystems!",
                "The 'main' method in Java must be inside a class!!",
                "Java programs are compiled into bytecode and run on the JVM!",
                "Java has a feature called Just-In-Time (JIT) compilation!",
                "Java supports multi-threading for parallel processing!",
                "The Java Development Kit (JDK) contains the Java compiler!",
                "Java SE, Java EE, and Java ME are different editions of Java!",
                "Java uses a strong type-checking mechanism!",
                "The default package in Java is java.lang!",
                "Java is among the most popular programming languages worldwide!"
        };
        String cyan = "\u001B[36m"; //untuk mewarnai string dengan warna biru muda
        String red = "\u001B[31m"; //untuk mewarnai string dengan warna merah
        String yellow = "\u001B[33m"; //untuk mewarnai string dengan warna kuning
        String blue = "\u001B[34m"; //untuk mewarnai string dengan warna biru
        String green = "\u001B[32m"; //untuk mewarnai string dengan warna hijau
        String reset = "\u001B[0m"; //untuk menyetel ulang wanra string agar tidak lanjut mewarnai string berikutnya
        String color; //untuk menetapkan color sebagai variabel string

        Scanner scanner = new Scanner(System.in); //untuk membuat objek scanner untuk membaca input dari user
        Random rand = new Random(); //membuat objek random untuk bisa menggunakan fungsi random
        Preferences pref = Preferences.userNodeForPackage(MyFirstProgram.class); // kode ini untuk buat ruang penyimpanan untuk funfacts yang sudah muncul sebelumnya

        String usedItemsString = pref.get("used_items", ""); //untuk baca facts yang tersimpan dalam penyimpanan, kalau belum ada maka akan kasih string yang kosong
        Set<String> usedItems = new HashSet<>(Arrays.asList(usedItemsString.split(","))); //mengubah string (fakta dari array yang dipisahkan dengan koma) menjadi hashset agar tidak ada duplikat dan memasukan string tersebut dalam arraylist useditems
        List<String> availableItems = new ArrayList<>(); //membuat arraylist baru untuk menyimpan fakta-fakta yang belum digunakan

        for (String item : facts) { //membaca semua string (fakta-fakta) yang ada di array
            if (!usedItems.contains(item)) {
                availableItems.add(item);
            } //kalau ada fakta yang belum dipakai, maka akan dimasukkan dalam arraylist available items
        }

        if (availableItems.isEmpty()) { //untuk mengecek apakah arraylist available items sudah kosong
            usedItems.clear(); //untuk mengosongkan arraylist useditems
            availableItems.addAll(Arrays.asList(facts)); //untuk memasukkan semua facts dalam arraylist availablleitems lagi
        }

        String fact = availableItems.get(rand.nextInt(availableItems.size())); // untuk mengambil fakta yang random di dalam array facts

        System.out.println(yellow + "Hello world!" + reset); //untuk mencetak kalimat "Hello World!" dalam terminal dengan warna kuning

        System.out.println("Hello there! Welcome to the world of Pokémon! My name is Oak! People call me the Pokémon Prof! This world is inhabited by creatures called Pokémon! For some people, Pokémon are pets. Others use them for fights. " +
                "\nMyself... I study Pokémon as a profession. First what's your name?"); //untuk mencetak string greeting bagiaan pertama
        System.out.print(red + "Enter Your Name: " + reset); //untuk mencetak kalimat "Enter Your Name: " dalam terminal dengan warna merah
        String name = scanner.nextLine(); //untuk membuat user menginput namanya
        System.out.println("Right! So yourp name is " + name + ". Welcome to the region of java, now before you start your journey." +
                " I would like you to choose your starter pokemon\n" + green + "1. rowlet\n" + red + "2. Torchic\n" + blue + "3. Piplup" + reset); //untuk mencetak string greeting bagian kedua
        while (true) {
            System.out.print("Choose your starter: "); //untuk mencetak string pertanyaan
            String n = scanner.nextLine().toLowerCase(); //untuk user bisa menginput jawaban mereka
            switch (n) {
                case "rowlet":
                case "1":
                    color = "\u001B[32m"; //untuk mengisi string color dengan kode warna hijau kalau user memilih 1
                    break;
                case "torchic":
                case "2":
                    color = "\u001B[31m"; //untuk mengisi string color dengan kode warna merah kalau user memilih 2
                    break;
                case "piplup":
                case "3":
                    color = "\u001B[34m"; //untuk mengisi string color dengan kode warna biru kalau user memilih 3
                    break;
                default:
                    System.out.println("Invalid Option"); //kalau jawaban user bukan 1,2 dan 3 maka akan dikasih tau invalid option
                    continue;
            } //untuk mengubah isi string color untuk warna string berikutnya berdasarkan pilihan user
            break;
        } //bagian pertanyaan akan terus mengulang kalo dijawab dengan cara yang salah contoh 4
        System.out.println(color + fact + reset); //untuk mencetak fun fact tentang java yang tadi dipilih secara random dengan warna yang terpilih dari switch case
        String version = System.getProperty("java.version"); //untuk mengambil versi java yang ada di komputer user
        System.out.print(cyan + "The current java version: " + version); ///untuk mencetak "The current java version: " bersama versi java yang didapat tadi dari komputer user
    }
}
