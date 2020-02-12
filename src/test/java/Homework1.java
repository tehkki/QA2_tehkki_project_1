import org.junit.jupiter.api.Test;

public class Homework1 {
    @Test
    public void answerIs() {
        carSale("Икарус","31415926","0.005");
        flyCost(2.54,68.50,1247.5);
        birthdayDate("111290-10415");
        mapDistance(40.6892,74.0445,40.7484, 73.9857);
    }

    private void carSale(String carBrand, String mileage, String cost){
        int mileageToInt = Integer.parseInt(mileage);
        double costToDouble = Double.parseDouble(cost);

        System.out.println("Продаю машину «" + carBrand + "» с пробегом " + mileageToInt + " за " + costToDouble + " денег!");
    }

    private void flyCost(double fuelCost, double consumption, double distance){
        double spentMoney = fuelCost * (consumption / 100) * distance;
        double roundedSpentMoney = Math.round(spentMoney*100.0)/100.0;

        System.out.println("Всего на перелет потратили " + roundedSpentMoney + " денег");
    }

    private void birthdayDate(String personalCode){
        String day = personalCode.substring(0, 2);
        int month = Integer.parseInt(personalCode.substring(2, 4));
        String year = personalCode.substring(4, 6);

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

    private double radians(double degrees){
        double pi = 3.1415926;
        return degrees * pi / 180;
    }

    private void mapDistance(double latitude, double longitude, double latitude2, double longitude2){
        double degreesLongitude = radians(longitude2 - longitude);
        double degreesLatitude = radians(latitude2 - latitude);

        double formula = (Math.sin(degreesLatitude / 2) * Math.sin(degreesLatitude / 2)) + Math.cos(radians(latitude)) * Math.cos(radians(latitude2)) * (Math.sin(degreesLongitude / 2) * Math.sin(degreesLongitude / 2));
        double angle = 2 * Math.atan2(Math.sqrt(formula), Math.sqrt(1 - formula));
        int earthRadius = 6371;
        double answer =  angle * earthRadius;
        double roundedAnswer = Math.round(answer*100.0)/100.0;

        System.out.println("Расстояние между этими двумя точками " + roundedAnswer + " км.");

    }
}
