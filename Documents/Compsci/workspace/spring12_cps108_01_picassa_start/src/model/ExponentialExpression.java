package model;

import java.util.List;

import model.util.ColorCombinations;


public class ExponentialExpression extends ParenExpression{

    protected ExponentialExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			return "exp";
		}

		@Override 
		protected int getNumParam() {
			return 2;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			return new ExponentialExpression(subExpressions);
		} 
		
	}

	
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.exponent(results.get(0), results.get(1));
	}
}
