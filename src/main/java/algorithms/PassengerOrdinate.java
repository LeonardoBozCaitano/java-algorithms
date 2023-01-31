package algorithms;

import java.util.*;
import java.util.stream.Collectors;

// You work for the airline and you have a plane to fill.
// Your airline's boarding method simply lists passengers in a boarding order from 1-n where n is the number of seats on the plane.
//
// You are given an unsorted list of Passengers in the following format
// class Passenger(
//    name: String,
//    bookingReference: String,
//    loyaltyClass: Int
// )
// Please write a function accepts a flat unsorted list of passengers,
// and outputs a list of passengers in the correct boarding order.

// The correct boarding order: orders the groups by loyalty class, but the group enter together with the person with higher loyalty.

public class PassengerOrdinate {

    static class Passenger {
        String name;
        String bookingReference;
        Integer loyaltyClass;

        Passenger(String name, String booking, Integer loyalty) {
            this.name = name;
            this.bookingReference = booking;
            this.loyaltyClass = loyalty;
        }

        public Integer getLoyaltyClass() {
            return this.loyaltyClass;
        }

        public String getBooking() {
            return this.bookingReference;
        }
    }

    public static void main(String[] args) {
        successOrder();
    }

    private static void successOrder() {
        List<Passenger> inputList = new ArrayList<>();
        inputList.add(new Passenger("Name1 - booked alone on 4st class", "1", 4));
        inputList.add(new Passenger("Name2 - booked with a partner on 3st class", "2", 3));
        inputList.add(new Passenger("Name3 - booked with a partner on 3st class", "2", 8));

        inputList.add(new Passenger("Name4 - booked with the job friends on 1st class", "3", 1));
        inputList.add(new Passenger("Name5 - booked with the job friends on 1st class", "3", 2));
        inputList.add(new Passenger("Name6 - booked with the job friends on 1st class", "3", 3));
        inputList.add(new Passenger("Name7 - booked with the job friends on 1st class", "3", 5));

        inputList.add(new Passenger("Name8 - booked with the wife on 2st class", "5", 2));
        inputList.add(new Passenger("Name9 - booked with the wife on 2st class", "5", 6));

        List<Passenger> outputList = passengersOrder(inputList);

        System.out.println("The name4 to 7 should be the firsts");
        System.out.println("Then the name 8 and 9 ");
        System.out.println("Then the name 3 and 2 ");
        System.out.println("And then the 1 at the end");
        System.out.println("results:");
        outputList.forEach(pass -> System.out.println(pass.name));

    }

    private static List<Passenger> passengersOrder(List<Passenger> passengers) {
        List<Passenger> orderPassengers = new ArrayList<>();
        Map<String, List<Passenger>> map = passengers
                .stream()
                .collect(Collectors.groupingBy(Passenger::getBooking));

        map.values().stream()
                .sorted(Comparator.comparing(passGroup -> passGroup.stream()
                            .min(Comparator.comparing(
                                    Passenger::getLoyaltyClass
                            )
                        ).get().getLoyaltyClass()
                )
        ).forEach(orderPassengers::addAll);

        return orderPassengers;
    }
}



