import org.junit.jupiter.api.Test;

import java.util.Date;

public class Homework1 {
    @Test
    public void answerIs() {
        //Task 1:
        tachkaSale("Икарус","31415926","0.005");
        //Task 2:
        ticketToRide(2.54,68.50,1247.5);
        //Task 3:
        howOldAmI("111290-10415");
        //Task 4*:
    }


    private void tachkaSale(String marka, String probeg, String cena){
        int prbegToInt = Integer.parseInt(probeg);
        double cenaToDouble = Double.parseDouble(cena);

        System.out.println("Продаю машину «" + marka + "» с пробегом " + prbegToInt + " за " + cenaToDouble + " денег!");
    }

    private void ticketToRide(double cenaSolarki, double rashod, double distance){
        double denegPotratili = cenaSolarki * (rashod / 100) * distance;
        double roundedDenegPotratili = Math.round(denegPotratili*100.0)/100.0;

        System.out.println("Всего на перелет потратили " + roundedDenegPotratili + " денег");
        //System.out.println("Всего на перелет потратили " + denegPotratili + " денег");
    }

    private void howOldAmI(String persKod){
        String day = persKod.substring(0, 2);
        int month = Integer.parseInt(persKod.substring(2, 4));
        String year = persKod.substring(4, 6);

        String monthString = "... хммм, подожди ка, ты не родился ни в какой месяц";
        if( month == 1){
            monthString = "января";
        }
        else if (month == 2){
            monthString = "февраля";
        }
        else if (month == 3){
            monthString = "марта";
        }
        else if (month == 4){
            monthString = "апреля";
        }
        else if (month == 5){
            monthString = "мая";
        }
        else if (month == 6){
            monthString = "июня";
        }
        else if (month == 7){
            monthString = "июля";
        }
        else if (month == 8){
            monthString = "августа";
        }
        else if (month == 9){
            monthString = "сентября";
        }
        else if (month == 10){
            monthString = "октября";
        }
        else if (month == 11){
            monthString = "ноября";
        }
        else if (month == 12){
            monthString = "декабря";
        }

        System.out.println("Твоя дата рождения " + day + " " + monthString + " 19" + year + " года!");
    }

//    private void navigator(double shirota1, double dolgota1, double shirota2, double dolgota1){
//
//    }
    
}
