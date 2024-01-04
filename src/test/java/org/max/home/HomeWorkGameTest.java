package org.max.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.max.home.Door;
import org.max.home.Game;
import org.max.home.Player;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkGameTest {

    private List<Door> doors;
    @BeforeEach
    void doors(){
        doors = new ArrayList<>();
        doors.add(new Door(true));
        doors.add(new Door(false));
        doors.add(new Door(false));
    }

    @Test
    void TestRoundRiskWin (){
        // Given
        Player gamer = new Player("Игрок", true);
        Game game = new Game(gamer, doors);
        //When
        Door door = game.round(1);
        //Then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    void TestRoundNoRiskWin (){
        // Given
        Player gamer = new Player("Игрок", false);
        Game game = new Game(gamer, doors);
        //When
        Door door = game.round(0);
        //Then
        Assertions.assertTrue(door.isPrize());
    }

    @Test
    void TestRoundNoRiskLose (){
        // Given
        Player gamer = new Player("Игрок", false);
        Game game = new Game(gamer, doors);
        //When
        Door door = game.round(1);
        //Then
        Assertions.assertFalse(door.isPrize());
    }
    @Test
    void TestRoundRiskLose (){
        // Given
        Player gamer = new Player("Игрок", true);
        Game game = new Game(gamer, doors);
        //When
        Door door = game.round(0);
        //Then
        Assertions.assertFalse(door.isPrize());
    }

    @Test
    void TestRoundNoRiskLose2 (){
        // Given
        Player gamer = new Player("Игрок", false);
        Game game = new Game(gamer, doors);
        //When
        Door door = game.round(2);
        //Then
        Assertions.assertEquals(3, doors.size());
        Assertions.assertFalse(door.isPrize());
    }

}
