package com.rafalkalita.javacore.enumerations;

/**
 * User: rafalkalita
 * Date: 28/01/2014
 * Time: 15:23
 */
public class DirectionsDriver {

    public static void main(String [] args) {

        DirectionsType directionsType = DirectionsType.EAST;

        switch(directionsType) {
            case NORTH:
                System.out.println("Going North");
                break;
            case SOUTH:
                System.out.println("Going South");
                break;
            case EAST:
                System.out.println("Going East");
                break;
            case WEST:
                System.out.println("Going West");
                break;
        }
    }
}
