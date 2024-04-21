import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Calendar;
import java.time.DateTimeException;
import java.util.InputMismatchException;

public class IncomingPassenger {
    private String firstName;
    private String lastName;
    public String countryOfOrigin;
    public LocalDate departureDate;

    public IncomingPassenger(String firstName, String lastName, String countryOfOrigin, LocalDate departureDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryOfOrigin = countryOfOrigin;
        this.departureDate = departureDate;
    }

    public static String firstName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger's first name: ");
        return scanner.nextLine().trim();
    }

    public static String lastName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger's last name: ");
        return scanner.nextLine().trim();
    }

    public static String country() {
        Scanner scanner = new Scanner(System.in);
        String[] allCountries = new String[]{"afghanistan", "albania", "algeria", "american samoa", "andorra", "angola", "anguilla", "antarctica", "antigua and barbuda", "argentina", "armenia", "aruba", "australia", "austria", "azerbaijan", "bahamas", "bahrain", "bangladesh", "barbados", "belarus", "belgium", "belize", "benin", "bermuda", "bhutan", "bolivia", "bosnia and herzegowina", "botswana", "bouvet island", "brazil", "british indian ocean territory", "brunei darussalam", "bulgaria", "burkina faso", "burundi", "cambodia", "cameroon", "canada", "cape verde", "cayman islands", "central african republic", "chad", "chile", "china", "christmas island", "cocos (keeling) islands", "colombia", "comoros", "congo", "congo, the democratic republic of the", "cook islands", "costa rica", "cote d'ivoire", "croatia (hrvatska)", "cuba", "cyprus", "czech republic", "denmark", "djibouti", "dominica", "dominican republic", "east timor", "ecuador", "egypt", "el salvador", "equatorial guinea", "eritrea", "estonia", "ethiopia", "falkland islands (malvinas)", "faroe islands", "fiji", "finland", "france", "france metropolitan", "french guiana", "french polynesia", "french southern territories", "gabon", "gambia", "georgia", "germany", "ghana", "gibraltar", "greece", "greenland", "grenada", "guadeloupe", "guam", "guatemala", "guinea", "guinea-bissau", "guyana", "haiti", "heard and mc donald islands", "holy see (vatican city state)", "honduras", "hong kong", "hungary", "iceland", "india", "indonesia", "iran (islamic republic of)", "iraq", "ireland", "israel", "italy", "jamaica", "japan", "jordan", "kazakhstan", "kenya", "kiribati", "korea, democratic people's republic of", "korea, republic of", "kuwait", "kyrgyzstan", "lao, people's democratic republic", "latvia", "lebanon", "lesotho", "liberia", "libyan arab jamahiriya", "liechtenstein", "lithuania", "luxembourg", "macau", "macedonia, the former yugoslav republic of", "madagascar", "malawi", "malaysia", "maldives", "mali", "malta", "marshall islands", "martinique", "mauritania", "mauritius", "mayotte", "mexico", "micronesia, federated states of", "moldova, republic of", "monaco", "mongolia", "montserrat", "morocco", "mozambique", "myanmar", "namibia", "nauru", "nepal", "netherlands", "netherlands antilles", "new caledonia", "new zealand", "nicaragua", "niger", "nigeria", "niue", "norfolk island", "northern mariana islands", "norway", "oman", "pakistan", "palau", "panama", "papua new guinea", "paraguay", "peru", "philippines", "pitcairn", "poland", "portugal", "puerto rico", "qatar", "reunion", "romania", "russian federation", "rwanda", "saint kitts and nevis", "saint lucia", "saint vincent and the grenadines", "samoa", "san marino", "sao tome and principe", "saudi arabia", "senegal", "seychelles", "sierra leone", "singapore", "slovakia (slovak republic)", "slovenia", "solomon islands", "somalia", "south africa", "south georgia and the south sandwich islands", "spain", "sri lanka", "st. helena", "st. pierre and miquelon", "sudan", "suriname", "svalbard and jan mayen islands", "swaziland", "sweden", "switzerland", "syrian arab republic", "taiwan, province of china", "tajikistan", "tanzania, united republic of", "thailand", "togo", "tokelau", "tonga", "trinidad and tobago", "tunisia", "türkiye", "turkmenistan", "turks and caicos islands", "tuvalu", "uganda", "ukraine", "united arab emirates", "united kingdom", "united states", "united states minor outlying islands", "uruguay", "uzbekistan", "vanuatu", "venezuela", "vietnam", "virgin islands (british)", "virgin islands (u.s.)", "wallis and futuna islands", "western sahara", "yemen", "yugoslavia", "zambia", "zimbabwe"};

        List<String> allCountriesList = Arrays.asList(allCountries);

        while (true) {
            System.out.print("Which country are you coming from? ");
            String countryInput = scanner.nextLine().trim().toLowerCase();
            if (countryInput.isEmpty()) {
                System.out.println("Cannot be empty");
                System.out.println();
            } else if (countryInput.matches("[a-zA-Z\\s-()]+")) {
                if (allCountriesList.contains(countryInput)) {
                    return countryInput;
                } else {
                    System.out.println("Country not found in database.");
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input. Please enter alphabets, spaces, hyphens, and parentheses only.");
                System.out.println();
            }
        }
    }

    public static LocalDate departureDateInput() {
        LocalDate departDate = LocalDate.now();

        int current_year = Calendar.getInstance().get(Calendar.YEAR);
        int current_month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int current_day = Calendar.getInstance().get(Calendar.DATE);

        int year = 0;
        int month = 0;
        int day = 0;

        Scanner scan = new Scanner(System.in);

        boolean check = true;
        boolean sub_check1 = true;
        boolean sub_check2 = true;
        boolean sub_check3 = true;

        while (check) {
            check = false;

            while (sub_check1) {
                sub_check1 = false;
                System.out.println();
                System.out.print("In which year(yyyy) you will be flying in? ");
                try {
                    year = scan.nextInt();
                    if (year < current_year) {
                        System.out.println("Did you travel from the past?");
                        sub_check1 = true;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Only accept numeric input.");
                    sub_check1 = true;
                    scan.next();
                }
            }

            while (sub_check2) {
                sub_check2 = false;
                System.out.println();
                System.out.print("In which month(mm) you will be flying in? ");
                try {
                    month = scan.nextInt();
                    if (year <= current_year && month < current_month) {
                        System.out.println("Did you travel from the past?");
                        sub_check2 = true;
                    } else if (month < 1 || month > 12) {
                        System.out.println("The input is invalid.");
                        sub_check2 = true;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Only accept numeric input.");
                    sub_check2 = true;
                    scan.next();
                }
            }

            while (sub_check3) {
                sub_check3 = false;
                System.out.println();
                System.out.print("On which day(dd) of the month you will be flying in? ");
                try {
                    day = scan.nextInt();
                    if (year == current_year && month == current_month && day < current_day) {
                        System.out.println("Did you travel from the past?");
                        sub_check3 = true;
                    } else if (day >= 1 && day <= 31) {
                        if (year % 4 == 0 && month == 2) {
                            if (day > 29) {
                                System.out.println("The input is invalid.");
                                sub_check3 = true;
                            }
                        } else if (year % 4 != 0 && month == 2) {
                            if (day > 28) {
                                System.out.println("The input is invalid.");
                                sub_check3 = true;
                            }
                        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                            if (day > 30) {
                                System.out.println("The input is invalid.");
                                sub_check3 = true;
                            }
                        }
                    } else {
                        System.out.println("The input is either illogical or invalid.");
                        sub_check3 = true;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Only accept numeric input.");
                    sub_check3 = true;
                    scan.next();
                }
            }

            try {
                departDate = LocalDate.of(year, month, day);
            } catch (DateTimeException exception) {
                check = true;
            }

            if (check) {
                System.out.println("Invalid date.");
            }
        }

        return departDate;
    }

    public void determineQuarantinePeriod() {
        int rank = countryRank(countryOfOrigin);
        int quarantinePeriod;

        switch (rank) {
            case 10:
                quarantinePeriod = 21;
                break;
            case 8:
                quarantinePeriod = 14;
                break;
            case 7:
                quarantinePeriod = 14;
                break;
            case 6:
                quarantinePeriod = 10;
                break;
            default:
                quarantinePeriod = 7;
        }

        System.out.println("\nYou are from " + countryOfOrigin + ", traveled on " + departureDate + ", and your quarantine period is " + quarantinePeriod + " days.");
    }

    public int countryRank(String departCountry) {
        int rank;
        switch (departCountry) {
            case "france":
            case "spain":
            case "italy":
            case "united kingdom":
            case "united states":
                rank = 10;
                break;
            case "india":
                rank = 8;
                break;
            case "brazil":
                rank = 7;
                break;
            case "russia":
                rank = 6;
                break;
            default:
                int min = 1;
                int maxCountryRank = 5;
                rank = (int) ((Math.random() * (maxCountryRank - min + 1)) + min);
        }
        return rank;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get passenger details
        String firstName = IncomingPassenger.firstName();
        String lastName = IncomingPassenger.lastName();
        System.out.println();
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println();

        String departCountry = IncomingPassenger.country();
        LocalDate departDate = IncomingPassenger.departureDateInput();

        // Create an instance of IncomingPassenger
        IncomingPassenger passenger = new IncomingPassenger(firstName, lastName, departCountry, departDate);

        // Determine quarantine period and display information
        passenger.determineQuarantinePeriod();
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }
}
