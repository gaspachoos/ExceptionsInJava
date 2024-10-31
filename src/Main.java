import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DataLengthError,SexError,PhoneNumberError,NumberParsingError,DateError,FullNameError {

        Scanner in = new Scanner(System.in);

        String data = in.nextLine();

        String[] dataArray = data.split(" ");

        checkLengthOfData(dataArray);
        checkSexData(dataArray);
        checkValidPhoneNumber(dataArray);
        checkValidDate(dataArray);
        checkFullNameValidation(dataArray);
    }

    public static void checkLengthOfData(String[] data) throws DataLengthError {
        if(data.length != 6) {
            throw new DataLengthError();
        }

    }
    public static void checkSexData(String[] data) throws SexError {
        String maleOrFemale = null;
        for (String word : data) {
            if (word.equalsIgnoreCase("m") || word.equalsIgnoreCase("f")) {
                maleOrFemale = word;
            }

        }
        if (maleOrFemale == null) {
            throw new SexError();
        }
    }
    public static void checkNumberLength(long number) throws PhoneNumberError{
        String numberString = String.valueOf(number);
        if(numberString.length() != 11){
            throw new PhoneNumberError();
        }
    }
    public static void checkValidPhoneNumber(String[] data) throws NumberParsingError,PhoneNumberError {
        long phoneNumber = 0;
        for (String element : data) {

            try{
                phoneNumber = Long.parseLong(element);
                checkNumberLength(phoneNumber);
                break;
            }catch(NumberFormatException _){
            }

        }
        if(phoneNumber == 0){
            throw new NumberParsingError();
        }
    }
    public static void checkValidDate(String[] data) throws DateError {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate birthDate = null;

        for (String element : data) {
            try {
                birthDate = LocalDate.parse(element, formatter);
            }catch(DateTimeParseException _){
            }
        }
        if(birthDate == null){
            throw new DateError();
        }
    }
    public static void checkFullNameValidation(String[] data) throws FullNameError {
        String[] fullNameArray = new String[2];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i].length() > 1 |  Character.isUpperCase(data[i].charAt(0))){
                fullNameArray[j] = data[i];
                j++;
                if(j == 2){
                    break;
                }

            }
        }
        if (fullNameArray.length != 2){
            throw new FullNameError();
        }

    }

}
