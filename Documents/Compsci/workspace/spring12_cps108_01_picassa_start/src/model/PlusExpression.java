package model;

import java.util.List;

import model.util.ColorCombinations;


public class PlusExpression extends ParenExpression{

    protected PlusExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
        
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.add(results.get(0), results.get(1));
	}
	 
	public static class Factory extends ParenExpression.Factory
	{ 
 
		@Override
		protected String commandName() {
			return "plus";
		}

		@Override 
		protected int getNumParam() {
			return 2;
		}

		@Override 
		protected ParenExpression constructParenExp(List<Expression> subExpressions) {
			return new PlusExpression(subExpressions); 
		} 
		
	}
}
