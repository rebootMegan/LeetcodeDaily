package walmart;


import java.util.HashMap;
import java.util.Map;

    public class TicketMatcher {
        public static void main(String[] argv) {
            String[][] users = {
                    {"John A.", "john.a@mail.com", "Top", "3"},
                    {"James S.", "j.s@mail.com", "Economy", "2"},
                    {"Stacy C.", "stacy.c@test.com", "Economy", "2"},
                    {"Bobby B.", "bob@mail.com", "Medium", "10"},
                    {"Michelle X.", "mix@test.com", "Medium", "10"},
                    {"Linda F.", "l.f@mail.com", "Top", "10"},
                    {"Betty T.", "b.t@mail.com", "ThreeEco", "1"},
                    {"Nancy L.", "n.l@test.com", "TwoEco", "1"},
                    {"Daniel O.", "d.o@mail.com", "OneEco", "1"},
                    {"Mike E.", "m.e@mail.com", "FourEco", "1"},
                    {"Matthew R.", "mr@test.com", "OneEco", "5"},
                    {"Albert K.", "albert@test.com", "OneEco", "5"}
            };

            String[][] payments = {
                    {"1", "john2@mail.com", "33"},
                    {"2", "michelle@mail.com", "60"},
                    {"4", "james@mail.com", "8"},
                    {"3", "stacy.c@test.com", "8"},
                    {"5", "bob@mail.com", "60"},
                    {"6", "email not found", "110"},
                    {"7", "email not found", "1"},
                    {"8", "email not found", "2"},
                    {"9", "email not found", "3"},
                    {"99", "email not found", "4"},
                    {"10", "mr@test.com", "5"},
                    {"11", "a@mail.com", "5"}
            };

            String[][] prices = {
                    {"Economy", "4"},
                    {"Top", "11"},
                    {"Medium", "6"},
                    {"OneEco", "1"},
                    {"TwoEco", "2"},
                    {"ThreeEco", "3"},
                    {"FourEco", "4"}
            };
            System.out.println(matching(users, payments, prices));
        }

        public static Map<String, String> matching(String[][] users, String[][] payments, String[][] prices) {
            Map<String, String> emailToName = new HashMap<>();
            Map<String, Integer> nameToPaymentAmount = new HashMap<>();
            Map<String, String> emailToPaymentId = new HashMap<>();
            Map<String, Integer> ticketToPrice = new HashMap<>();
            Map<Integer, String> amountToName = new HashMap<>();
            Map<String, String> result = new HashMap<>();

            // Fill in the maps
            for (String[] price : prices) {
                ticketToPrice.put(price[0], Integer.parseInt(price[1]));
            }

            for (String[] payment : payments) {
                emailToPaymentId.put(payment[1], payment[0]);
            }

            for (String[] user : users) {
                emailToName.put(user[1], user[0]);
                int totalAmount = Integer.parseInt(user[3]) * ticketToPrice.get(user[2]);
                nameToPaymentAmount.put(user[0], totalAmount);
                if (!emailToPaymentId.containsKey(user[1])) {
                    amountToName.put(totalAmount, user[0]);
                }
            }

            for (String[] payment : payments) {
                int amount = Integer.parseInt(payment[2]);
                if (emailToName.containsKey(payment[1])) {
                    result.put(payment[0], emailToName.get(payment[1]));
                } else if (amountToName.containsKey(amount)) {
                    result.put(payment[0], amountToName.get(amount));
                }
            }

            return result;
        }
    }