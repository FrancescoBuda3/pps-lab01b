package e2;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
  public static final int SIZE = 5;
  public static final Pair<Integer,Integer> SCRIPTED_PAWN_POS = new Pair<>(1,1);
  public static final  Pair<Integer,Integer> SCRIPTED_KNIGHT_POS = new Pair<>(3,2);
  public static final List<Pair<Integer, Integer>> POSSIBLE_SCRIPTED_MOVEMENTS = List.of(new Pair<>(1,1), new Pair<>(1,3), new Pair<>(4,0), new Pair<>(2,0), new Pair<>(2,4) , new Pair<>(4,4));

  private Logics game;
  private Logics scriptedChessboard;

  @BeforeEach
  void setUp() {
    this.game = new LogicsImpl(SIZE);
    this.scriptedChessboard = new LogicsImpl(SIZE, SCRIPTED_PAWN_POS,  SCRIPTED_KNIGHT_POS);

  }

  @Test
  public void test() {
    assert(true);
    // TODO: Add your test logic here
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);
  }

  private Predicate<Pair<Integer, Integer>> assignPredicate(boolean pawnOrElseKnight) {
    if (pawnOrElseKnight) {
      return pair -> this.game.hasPawn(pair.getX(), pair.getY());
    } else {
      return pair -> this.game.hasKnight(pair.getX(), pair.getY());
    }
  }

  private Optional<Pair<Integer, Integer>> find(boolean pawnOrElseKnight) {
    Optional<Pair<Integer, Integer>> pos;
    Predicate<Pair<Integer, Integer>> predicate;
    predicate = assignPredicate(pawnOrElseKnight);
    for (int i = 0; i < SIZE; i++){
      for (int j = 0; j < SIZE; j++){
        pos = Optional.of(new Pair<>(i,j));
        if(predicate.test(pos.get())){
          return pos;
        }
      }
    }
    return Optional.empty();
  }

  @Test
  public void pawnIsPresent(){
    Optional<Pair<Integer, Integer>> pawnPos = find(true);
    assert(pawnPos.isPresent());
  }

  @Test
  public void knightIsPresent(){
    Optional<Pair<Integer, Integer>> knightPos = find(false);
    assert(knightPos.isPresent());
  }

  @Test
  public void pawnCanBeHit(){
    assertTrue(scriptedChessboard.hit(SCRIPTED_PAWN_POS.getX(), SCRIPTED_PAWN_POS.getY()));
  }

  @Test
  public void KnightCanMoveInAllowedPositions(){
      for (Pair<Integer, Integer> movement : POSSIBLE_SCRIPTED_MOVEMENTS) {
          scriptedChessboard.hit(movement.getX(), movement.getY());
          assertTrue(scriptedChessboard.hasKnight(movement.getX(), movement.getY()));
          scriptedChessboard.hit(SCRIPTED_KNIGHT_POS.getX(), SCRIPTED_KNIGHT_POS.getY());
      }
  }

  private static Set<Pair<Integer, Integer>> generateAllPositions() {
    Set<Pair<Integer,Integer>> positions = new HashSet<>();
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        positions.add(new Pair<>(i, j));
      }
    }
    return positions;
  }

  @Test
  public void KnightCannotMoveInNotAllowedPositions(){
    Set<Pair<Integer, Integer>> notAllowedPositions = generateAllPositions();
    POSSIBLE_SCRIPTED_MOVEMENTS.forEach(notAllowedPositions::remove);
    notAllowedPositions.remove(SCRIPTED_KNIGHT_POS);
    for (Pair<Integer, Integer> movement : notAllowedPositions) {
      assertAll(
              () -> assertFalse(scriptedChessboard.hit(movement.getX(), movement.getY())),
              () -> assertFalse(scriptedChessboard.hasKnight(movement.getX(), movement.getY())),
              () -> assertTrue(scriptedChessboard.hasKnight(SCRIPTED_KNIGHT_POS.getX(), SCRIPTED_KNIGHT_POS.getY()))
      );
    }
  }




}
