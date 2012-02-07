package model;

import java.util.List;

import model.util.ColorCombinations;


public class DivideExpression extends ParenExpression{

    protected DivideExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			return "div";
		}

		@Override 
		protected int getNumParam() {
			return 2;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			return new DivideExpression(subExpressions);
		} 
		
	}

	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.divide(results.get(0), results.get(1));
	}
}
