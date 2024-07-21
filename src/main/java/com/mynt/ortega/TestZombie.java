package com.mynt.ortega;



public class TestZombie {
    public static void main(String[] args) {
        Zombie zombie = new Zombie(3, "brainless");
        System.out.println(zombie.getTeeth() + zombie.getBrains());
    }
}
