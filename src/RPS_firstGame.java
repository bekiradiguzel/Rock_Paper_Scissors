import java.util.Random;
import java.util.Scanner;

public class RPS_firstGame {
    public static void main(String[] args) {
        int wins = 0, loss = 0, ties = 0;

        Scanner scanner = new Scanner(System.in); //1. While Loop'u. Scanner'ı her defasında yaratmamak için While Loop'u dışına çıkardık.


        while (true) { //bu EN tepedeki 1. While Loop'u
            String[] rps = {"t", "k", "m"};
            String bilgisayarınSecimi = rps[new Random().nextInt(rps.length)];
            String oyuncuSecimi;// player inputs the choice
            //rps.length is 3 but it will give us
            // 0,1,2 index numbers
            // System.out.println(rps.length);
            while (true) {
                System.out.println("TAŞ-KAĞIT-MAKAS OYUNU\nLütfen, Seçiminizi yapın!\nTaş için: t \nKağıt için: k \nMakas için: m");
                oyuncuSecimi = scanner.nextLine();
                if (oyuncuSecimi.equals("t") || oyuncuSecimi.equals("k") || oyuncuSecimi.equals("m")) {
                    break;
                }
                System.out.println(oyuncuSecimi + " geçerli bir seçim değil.");
            }
            System.out.println("Bilgisayarın Secimi: " + bilgisayarınSecimi);
            //BERABERE OLDUĞU DURUM
            if (oyuncuSecimi.equals(bilgisayarınSecimi)) {
                System.out.println("Oyun berabere. \nİkiniz de aynı şeyi seçtiniz :) ");
                ties++;
            }
            // 1. İF Blokumuz / Oyuncu Seçimi: TAŞ  VS kağıt
            else if (oyuncuSecimi.equals("t")) {
                if (bilgisayarınSecimi.equals("k")) {

                    System.out.println("Kaybettin!  \nKağıt  Taşı Yener! :(");
                    loss++;
                    //taş VS makas
                } else if (bilgisayarınSecimi.equals("m")) {
                    System.out.println(" Kazandın! :) \nTaş Makas'ı Yener ");
                    wins++;
                }
            }
            // 2. İF Blokumuz / Oyuncu Seçimi:KAĞIT VS taş
            else if (oyuncuSecimi.equals("k")) {
                if (bilgisayarınSecimi.equals("t")) {
                    System.out.println("Kazandın! :) ");
                    wins++;
                } else if (bilgisayarınSecimi.equals("m")) { //taş VS makas
                    System.out.println("Kaybettin. \nMakas Kağıdı Yener! :( ");
                    loss++;
                }
            }
            // 3. İF Blokumuz / Oyuncu Seçimi:MAKAS VS taş
            else if (oyuncuSecimi.equals("m")) {
                if (bilgisayarınSecimi.equals("k")) {
                    System.out.println(" Kazandın! :)  \n Kağıt Makas'ı keser ");
                    wins++;
                } else if (bilgisayarınSecimi.equals("t")) { //makas VS taş
                    System.out.println("Kaybettin! :( \n Makas'ın Taş tafından parçalandı. ");
                loss++;
                }
            }

            System.out.println("Yeniden oynamak ister misin?\nEvet için :e \nHayır için: h ");
            String yenidenOyna = scanner.nextLine();
            if (!yenidenOyna.equals("e")) {
                System.out.println("Tekrar görüşümek  üzere, \nBy By... ");
                break;
            }
        }
        System.out.println("Toplam Zafer : " +wins);
        System.out.println("Toplam Yenilgi : " +loss);
        System.out.println("Toplam Berabere : " +ties);

        scanner.close();
    }
}