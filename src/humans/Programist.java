package humans;

import generator.Generator;
import java.io.FileNotFoundException;


public  class Programist extends Human{

    public int[] skillTechnology = new int[6];
    public String position;

    public int skillPoint;

    public int failChance;


    Generator generator = new Generator();

    public Programist() throws FileNotFoundException {//konstruktor obiektu programista
        generator.dice = generator.rollDice(4);
        switch (generator.dice) {   //przy pomocy rzutu kostką , losowany jest stopień zaawansowania nowego pracownika , oraz pieniądze potrzebne na jego utrzymanie
            case 0 -> {
                this.position = "stażysta";
                this.price = 2500.0;
                this.skillPoint = 2;
                failChance = 70;
            }
            case 1 -> {
                this.position = "junior";
                this.price = 5000.0;
                this.skillPoint = 4;
                failChance = 50;
            }
            case 2 -> {
                this.position = "mid";
                this.price = 7500.0;
                this.skillPoint = 6;
                failChance = 30;
            }
            case 3 -> {
                this.position = "senior";
                this.price = 10000.0;
                this.skillPoint = 8;
                failChance = 10;
            }
        }

        for (int i = skillPoint; i > 0; i--) { // rozdanie punktow stazowych w poszczegolne technologie , za pomoca rzutu kostka
            generator.dice = generator.rollDice(6);
            switch (generator.dice) {
                case 0 -> this.skillTechnology[0] += 1; //front
                case 1 -> this.skillTechnology[1] += 1; //back
                case 2 -> this.skillTechnology[2] += 1; //db
                case 3 -> this.skillTechnology[3] += 1; //mobile
                case 4 -> this.skillTechnology[4] += 1; // wordpress
                case 5 -> this.skillTechnology[5] += 1; // presta
            }
        }
        this.name = generator.nameGenerator("src/humans/HumanName");

        this.isSick = false;


    }

}