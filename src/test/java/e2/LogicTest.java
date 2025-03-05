package e2;
import org.junit.jupiter.api.*;

import java.util.Optional;
import java.util.function.Predicate;

public class LogicTest {
  public static final int SIZE = 5;
  private Logics game;

  @BeforeEach
  void setUp() {
    this.game = new LogicsImpl(SIZE);
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


}
