package model;

import java.util.List;

import model.util.ColorCombinations;


public class ColorExpression extends ParenExpression{

    protected ColorExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
    

	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() { 
			return "color";
		}

		@Override 
		protected int getNumParam() {
			return 3;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) { 
			// TODO Auto-generated method stub
			return new ColorExpression(subExpressions);
		} 
		
	}

	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);

        return ColorCombinations.color(results.get(0), results.get(1), results.get(2));
	}

}
