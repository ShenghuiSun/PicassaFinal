package model;

import java.util.List;

import model.util.ColorCombinations;


public class MinusExpression extends ParenExpression{

    protected MinusExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			return "minus";
		}

		@Override 
		protected int getNumParam() {
			return 2;
		}

		@Override 
		protected ParenExpression constructParenExp(List<Expression> subExpressions) {
			return new MinusExpression(subExpressions);
		} 
		
	}

	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.subtract(results.get(0), results.get(1));
	} 
}
