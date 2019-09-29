package collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Dogs dogArr[];
        // dogArr = new Dogs[5];

        Dogs[] dogArr = new Dogs[5];

        System.out.println("*** Arrays ***");

        dogArr[0] = new Dogs("Springer", 50, false);
        dogArr[1] = new Dogs("Poodle", 13, true);
        dogArr[2] = new Dogs("Doberman", 27, false);
        dogArr[3] = new Dogs("Yorkie", 6, true);
        dogArr[4] = new Dogs("Corgie", 30, true);
        // dogArr[5] = new Dogs("Mutt", 20, true);
        System.out.println();
        System.out.println("*** For Loop ***");

        for (int i = 0; i < dogArr.length; i = i + 1) {
            System.out.println(dogArr[i]);
        }

        System.out.println("Breed 3 good for apartment? " + dogArr[3].isApartment());
        System.out.println();
        System.out.println(dogArr.toString());
        System.out.println();
        System.out.println(Arrays.toString(dogArr));
        System.out.println(dogArr[3].toString());
        System.out.println();

        // output
        // Dogs{breed='Springer', averageWeight=50, apartment=false}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Breed 3 good for apartment? true

        // [Lcollections.Dogs;@1e643faf

        // [Dogs{breed='Springer', averageWeight=50, apartment=false},
        // Dogs{breed='Poodle', averageWeight=13, apartment=true},
        // Dogs{breed='Doberman', averageWeight=27, apartment=false},
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}, Dogs{breed='Corgie',
        // averageWeight=30, apartment=true}]
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}

        System.out.println("*** Array Lists ***");
        ArrayList<Dogs> dogsArrayList = new ArrayList<Dogs>();
        dogsArrayList.addAll(Arrays.asList(dogArr));

        dogsArrayList.add(new Dogs("Mutt", 15, true));

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println();

        for (Dogs d : dogsArrayList) {
            if (d.getAvgWeight() >= 50) {
                System.out.println(d.getBreed() + " are large");
            } else {
                System.err.println(d.getBreed() + " are small");
            }
        }

        System.out.println();

        if (dogsArrayList.get(2).getBreed().equals("Turtle")) {
            System.out.println("We have a match");
        } else {
            System.out.println("No match for " + dogsArrayList.get(2).getBreed());
        }
        System.out.println("dogsArrayList is (size) " + dogsArrayList.size());

        System.out.println(dogsArrayList.get(3));
        dogsArrayList.remove(3);
        System.out.println(dogsArrayList.get(3));
        System.out.println("dogsArrayList is (size) " + dogsArrayList.size());
        System.out.println();

        Iterator<Dogs> iterator = dogsArrayList.iterator();
        while (iterator.hasNext()) {
            Dogs tempDog = iterator.next();
            System.out.println(tempDog);
        }
        System.out.println();
        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o1.getBreed().compareToIgnoreCase(o2.getBreed());
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println();

        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o1.getAvgWeight() - o2.getAvgWeight(); // returns asc
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println();

        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o2.getAvgWeight() - o1.getAvgWeight(); // returns desc
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println();

        // output
        // Dogs{breed='Springer', averageWeight=50, apartment=false}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}

        // Springer are large
        // Poodle are small
        // Doberman are small
        // Yorkie are small
        // Corgie are small
        // Mutt are small

        // No match for Doberman
        // dogsArrayList is (size) 6
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // dogsArrayList is (size) 5

        // Dogs{breed='Springer', averageWeight=50, apartment=false}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}

        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Springer', averageWeight=50, apartment=false}

        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Springer', averageWeight=50, apartment=false}

        // Dogs{breed='Springer', averageWeight=50, apartment=false}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}

        System.out.println("*** HashMaps ***");
        // HashMap<KEY, VALUE>
        HashMap<Integer, Dogs> dogsHashMap = new HashMap<Integer, Dogs>();

        int hashCount = 0;
        for (Dogs d : dogsArrayList) {
            // put takes the KEY, VALUE (add: if key doesn't exist, put: will add or replace
            // even if key exists)
            dogsHashMap.put(hashCount, d);
            hashCount++;
        }

        dogsArrayList.clear();

        System.out.println(dogsHashMap.get(3));
        System.out.println(dogsHashMap.size());
        dogsHashMap.remove(3);
        System.out.println(dogsHashMap.get(3));
        System.out.println(dogsHashMap.size());
        System.out.println();

        for (Integer i : dogsHashMap.keySet()) {
            System.out.println("key: " + i + ", value: " + dogsHashMap.get(i));
        }
        System.out.println();

        ArrayList<HashMap.Entry<Integer, Dogs>> sortedMap = new ArrayList<HashMap.Entry<Integer, Dogs>>();
        sortedMap.addAll(dogsHashMap.entrySet());

        Collections.sort(sortedMap, new Comparator<HashMap.Entry<Integer, Dogs>>() {
            public int compare(HashMap.Entry<Integer, Dogs> o1, HashMap.Entry<Integer, Dogs> o2) {
                return o1.getValue().getAvgWeight() - o2.getValue().getAvgWeight();
            }
        });
        for (HashMap.Entry<Integer, Dogs> d : sortedMap) {
            System.out.println("key: " + d.getKey() + ", value: " + d.getValue());
        }
        System.out.println();

        // output

        // Dogs{breed='Mutt', averageWeight=15, apartment=true}
        // 5
        // null
        // 4

        // key: 0, value: Dogs{breed='Springer', averageWeight=50, apartment=false}
        // key: 1, value: Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // key: 2, value: Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // key: 4, value: Dogs{breed='Poodle', averageWeight=13, apartment=true}

        // key: 4, value: Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // key: 2, value: Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // key: 1, value: Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // key: 0, value: Dogs{breed='Springer', averageWeight=50, apartment=false}

    }
}