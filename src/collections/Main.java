package collections;

import java.util.*; // Arrays are part of Java utilities, * will pull all utilities

public class Main {
    public static void main(String[] args) {

        // --- *** Arrays *** --- //
        // fixed index -> it has to be an integer
        // fixed element type
        // fixed length
        // Find length with .length for arrays

        // --- *** ArrayList *** --- //
        // fixed index
        // fixed element type
        // varied length
        // keep their order
        // Find length with .size() for ArrayList

        // --- *** HashMaps *** --- //
        // choice in index (can be any data type)
        // fixed element type
        // varied length

        System.out.println("*** Arrays ***");
        // You can initialize an Array like this:
        // Dogs dogArr[];
        // dogArr = new Dogs[5];

        // Or like this:
        Dogs[] dogArr = new Dogs[5];

        // Instantiate new dogs in your Array
        dogArr[0] = new Dogs("Springer", 50, false);
        dogArr[1] = new Dogs("Poodle", 13, true);
        dogArr[2] = new Dogs("Doberman", 27, false);
        dogArr[3] = new Dogs("Yorkie", 6, true);
        dogArr[4] = new Dogs("Corgie", 30, true);
        // dogArr[5] = new Dogs("Mutt", 20, true); // won't add because Array is limited
        // to 5 items
        System.out.println();

        System.out.println("*** For Loop ***");

        for (int i = 0; i < dogArr.length; i = i + 1) {
            System.out.println(dogArr[i]);
        }
        System.out.println();
        // Dogs{breed='Springer', averageWeight=50, apartment=false}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}

        System.out.println("Breed 3 good for apartment? " + dogArr[3].isApartment());
        System.out.println();

        // Breed 3 good for apartment? true

        System.out.println(dogArr.toString());
        System.out.println();

        // [Lcollections.Dogs;@1e643faf

        System.out.println(Arrays.toString(dogArr));
        System.out.println();
        // [Dogs{breed='Springer', averageWeight=50, apartment=false},
        // Dogs{breed='Poodle', averageWeight=13, apartment=true},
        // Dogs{breed='Doberman', averageWeight=27, apartment=false},
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}, Dogs{breed='Corgie',
        // averageWeight=30, apartment=true}]

        System.out.println(dogArr[3].toString());
        System.out.println();

        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}

        System.out.println("*** ArrayList ***");
        // A visual of where ArrayList comes from
        // Object -> Collections -> List -> ArrayList
        // -> Linked List
        // -> Map
        // -> Set

        ArrayList<Dogs> dogsArrayList = new ArrayList<Dogs>();
        dogsArrayList.addAll(Arrays.asList(dogArr));

        dogsArrayList.add(new Dogs("Mutt", 15, true));

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }
        System.out.println();

        // Dogs{breed='Springer', averageWeight=50, apartment=false}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Yorkie', averageWeight=6, apartment=true}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}

        for (Dogs d : dogsArrayList) {
            if (d.getAvgWeight() >= 50) {
                System.out.println(d.getBreed() + " are large");
            } else {
                System.err.println(d.getBreed() + " are small");
            }
        }

        System.out.println();

        // Springer are large
        // Poodle are small
        // Doberman are small
        // Yorkie are small
        // Corgie are small
        // Mutt are small

        // how to compare strings
        // if ("a" == "b")
        if (dogsArrayList.get(2).getBreed().equals("Turtle")) {
            System.out.println("We have a match");
        } else {
            System.out.println("No match for " + dogsArrayList.get(2).getBreed());
        }
        // Output: No match for Doberman

        // add elements to an ArrayList by index (moves items down)
        dogsArrayList.add(2, new Dogs("Labrador", 75, true));
        dogsArrayList.forEach(d -> System.out.println(d));
        System.out.println();

        // change an element by index
        dogsArrayList.set(2, new Dogs("Chihuahua", 75, true));
        dogsArrayList.forEach(d -> System.out.println(d));
        System.out.println();

        // check for length of
        System.out.println("dogsArrayList is (size) " + dogsArrayList.size());
        // Output: dogsArrayList is (size) 6

        // get single item in ArrayList
        System.out.println(dogsArrayList.get(3));
        // Output: Dogs{breed='Yorkie', averageWeight=6, apartment=true}

        // remove an item from an ArrayList
        dogsArrayList.remove(3);

        // if you try to get the item removed it returns the item that used to be index
        // 4
        System.out.println(dogsArrayList.get(3));
        // Output: Dogs{breed='Corgie', averageWeight=30, apartment=true}

        // print new size of ArrayList
        System.out.println("dogsArrayList is (size) " + dogsArrayList.size());
        System.out.println();
        // Output: dogsArrayList is (size) 5

        Iterator<Dogs> iterator = dogsArrayList.iterator();
        while (iterator.hasNext()) {
            Dogs tempDog = iterator.next();
            System.out.println(tempDog);
        }
        System.out.println();

        // Dogs{breed='Springer', averageWeight=50, apartment=false}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}

        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o1.getBreed().compareToIgnoreCase(o2.getBreed());
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println();

        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}
        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Springer', averageWeight=50, apartment=false}

        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o1.getAvgWeight() - o2.getAvgWeight(); // returns asc
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println();

        // Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // Dogs{breed='Mutt', averageWeight=15, apartment=true}
        // Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // Dogs{breed='Springer', averageWeight=50, apartment=false}

        Collections.sort(dogsArrayList, new Comparator<Dogs>() {
            public int compare(Dogs o1, Dogs o2) {
                return o2.getAvgWeight() - o1.getAvgWeight(); // returns desc
            }
        });

        for (Dogs d : dogsArrayList) {
            System.out.println(d);
        }

        System.out.println();

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

        // Dogs{breed='Mutt', averageWeight=15, apartment=true}
        // 5
        // null
        // 4

        for (Integer i : dogsHashMap.keySet()) {
            System.out.println("key: " + i + ", value: " + dogsHashMap.get(i));
        }
        System.out.println();
        // key: 0, value: Dogs{breed='Springer', averageWeight=50, apartment=false}
        // key: 1, value: Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // key: 2, value: Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // key: 4, value: Dogs{breed='Poodle', averageWeight=13, apartment=true}

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

        // key: 4, value: Dogs{breed='Poodle', averageWeight=13, apartment=true}
        // key: 2, value: Dogs{breed='Doberman', averageWeight=27, apartment=false}
        // key: 1, value: Dogs{breed='Corgie', averageWeight=30, apartment=true}
        // key: 0, value: Dogs{breed='Springer', averageWeight=50, apartment=false}

    }
}