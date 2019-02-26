/*
https://leetcode.com/problems/queue-reconstruction-by-height/

Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), where 
h is the height of the person and 
k is the number of people in front of this person who have a height greater than or equal to h. 

Write an algorithm to reconstruct the queue.

Example
Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }

        List<Person> persons = new ArrayList<>();
        for (int[] p : people) {
            persons.add(new Person(p));
        }

        Collections.sort(persons);

        ArrayList<Person> queue = new ArrayList<>(persons.size());
        for (Person person : persons) {
            queue.add(person.numberOfTallerPeopleBefore, person);
        }

        for (int i = 0; i < queue.size(); i++) {
            people[i] = queue.get(i).toArray();
        }

        return people;
    }
}

class Person implements Comparable<Person> {
    int height;
    int numberOfTallerPeopleBefore;

    Person(int[] person) {
        this.height = person[0];
        this.numberOfTallerPeopleBefore = person[1];
    }

    int[] toArray() {
        return new int[]{this.height, this.numberOfTallerPeopleBefore};
    }

    @Override
    public int compareTo(Person other) {
        if (this.height != other.height) {
            return Integer.compare(other.height, this.height);
        } else {
            return Integer.compare(this.numberOfTallerPeopleBefore, other.numberOfTallerPeopleBefore);
        }
    }
}

/*
Hint:
Position of taller person in not influenced by shorter person.
So fix the position of taller people first.
Then insert the shorter person based on number of taller people in front of him
 */
