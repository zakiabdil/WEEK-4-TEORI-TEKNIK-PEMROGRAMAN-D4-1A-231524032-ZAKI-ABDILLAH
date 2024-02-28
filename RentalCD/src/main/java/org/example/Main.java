package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class RentalCD{
    private final int maxCapacity;
    private ArrayList<Disc> discs = new ArrayList<>();
    private static final String NOTENOUGH = "Not Enough Capacity";
    private int usedSpace;

    RentalCD(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.usedSpace = 0;
        discs = new ArrayList<>(maxCapacity);
    }

    public void tambahCD(MusicDisc[] musicDiscs){
        if (musicDiscs.length <= (maxCapacity-usedSpace)){
            int i = 0;
            while (i < musicDiscs.length){
                this.discs.add(this.usedSpace,musicDiscs[i]);
                i++;this.usedSpace++;
            }
        }else{
            System.out.println(NOTENOUGH);
        }
    }

    public void displayDisc(){
        //Disc
        String judul, kategori, publisher;
        int stok;
        //Music Disc
        String[] penyanyi, produser;
        String tophits;
        //Movie Disc
        String[] pemeran, sutradara;
        for (int i = 0;i < usedSpace;i++){
            if(discs.get(i) instanceof MusicDisc){
                //Music Disc
                judul = getDisc(i).getJudul();
                kategori = getDisc(i).getKategori();
                publisher = getDisc(i).getPublisher();
                stok = getDisc(i).getStok();
                penyanyi = ((MusicDisc) discs.get(i)).getPenyanyi();
                produser = ((MusicDisc) discs.get(i)).getProduser();
                tophits = ((MusicDisc) discs.get(i)).getTophits();
                System.out.println("Judul Album : "+judul+", Penyanyi Album : "+ Arrays.toString(penyanyi) +", Produser Album : "+ Arrays.toString(produser) +"\nTopHits : "+ tophits +", Publisher Album : "+publisher+"\nKategori Album : "+kategori+", Stok Album : "+stok+"\n");
            }else{
                //Movie Disc
                judul = getDisc(i).getJudul();
                kategori = getDisc(i).getKategori();
                publisher = getDisc(i).getPublisher();
                stok = getDisc(i).getStok();
                pemeran = ((MovieDisc) discs.get(i)).getPemeran();
                sutradara = ((MovieDisc) discs.get(i)).getSutradara();
                System.out.println("Judul Film : "+judul+", Sutradara Film : "+ Arrays.toString(sutradara) +"\nPemeran Film : "+ Arrays.toString(pemeran) +", Publisher Film : "+publisher+"\nKategori Film : "+kategori+", Stok Film : "+stok+"\n");
            }
        }
    }

    public void displayMusicDisc(){
        //Disc
        String judul, kategori, publisher;
        int stok;
        //Music Disc
        String[] penyanyi, produser;
        String tophits;
        for (int i = 0;i < usedSpace;i++){
            if(discs.get(i) instanceof MusicDisc){
                //Music Disc
                judul = getDisc(i).getJudul();
                kategori = getDisc(i).getKategori();
                publisher = getDisc(i).getPublisher();
                stok = getDisc(i).getStok();
                penyanyi = ((MusicDisc) discs.get(i)).getPenyanyi();
                produser = ((MusicDisc) discs.get(i)).getProduser();
                tophits = ((MusicDisc) discs.get(i)).getTophits();
                if (stok > 0){
                    System.out.println("Judul Album : "+judul+", Penyanyi Album : "+ Arrays.toString(penyanyi) +", Produser Album : "+ Arrays.toString(produser) +"\nTopHits : "+ tophits +", Publisher Album : "+publisher+"\nKategori Album : "+kategori+", Stok Album : "+stok+"\n");
                }
            }
        }
    }

    public void displayMovieDisc(){
        //Disc
        String judul, kategori, publisher;
        int stok;
        //Movie Disc
        String[] pemeran, sutradara;
        for (int i = 0;i < usedSpace;i++){
            if(discs.get(i) instanceof MovieDisc){
                //Movie Disc
                judul = getDisc(i).getJudul();
                kategori = getDisc(i).getKategori();
                publisher = getDisc(i).getPublisher();
                stok = getDisc(i).getStok();
                pemeran = ((MovieDisc) discs.get(i)).getPemeran();
                sutradara = ((MovieDisc) discs.get(i)).getSutradara();
                if (stok > 0){
                    System.out.println("Judul Film : "+judul+", Sutradara Film : "+ Arrays.toString(sutradara) +"\nPemeran Film : "+ Arrays.toString(pemeran) +", Publisher Film : "+publisher+"\nKategori Film : "+kategori+", Stok Film : "+stok+"\n");
                }
            }
        }
    }

    public void borrowDisc(String judul){
        int i = 0;
        boolean found = false;
        while ((i < usedSpace)&&(!found)){
            if (judul.toLowerCase().compareTo(getDisc(i).getJudul().toLowerCase()) == 0){
                found = true;
            }else{
                i++;
            }
        }
        if (found && getDisc(i).getStok() > 0){
            getDisc(i).setStok(getDisc(i).getStok() - 1);
            System.out.println("Borrowing Success! it will be mailed to you in about a day");
        }else {
            System.out.println("Make sure your input is correct or the DVD that you're looking for is not available");
        }
    }

    public Disc getDisc(int i) {
        return discs.get(i);
    }

    public void tambahCD(MovieDisc[] movieDiscs){
        if (movieDiscs.length <= (maxCapacity-usedSpace)){
            int i = 0;
            while (i < movieDiscs.length){
                this.discs.add(this.usedSpace,movieDiscs[i]);
                i++;this.usedSpace++;
            }
        }else{
            System.out.println(NOTENOUGH);
        }
    }

    public void tambahCD(MusicDisc musicDiscs){
        if(usedSpace != maxCapacity){
            this.discs.add(this.usedSpace,musicDiscs);
        }else{
            System.out.println(NOTENOUGH);
        }

    }

    public void tambahCD(MovieDisc movieDisc){
        if(usedSpace != maxCapacity){
            this.discs.add(this.usedSpace,movieDisc);
        }else{
            System.out.println(NOTENOUGH);
        }
    }

    public int getUsedSpace() {
        return usedSpace;
    }
}

class Disc{
    private String judul;
    private String publisher;
    private String kategori;
    private int stok;

    Disc(String judul, String publisher, String kategori, int stok){
        this.judul = judul;
        this.publisher = publisher;
        this.stok = stok;
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public String getKategori() {
        return kategori;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

class MusicDisc extends Disc{
    private String[] penyanyi;
    private String[] produser;
    private String tophits;

    MusicDisc(String judul, String[] penyanyi, String[] produser, String publisher, String tophits, String kategori, int stok){
        super(judul, publisher, kategori, stok);
        this.penyanyi = penyanyi;
        this.produser = produser;
        this.tophits = tophits;
    }

    MusicDisc(String judul, String penyanyi, String produser, String publisher, String tophits,String kategori, int stok){
        super(judul, publisher, kategori, stok);
        this.penyanyi = new String[1];
        this.penyanyi[0] = penyanyi;
        this.produser = new String[1];
        this.produser[0] = produser;
        this.tophits = tophits;
    }

    MusicDisc(){
        super("An Album","The Publisher","C",53);
        this.penyanyi = new String[1];
        this.penyanyi[0] = "A Singer";
        this.produser = new String[1];
        this.produser[0] = "A Producer";
        this.tophits = "A Classic";
    }

    public String getTophits() {
        return tophits;
    }

    public String[] getPenyanyi() {
        return penyanyi;
    }

    public String[] getProduser() {
        return produser;
    }
}

class MovieDisc extends Disc{
    private String[] pemeran;
    private String[] sutradara;
    MovieDisc(String judul, String[] pemeran, String[] sutradara, String publisher, String kategori, int stok){
        super(judul,publisher,kategori,stok);
        this.pemeran = pemeran;
        this.sutradara = sutradara;
    }

    MovieDisc(String judul, String[] pemeran, String sutradara, String publisher, String kategori, int stok){
        super(judul,publisher,kategori,stok);
        this.pemeran = pemeran;
        this.sutradara = new String[1];
        this.sutradara[0] = sutradara;
    }

    MovieDisc(){
        super("Classic","A Company","SU",113);
        this.pemeran = new String[]{"A Man","Another Man","Another Nother Man"};
        this.sutradara = new String[]{"A Man","Another Man"};
    }

    public String[] getPemeran() {
        return pemeran;
    }

    public String[] getSutradara() {
        return sutradara;
    }
}

public class Main {
    public static String InputString(){
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        return input;
    }

    public static int InputInteger(){
        int input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        return input;
    }

    public static void Run(RentalCD rentalCD){
        int input;
        String input2;
        boolean run = true;
        while (run){
            System.out.println("Welcome to Digital DVD Rental, What Do You Need?");
            System.out.println("1. Check Available DVD");
            System.out.println("2. Check Available Music DVD");
            System.out.println("3. Check Available Movie DVD");
            System.out.println("4. Borrow a DVD");
            System.out.println("5. Exit");
            System.out.print("Your choice : ");
            input = InputInteger();
            switch (input){
                case 1:
                    System.out.println("\nHere is the list of all of our available DVD");
                    rentalCD.displayDisc();
                    break;
                case 2:
                    System.out.println("\nHere is the list of all of our available Music DVD");
                    rentalCD.displayMusicDisc();
                    break;
                case 3:
                    System.out.println("\nHere is the list of all of our available Movie DVD");
                    rentalCD.displayMovieDisc();
                    break;
                case 4:
                    System.out.println("Enter The Title Of The DVD That You Want To Borrow!! Type 2 To Go Back To The Main Menu");
                    input2 = InputString();
                    if (input2.compareTo("2")!=0){
                        rentalCD.borrowDisc(input2);
                    }
                    System.out.println("\n");
                    break;
                case 5:
                    run = false;
                    break;
                default:System.out.println("Enter One Of The Choices Above");
            }
        }
    }

    public static void main(String[] args) {
        MusicDisc[] collection1 = new MusicDisc[13];
        MovieDisc[] collection2 = new MovieDisc[8];

        collection1[0] = new MusicDisc("21","Adele","XL Recordings","XL Recordings","Rolling in the Deep","P",10);
        collection1[1] = new MusicDisc("Back to Black","Amy Winehouse","Universal Music Group","Universal Music Group","Rehab","O",15);
        collection1[2] = new MusicDisc("Thriller","Michael Jackson","Epic Records","Epic Records","Beat It","O",18);
        collection1[3] = new MusicDisc("The Dark Side of the Moon","Pink Floyd","","Harvest Records","Money","R",20);
        collection1[4] = new MusicDisc("Divide","Ed Sheeran","Atlantic Records","Atlantic Records","Shape of You","P",15);
        collection1[5] = new MusicDisc("Random Access Memories","Daft Punk","Columbia Records","Columbia Records","Get Lucky","O",22);
        collection1[6] = new MusicDisc("Abbey Road","The Beatles","Apple Records","Apple Records","Come Together","R",17);
        collection1[7] = new MusicDisc("Legend","Bob Marley & The Wailers","Island Records","Island Records","No Woman, No Cry","R",19);
        collection1[8] = new MusicDisc("The Marshall Mathers LP","Eminem","Aftermath Entertainment","Aftermath Entertainment","The Real Slim Shady","R",14);
        collection1[9] = new MusicDisc("Hotel California","Eagles","Asylum Records","Asylum Records","Hotel California","R",13);
        collection1[10] = new MusicDisc("Rumours","Fleetwood Mac","Warner Bros. Records","Warner Bros. Records","Go Your Own Way","R",15);
        collection1[11] = new MusicDisc("In the Lonely Hour","Sam Smith","Capitol Records","Capitol Records","Stay with Me","P",16);
        collection1[12] = new MusicDisc("1989","Taylor Swift","Big Machine Records","Big Machine Records","Shake It Off","P",18);

        collection2[0] = new MovieDisc("The Shawshank Redemption", new String[]{"Tim Robbins", " Morgan Freeman"},"Frank Darabont","Warner Bros.","D",20);
        collection2[1] = new MovieDisc("The Godfather", new String[]{"Marlon Brando", "Al Pacino", "James Caan"},"Francis Ford Coppola","Paramount Pictures","D",15);
        collection2[2] = new MovieDisc("The Dark Knight", new String[]{"Christian Bale", "Heath Ledger", "Aaron Eckhart"},"Christopher Nolan","Warner Bros.","D",18);
        collection2[3] = new MovieDisc("Pulp Fiction", new String[]{"John Travolta", "Uma Thurman", "Samuel L. Jackson"},"Quentin Tarantino","Miramax Films","D",23);
        collection2[4] = new MovieDisc("Forrest Gump", new String[]{"Tom Hanks", "Robin Wright", "Gary Sinise"},"Robert Zemeckis","Paramount Pictures","D",16);
        collection2[5] = new MovieDisc("Inception", new String[]{" Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"},"Christopher Nolan","Warner Bros.","D", 20);
        collection2[6] = new MovieDisc("Fight Club", new String[]{"Brad Pitt", "Edward Norton", "Helena Bonham Carter"},"David Fincher","20th Century Fox","D",17);
        collection2[7] = new MovieDisc("The Matrix", new String[]{"Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"},"The Wachowskis","Warner Bros.","D",19);

        RentalCD rental1 = new RentalCD(100);
        rental1.tambahCD(collection1);
        rental1.tambahCD(collection2);
        //rental1.displayDisc();

        Run(rental1);
    }
}