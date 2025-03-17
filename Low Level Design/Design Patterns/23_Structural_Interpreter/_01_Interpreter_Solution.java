import java.util.*;

// Context class to store variable values
class Context {
  private final Map<String, Integer> variables = new HashMap<>();

  public void setVariable(String name, int value) {
      variables.put(name, value);
  }

  public int getVariable(String name) {
      return variables.get(name);
  }
}

// Abstract Expression
interface Expression {
  int interpret(Context context);
}

// Terminal Expression for Variables
class VariableExpression implements Expression {
  private final String name;

  public VariableExpression(String name) {
      this.name = name;
  }

  @Override
  public int interpret(Context context) {
      return context.getVariable(name);
  }
}

// Non-Terminal Expression for Addition
class AddExpression implements Expression {
  private final Expression left, right;

  public AddExpression(Expression left, Expression right) {
      this.left = left;
      this.right = right;
  }

  @Override
  public int interpret(Context context) {
      return left.interpret(context) + right.interpret(context);
  }
}

// Non-Terminal Expression for Multiplication
class MultiplyExpression implements Expression {
  private final Expression left, right;

  public MultiplyExpression(Expression left, Expression right) {
      this.left = left;
      this.right = right;
  }

  @Override
  public int interpret(Context context) {
      return left.interpret(context) * right.interpret(context);
  }
}


public class _01_Interpreter_Solution {
  public static void main(String[] args) {
      // Context with variable values
      Context context = new Context();
      context.setVariable("a", 2);
      context.setVariable("b", 3);
      context.setVariable("c", 4);

      // Expression: a + (b * c)
      Expression expr = new AddExpression(
          new VariableExpression("a"), 
          new MultiplyExpression(
              new VariableExpression("b"), 
              new VariableExpression("c")
          )
      );

      System.out.println("Result: " + expr.interpret(context));
      // Output: 2 + (3 * 4) = 14
  }  
}
