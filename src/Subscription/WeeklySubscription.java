package Subscription;

import java.util.*;

public class WeeklySubscription {
    static List<List<Float>> allCombinations = new ArrayList<>();
    static List<List<Float>> combination = new ArrayList<>();
    static List<List<String>> result = new ArrayList<>();
    static Map<Float, String> storeExpense = new LinkedHashMap();

    static void totalExpense(Map<String, ArrayList<Float>> plans) {
        // storing total weeklyprice and newspaper in map
        for (Map.Entry<String, ArrayList<Float>> e : plans.entrySet()) {
            float sum = 0;
            ArrayList<Float> gettingPrice = e.getValue();
            for (Float f : gettingPrice)
                sum += f;
            storeExpense.put(sum, e.getKey());
        }
    }

    static void findCombination(int index, List<Float> weeklyExpense, float target, List<Float> temp) {
        // recursive method to find all combination


        if (index == weeklyExpense.size()) {
            allCombinations.add(new ArrayList<>(temp));
            return;
        }
        if (weeklyExpense.get(index) <= target) {
            temp.add(weeklyExpense.get(index));
            findCombination(index + 1, weeklyExpense, target - weeklyExpense.get(index), temp);
            temp.remove(temp.size() - 1);
        }
        findCombination(index + 1, weeklyExpense, target, temp);
    }

    static int lengthOf() {
        //finding length of combination which contain maximum newspaper
        int maxLen = Integer.MIN_VALUE;
        for (List<Float> f : allCombinations) {
            if (maxLen < f.size())
                maxLen = f.size();
        }
        return maxLen;
    }

    static void printPaperCombination(List<List<Float>> combination) {
        //method to print newspaper
        for (List<Float> f : combination) {
            List<String> temp = new ArrayList<>();
            for (Float aF : f) {
                temp.add(storeExpense.get(aF));
            }
            result.add(new ArrayList<>(temp));
        }
    }

    /* --- main Method --- */
    public static void main(String[] args) {
        try {

            int totalNewsPaper = 5, numberOfDays = 7;

            /*
             * using Map to store newspaper and it's weekly price where newspaper is
             * the key and weekly
             * price is value in the form of arraylist
             */
            Map<String, ArrayList<Float>> plans = new LinkedHashMap<String, ArrayList<Float>>();
            plans.put("TOI", new ArrayList<Float>());
            plans.put("Hindu", new ArrayList<Float>());
            plans.put("ET", new ArrayList<Float>());
            plans.put("BM", new ArrayList<Float>());
            plans.put("HT", new ArrayList<Float>());

            /* --- putting price value of each newspaper --- */
            plans.get("TOI").add(3f);
            plans.get("TOI").add(3f);
            plans.get("TOI").add(3f);
            plans.get("TOI").add(3f);
            plans.get("TOI").add(3f);
            plans.get("TOI").add(5f);
            plans.get("TOI").add(6f);

            plans.get("Hindu").add(2.5f);
            plans.get("Hindu").add(2.5f);
            plans.get("Hindu").add(2.5f);
            plans.get("Hindu").add(2.5f);
            plans.get("Hindu").add(2.5f);
            plans.get("Hindu").add(4f);
            plans.get("Hindu").add(4f);

            plans.get("ET").add(4f);
            plans.get("ET").add(4f);
            plans.get("ET").add(4f);
            plans.get("ET").add(4f);
            plans.get("ET").add(4f);
            plans.get("ET").add(4f);
            plans.get("ET").add(10f);

            plans.get("BM").add(1.5f);
            plans.get("BM").add(1.5f);
            plans.get("BM").add(1.5f);
            plans.get("BM").add(1.5f);
            plans.get("BM").add(1.5f);
            plans.get("BM").add(1.5f);
            plans.get("BM").add(1.5f);

            plans.get("HT").add(2f);
            plans.get("HT").add(2f);
            plans.get("HT").add(2f);
            plans.get("HT").add(2f);
            plans.get("HT").add(2f);
            plans.get("HT").add(4f);
            plans.get("HT").add(4f);

            /*
             * finding total weekly expense of individual newspaper and storing it in Map
             * where "total weekly expense" is key and it's particular newspaper is the
             * value
             */

            totalExpense(plans); // Function calling to add weekly expense and storing it in map

            /*
             * Getting total weekly expense and storing them in Arraylist
             * for Test case 1: input 40
             * Set "weekly" will contain [26,20.5,34,10.5,18] in set form...
             * I have converted them in arraylist for my ease so my weeklyExpense list will
             * be { 26,20.5,34,10.5,18}
             */

            Set<Float> weekly = storeExpense.keySet();
            ArrayList<Float> weeklyExpense = new ArrayList<Float>(weekly);

            /* --------- Now checking possible combinations for given Budget------------ */
            float target = 10;
            findCombination(0, weeklyExpense, target, new ArrayList<>()); // doing recursive call for budget 40

            /*
             * There could be many possibilities but i have to find maximum length newspaper
             * combination i can buy in given budget
             */

            int maxLenSubset = lengthOf(); // calling lengthOf method and adding in list "combination"
            for (List<Float> f : allCombinations) {
                if (f.size() == maxLenSubset)
                    combination.add(f);
            }

            /*
             * In List "combination" possible combination is present in
             * {{26,10.5},{10.5,18},{10.5,20.5},{20.5,18}}
             * form but i have to print it's newspaper name
             * so i will need the help of Map "storeExpense"...where i have stored the
             * newspaper name as value
             * and sum(total weekly expense) as key
             */

            // Printing Final answer........
            printPaperCombination(combination); // Method Calling..

            if (result.get(0).size() == 0)    // If budget is not enough
                System.out.println("Not Enough Budget!!");
            else System.out.println(result);


        } catch (Exception e) {
            return;
        }
    }
}

