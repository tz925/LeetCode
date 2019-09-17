package com.Thomaszhou.sample;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
1) Write a function that prints the numbers from 1 to 100. But for multiples of three print “Foo” instead of the number and for the multiples of five print “Bar”. For numbers which are multiples of both three and five print “FooBar”.

Example output: 1 2 Foo 4 Bar Foo 7 8 Foo Bar 11 Foo 13 14 FooBar …

2) Write a function that determines the number of even numbers that appear in a range of integers 0..n, where n is supplied as the sole argument to your function.

Example:

even_integers(3)

Example output: 2

3) Given the following pseudo code, determine the range of possible values for “a”.

x = random_int(1,6)

y = random_int(1,6)

z = random_int(1,6)

a = x + y + z

4) Given: words = ['one', 'one', 'two', 'three', 'three', 'two']

Remove the duplicates.

5) And finally, tell us in 1 to 3 paragraphs how you would build a simple web based chat application. Include the
technologies you would use and why you would use them, as well as a high level explanation of how you would code the application.


 */
public class IotumApplicationQuestion {
    public void question1(){
        for (int i = 1; i <= 100; i++) {
            if (i % 3 != 0 && i % 5 != 0){
                System.out.println(i);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            String foo = "Foo";
            String bar = "Bar";
            if (i % 3 == 0) sb.append(foo);
            if (i % 5 == 0) sb.append(bar);
            System.out.println(sb.toString());
        }
    }

    public int question2(int n){
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) count++;
        }
        return count;
    }


    //question 3 : int a in range 3 to 18.

    public void question4(List<String> input){
        Set<String> s = new HashSet<>(input);
    }

    /*
     question 5:

     Node.js and Express, for server, Node.js and express are very ideal for small app like this, and inexpensive comparing
     to Java Servers. (Alternative can be Python Django which is also inexpensive). Front-End I will choose React.js for
     easiness to use and quick development speed, react is ideal for SPA. DB is not really neccessary unless we want to
     store some account details(login, password, etc.) or chat history. I'm going to use Socket.io to create socket connections.
     */

}
