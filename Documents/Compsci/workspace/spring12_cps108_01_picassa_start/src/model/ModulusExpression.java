package model;

import java.util.List;

import model.util.ColorCombinations;


public class ModulusExpression extends ParenExpression{

    protected ModulusExpression(List<Expression> subexpressions) {
        super(subexpressions);
    }
    
	@Override
	public RGBColor evaluate(double X, double Y) {
        List<RGBColor> results = evaluateSubexpressions(X, Y);
        return ColorCombinations.modulus(results.get(0), results.get(1));
	}
	 
	public static class Factory extends ParenExpression.Factory
	{

		@Override
		protected String commandName() {
			// TODO Auto-generated method stub
			return "mod";
		}

		@Override 
		protected int getNumParam() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		protected ParenExpression constructParenExp(
				List<Expression> subExpressions) {
			// TODO Auto-generated method stub
			return new ModulusExpression(subExpressions);
		} 
		
	}
}

