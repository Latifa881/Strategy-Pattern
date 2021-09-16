package com.example.strategypattern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JumpBehavior jumpWithLegs = new JumpWithLegs();
        Person athletePerson = new AthletePerson(jumpWithLegs);
        athletePerson.performJump();
        Person olympicPerson=new OlympicPerson(jumpWithLegs);
        olympicPerson.performJump();
    }
}
interface JumpBehavior {
    public void jump();
}
abstract class Person {
    protected JumpBehavior jumpBehavior;
    public Person(JumpBehavior jumpBehavior){
        this.jumpBehavior = jumpBehavior;
    }
    public void performJump(){
        jumpBehavior.jump();
    }
}
class JumpWithLegs implements JumpBehavior {
    @Override
    public void jump() {
        System.out.println("I'm Jumping");
    }
}
class AthletePerson extends Person {
    public AthletePerson(JumpBehavior jumpBehavior){
        super(jumpBehavior);
    }
    public void performJump(){
        jumpBehavior.jump();
    }
}
class OlympicPerson extends Person{

    public OlympicPerson(JumpBehavior jumpBehavior) {
        super(jumpBehavior);
    }
    public void performJump(){
        jumpBehavior.jump();}
}